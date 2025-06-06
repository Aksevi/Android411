package com.example.myactivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    Button btnPermission; // кнопка
    TextView textInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

// доступ к элементам
        btnPermission = findViewById(R.id.btn_permission);
        textInfo = findViewById(R.id.text_info);

        new Handler().postDelayed(this::getPermission, 2000); // Небольшая задержка перед проверкой разрешений

// жмем кнопку
        btnPermission.setOnClickListener(v -> {
            getPermission();
        });
    }

    // Когда пользователь возвращается в приложение из настроек — мы проверяем, дали ли разрешение.
    @Override
    protected void onResume() {
        super.onResume();
//Если дали:
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                textInfo.setText("Разрешение успешно предоставлено!"); //Меняем текст textInfo
                btnPermission.setVisibility(View.GONE); // видимость кнопки

/*                // если нужно  - переход на нужную активность с задержкой в 1,5 секунды
                new Handler().postDelayed(() -> {
                    Intent intent = new Intent(this, MainActivity.class); // заменить на нужную Activity
                    startActivity(intent);
                    finish();
                }, 1500);*/
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (Environment.isExternalStorageManager()) {
                textInfo.setText("Разрешение успешно предоставлено!");
                btnPermission.setVisibility(View.GONE);

/*                //  Переход при желании:
                new Handler().postDelayed(() -> {
                    Intent intent = new Intent(this, MainActivity.class); // замени на нужную Activity
                    startActivity(intent);
                    finish();
                }, 1500);*/
            }
        }
    }

//метод проверяет, выданы ли разрешения, и если нет — запрашивает их.
    private void getPermission() {

        // разрешения до андроид 10 API 29
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) { //Проверяем, что Android 10 или ниже.
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) { //Проверка, выдано ли уже разрешение на чтение из внешнего хранилища (READ_EXTERNAL_STORAGE).
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100); //Если разрешения нет — показывается системное окно запроса разрешения.
//                btnPermission.setVisibility(View.VISIBLE);
            } else { //Иначе — просто показываем Toast и меняем текст.
                Log.d("DEBUG", "READ_EXTERNAL_STORAGE уже дан"); //Если разрешение уже есть — просто выводится сообщение в лог.
                Toast.makeText(this, "Разрешения уже были даны", Toast.LENGTH_SHORT).show();
                textInfo.setText("Разрешение уже получено. спасибо!");
            }
        }
// Разрешения для андроид 11 API 30 и выше. Для Android 11 и выше Google усложнил доступ к файловой системе — теперь нужно специальное разрешение: MANAGE_EXTERNAL_STORAGE
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { // если Android 11 и выше (API 30+)
            if (!Environment.isExternalStorageManager()) { //Проверка: не включены ли уже это спец-разрешение.
                try {
                    //Если не включено — запускается Intent, который открывает системные настройки, где пользователь вручную даёт разрешение:
                    Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(String.format("package:%s", getApplicationContext().getPackageName())));
                    startActivity(intent);
                    textInfo.setText("Дайте разрешения в открывшемся окне и вернитесь в приложение");
                    btnPermission.setVisibility(View.VISIBLE);

                    //Если Intent не сработал — пробуется открыть настройки без Uri.
                } catch (Exception e) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                    startActivity(intent);
                    textInfo.setText("Дайте разрешения в открывшемся окне и вернитесь в приложение");
                    btnPermission.setVisibility(View.VISIBLE);
                }
            }
            //Если разрешение уже есть — просто выводится сообщение в лог.
            else {
                Log.d("DEBUG", "READ_EXTERNAL_STORAGE уже дан");
                Toast.makeText(this, "Разрешения уже были даны", Toast.LENGTH_SHORT).show();
                textInfo.setText("Разрешение уже получено. спасибо!");
            }
        }
    }
    //Сюда приходит результат диалога разрешений (если вызывался requestPermissions).
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100) { //Если пользователь нажал «Разрешить»:
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                textInfo.setText("Разрешение получено! Спасибо!");
                Toast.makeText(this, "Разрешение получено", Toast.LENGTH_SHORT).show();
            } else { //Если отказался: Снова показываем кнопку и говорим, что без разрешения ничего не выйдет.
                textInfo.setText("Разрешение не получено. Нажмите кнопку ниже, чтобы попробовать снова.");
                btnPermission.setVisibility(View.VISIBLE);
                Toast.makeText(this, "Без разрешения приложение не сможет работать с файлами", Toast.LENGTH_LONG).show();
            }
        }
    }
}



