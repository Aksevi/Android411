package com.example.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

// переменные создаем
    private TextView result;// result просто любое имя
    private EditText num1, num2; // num1, num2; просто имена любые
    private Button button;// button просто имя

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

// получаем доступ к переменным по id
          result = findViewById(R.id.result);
          num1 = findViewById(R.id.editNumber1);
          num2 = findViewById(R.id.editNumber2);
          button = findViewById(R.id.calcSum);

          button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                 Integer number1 = Integer.parseInt(num1.getText().toString()); // переводим строковое значение к числовому. строковое было потому что любой ввод это строка
                 Integer number2 = Integer.parseInt(num2.getText().toString()); // переводим строковое значение к числовому. строковое было потому что любой ввод это строка

                  result.setText(String.valueOf(number1 + number2));// переводим в строковое значение

              }
          });


    }
}