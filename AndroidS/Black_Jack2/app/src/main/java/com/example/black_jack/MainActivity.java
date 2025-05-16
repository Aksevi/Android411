package com.example.black_jack;

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

        EditText playerName = findViewById(R.id.playerName);
        Button buttonLevelOne = findViewById(R.id.buttonLevelOne);
        Button buttonLevelTwo = findViewById(R.id.buttonLevelTwo);
        Button buttonLevelThree = findViewById(R.id.buttonLevelThree);

// жмем кнопку level 1
        buttonLevelOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String playerNameString = playerName.getText().toString().trim(); // забираем введенные данные в строковую переменную(чтобы потом отображать и работать как с текстом). playerName - обращаемся к переменной в которую вводят имя .getText() - получаем ее текстовое содержимое (то что ввели)  .toString() - и преобразуем все это в строку.  .trim() убирает пробелы

                if (playerNameString.isEmpty()){ // если ничего не ввели то выводим сообщение
                    Toast.makeText(MainActivity.this, "Enter name!", Toast.LENGTH_SHORT).show();
                }
                else { // если ввели и все норм то
                    Intent intent = new Intent(MainActivity.this, Level1.class); // переходим на страницу  level1
                    intent.putExtra("playerName", playerNameString); // и забираем имя которое ввел пользователь
                    startActivity(intent);
                }
            }
        });

// жмем кнопку level 2
/*        buttonLevelTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String playerNameString = playerName.getText().toString().trim(); // забираем введенные данные в строковую переменную(чтобы потом отображать и работать как с текстом). playerName - обращаемся к переменной в которую вводят имя .getText() - получаем ее текстовое содержимое (то что ввели)  .toString() - и преобразуем все это в строку.  .trim() убирает пробелы

                if (playerNameString.isEmpty()){ // если ничего не ввели то выводим сообщение
                    Toast.makeText(MainActivity.this, "Enter name!", Toast.LENGTH_SHORT).show();
                }
                else { // если ввели и все норм то
                    Intent intent = new Intent(MainActivity.this, Level2.class); // переходим на страницу  level1
                    intent.putExtra("playerName", playerNameString); // и забираем имя которое ввел пользователь
                    startActivity(intent);
                }
            }
        });*/

        buttonLevelThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String playerNameString = playerName.getText().toString().trim(); // забираем введенные данные в строковую переменную(чтобы потом отображать и работать как с текстом). playerName - обращаемся к переменной в которую вводят имя .getText() - получаем ее текстовое содержимое (то что ввели)  .toString() - и преобразуем все это в строку.  .trim() убирает пробелы

                if (playerNameString.isEmpty()){ // если ничего не ввели то выводим сообщение
                    Toast.makeText(MainActivity.this, "Enter name!", Toast.LENGTH_SHORT).show();
                }
                else { // если ввели и все норм то
                    Intent intent = new Intent(MainActivity.this, Level3.class); // переходим на страницу  level1
                    intent.putExtra("playerName", playerNameString); // и забираем имя которое ввел пользователь
                    startActivity(intent);
                }
            }
        });



    }
}