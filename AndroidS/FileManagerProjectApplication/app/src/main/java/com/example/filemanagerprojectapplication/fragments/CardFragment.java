package com.example.filemanagerprojectapplication.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filemanagerprojectapplication.FileAdapter;
import com.example.filemanagerprojectapplication.OnFileSelectedListener;
import com.example.filemanagerprojectapplication.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CardFragment extends Fragment implements OnFileSelectedListener { // Это фрагмент, то есть "экран" внутри приложения. Он реализует интерфейс OnFileSelectedListener — то есть умеет реагировать на нажатия по файлам.

//Поля класса
    private FileAdapter fileAdapter; // переменная адаптера который подкидывает файлы в RecyclerView.

    // переменные
    private RecyclerView recyclerView; //виджет для списка файлов (в виде сетки)
    private List<File> fileList; // список найденных файлов.
    private ImageView cardImgBack; //кнопка "назад" (пока не используется).
    private TextView cardTvPathFolder; //текстовое поле с текущим путём.

    File storage; //текущая папка, откуда показываем файлы.

    View view; //корневой View фрагмента.


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_card, container, false);

// доступ к переменным из fragment_card.xml
        cardImgBack = view.findViewById(R.id.card_img_back);
        cardTvPathFolder = view.findViewById(R.id.card_tv_path_folder);

// получаем доступ к ВНЕШНЕЙ карте памяти
        File[] externalDirs = ContextCompat.getExternalFilesDirs(getContext(), null); // Метод getExternalFilesDirs() Получает массив путей, где приложение может хранить файлы: externalDirs[0] — это внутренняя память (например: /storage/emulated/0/Android/data/твоё_приложение/files). externalDirs[1] — это SD-карта, если она вставлена (например: /storage/XXXX-XXXX/Android/data/твоё_приложение/files)


        if (externalDirs.length > 1 && externalDirs[1] != null) { // Проверка: В массиве есть хотя бы 2 пути (length > 1) и Второй путь (SD-карта) реально существует (не null). если проще то строка читается так "Если в массиве есть второй путь, и он реально указывает на SD-карту — работаем с ним!"
            // Внешняя SD-карта доступна. Действие:

            storage = getSdCardRoot(); // находим корень sd карты через метод getSdCardRoot() (он ниже)

// если путь к папке был передан через Bundle (например, кликнули по папке):
            if (getArguments() != null) {
                String card_data = getArguments().getString("path");
                storage = new File(card_data);
            }
// то Отображаем путь:
            cardTvPathFolder.setText("SD-карта: " + storage.getAbsolutePath());// Показываешь путь на экране

            runtimePermission(); // вызов метода запроса разрешений

        } else {
            // Если SD-карты нет — используем внутреннюю
            storage = new File(Environment.getExternalStorageDirectory().getAbsolutePath()); //Используем стандартный путь к внутренней памяти
            cardTvPathFolder.setText("Встроенная память: " + storage.getAbsolutePath()); //Отображаем, что работаем с внутренней

            runtimePermission(); // вызов метода запроса разрешений
        }
        return view;
    }

// метод запроса разрешений
    private void runtimePermission() {
// +++++++++++++++++ разрешения до 10 андроида (API 29)+++++++++++++++++++++++++++++++++++++++++++++
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
//если разрешение не дано
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            }
//если разрешение  дано
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                displayFiles(); // метод см ниже
            }
        }
//--------------------------- разрешения для андроид 11 (API 30) и выше-----------------------------
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
// если разрешение не дано
            if (!Environment.isExternalStorageManager()) {
                try {
                    Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null); // "package" просто имя
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    intent.setData(uri);
                    intent.addCategory("android.intent.category.DEFAULT"); // "android.intent.category.DEFAULT" - стандартная надпись
                    intent.setData(Uri.parse(String.format("package:%s", getActivity().getPackageName())));
                    getActivity().startActivityIfNeeded(intent, 101);

                } catch (
                        Exception e) { // если даже где то ошибка то все равно проверяем есть ли разрешения и просим их дать
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    getActivity().startActivityIfNeeded(intent, 101);
                }
            }
            if (Environment.isExternalStorageManager()) {
                displayFiles(); // метод см ниже
            }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//--------------------------------------------------------------------------------------------------
        }
    }

