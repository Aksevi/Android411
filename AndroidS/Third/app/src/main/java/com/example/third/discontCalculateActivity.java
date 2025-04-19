package com.example.third;

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

import java.text.NumberFormat;
import java.util.Locale;

public class discontCalculateActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discont_calculate);
// объявили пемеремнные и доступ к ним по id
        Button calculateButton = findViewById(R.id.calculateButton);
        TextView discontCost = findViewById(R.id.discontCost);
        TextView discontSumm = findViewById(R.id.discontSumm);


// жмем на кнопку рассчитать скидку
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText enterCost = findViewById(R.id.enterCost); // доступ к текстовому полю ввода
                String cost = enterCost.getText().toString(); // cost это переменная куда попадает текст из поля ввода уже в виде строки
                int price = Integer.parseInt(cost);// преобразуем строковое значение в числовое/ по сути сюда попадает число которе ввели в текстовое поле но уже не в виде строки а в виде числа
                double temp = 0; // временная переменная для рассчета скидки
                double discont;


                if (price >= 500 && price < 1000){ // если сумма покупки больше  или равна 500 но меньше 1000
                    temp = price * 0.03; // temp - переменная куда кладем рассчет скидки
//                    String result = String.valueOf(price - temp); // вычисляем разность между ценой и скидкой (читай получаем сумму покупки со скидкой)
//                    discontCost.setText("Цена со скидкой: " + result); // в поле "цена со скидкой" передаем содержимое result
//                    String result1 = String.valueOf(temp); // переводим в строку значение temp (саму скидку) и сохраняем его в result1
//                    discontSumm.setText("Ваша скидка составила: " + result1); // в поле "сумма скидки" передаем содержимое result1

// это аналог строк 45-48 но с локалью
                    Locale ruLocale = new Locale("ru", "RU"); // создаем локаль для русского стандарта
                    NumberFormat ruCurrencyFormat = NumberFormat.getCurrencyInstance(ruLocale); // Создаём форматтер валюты под российскую локаль. Теперь ruCurrencyFormat умеет автоматически подставлять символ рубля, расставлять пробелы и форматировать числа красиво, как мы привыкли в России.
                    String result = ruCurrencyFormat.format(price - temp); // Вычисляем цену со скидкой и форматируем в валюту
                    discontCost.setText("Цена со скидкой: " + result); //Выводим цену со скидкой  в поле "цена со скидкой"
                    String result1 = ruCurrencyFormat.format(temp); // Форматируем саму скидку в валюту
                    discontSumm.setText("Ваша скидка составила: " + result1); // Выводим размер скидки в поле "сумма скидки"



                }
                else if (price > 1000){ // если сумма покупки больше 1000
                    temp = price * 0.05; // temp - переменная куда кладем рассчет скидки
//                    String result = String.valueOf(price - temp); // вычисляем разность между ценой и скидкой (читай получаем сумму покупки со скидкой)
//                    discontCost.setText("Цена со скидкой: " + result); // в поле "цена со скидкой" передаем содержимое result
//                    String result1 = String.valueOf(temp); // переводим в строку значение temp (саму скидку) и сохраняем его в result1
//                    discontSumm.setText("Ваша скидка составила: " + result1); // в поле "сумма скидки" передаем содержимое result1

// это аналог строк 63-66 но с локалью
                    Locale ruLocale = new Locale("ru", "RU"); // создаем локаль для русского стандарта
                    NumberFormat ruCurrencyFormat = NumberFormat.getCurrencyInstance(ruLocale); // Создаём форматтер валюты под российскую локаль. Теперь ruCurrencyFormat умеет автоматически подставлять символ рубля, расставлять пробелы и форматировать числа красиво, как мы привыкли в России.
                    String result = ruCurrencyFormat.format(price - temp); // Вычисляем цену со скидкой и форматируем в валюту
                    discontCost.setText("Цена со скидкой: " + result); //Выводим цену со скидкой  в поле "цена со скидкой"
                    String result1 = ruCurrencyFormat.format(temp); // Форматируем саму скидку в валюту
                    discontSumm.setText("Ваша скидка составила: " + result1); // Выводим размер скидки в поле "сумма скидки"

                }
                else
                    discontCost.setText("Извините, скидки нет"); // если сума покупки меньше 500 - выводим это

            }
        });

    }
}