package com.example.auto_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
// элементы из активити майн
    private EditText currentMileage; // текущий пробег
    private EditText numberOfLiters; // количество литров
    private TextView previousMileage; // предыдущий пробег
    private TextView distanceTraveled; // предыдущий пробег
    private TextView fuelConsumption; // расход
    private TextView fuelConsumptionPer100; // расход на 100
    private TextView lastFuelConsumptionPer100; // последний расход на 100
    Button enterButton;
    Button resButton;


// ключи и настройки для сохранения
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref"; // общие настройки, mypref - имя файла куда сохраняем настройки
    private static final String KEY_CURRENT_MILLEAGE = "curmill"; //ключ для сохранения текущий пробег curmill - ключ по которому сохраняем текущий пробег
// ключи для сохранения литров и даты
    private static final String KEY_LITERS = "litres";
    private static final String KEY_DATE = "date";
    private static final String KEY_LAST_DATE = "lastdate"; //ключ для сохранения дата последнего ввода
    private static final String KEY_LAST_CONSUMPTION = "lastconsumption"; //ключ для сохранения последний расход на 100

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE); // открываем доступ к хранилищу

// получаем доступ к элементам на экране
        currentMileage = findViewById(R.id.currentMileage);
        numberOfLiters = findViewById(R.id.numberOfLiters); // количество литров
        previousMileage = findViewById(R.id.previousMileage); // предыдущий пробег
        distanceTraveled = findViewById(R.id.distanceTraveled); // предыдущий пробег
        fuelConsumption = findViewById(R.id.fuelConsumption); // расход
        fuelConsumptionPer100 = findViewById(R.id.fuelConsumptionPer100); // расход на 100
        lastFuelConsumptionPer100 = findViewById(R.id.lastFuelConsumptionPer100); // расход на 100
        enterButton = findViewById(R.id.enterButton); // кнопка
        resButton = findViewById(R.id.resButton); // кнопка

// если ранее был пробег сохранен то показываем его на экране
        String saveCurrentMilleageString  = sharedPreferences.getString(KEY_CURRENT_MILLEAGE, null);
        if (saveCurrentMilleageString != null){
            previousMileage.setText("Предыдущий пробег " + saveCurrentMilleageString);
        }

        String savedDate = sharedPreferences.getString(KEY_LAST_DATE, null); // пытаемся достать дату последнего ввода из SharedPreferences по ключу KEY_LAST_DATE/ Если такого ключа ещё нет (например, это первое открытие приложения), то savedDate будет null.
        if (savedDate != null) {
            Toast.makeText(this, "Последний ввод был: " + savedDate, Toast.LENGTH_LONG).show(); // Если дата всё-таки была найдена — показываем её пользователю в виде всплывающего окошка (Toast).
        }

        String savedLiters = sharedPreferences.getString(KEY_LITERS, null); //пытаемся достать сохранённое значение литров (топлива), введённое при последнем запуске.
        if (savedLiters != null){
           numberOfLiters.setText(savedLiters); //Если литры найдены — автоматически вставляем это значение в поле ввода numberOfLiters, чтобы пользователь видел, сколько он в прошлый раз заливал.
        }
        String savedLastConsumption = sharedPreferences.getString(KEY_LAST_CONSUMPTION, null); //пытаемся достать сохранённое значение последнего расхода, полученное при последнем рассчете.
        if (savedLastConsumption != null){
            double consumption = Double.parseDouble(savedLastConsumption); // приводим значение к типу double(или float - пофиг)
            lastFuelConsumptionPer100.setText(String.format("Последний расход: ~%.2f л/100км", consumption)); // выводим в удобоваримом виде чтобы 2 знака после запятой


        }

// жмем кнопку рассчета
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String currMill = currentMileage.getText().toString().trim(); // получаем то что ввел пользователь (пробег) и проверяем чтобы поля заполнены были в тч учитываем пробелы

                String numOfLitres = numberOfLiters.getText().toString().trim().replace(",", ".");; // получаем то что ввел пользователь (литры) и проверяем чтобы поля заполнены были в тч учитываем пробелы и ззаменяем запятую на точку - это делаем чтобы пользователь мог ввести например 22,5 или 22.5 - прога все приведет к 22.5 и не выдаст ошибку100

// если хоть одно поле пустое - ругаемся
                if (currMill.isEmpty() || numOfLitres.isEmpty()){
                    Toast.makeText(MainActivity.this, "Заполните поля", Toast.LENGTH_SHORT).show();
                    playSound(R.raw.bad_start_engine);
                    return;
                }
                playSound(R.raw.start_engine2);

