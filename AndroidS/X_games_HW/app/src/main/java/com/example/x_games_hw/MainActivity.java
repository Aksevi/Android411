package com.example.x_games_hw;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
// получаем доступ к переменным
        EditText playerName = findViewById(R.id.playerName);
        Button easyButton = findViewById(R.id.easy_level);
        Button hardButton = findViewById(R.id.hard_level);

// нажимаем на кнопку easyButton
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// забираем те данные которые игрок ввел в поле имя игрока
                String getPlayerName = playerName.getText().toString();// забираем введенные данные в строковую переменную(чтобы потом отображать и работать как с текстом). playerName - обращаемся к переменной в которую вводят имя .getText() - получаем ее текстовое содержимое (то что ввели)  .toString() - и преобразуем все это в строку

                if (getPlayerName.isEmpty()){

                    Toast.makeText(MainActivity.this, "Введите имя!", Toast.LENGTH_SHORT).show();

                }
                else {
                    Intent intent = new Intent(MainActivity.this, Easy_Level.class); // переход на страницу с уровнем Easy

                    intent.putExtra("playerName", getPlayerName); // вместе с переходм забираем имя которое ввел пользователь

                    startActivity(intent);
                }

// нажимаем на кнопку hardButton
                hardButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String getPlayerName = playerName.getText().toString();// забираем введенные данные в строковую переменную(чтобы потом отображать и работать как с текстом). playerName - обращаемся к переменной в которую вводят имя .getText() - получаем ее текстовое содержимое (то что ввели)  .toString() - и преобразуем все это в строку

                        if (getPlayerName.isEmpty()){

                            Toast.makeText(MainActivity.this, "Введите имя!", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Intent intent = new Intent(MainActivity.this, Hard_Level.class); // переход на страницу с уровнем Hard

                            intent.putExtra("playerName", getPlayerName); // вместе с переходм забираем имя которое ввел пользователь

                            startActivity(intent);
                        }
                    }
                });


            }
        });

    }
}