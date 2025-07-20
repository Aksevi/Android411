package com.example.logiappdz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;
import android.util.Base64;

import androidx.annotation.Nullable;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//свой класс, который расширяет (extends) SQLiteOpenHelper — это официальный способ грамотно управлять SQLite-базами на Android.
public class DataBaseHelper extends SQLiteOpenHelper { //служебный класс для работы с базами данных в андроид. сперва имплементируем 2 метода потом создаем конструктор.(выбираем самый первый)
// подготовили имя базы и имя таблицы

    private static final String DATA_BASE_NAME = "my_dz_base.db"; //имя файла базы данных.
    private static final String TABLE_NAME = "users"; //имя таблицы в этой базе.

    // это добавили позже при помощи ctrl+alt+c когда писали onCreate
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATA_BASE_NAME, null, 1);
    }

    // переопределенный метод
    @Override
    public void onCreate(SQLiteDatabase db) {
        // вот здесь сперва писали вот в таком виде -- db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)"); -- а потом  чтобы  каждое поле таблицы выносилось как константа: по очереди  выделяем названия полей таблицы которую создаем и нажимаем CTRL+ALT+C (команда Introduce Constant) -> выбираем модификатор доступа (Private, Public и тд) -> ok. В результате в самом верху после public class создастся константа по типу **private static final String USER = "user";**
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EMAIL + " TEXT, " + PASSWORD + " TEXT)"); //db.execSQL(...) - вызов метода, который выполняет SQL-запрос. "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (...)" - Это SQL-команда CREATE TABLE — команда создания таблицы.IF NOT EXISTS — добавлена на случай, если таблица уже есть. Чтобы приложение не вылетело с ошибкой: «такая таблица уже существует». TABLE_NAME — это  строковая переменная, содержащая имя таблицы. В скобках структура таблицы
    }

    // переопределенный метод
    // в этом методе если версия(см выше стр 30) меняется то он сперва удаляет таблицу сцществующую чтобы конфликта не было а потом созадет новую таблицу. при этом данные в таблице теряются поэтому надо бэкапить. пока не знаем как
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); // удаляем таблицу если она есть
        onCreate(db); // создаем таблицу
    }


    //С хэшированием
    // Метод регистрирует нового пользователя в базе данных, получая на вход два параметра: email и password. Возвращает boolean — успех или неудача.
    public boolean registerUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase(); //Получаем открытую базу данных на запись. write-доступ потому что добавляем туда что нибудь
        ContentValues values = new ContentValues(); //Создаём "коробочку" values, куда будем класть пары "ключ-значение".

        try {
            //хешируем пароль при сохранении
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); //Готовим хэш-функцию - Получаем объект MessageDigest, который умеет делать хэш с помощью алгоритма SHA-256
            //Хэшируем пароль
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8)); //  password.getBytes(...) — превращаем строку в байты. digest.digest(...) — хэшируем эти байты с помощью SHA-256. Base64.encodeToString(...) — кодируем байты хэша в строку (удобно для хранения/сравнения).
            String hashedPassword = Base64.encodeToString(hash, Base64.NO_WRAP); // Base64.encodeToString(...) — кодируем байты хэша в строку (удобно для хранения/сравнения).

            //Кладём email и хэш в базу
            values.put(EMAIL, email); // константа EMAIL в этом классе находится а email мы передаем в момент ввода
            values.put(PASSWORD, hashedPassword); // константа PASSWORD в этом классе находится а password мы передаем в момент ввода НО!!! теперь сохраняем ХЕШ, а не обычный пароль

            long result = db.insert(TABLE_NAME, null, values); //insert(...) пытается добавить новую строку в таблицу TABLE_NAME с нашими значениями. Если всё хорошо, метод вернёт ID вставленной строки (например, 1, 2, 3 и т.д.). Если что-то пошло не так (например, ошибка БД) — вернёт -1.
            db.close(); //Закрываем базу
            return result != -1; // Если операция прошла успешно (result != -1) — возвращает true.

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Метод проверяет, существует ли пользователь с указанным email в базе данных. Возвращает true, если email уже есть в таблице (то есть, пользователь зарегистрирован).
    //false — если такого email ещё нет.
    public boolean checkEmail(String email) { //Метод публичный. Возвращает boolean. Принимает email (тот, который ты хочешь проверить — вдруг уже занят?)
        SQLiteDatabase db = this.getWritableDatabase(); //Получаем открытую базу данных на запись.
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE email = ?", new String[]{email}); //rawQuery() выполняет сырой SQL-запрос. "SELECT * FROM " + TABLE_NAME + " WHERE email = ?" — выбираем все записи, где email совпадает. new String[]{email} — подставляем значение вместо ?. Это защита от SQL-инъекций (и просто хорошая практика).

// такая запись позволяет закрыть курсор и избежать утечки памяти. на уроке делали просто  return cursor.getCount() > 0;
        boolean exists = cursor.getCount() > 0; //сохраняем результат проверки в переменную exists. cursor.getCount() возвращает количество строк, найденных по запросу. Если хотя бы одна — значит, email уже есть, и мы возвращаем true. Если 0 — значит, такого email нет, возвращаем false.

        cursor.close();// закрываем курсор чтобы избежать утечки памяти
        return exists; // возвращаем результат метода
    }

    // проверка пароля (хэштрованного) и мыла
    public boolean checkUser(String email, String password) { // сюда в аргументы приходят пароль и мыло введенные при регистрации
        SQLiteDatabase db = this.getWritableDatabase(); //Открываем базу для записи (хотя здесь можно было бы и getReadableDatabase(), но не критично). Главное — получить доступ к данным.

        try {
            // // ХЕШИРУЕМ вводимый пароль
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); //Создаём хэш-функцию. MessageDigest — Java-класс, который будет превращать текст в безопасный цифровой отпечаток (хэш).
            //Хэшируем пароль
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8)); //password.getBytes(...) — превращаем строку в байты. digest.digest(...) — хэшируем эти байты с помощью SHA-256. Base64.encodeToString(...) — кодируем байты хэша в строку (удобно для хранения/сравнения).
            String hashedPassword = Base64.encodeToString(hash, Base64.NO_WRAP); // Байты в чистом виде в базу не засунешь — переводим их в строку с помощью кодировки Base64.

            //Выполняем SQL-запрос. Ищем в таблице `users` запись, где: `email` = тот, что ввёл пользователь `password` = хэш от введённого пароля Если такая строка найдена — значит, данные совпадают.
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + EMAIL + " = ? AND " + PASSWORD + "  = ?", new String[]{email, hashedPassword}); // под ? попадает тот  емайл который придет при вызове метода и тот хэштрованный пароль который получился из введенного пользователем

// такая запись позволяет закрыть курсор и избежать утечки памяти. на уроке делали просто  return cursor.getCount() > 0;
            boolean exists = cursor.getCount() > 0;//сохраняем результат проверки в переменную exists. cursor.getCount() возвращает количество строк, найденных по запросу. Если хотя бы одна — значит, email уже есть, и мы возвращаем true. Если 0 — значит, такого email нет, возвращаем false.

            cursor.close();// закрываем курсор чтобы избежать утечки памяти
            return exists; // возвращаем результат метода
        } catch (NoSuchAlgorithmException e) { //Если вдруг SHA-256 не поддерживается (что маловероятно на Android), приложение не упадёт, а просто вернёт false.
            e.printStackTrace();
            return false;
        }

    }
}
