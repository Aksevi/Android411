package com.example.first;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HW_4 extends AppCompatActivity {

    private TextView calcresult;// calcresult просто любое имя
    private EditText firstNum, secondNum; // firstNum, secondNum просто имена любые
    private Button plus, mines, multiply, divide, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hw4);

        calcresult = findViewById(R.id.calcresult);
        firstNum = findViewById(R.id.firstNum);
        secondNum = findViewById(R.id.secondNum);
        plus = findViewById(R.id.plus_btn);
        mines = findViewById(R.id.mines_btn);
        multiply = findViewById(R.id.multiply_btn);
        divide = findViewById(R.id.divide_btn);
        exit = findViewById(R.id.exit_btn);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number1 = Integer.parseInt(firstNum.getText().toString());
                Integer number2 = Integer.parseInt(secondNum.getText().toString());

                double sum = number1 + number2;

                calcresult.setText(String.valueOf("Result: " + (double) number1 + " + " + (double) number2 + " = " + sum));
            }
        });



        mines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number1 = Integer.parseInt(firstNum.getText().toString());
                Integer number2 = Integer.parseInt(secondNum.getText().toString());

                double difference = number1 - number2;

                calcresult.setText(String.valueOf("Result: " + (double) number1 + " - " + (double) number2 + " = " + difference));
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Integer number1 = Integer.parseInt(firstNum.getText().toString());
                Integer number2 = Integer.parseInt(secondNum.getText().toString());

                double product = number1 * number2;

                calcresult.setText(String.valueOf("Result: " + (double) number1 + " * " + (double) number2 + " = " + product));
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer number1 = Integer.parseInt(firstNum.getText().toString());
                Integer number2 = Integer.parseInt(secondNum.getText().toString());

                if (number2 == 0) {
                    calcresult.setText("На ноль не делят!!!");
                } else {
                    double quotient = (double)number1 / (double)number2;

//                    calcresult.setText(String.valueOf("Result: " + (double) number1 + " / " + (double) number2 + " = " + quotient));
                    calcresult.setText(String.format("Результат: %.1f / %.1f = %.1f", (double) number1, (double) number2, quotient));// будет после запятой 1 символ.
                }

            }
        });
// ниже реализуем закрытие приложения через всплывающее окно
        exit.setOnClickListener(new View.OnClickListener() { // при нажатии на кнопку "Выход"
            @Override
            public void onClick(View v) {
                showInfoAlert("Вы хотите зарыть приложение?"); // появляется окно с этим текстом

            }
        });
    }
 // метод вывода всплывающего окна
    private void showInfoAlert (String text){ // имя метода

        AlertDialog.Builder builder = new AlertDialog.Builder(HW_4.this);// AlertDialog.Builder -  тип  builder - имя, MainActivity3 - имя нашего документа, this - означает что окно будет появляться в этой же вкладке
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
        AlertDialog dialog = builder.create(); // создаем переменную типа AlertDialog  с именем dialog обращаемся через нее к builder из стр 109
        dialog.show(); // вызываем метод
    }
}

