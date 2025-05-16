package com.example.shark_floor;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText floor; // сколько этажей
    private EditText firstRoom; // первая кв
    private EditText lastRoom; // посл кв
    private EditText findingRoom; // искомая кв
    private EditText ApartmentOnFirst; // искомая кв
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
//эта строка нужна бужет когда решу вопрос с неравномерностью 1
//        ApartmentOnFirst = findViewById(R.id.firstFloorApt);
    Button find_button = findViewById(R.id.find_btn);
    result = findViewById(R.id.result);
    exit  = findViewById(R.id.exit_btn);

        find_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// проверка чтобы все поля были заполнены
                if (floor.getText().toString().trim().isEmpty() || firstRoom.getText().toString().trim().isEmpty() || lastRoom.getText().toString().trim().isEmpty() || findingRoom.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Введите данные!", Toast.LENGTH_SHORT).show();
                    return;
                }

                    float room1 = Float.parseFloat(firstRoom.getText().toString()); // первая кв в строку
                    float room2 = Float.parseFloat(lastRoom.getText().toString()); // псоледняя кв в строку
                    float room3 = Float.parseFloat(findingRoom.getText().toString()); // искомая кв в строку
                    float floors = Float.parseFloat(floor.getText().toString()); // количество этажей в строку
//                float onFirstFloor = Float.parseFloat(ApartmentOnFirst.getText().toString()); // кол-во кв на первом этаже в строку

// надо думать решать при неравномерном количествет кв на 1 этаже
/*                boolean hasFirstFloor = onFirstFloor > 0;// булевая переменная на нулевое количесвто квартир на 1 этаже

// ищем сколько квратир на этаже (flatsPerFloor - сколько кв на этаже). если onFirstFloor > 0 (на 1 этаже не 0 кв), то считает то что после ? если на 1 этаже 0 кв то считает то что после :
                float flatsPerFloor = hasFirstFloor ? ((room2 - room1 + 1) - onFirstFloor) / (floors - 1) : (room2 - room1 + 1) / floors;
                 if (flatsPerFloor <= 0){ // если квартир на этаже 0 или меньше то выдаст ошибку
                result.setText("Error");
                return;
                }
                if (hasFirstFloor && room3 <= room1 + onFirstFloor - 1){ // проверяет не находится ли искомая кв (room3) на первом этаже. если hasFirstFloor true (то есть больше 0) и room3  меньше или равно 1 квартира минус количество кв на этаже минус 1 - значит искомая кв на первом этаже
                    result.setText("1");
                    return;
                }
// ищем на каком этаже искомая квартира (floorNumber)
                float floorNumber = hasFirstFloor ? ((room3 - room1 - onFirstFloor) / flatsPerFloor) + 2 : ((room3 - room1) / flatsPerFloor) + 1;
                result.setText(String.valueOf((int) Math.ceil(floorNumber))); // если на первом этаже есть кв (их больше 0) то считается то что после ?, если первый этаж пуст - то то что после :
                }*/

                float flatsPerFloor = (room2 - room1 + 1) / floors;// кол-во кв на этаже ищем
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