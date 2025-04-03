package com.example.x_games_hw;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Easy_Level extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_easy_level);

        String getPlayerName = getIntent().getStringExtra("playerName"); // получаем имя которое ввел игрок в mainActivity.java
        String phoneModel = Build.MODEL; // получаем модель телефона

        TextView playerTextView = findViewById(R.id.playerName); // TextView - тип переменной  playerTextView - имя переменной. findViewById(R.id.playerName) - получили доступ по id где playerName - это id текстового поля из easy_level.xml

        TextView phoneTextView = findViewById(R.id.phoneModel); // TextView - тип переменной  phoneTextView - имя переменной. findViewById(R.id.phoneModel) - получили доступ по id где phoneModel - это id текстового поля из easy_level.xml


        playerTextView.setText(getPlayerName); // устанавливаем в поле  playerTextView имя которое ввел юзер в поле getPlayerName из MainActivity и которое мы получили в переменную getPlayerName на этой странице в стр 21

        phoneTextView.setText("VS  " + phoneModel); // устанавливаем в поле  phoneTextView модель телефона которую получили в переменную phoneModel в стр 22 с помощью Build.MODEL

    }
}