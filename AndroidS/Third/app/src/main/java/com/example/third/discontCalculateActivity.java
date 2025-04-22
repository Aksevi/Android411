package com.example.third;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import java.text.NumberFormat;
import java.util.Locale;

public class discontCalculateActivity extends AppCompatActivity {

// объявляем переменные
    SharedPreferences sharedPreferences; // это способ сохранять данные между запусками приложения (например, введённую сумму).
    private  static final String SHARED_PREF_NAME = "mypref"; // SHARED_PREF_NAME — имя файла, где всё это хранится. Просто строка.  "mypref" - имя
    private  static final String KEY_SUMM = "summ"; // ключ, под которым мы будем хранить и доставать сумму.  "summ" - имя

// эти две строки делаем для второго варианта - то есть чтобы при запуске не производился снова рассчет скидки а значения сразу ставились в поля. с этими строчками использую следующие строки 54-55, 129-131, 149-151, 172-173. комментим строки 63-89
    private  static final String KEY_COST_DISCONT = "costDiscont"; // ключ, под которым мы будем хранить и доставать сумму.  "summ" - имя
    private  static final String KEY_DISCONT = "discont"; // ключ, под которым мы будем хранить и доставать сумму.  "summ" - имя


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discont_calculate);



        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE); // здесь мы инициализируем SharedPreferences, типа Дай мне доступ к файлу mypref, в режиме только для моего приложения (MODE_PRIVATE)".
// доступ к элементам по id
        Button calculateButton = findViewById(R.id.calculateButton);
        Button resetButton = findViewById(R.id.resetButton);
        TextView discontCost = findViewById(R.id.discontCost);
        TextView discontSumm = findViewById(R.id.discontSumm);
        EditText enterCost = findViewById(R.id.enterCost);


// этот кусок кода (до calculateButton.setOnClickListener(new View.OnClickListener()) запускается при запуске программы

// Если раньше вводили сумму — заполним поле и отобразим результат
        String savedCost = sharedPreferences.getString(KEY_SUMM, null); // достаем сохранённую сумму из SharedPreferences

        String savedCostDiscont = sharedPreferences.getString(KEY_COST_DISCONT, null); // достаем сохранённую сумму из SharedPreferences
        String savedDiscont = sharedPreferences.getString(KEY_DISCONT, null); // достаем сохранённую сумму из SharedPreferences

        if (savedCost != null) { // если сумма есть ( ее уже вводили)
            enterCost.setText(savedCost);
            discontCost.setText(savedCostDiscont);
            discontSumm.setText(savedDiscont);
}
// стр 63-89 нужны если сохраняем значение только из поля "введите сумму", а поля сумма скидки и цена со скидкой высчитываются уже в этих строках
//        if (savedCost != null) { // если сумма есть ( ее уже вводили)
//            enterCost.setText(savedCost); // Подставим сумму  в поле ввода
//
//            int savedPrice = Integer.parseInt(savedCost); // преобразуем строку (savedCost) в число и присваиваем его в переменную savedPrice
//            double savedDiscount = 0; // savedDiscount это переменная скидки. изначально она = 0
//// здесь идет рассчет скидки - это делаем чтобы не городить сэйвы а сохранив только введенную сумму просто делаем рассчет скидок и подставляем результаты в соответствующие поля
//            if (savedPrice >= 500 && savedPrice < 1000) { // если сумма больше 500 и меньше 1000 то скидка 3%
//                savedDiscount = savedPrice * 0.03;
//            } else if (savedPrice > 1000) { // если сумма больше 1999 то скидка 5%
//                savedDiscount = savedPrice * 0.05;
//            }
//
//            if (savedDiscount > 0) { // если скидка есть (она больше 0)
//// то форматируем ее в русскую локаль и выводим в соответствующие поля
//                Locale ruLocale = new Locale("ru", "RU");
//                NumberFormat ruCurrencyFormat = NumberFormat.getCurrencyInstance(ruLocale);
//
//                String result = ruCurrencyFormat.format(savedPrice - savedDiscount);
//                String result1 = ruCurrencyFormat.format(savedDiscount);
//
//                discontCost.setText("Цена со скидкой: " + result);
//                discontSumm.setText("Ваша скидка составила: " + result1);
//            } else { // если скидки нет то пишем это
//                discontCost.setText("Извините, скидки нет");
//                discontSumm.setText("Сумма скидки");
//            }
//        }


// этот блок работает при самом первом запуске или когда заново вводим данные
// жмем на кнопку рассчитать скидку
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText enterCost = findViewById(R.id.enterCost); // доступ к текстовому полю ввода
                String cost = enterCost.getText().toString().trim(); // cost это переменная куда попадает текст из поля ввода уже в виде строки/ .trim() в конце проверяет на пробелы и убирает их. ну типа если вместо суммы просто пробелы - то их уберет и не посчитает строку чем то наполненной

                if (cost.isEmpty()){ // если строка пустая то выдаст это
                    Toast.makeText(discontCalculateActivity.this, "Введите сумму!", Toast.LENGTH_SHORT).show();
                    return;
                }
// дальше бахаем как обычно - парсим строку в число и понеслась
                int price = Integer.parseInt(cost);// преобразуем строковое значение в числовое/ по сути сюда попадает число которе ввели в текстовое поле но уже не в виде строки а в виде числа
                double temp = 0; // временная переменная для рассчета скидки
