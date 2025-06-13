package com.example.fck_my_brain;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int[] backgroundColors;
    private int[] textColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundColors = new int[] {
                ContextCompat.getColor(this, R.color.light_blue),
                ContextCompat.getColor(this, R.color.yellow),
                ContextCompat.getColor(this, R.color.red),
                ContextCompat.getColor(this, R.color.orange),
                ContextCompat.getColor(this, R.color.green),
                ContextCompat.getColor(this, R.color.purple),
                ContextCompat.getColor(this, R.color.blue)
        };

        int[] textColors = {
                ContextCompat.getColor(this, R.color.black),
                ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.light_blue),
                ContextCompat.getColor(this, R.color.yellow),
                ContextCompat.getColor(this, R.color.red),
                ContextCompat.getColor(this, R.color.orange),
                ContextCompat.getColor(this, R.color.green),
                ContextCompat.getColor(this, R.color.purple),
                ContextCompat.getColor(this, R.color.blue)
        };

    }
}