package com.example.gamexo;

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

        EditText playerOne = findViewById(R.id.payerOne);
        EditText playerTwo = findViewById(R.id.playerTwo);
        Button startGameButton = findViewById(R.id.startGameButton);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getPlayerOneName = playerOne.getText().toString(); // введенные данные преобразуем в строковое значение
                String getPlayerTwoName = playerTwo.getText().toString(); // введенные данные преобразуем в строковое значение

                if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()){ // если не ввели что то

                    Toast.makeText(MainActivity.this, "Please enter Player name", Toast.LENGTH_SHORT).show(); // то покажет окно с этим текстом

                } else { // если все заполнено то

                    Intent intent = new Intent(MainActivity.this, PlayingField.class);//перейдет на нужное окно

// вместе с переходом на новую стр забираем те данные которые ввел пользователь
                    intent.putExtra("playerOne", getPlayerOneName);
                    intent.putExtra("playerTwo", getPlayerTwoName);


                    startActivity(intent);

                }
            }
        });


    }
}