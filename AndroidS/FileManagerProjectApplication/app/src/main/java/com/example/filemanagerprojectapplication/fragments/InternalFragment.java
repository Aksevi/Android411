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


public class InternalFragment extends Fragment  implements OnFileSelectedListener {

    private FileAdapter fileAdapter; // переменная адаптера

    // переменные
    private RecyclerView recyclerView;
    private List<File> fileList; // для работы со списком файлов
    private ImageView imgBack;
    private TextView tvPathFolder;

    File storage;
    String data;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_internal, container, false);

// доступ к переменным
        imgBack = view.findViewById(R.id.img_back);
        tvPathFolder = view.findViewById(R.id.tv_path_folder);

// получение доступа к ВНУТРЕННЕЙ SD карте
        String internalStorage = System.getenv("EXTERNAL_STORAGE");//Это путь вроде /storage/emulated/0 — корень пользовательского хранилища.
        storage = new File(internalStorage); //Создание объекта File

        if (getArguments() != null){
            data = getArguments().getString("path");
            storage = new File(data);
        }

        tvPathFolder.setText(storage.getAbsolutePath());//Установка текста с путем к папке

        runtimePermission(); // Запрос разрешений на доступ к файлам

        return view;
    }

    // метод запроса разрешений. Метод проверяет, есть ли нужные разрешения, и если нет — запрашивает их.
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
        //Тут всё жёстче — Android требует "All Files Access", а не просто READ_EXTERNAL_STORAGE.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                try {
                    Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    intent.setData(uri);
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(String.format("package:%s", getActivity().getPackageName())));
                    getActivity().startActivityIfNeeded(intent, 101);
                } catch (Exception e) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    getActivity().startActivityIfNeeded(intent, 101);
                }
            }
            if (Environment.isExternalStorageManager()) {
                displayFiles();
            }
        }
    }

    // Метод поиска файлов Этот метод ищет файлы и папки в указанной директории. Возвращает список файлов.
    public ArrayList<File> findFiles(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();

        assert files != null;
        for (File singleFile : files) {
            if (singleFile.isDirectory() && !singleFile.isHidden()) { //Сначала ищем все папки (не скрытые).
                arrayList.add(singleFile);
            }
        }
        for (File singleFile : files) { //Потом ищем файлы с нужными расширениями:
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

    //метод отображения файлов
    private void displayFiles() {

        recyclerView = view.findViewById(R.id.recycler_internal); //Получаем RecyclerView из view
        recyclerView.setHasFixedSize(true); // настройка нужна если размер recyclerView  не зафиксирован нами вручную

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // содержимое выводим в 2 колонки

        fileList = new ArrayList<>(); //Получаем список файлов:
        fileList.addAll(findFiles(storage));
        System.out.println("!!!!!!!!!!!!!!!!" + fileList);

        fileAdapter = new FileAdapter(getContext(), fileList, this);
        recyclerView.setAdapter(fileAdapter);
    }

    // При клике по папке - Создаётся новый фрагмент InternalFragment. Передаётся путь к новой папке через Bundle. Выполняется замена фрагмента (replace) с добавлением в стек (addToBackStack).
    @Override
    public void onFileClicked(File file) {
        if (file.isDirectory()){
            Bundle bundle = new Bundle();
            bundle.putString("path", file.getAbsolutePath());
            InternalFragment internalFragment = new InternalFragment();
            internalFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, internalFragment).addToBackStack(null).commit();
        }

    }

    @Override
    public void onFileLongClicked(File file) {

    }
}
//Что делает InternalFragment
//Это фрагмент, который:
//Запрашивает разрешения на доступ к хранилищу.
//Получает путь к папке (по умолчанию — /storage/emulated/0, но можно передать другой путь через Bundle).
//Показывает путь в TextView.
//Находит и отображает папки + файлы с нужными расширениями в RecyclerView.
//При клике на папку — открывает её (новый InternalFragment с новым path).

