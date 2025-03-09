package com.example.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textSample; // созд переменную куда сохраняем доступ к текстовому содержимому/ TextView - тип данных так как этотекстовое поле TextView. textSample просто имя
// второй способ нажатия кнопки
    private  Button secondButton; // созд переменную типа Button/ secondButton просто имя

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.first_layout);
//        setContentView(R.layout.second_layout);
//        setContentView(R.layout.home_layout);
//        setContentView(R.layout.linear_layout_2);
//        setContentView(R.layout.table_layout);
//        setContentView(R.layout.frame_layout);
//        setContentView(R.layout.scroll_view);
        setContentView(R.layout.third_layout);

        textSample = findViewById(R.id.textSample); // присваиваем переменной доступ к текстовому содержимому(стр 15)
        secondButton = findViewById(R.id.secondButton);// второй способ нажатия кнопки. получаекм доступ к второй кнопке

    secondButton.setOnClickListener(new View.OnClickListener() { // реализация второго способа нажатия кнопки до стр 44
        @Override
        public void onClick(View v) {
            textSample.setText("Новое приветствие");// устанавливаем новый текст
            textSample.setTextSize(32);
        }
    });
    }

    public void sayHello(View view){ //созд метод в котором действие при нажатии на кнопку. sayHello - просто имя. View тип данных.  view - имя переменной(View надо импортировать). View это любой элемент котрый расположен в xml разметке
        textSample.setText("Привет");// устанавливаем новый текст
        textSample.setTextSize(24);


    }
}