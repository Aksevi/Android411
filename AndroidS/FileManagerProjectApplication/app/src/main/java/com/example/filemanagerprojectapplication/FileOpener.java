package com.example.filemanagerprojectapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.core.content.FileProvider;

import java.io.File;

// Это утилитный класс, который умеет открывать файл через соответствующее приложение на телефоне (например, PDF откроется в PDF-читалке, картинка — в галерее и т.п.).
public class FileOpener {

// метод открытия файлов
    public static void openFile(Context context, File file){ // public static — можно вызвать из любого места без создания объекта класса. Context context — нужен для создания Intent и запуска активности. File file — передаём сюда конкретный файл, который хотим открыть.

        File selectedFile = file; // переменная selectedFile в которую приходит file из public static void openFile(Context context, File file)

// Получаем безопасный URI ⚠️ Без этого шага Android просто не даст открыть файл с file://,
//        Uri uri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", file); // FileProvider создаёт content:// URI из обычного файла. .getUriForFile() принимает:  context — кто запрашивает.  authority — должен совпадать с тем, что ты указал в AndroidManifest.xml (в <provider>), например: com.myapp.filemanager.provider.   file — тот самый файл, который хотим открыть.
        Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file); // FileProvider создаёт content:// URI из обычного файла. .getUriForFile() принимает:  context — кто запрашивает.  authority — должен совпадать с тем, что ты указал в AndroidManifest.xml (в <provider>), например: com.myapp.filemanager.provider.   file — тот самый файл, который хотим открыть.

//Создаём Intent на открытие файла:
        Intent intent = new Intent(Intent.ACTION_VIEW); // объявляем намерение просмотреть файл
//Определяем тип файла: чтобы Android знал, какой тип содержимого мы открываем
        if (uri.toString().contains(".doc")){
            intent.setDataAndType(uri, "application/msword");
        }
        else if (uri.toString().contains(".pdf")){ //uri.toString().contains(".pdf") — это не самое надёжное решение, лучше проверять file.getName().endsWith(".pdf"), но это решение тоже работает в большинстве случаев.
            intent.setDataAndType(uri, "application/pdf");
        }
        else if (uri.toString().contains(".mp3") || uri.toString().contains(".wav")){
            intent.setDataAndType(uri, "audio/x-wav");
        }
        else if (uri.toString().contains(".jpeg") || uri.toString().contains(".jpg") || uri.toString().contains(".png")){
            intent.setDataAndType(uri, "image/jpeg");
        }
        else if (uri.toString().contains(".mp4")){
            intent.setDataAndType(uri, "video/*");
        }
        else {
            intent.setDataAndType(uri, "*/*");
        }
//Добавляем флаг Разрешает временному приложению (например, PDF-читалке) читать твой файл, получив content:// URI. Без него другое приложение не получит доступ к файлу.
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//Запускаем. Android находит подходящее приложение и запускает его, передав туда intent.
        context.startActivity(intent);
    }
}
