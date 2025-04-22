package com.example.third;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

// переменные
    EditText editTextName, editTextEmail; // текстовые поля
    Button buttonSave; // кнопка
    SharedPreferences sharedPreferences; // переменная в которую будем сохранять наши данные

    private  static final String SHARED_PREF_NAME = "mypref"; // общее название для наших настроек. ключ (SHARED_PREF_NAME) и имя ("mypref") придумали сами
    private  static final String KEY_NAME = "name"; // те значения которые ввел пользователь. ключ и имя придумали сами
    private  static final String KEY_EMAil = "email"; // те значения которые ввел пользователь. ключ и имя придумали сами

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSave = findViewById(R.id.buttonSave);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE); // sharedPreferences Это переменная, которая будет ссылаться на объект SharedPreferences. getSharedPreferences(...) Это метод, который говорит: «Эй, Android, дай-ка мне доступ к файлу с настройками под именем SHARED_PREF_NAME». SHARED_PREF_NAME  Это строковая переменная (типа String), содержащая имя твоего хранилища настроек. MODE_PRIVATE  Это режим доступа. Говорит: «Эти настройки только для моего приложения.
        String name = sharedPreferences.getString(KEY_NAME, null); // изначально (по умолчанию) name = null

        if (name != null) { // если данные есть (не пустые)
            Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
            startActivity(intent);
        }


        buttonSave.setOnClickListener(new View.OnClickListener() { // жмем на кнопку buttonSave
            @Override
            public void onClick(View v) {


                SharedPreferences.Editor editor = sharedPreferences.edit(); // SharedPreferences.Editor - готовый интерфейс. editor имя. в нее кладем mypref - см.выше - sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE), а SHARED_PREF_NAME = "mypref"

                editor.putString(KEY_NAME, editTextName.getText().toString()); // получаем из editTextName текстовое содержимое преводим в String и кладем в editor
                editor.putString(KEY_EMAil, editTextEmail.getText().toString());// получаем из editTextEmail текстовое содержимое преводим в String и кладем в editor
                editor.apply(); // применяем изменения

                Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(intent);

                Toast.makeText(RegisterActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

            }
        });


    }
}