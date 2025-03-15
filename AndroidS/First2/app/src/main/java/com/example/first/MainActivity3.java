package com.example.first;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

// доступ к переменным по id
        TextView mainText = findViewById(R.id.mainText); //TextView  - тип, mainText - имя
        Button btnSecond = findViewById(R.id.buttonSecond); // Button - тип, btnSecond - имя

// первый способ вызова всплывайки (2 кнопка)
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                showInfo(mainText.getText().toString(), btnSecond); // покажет содержимое тектсового поля (Текст)

                showInfoAlert("Вы хотите зарыть приложение?");


            }
        });
    }

    // второй способ вызова всплывайки (1 и 3 кнопки)
    public void  btnClick(View view){
        showInfo(((Button)view).getText().toString(), (Button) view); // покажет содержимое текстового поля кнопок (Button 1 и Button 2)

    }

    private void showInfoAlert (String text){ // имя метода

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);// AlertDialog.Builder -  тип  builder - имя, MainActivity3 - имя нашего документа, this - означает что окно будет появлятьься в этой же вкладке
        builder.setTitle("Заголовок окна") // здесь можно закончить ; но можно добавить через точку что еще сделать (см ниже))
                .setMessage(text) // устанавливаем текст который приходит из строки showInfoAlert("Вы хотите зарыть приложение?"); - см внимательно там в самой строке есть слово text в скобках
                .setCancelable(false)// указываем закрывать ли окно по клику за пределами окна. (false - не будет, true - будет)

                .setPositiveButton("Да", new DialogInterface.OnClickListener() { // реализуем закрытие по кнопке "Да"
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // служ функция закрытия программы

                    }
                })

                .setNegativeButton("Нет", new DialogInterface.OnClickListener() { // закрываем диалоговое окно по кнопке "нет"
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });


        AlertDialog dialog = builder.create(); // создаем переменную типа AlertDialog  с именем dialog обращаемся через нее к builder из стр 53
        dialog.show(); // вызываем метод
    }

    // функция на всплывающее окно
    private void showInfo(String text, Button btn){ // String - принимаемый тип,  text - имя/ с вторым

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show(); // Toast.makeText -служ функция, this значит в этом документе будет всплывать, text - наша переменная из имени метода, LENGTH_SHORT - время показа ( можно LONG)

        btn.setText("Уже нажали");
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.LTGRAY));//
    }

}