// Метод поиска файлов. Ищет файлы и папки в переданной папке.
    public ArrayList<File> findFiles(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();

//        assert files != null;
        if (files == null) return new ArrayList<>();
// и Добавляет в список: Сначала все видимые папки.
        for (File singleFile : files) {
            if (singleFile.isDirectory() && !singleFile.isHidden()) {
                arrayList.add(singleFile);
            }
        }
//Потом файлы нужных типов (jpg, mp3, mp4, pdf, doc, apk...).
        for (File singleFile : files) {
            if (singleFile.getName().toLowerCase().endsWith(".jpeg") ||
                    singleFile.getName().toLowerCase().endsWith(".jpg") ||
                    singleFile.getName().toLowerCase().endsWith(".png") ||
                    singleFile.getName().toLowerCase().endsWith(".mp3") ||
                    singleFile.getName().toLowerCase().endsWith(".wav") ||
                    singleFile.getName().toLowerCase().endsWith(".mp4") ||
                    singleFile.getName().toLowerCase().endsWith(".pdf") ||
                    singleFile.getName().toLowerCase().endsWith(".doc") ||
                    singleFile.getName().toLowerCase().endsWith(".docx") ||
                    singleFile.getName().toLowerCase().endsWith(".apk")) {

                arrayList.add(singleFile);
            }
        }
        return arrayList;

    }

    //метод отображения файлов. Выводит список файлов в RecyclerView.
    private void displayFiles() {

        recyclerView = view.findViewById(R.id.recycler_internal);
        recyclerView.setHasFixedSize(true); // настройка нужна если размер recyclerView  не зафиксирован нами вручную

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // содержимое выводим в 2 колонки
        fileList = new ArrayList<>();
        fileList.addAll(findFiles(storage));

        fileAdapter = new FileAdapter(getContext(), fileList, this);
        recyclerView.setAdapter(fileAdapter);
    }
//======================================Обработка кликов============================================
    //Если пользователь нажимает на папку:  открываем новый фрагмент, передаём путь — и показываем содержимое этой папки.
    @Override
    public void onFileClicked(File file) {
        if (file.isDirectory()) {
            Bundle bundle = new Bundle();
            bundle.putString("path", file.getAbsolutePath());
            CardFragment cardFragment = new CardFragment();
            cardFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cardFragment).addToBackStack(null).commit();
        }
    }

    @Override
    public void onFileLongClicked(File file) {

    }

// ищем корень sd карты
    //Цель метода  Из стандартного пути вроде: /storage/XXXX-XXXX/Android/data/com.example.app/files/
    //получить: /storage/XXXX-XXXX То есть корневую директорию SD-карты.
    public File getSdCardRoot() {
        // Метод возвращает массив путей:
        //dirs[0] — внутренняя память: /storage/emulated/0/Android/data/...
        //dirs[1] — SD-карта (если есть): /storage/XXXX-XXXX/Android/data/...
        File[] dirs = ContextCompat.getExternalFilesDirs(getContext(), null);
        //Мы хотим использовать второй путь — dirs[1].
        if (dirs != null && dirs.length > 1 && dirs[1] != null) {
            File sdPath = dirs[1]; //Сохраняем путь к SD-карте в переменную sdPath. На этом этапе он выглядит примерно так: /storage/XXXX-XXXX/Android/data/com.example.app/files/
            File parent;
            // Поднимаемся вверх, пока не найдём родителя с именем "storage"
            //цикл, который "шагает" вверх по дереву папок. Что мы делаем:
            //sdPath.getParentFile() — получаем родительскую папку.
            //Проверяем: имя папки не равно "storage" (всё ещё на SD-карте).
            while ((parent = sdPath.getParentFile()) != null && !parent.getName().equalsIgnoreCase("storage")) {
                sdPath = parent; //Если не дошли до /storage, то делаем шаг назад: sdPath = parent.
            }
            if (parent != null && parent.getName().equalsIgnoreCase("storage")) {
                return sdPath; //Когда мы дошли до /storage/XXXX-XXXX, возвращаем этот путь.
 //Пример как работает:
                //Шаг 1: /storage/XXXX-XXXX/Android/data/... → родитель = /storage/XXXX-XXXX/Android/data/
                //Шаг 2: → /storage/XXXX-XXXX/Android/
                //Шаг 3: → /storage/XXXX-XXXX/
                //Шаг 4: родитель = /storage/ → имя storage — стоп! Цикл завершён.
            }
        }
        return null;
    }

}

