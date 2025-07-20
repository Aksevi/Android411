package com.example.logiappdz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


//создаём активность с двумя кнопками:
//🔹 Login (Вход)
//🔹 Create Account (Регистрация)
//При нажатии на любую из кнопок — открывается кастомный диалог (всплывающее окно снизу), в котором пользователь может:
//либо войти в систему (пока без логики),
//либо зарегистрироваться (с логикой проверки email и пароля)
public class MainActivity extends AppCompatActivity {
    // переменные
    private Button loginBtn;
    private Button createAccountBtn;
    private DataBaseHelper myDataBase;  // переменная вспомогательного класса DataBaseHelper.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataBase = new DataBaseHelper(this);//создаём объект DataBaseHelper и передаёшь туда this, т.е. MainActivity, чтобы помощник знал контекст и мог работать с БД, файлами, ресурсами и т.д.
//Привязываеv переменные к кнопкам на экране по их ID
        loginBtn = findViewById(R.id.login_btn);
        createAccountBtn = findViewById(R.id.create_btn);

/*        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // убираем заголовок окна диалога
                dialog.setContentView(R.layout.floating_login_dialog); // подключаем наш слой с диалогом

                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT); // программно установили ширину и высоту диалогового окна
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // убираем фон (без этой строки углы закруглеты но под ними виден белый фон)
                dialog.getWindow().getAttributes().windowAnimations = R.style.floatingWindowDialogAnimation; // DialogAnimation мы писали в themes в  теге <style>. соответственно мы это и подключаем
                dialog.getWindow().setGravity(Gravity.BOTTOM); // опускаем окно диалога вниз
            }
        });*/

// При нажатии на кнопку "Создать аккаунт" вызывается showRegisterDialog() — кастомный диалог для регистрации.
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterDialog(); // вызываем метод показа диалога регистрации. он у нас всплывет в диалоговом окне
            }
        });

// При нажатии на кнопку "Войти" вызывается showLoginDialog() — кастомный диалог для входа.
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoginDialog(); // вызываем метод показа диалога входа. он у нас всплывет в диалоговом окне
            }
        });
    }
//**************************************************************************************************
//**********************АВТОРИЗАЦИЯ ПОЛЬЗОВАТЕЛЯ****************************************************
    private void showLoginDialog() {
        Dialog dialog = new Dialog(MainActivity.this); // создаем диалог
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // убираем заголовок окна диалога
        dialog.setContentView(R.layout.floating_login_dialog); // подключаем наш слой с диалогом

        dialog.show();// показываем диалог
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT); // программно установили ширину и высоту диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // убираем фон (без этой строки углы закруглены но под ними виден белый фон)
        dialog.getWindow().getAttributes().windowAnimations = R.style.floatingWindowDialogAnimation; // DialogAnimation мы писали в themes в  теге <style>. соответственно мы это и подключаем
        dialog.getWindow().setGravity(Gravity.BOTTOM); // опускаем окно диалога вниз

        // переменные и доступ к элементам на экране диалога логина
        EditText loginEmail = dialog.findViewById(R.id.login_email);
        EditText loginPassword = dialog.findViewById(R.id.login_password);
        Button loginBtn = dialog.findViewById(R.id.enter_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // создаем стринговые переменные в которые кладем вводимый в поля текст и парсим его в строку (Считываем, что ввёл пользователь)
                String email = loginEmail.getText().toString(); // создали переменную email в нее положили мыло введенное пользователем и запарсили в строку
                String password = loginPassword.getText().toString(); // создали переменную passowrd в нее положили пароль введенное пользователем и запарсили в строку

                boolean log = myDataBase.checkUser(email, password); // бул переменная в которую приходит мыло и пароль введенные пользователем при логине. myDataBase наша переменная класса DataBaseHelper который работает с нашей БД. вернет true или false

                if (email.isEmpty() || password.isEmpty()) { // если не все поля заполнены
                    Toast.makeText(MainActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    if (log) { // если log вернул true
                        Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, AppActivity.class); // переходим на активность приложения
                        startActivity(intent);
                        dialog.dismiss();
                    } else { // если log вернул false
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

//**************************************************************************************************
//===============РЕГИСТРАЦИЯ ПОЛЬЗОВАТЕЛЯ===========================================================
// этот метод в котором создаётся диалог регистрации, всплывающее окно с тремя полями: Email Пароль Подтверждение пароля
    private void showRegisterDialog() {
        Dialog dialog = new Dialog(MainActivity.this); // создаем диалог
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // убираем заголовок окна диалога
        dialog.setContentView(R.layout.floating_register_dialog); // подключаем наш слой с диалогом

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT); // программно установили ширину и высоту диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // убираем фон (без этой строки углы закруглены но под ними виден белый фон)
        dialog.getWindow().getAttributes().windowAnimations = R.style.floatingWindowDialogAnimation; // DialogAnimation мы писали в themes в  теге <style>. соответственно мы это и подключаем
        dialog.getWindow().setGravity(Gravity.BOTTOM); // опускаем окно диалога вниз

        // переменные и доступ к элементам на экране диалога регистрации
        EditText registerEmail = dialog.findViewById(R.id.register_email);
        EditText registerPassword = dialog.findViewById(R.id.register_password);
        EditText confirmPassword = dialog.findViewById(R.id.confirm_password);
        Button registerBtn = dialog.findViewById(R.id.register_btn);

// Обработка нажатия на кнопку "Зарегистрироваться"
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // создаем стринговые переменные в которые кладем вводимый в поля текст и парсим его в строку (Считываем, что ввёл пользователь.)
                String email = registerEmail.getText().toString(); // создали переменную email в нее положили мыло введенное пользователем и запарсили в строку
                String passowrd = registerPassword.getText().toString(); // создали переменную passowrd в нее положили пароль введенное пользователем и запарсили в строку
                String confPassword = confirmPassword.getText().toString(); // создали переменную confPassword в нее положили подтаерждние пароля введенное пользователем и запарсили в строку

                if (email.isEmpty() || passowrd.isEmpty() || confPassword.isEmpty()) { // если хоть одно поле не заполнено то
                    Toast.makeText(MainActivity.this, "Заполни все поля", Toast.LENGTH_SHORT).show(); // сообщение о необходимости заполнить все поля
                } else {
                    //Совпадают ли пароли:
                    if (passowrd.equals(confPassword)) { // если пароль и подтверждение совпадают
                        boolean checkUserEmail = myDataBase.checkEmail(email); // вызывается метод checkEmail и проверяется на уникальность email который ввел пользователь при регистрации  и результат проверки попадает в булевую checkUserEmail

                        if (!checkUserEmail) {//Если не существует (!checkUserEmail) — можно регистрировать.
                            //Регистрация пользователя:
                            boolean insert = myDataBase.registerUser(email, passowrd);
                            if (insert) { // если успешно
                                Toast.makeText(MainActivity.this, "User register succefully", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                showLoginDialog();

                            } else { // если неудачно
                                Toast.makeText(MainActivity.this, "Register Error", Toast.LENGTH_SHORT).show();
                            }
                        } else {// если email уже в базе
                            Toast.makeText(MainActivity.this, "User already exists/ Please Login", Toast.LENGTH_SHORT).show();
                        }
                    } else { //Если пароли не совпадают:
                        Toast.makeText(MainActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
//======================================================================================================================
}