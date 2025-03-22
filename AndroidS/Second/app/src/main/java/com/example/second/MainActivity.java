package com.example.second;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    }
    // метод перехода по клику на новую стр
    public void newActivity(View view){

        Intent intent = new Intent(this, SecondActivity.class); //Intent - тип  intent - имя   new Intent(this, SecondActivity.class) -this - с этой стр/ SecondActivity.class - куда )

        startActivity(intent);

    }
}