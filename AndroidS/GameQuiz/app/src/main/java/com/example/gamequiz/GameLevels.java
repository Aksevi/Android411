package com.example.gamequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levels);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); // эта строчка убирает вверху экрана строку состояния и ее можно вызвать потянув сверху шторку. это применяют чтобы при игре не мешала

        Button buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameLevels.this, MainActivity.class); // собственно возврат с GameLevels на MainActivity
                startActivity(intent);

            }
        });

        TextView textView1 = findViewById(R.id.textView1); // кнопка перехода на 1 уровень
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameLevels.this, Level1.class); // переход с GameLevels на Level1
                startActivity(intent);
            }
        });

    }
}