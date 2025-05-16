package com.example.maze_app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//класс рисования клеток как в тетради
public class GridView extends View {
    private Paint paint;
    private int cellSize;
    private int gridSize;

    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLACK);  // Цвет линии
        paint.setStyle(Paint.Style.STROKE);  // Линии без заливки
        paint.setStrokeWidth(3);  // Толщина линии

        // Размер клетки и размер сетки
        cellSize = 100;  // Размер клетки (можно варьировать)
        gridSize = 5;  // Размер сетки (например, 5x5)
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Рисуем горизонтальные линии
        for (int i = 0; i <= gridSize; i++) {
            canvas.drawLine(0, i * cellSize, gridSize * cellSize, i * cellSize, paint);
        }

        // Рисуем вертикальные линии
        for (int i = 0; i <= gridSize; i++) {
            canvas.drawLine(i * cellSize, 0, i * cellSize, gridSize * cellSize, paint);
        }
    }
}