/*                double discont;*/


                SharedPreferences.Editor editor = sharedPreferences.edit(); // SharedPreferences.Editor - готовый интерфейс. editor имя. в нее кладем mypref - см.выше - sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE), а SHARED_PREF_NAME = "mypref"
                editor.putString(KEY_SUMM, enterCost.getText().toString()); // получаем из editTextName текстовое содержимое преводим в String и кладем в editor
                editor.apply(); // применяем изменения

                if (price >= 500 && price < 1000){ // если сумма покупки больше  или равна 500 но меньше 1000
                    temp = price * 0.03; // temp - переменная куда кладем рассчет скидки
//                    String result = String.valueOf(price - temp); // вычисляем разность между ценой и скидкой (читай получаем сумму покупки со скидкой)
//                    discontCost.setText("Цена со скидкой: " + result); // в поле "цена со скидкой" передаем содержимое result
//                    String result1 = String.valueOf(temp); // переводим в строку значение temp (саму скидку) и сохраняем его в result1
//                    discontSumm.setText("Ваша скидка составила: " + result1); // в поле "сумма скидки" передаем содержимое result1

// это аналог строк 45-48 но с локалью
                    Locale ruLocale = new Locale("ru", "RU"); // создаем локаль для русского стандарта
                    NumberFormat ruCurrencyFormat = NumberFormat.getCurrencyInstance(ruLocale); // Создаём форматтер валюты под российскую локаль. Теперь ruCurrencyFormat (это просто имя) умеет автоматически подставлять символ рубля, расставлять пробелы и форматировать числа красиво, как мы привыкли в России.
                    String result = ruCurrencyFormat.format(price - temp); // Вычисляем цену со скидкой и форматируем в валюту
                    discontCost.setText("Цена со скидкой: " + result); //Выводим цену со скидкой  в поле "цена со скидкой"
                    String result1 = ruCurrencyFormat.format(temp); // Форматируем саму скидку в валюту
                    discontSumm.setText("Ваша скидка составила: " + result1); // Выводим размер скидки в поле "сумма скидки"

                    editor.putString(KEY_COST_DISCONT, discontCost.getText().toString()); // получаем из editTextName текстовое содержимое преводим в String и кладем в editor
                    editor.putString(KEY_DISCONT, discontSumm.getText().toString()); // получаем из editTextName текстовое содержимое преводим в String и кладем в editor
                    editor.apply();

                }
                else if (price >= 1000){ // если сумма покупки больше 1000
                    temp = price * 0.05; // temp - переменная куда кладем рассчет скидки
//                    String result = String.valueOf(price - temp); // вычисляем разность между ценой и скидкой (читай получаем сумму покупки со скидкой)
//                    discontCost.setText("Цена со скидкой: " + result); // в поле "цена со скидкой" передаем содержимое result
//                    String result1 = String.valueOf(temp); // переводим в строку значение temp (саму скидку) и сохраняем его в result1
//                    discontSumm.setText("Ваша скидка составила: " + result1); // в поле "сумма скидки" передаем содержимое result1

// это аналог строк 122-125 но с локалью
                    Locale ruLocale = new Locale("ru", "RU"); // создаем локаль для русского стандарта
                    NumberFormat ruCurrencyFormat = NumberFormat.getCurrencyInstance(ruLocale); // Создаём форматтер валюты под российскую локаль. Теперь ruCurrencyFormat (это просто имя) умеет автоматически подставлять символ рубля, расставлять пробелы и форматировать числа красиво, как мы привыкли в России.
                    String result = ruCurrencyFormat.format(price - temp); // Вычисляем цену со скидкой и форматируем в валюту
                    discontCost.setText("Цена со скидкой: " + result); //Выводим цену со скидкой  в поле "цена со скидкой"
                    String result1 = ruCurrencyFormat.format(temp); // Форматируем саму скидку в валюту
                    discontSumm.setText("Ваша скидка составила: " + result1); // Выводим размер скидки в поле "сумма скидки"

                    editor.putString(KEY_COST_DISCONT, discontCost.getText().toString()); // получаем из editTextName текстовое содержимое преводим в String и кладем в editor
                    editor.putString(KEY_DISCONT, discontSumm.getText().toString()); // получаем из editTextName текстовое содержимое преводим в String и кладем в editor
                    editor.apply();
// если цена = 0 то вот это будет
                } else if (price == 0) {
                    discontCost.setText("Извините, скидки нет");
                    discontSumm.setText("Сумма скидки");
                 } else // если меньше 500
                    discontCost.setText("Извините, скидки нет"); // если сума покупки меньше 500 - выводим это

            }
        });
// очищаем данные
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterCost.setText(""); // очищаем поле ввода суммы
                discontCost.setText("Цена со скидкой");  // поле цена со скидкой
                discontSumm.setText("Сумма скидки");  // поле сумма скидки

//  Очищаем SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(KEY_SUMM);
                editor.remove(KEY_COST_DISCONT);
                editor.remove(KEY_DISCONT);
                editor.apply();
// всплывайка говорящая что данные очищены
                Toast.makeText(discontCalculateActivity.this, "Данные очищены", Toast.LENGTH_SHORT).show();

            }
        });

    }
}