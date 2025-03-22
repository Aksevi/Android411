package com.example.shark_floor;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText floor; // сколько этажей
    private EditText firstRoom; // первая кв
    private EditText lastRoom; // посл кв
    private EditText findingRoom; // искомая кв
    private TextView result;
    private Button exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        floor = findViewById(R.id.floors);
        firstRoom = findViewById(R.id.firstRoom);
        lastRoom = findViewById(R.id.lastRoom);
        findingRoom = findViewById(R.id.findingRoom);
    Button find_button = findViewById(R.id.find_btn);
    result = findViewById(R.id.result);
    exit  = findViewById(R.id.exit_btn);

        find_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float room1 = Float.parseFloat(firstRoom.getText().toString()); // первая кв в строку
                float room2 =  Float.parseFloat(lastRoom.getText().toString()); // псоледняя кв в строку
                float room3 =  Float.parseFloat(findingRoom.getText().toString()); // искомая кв в строку
                float floors =  Float.parseFloat(floor.getText().toString()); // количество этажей


                float flatsPerFloor =(room2 - room1 + 1) / floors;// колво кв на этаже ищем
                if (flatsPerFloor == 0) {
                    result.setText("Ошибка");
                    return;
                }


                float  floorNumber = (room3 - room1 + 1) / flatsPerFloor ; // ищем на каком этаже искомая кв

                result.setText(String.valueOf((int) Math.ceil(floorNumber)));
            }
        });

// реализуем закрытие программы через всплывающее окно
        exit.setOnClickListener(new View.OnClickListener() { // при нажатии на кнопку выход всплывает окно с надписью "выйти?"
            @Override
            public void onClick(View v) {

                showInfoAlert("Выйти?");
            }
        });

    }
// метод выводы всплывающего окна
    private void showInfoAlert(String text){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); // AlertDialog.Builder -  тип  builder - имя, MainActivity3 - имя нашего документа, this - означает что окно будет появляться в этой же вкладке
        builder.setTitle("Заголовок окна") // это заголовок всплывающего окна
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() { // кнопка "Да" при нажатии на нее прога закрывается(см стр 80)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })

                .setNegativeButton("Нет", new DialogInterface.OnClickListener() { // кнопка "ytn" при нажатии на нее  закрывается диалоговое окно(см стр 87)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog dialog = builder.create(); // создаем переменную типа  AlertDialog с именем  dialog и через нее обращаемся к builder из стр 73
        dialog.show();



    }
}