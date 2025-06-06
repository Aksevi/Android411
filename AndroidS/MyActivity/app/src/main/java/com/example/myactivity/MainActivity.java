package com.example.myactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final static String FILE_NAME = "content.txt"; // Создаётся константа — имя файла, в который будет сохраняться текст.

    Button saveText; // кнопки
    Button openText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // доступ к элементам
        saveText = findViewById(R.id.save_text);
        openText = findViewById(R.id.open_text);

// жмем сохранить
        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileOutputStream fileOutputStream = null; // стандартный класс для записи байт в файл

                EditText editor = findViewById(R.id.editor);// Получаем EditText с текстом от пользователя:
                String text = editor.getText().toString();// создаем строковую переменную куда помещаем текст введенный пользователем
                try {
                    fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE); // openFileOutput - открывает файл для записи, MODE_PRIVATE - перезапишет,    MODE_APPEND - добавит

                    fileOutputStream.write(text.getBytes()); // Превращаем строку в байты и записываем
                    Toast.makeText(MainActivity.this, "Файл сохранен", Toast.LENGTH_SHORT).show(); //Показываем всплывающее сообщение

                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
// В finally блоке закрываем поток, чтобы не было утечки ресурсов
                finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

// жмем кнопку открыть файл
        openText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileInputStream fileInputStream = null;
                TextView textView = findViewById(R.id.text_view); // доступ к полю где покажем загруженный файл

                try {
                    fileInputStream = openFileInput(FILE_NAME); //Открываем файл

                    byte[] bytes = new byte[fileInputStream.available()]; // Считываем байты
                    fileInputStream.read(bytes);

                    String text = new String(bytes); //Преобразуем байты в строку
                    textView.setText(text); //Отображаем текст в TextView
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    try {
                        if (fileInputStream != null) {
                            fileInputStream.close(); //Закрываем поток
                        }
                    } catch (IOException e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

    }
}