// первый запуск, когда еще ничего не сохранено
                String saveCurrentMilleageString  = sharedPreferences.getString(KEY_CURRENT_MILLEAGE, null); // создаем строковую переменную куда кладем текущий пробег введенный пользователем. это нам нужно чтобы при следующем запуске положить его в предыдущий пробег

// Если нет сохранённого пробега — сохраняем введённый как первый
                if (saveCurrentMilleageString == null) {

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    SharedPreferences.Editor editor = sharedPreferences.edit(); // создаем редактора (Editor) для SharedPreferences, чтобы потом записать данные в хранилище. sharedPreferences.edit() — ты вызываешь метод .edit(), чтобы начать редактирование этих данных.
                    editor.putString(KEY_CURRENT_MILLEAGE, currMill); //.putString(...) — сохранить строку .putInt(...) — сохранить целое число .putBoolean(...) — сохранить булевое значение и тд
                    editor.apply(); // editor.apply() или editor.commit() — обязательно вызываются в конце, чтобы сохранить изменения.
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                    previousMileage.setText("Предыдущий пробег: " + currMill); // показываем текущий пробег на экране в поле предыдущий пробег
                    Toast.makeText(MainActivity.this, "Сохранили первый пробег!", Toast.LENGTH_SHORT).show(); // сообщение если первый запуск
                    return; // больше ничего не считаем так как не чего еще считать
                }

// если пробег уже был (ну то есть второй и следующие запуски) то проводим рассчеты
                // парсим (преобразуем) строки в числа
                int previousMilleageInt = Integer.parseInt(saveCurrentMilleageString); // интовые - для пробега предыдущего
                int currentMilleageInt = Integer.parseInt(currMill); // и текущего
                float litresInt = Float.parseFloat(numOfLitres); // не целые (float) для топлива
// проверяем чтобы пробеги были корректны
                if (currentMilleageInt <= previousMilleageInt){
                    Toast.makeText(MainActivity.this, "Текущий пробег должен быть больше предыдущего", Toast.LENGTH_SHORT).show();
                    return;
                }

// собственно рассчеты
                int distance = currentMilleageInt - previousMilleageInt; // пройденое расстояние
                float consumption = litresInt / distance; // расход на 1 км
                float per100km = consumption * 100; // расход на сотню
// выводим результаты на экран
//                fuelConsumption.setText("Расход " + consumption);
//                fuelConsumptionPer100.setText("Расход на 100 км " + per100km);
                fuelConsumption.setText(String.format("%.2f л/км", consumption));
                fuelConsumptionPer100.setText(String.format("~%.2f л/100км", per100km));

                previousMileage.setText("Предыдущий пробег: " + previousMilleageInt);
                distanceTraveled.setText("Пройденное расстояние: " + distance);

// =====================================обновляем сохраненный пробег=================================
                SharedPreferences.Editor editor = sharedPreferences.edit(); // запускаем едитора
//                editor.putString(KEY_CURRENT_MILLEAGE, currentMileage.getText().toString());
                editor.putString(KEY_CURRENT_MILLEAGE, currMill); // то же самое что строка сверху currMill это строковое представление того что ввел юзер в текущий пробег

                String currentDate = new SimpleDateFormat("dd.MM.yyyy HH:mm", new Locale("ru")).format(new Date()); // это переменная для даты во всполывающем окн

                editor.putString(KEY_LITERS, numOfLitres); // сохраняем введенные литры
                editor.putString(KEY_DATE, currentDate); // сохраняем дату
                editor.putString(KEY_LAST_DATE, currentDate);
                editor.putString(KEY_LAST_CONSUMPTION, String.valueOf(per100km)); // сохраняем последний расход
                editor.apply(); // применяем едитора

            }
        });
// жмем кнопку сброса
        resButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("mypref", MODE_PRIVATE); // Удаляет все ключи и значения из SharedPreferences, в данном случае из "mypref". - это имя наших настроек и оно доолжно быть именно таким какое дали вверху
                prefs.edit().clear().apply(); // очищаем все данные
                playSound(R.raw.off_engine);

// Перезапуск activity
                Intent intent = getIntent(); //getIntent() получает текущий Intent (то есть, как был запущен экран).
                finish(); //finish() закрывает текущую Activity.
                startActivity(intent); // запускает её заново — как бы ты только что открыл приложение.

            }
        });

    }
    private  void playSound(int soundResId){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, soundResId);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
        mediaPlayer.setVolume(1.0f, 1.0f); // Максимальная громкость (левый и правый каналы)
        mediaPlayer.start();
    }
}


