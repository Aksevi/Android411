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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    private final static String FILE_NAME = "document.txt"; //Имя файла, который будет сохранён в папку внешнего хранилища.

    Button saveText; // Кнопки для действий.
    Button openText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // доступ к элементам
        saveText = findViewById(R.id.save_text);
        openText = findViewById(R.id.open_text);

// жмем схранить
        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try (FileOutputStream fileOutputStream = new FileOutputStream(getExternalPath())){ //Тут используется try-with-resources — крутая конструкция, которая автоматически закрывает поток, даже если возникла ошибка.
                    EditText edit = findViewById(R.id.editor); // получаем доступ к полю ввода текста
                    String text = edit.getText().toString(); // строковая переменная куда передаем текст введенный пользователем
                    fileOutputStream.write(text.getBytes()); // преобразуем текст в байты
                    Toast.makeText(MainActivity2.this, "Текст сохранен", Toast.LENGTH_SHORT).show(); // dsdjlbv cjj,otybt

                } catch (IOException e) {
                    Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
// жмем загрузить
        openText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textView = findViewById(R.id.text_view); // доступ к полюкуда выведется загруженный текст
                File file = getExternalPath(); // создали переменную в которую положили путь к файлу

                if (!file.exists()){ //Проверка: если файла нет — просто выходим.
                    return;
                }
            // Читаем и отображаем текст в TextView.
                try(FileInputStream fileInputStream = new FileInputStream(file)) {
                    byte[] bytes = new byte[fileInputStream.available()];
                    fileInputStream.read(bytes);
                    String text = new String(bytes);
                    textView.setText(text);

                } catch (IOException e){
                    Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    //    Метод getExternalPath()
    //Создаёт путь к файлу:  /storage/emulated/0/Android/data/твоё_приложение/files/document.txt
    // Этот путь: виден только твоему приложению (без дополнительных разрешений) и не требует запроса WRITE_EXTERNAL_STORAGE (начиная с Android 10)
    private File getExternalPath() {
        return new File(getExternalFilesDir(null), FILE_NAME);
    }
}