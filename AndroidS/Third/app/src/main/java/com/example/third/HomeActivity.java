package com.example.third;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

// переменные
    TextView textFullName, textEmail;
    Button logOut;
// это мы делали в RegisterActivity.java и просто оттуда скопировали
SharedPreferences sharedPreferences;
    private  static final String SHARED_PREF_NAME = "mypref"; // общее название для наших настроек. ключ (SHARED_PREF_NAME) и имя ("mypref") придумали сами
    private  static final String KEY_NAME = "name"; // те значения которые ввел пользователь. ключ и имя придумали сами
    private  static final String KEY_EMAil = "email"; // те значения которые ввел пользователь. ключ и имя придумали сами

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

// доступ к полям по id
        textFullName = findViewById(R.id.textFullName);
        textEmail = findViewById(R.id.textEmail);
        logOut = findViewById(R.id.logOut);

// это мы делали в RegisterActivity.java и просто оттуда скопировали и чуть изменили
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE); // sharedPreferences Это переменная, которая будет ссылаться на объект SharedPreferences. getSharedPreferences(...) Это метод, который говорит: «Эй, Android, дай-ка мне доступ к файлу с настройками под именем SHARED_PREF_NAME». SHARED_PREF_NAME  Это строковая переменная (типа String), содержащая имя твоего хранилища настроек. MODE_PRIVATE  Это режим доступа. Говорит: «Эти настройки только для моего приложения.
        String name = sharedPreferences.getString(KEY_NAME, null); //  в name получаем значение KEY_NAME, если его нет то установит null
        String email = sharedPreferences.getString(KEY_EMAil, null); // добавили тут это! в email получаем значение KEY_NAME, если его нет то установит null

        if (name != null || email != null) { // если данные есть (не пустые) тут добавили это || email != null
// тут изменили if взятый из  RegisterActivity.java
            textFullName.setText("Full name - " + name);
            textEmail.setText("EMail - " + email);
        }

// жмем на кнопку Log Out
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences.Editor editor = sharedPreferences.edit(); // эта строка есть в RegisterActivity.java ее просто копируем или пишем заново
                editor.clear(); // очищаем данные в editor
                editor.apply(); // применяет метод очищения. .apply() обязателен всегда
                finish();// заканчивает процесс. без этого после логаута останется на этой странице. с ним - вернется на стартовую

                Toast.makeText(HomeActivity.this, "Вы вышли из системы", Toast.LENGTH_SHORT).show();

            }
        });

    }
}