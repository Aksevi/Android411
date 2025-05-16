package com.example.maze_app;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class Level_1 extends AppCompatActivity {
    private GridLayout grid_Layout;
    private int gridSize = 5; // Размер сетки (5x5)
    private static final int WALL = 1; // ввели константы и их будем использовать в обработке нажатия на клетку
    private static final int PATH = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        grid_Layout = findViewById(R.id.grid_Layout);

        // Генерация сетки
        generateGrid();
    }
// жмем на клетку. работает со значениями row (строка) col (колонка) значение (value) и с кнопками
    private void onCellClicked(int row, int col, int value, Button button) {

        if (value == WALL) { // если значение в клетке = 1 (WALL) то это стена красит в черный
            button.setBackgroundColor(Color.BLACK); // стена
        } else { // если значение в клетке = 2 (PATH) то это это проход красит в белый
            button.setBackgroundColor(Color.WHITE); // проходимо
            button.setText(String.valueOf(value)); // показываем цифру, если надо
        }
    }

// generateGrid() — создаём поле
    private void generateGrid() {

        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int buttonSize = (screenWidth - 212) / gridSize; // делаем клетки  квадратными (цифры моджно менять они нужны чтобы клетки в экран влезли. потом поменять еще отступы в сетке надо)

// Устанавливаем количество строк и столбцов
        grid_Layout.setColumnCount(gridSize);
        grid_Layout.setRowCount(gridSize);
        grid_Layout.setUseDefaultMargins(true);

// Генерация кнопок
        Random random = new Random(); // << перемести это сюда один раз перед циклом
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Button button = new Button(this);

                int value = new Random().nextInt(2) + 1; // от 1 до 2 (вкл)

                // // сохраняем значение как тег, текст пока не показываем/ setTag() позволяет потом узнать, что "лежит" в клетке.
                button.setTag(value);
                button.setText(""); // Скрываем цифру

//Размер и стиль кнопок:
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = buttonSize;
                params.height = buttonSize;
                button.setLayoutParams(params);

                grid_Layout.addView(button); //Метод addView() добавляет визуальный элемент (View) — в твоём случае Button — в родительский контейнер, то есть в твой GridLayout.

                int finalI = i;
                int finalJ = j;
                int finalValue = value;
                button.setOnClickListener(v -> onCellClicked(finalI, finalJ, finalValue, button));
            }

        }

    }
}