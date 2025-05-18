package com.example.fragment_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
// переменные кнопок и одного фрагмента
    Button firstFragmentBtn;
    Button secondFragmentBtn;

    TextView data;

    Fragment1  firstFragment = new Fragment1(); //экз класса  Fragment1/ Это здесь чтобы при запуске сразу окно как бы подгружалось. если у фрейма свои есть параметры - фон там и тд то это можно не тут а в обработке кнопки как у Fragment2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(firstFragment); // эта строчка нужна если 20 стр есть/ она сразу запускает на экране фрагмент 1

// доступ к кнопкам
        firstFragmentBtn = findViewById(R.id.fragment1Btn);
        secondFragmentBtn = findViewById(R.id.fragment2Btn);
// жмем кнопку
        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment1  firstFragment = new Fragment1();// эта строчка нужна если 20 стр нет
                replaceFragment(firstFragment);

            }
        });
// жмем кнопку
        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment2 secondFragment = new Fragment2(); //экз класса  Fragment2
                replaceFragment(secondFragment);

            }
        });

        data = findViewById(R.id.data);// доступ к текстовому полю
        Intent intent = getIntent(); // создали намерение (стандартный код)
        String getData = intent.getStringExtra("key"); // создали стринговую переменную  в которую попадет значение с ключом (имя ключа может быть любое) который создадим во фрагмент 1 java
        data.setText(getData);// в data устанавливаем тектс котрый попал в getData


    }

// метод вызываемый при нажатии на кнопки
    private void replaceFragment(Fragment fragment){

// =================Этот код заменяет один фрагмент другим в Android-приложении.====================
        //getSupportFragmentManager() — это вызов, который возвращает объект FragmentManager, управляющий фрагментами в активити. (если ты используешь AppCompatActivity, а ты наверняка используешь, раз getSupport...) .beginTransaction() — говорит: "Эй, Android! Я собираюсь сделать какие-то изменения с фрагментами. Начинаем транзакцию!"
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction(); // стандартная запись для замены фрагмента. менять можно только имя
        fragmentTransaction.replace(R.id.frameLayout, fragment);// replace(...) означает: замени существующий фрагмент внутри контейнера (в данном случае R.id.frameLayout) на новый фрагмент, указанный вторым аргументом.
        fragmentTransaction.commit(); //Завершает всю эту операцию. То есть: "Применить изменения — ПОЕХАЛИ!" Без commit() вообще ничего не произойдёт. Это как нажать "Сохранить".
//итоговая суть "Хочу заменить содержимое FrameLayout (идентификатор R.id.frameLayout) новым фрагментом fragment. Начинаю транзакцию → заменяю фрагмент → применяю изменения."
//==================================================================================================
    }
}