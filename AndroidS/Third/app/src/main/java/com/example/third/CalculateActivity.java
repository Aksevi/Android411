package com.example.third;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.text.NumberFormat;
import java.util.Locale;

public class CalculateActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);


        Button idCalculateButton = findViewById(R.id.id_calculate_button); // доступ к кнопке

        idCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText costOfService = findViewById(R.id.cost_of_service); // доступ к текстовому полю
                String keyword = costOfService.getText().toString(); // в  keyword получаем текст из текстового поля. String потому что все что в тестовом поле изначально - строка
                int cost = Integer.parseInt(keyword); // преобразуем строковое значение в числовое/ по сути сюда попадает число которе ввели в текстовое поле но уже не в виде строки а в виде числа

                double tip = 0; // чаевые изначально = 0


                RadioGroup tipOptions = findViewById(R.id.tip_options); // доступ к радиогруппе
                int selectedId = tipOptions.getCheckedRadioButtonId(); // создаем переменную в которую кладем Id нажатой радиокнопки

                if (selectedId == R.id.options_ten_percent){
                    tip = cost * 0.1;
                } else if (selectedId == R.id.options_seven_percent){
                    tip = cost * 0.07;
                } else if (selectedId == R.id.options_five_percent) {
                    tip = cost * 0.05;
                }



                SwitchMaterial roundSwitch = findViewById(R.id.round_switch); // доступ к переключателю округления чаевых
                boolean round = roundSwitch.isChecked(); // проверяем включен ли переключатель (тру или фолсе)
                if (round){ // если включен то
                    tip = Math.ceil(tip); // округляем в большую сторону
                }

                TextView tipResult = findViewById(R.id.tip_result); // доступ к текстовому полю сумма чаевых
//                String result = String.valueOf(tip); // преобразуем числовое значение tip в строковое и кладем в переменную result
//                tipResult.setText(result); // передаем в тектсовое поле сумма чаевых значение result

// Locale это возможность использования какого то языка
//                Locale usLocale = new Locale("en", "US"); // создаем локаль для американского стандарта
                Locale usLocale = new Locale("ru", "RU"); // создаем локаль для американского стандарта
                NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(usLocale); // в эту переменную передаем значение usLocale
                String currencyTip = usCurrencyFormat.format(tip); // аналог стр 64 - приводим числовое значение в строку


                String text = "Оставьте на чай: " + currencyTip;
                tipResult.setText(text);
            }
        });

    }
}