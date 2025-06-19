package com.example.filemanagerprojectapplication.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filemanagerprojectapplication.FileAdapter;
import com.example.filemanagerprojectapplication.FileOpener;
import com.example.filemanagerprojectapplication.OnFileSelectedListener;
import com.example.filemanagerprojectapplication.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.text.format.Formatter;
import android.widget.Toast;

import java.util.List;


//Назначение класса InternalFragment
//Это фрагмент, который отвечает за:
//отображение списка файлов во внутреннем хранилище (/storage/emulated/0)
//переход по папкам
//открытие файлов
//отображение информации о файлах (по долгому нажатию)
//обработку разрешений на доступ к памяти

public class InternalFragment extends Fragment implements OnFileSelectedListener {

    private FileAdapter fileAdapter; // переменная адаптера

    // переменные
    private RecyclerView recyclerView; //виджет, в котором будут отображаться файлы и папки.
    private List<File> fileList; //  список файлов, которые нужно показать.
    private ImageView imgBack;
    private TextView tvPathFolder;// отображение текущего пути.

    File storage; //текущая директория.
    String data; //путь, переданный во фрагмент.

    View view;

    String[] items = {"Details", "Rename", "Delete"}; // массив для option dialog  пункты меню при долгом нажатии на файл.

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

        if (getArguments() != null) {
            data = getArguments().getString("path");
            storage = new File(data);
        }

        tvPathFolder.setText(storage.getAbsolutePath());// Отображает путь.

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
            }
// для того чтобы в API 28 позволял переименовывать - добавляем вот этот блок if и меняем  READ_EXTERNAL_STORAGE в стр 108 109 и 112 на WRITE_EXTERNAL_STORAGE
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
//если разрешение  дано
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                displayFiles(); // метод см ниже
            }
        }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
        return arrayList; //Возвращает ArrayList<File> — список найденного.
    }

    //метод отображения файлов
    private void displayFiles() {

        recyclerView = view.findViewById(R.id.recycler_internal); //Получаем RecyclerView из view
        recyclerView.setHasFixedSize(true); // настройка нужна если размер recyclerView  не зафиксирован нами вручную

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // содержимое выводим в 2 колонки

        fileList = new ArrayList<>(); //Получаем список файлов:
        fileList.addAll(findFiles(storage));
        System.out.println("!!!!!!!!!!!!!!!!" + fileList);

        fileAdapter = new FileAdapter(getContext(), fileList, this); //Создаёт и подключает адаптер (FileAdapter).
        recyclerView.setAdapter(fileAdapter);
    }

    // При клике по папке - Создаётся новый фрагмент InternalFragment. Передаётся путь к новой папке через Bundle. Выполняется замена фрагмента (replace) с добавлением в стек (addToBackStack).
    @Override
    public void onFileClicked(File file) {
        if (file.isDirectory()) { // если клик по папке - то открывается папка
            Bundle bundle = new Bundle();
            bundle.putString("path", file.getAbsolutePath());
            InternalFragment internalFragment = new InternalFragment();
            internalFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, internalFragment).addToBackStack(null).commit();
        } else {  // если клик по файлу - открывается файл
            FileOpener.openFile(getContext(), file); // вызываем метод openFile из класса  FileOpener
        }
    }

    @Override
    public void onFileLongClicked(File file, int position) { // int position добавили чтобы работать с Renaim перед этим в интерфейсе OnFileSelectedListener добавили position в аргументы onFileLongClicked

        final Dialog optionDialog = new Dialog(getContext()); // константа класса  Dialog c именем optionDialog и в нее кладем экземпляр класса Dialog Создаём новое диалоговое окно Dialog. Это будет наше меню с действиями. getContext() — берёт текущий контекст (активность или фрагмент).
        optionDialog.setContentView(R.layout.option_dialog); // Устанавливаем макет диалога из res/layout/option_dialog.xml
        optionDialog.setTitle("Select Options."); // Задаём заголовок: «Select Options»

        ListView options = optionDialog.findViewById(R.id.list_item); //Ищем внутри диалога ListView, в котором будут отображаться пункты меню.

        CustomAdapter customAdapter = new CustomAdapter(); //Создаём экземпляр  адаптера CustomAdapter, который умеет показывать текст и иконки
        options.setAdapter(customAdapter); //Устанавливаем адаптер для списка.
        optionDialog.show(); //Показываем диалог на экране.

// оживляем элементы контекстного меню
//задаём, что делать при нажатии на пункт меню
        options.setOnItemClickListener(new AdapterView.OnItemClickListener() { // options (см в 187 стр) - это наш список  который берем из поля list_item в option_dialog.xml
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = parent.getItemAtPosition(position).toString(); //Получаем выбранный пункт (Details, Rename, Delete...)

                switch (selectedItem) {
// *************************************************************************************************
// **********************************DETAILS********************************************************
                    // если нажали Details
                    case "Details":
                        AlertDialog.Builder detailDialog = new AlertDialog.Builder(getContext()); //Создаём диалог AlertDialog — это стандартное окно с кнопками и сообщением.
                        detailDialog.setTitle("Details:"); //Заголовок — «Details:»
                        final TextView details = new TextView(getContext()); //Создаём программно TextView, в который запишем инфу о файле, и устанавливаем его в окно.
                        detailDialog.setView(details); //и устанавливаем его в окно.
                        Date lastModified = new Date(file.lastModified()); // создаем переменную в которую вызвали метод возвращающий дату последних изменений файла
                        SimpleDateFormat formatted = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // в каком виде будет выводится информация о последних изменениях
                        String formattedDate = formatted.format(lastModified);

//здесь настроили вывод информации при нажатии на Details
                        details.setText("File name: " + file.getName() + "\n" +
                                "Size: " + Formatter.formatShortFileSize(getContext(), file.length()) + "\n" + "Path: " + file.getAbsolutePath() + "\n" + "Last Modified: " + formattedDate);
                        details.setPadding(70, 10, 10, 10); // программно отступы установили
// добавляем кнопку ОК на которую жмем чтобы закрыть диалог
                        detailDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                optionDialog.closeOptionsMenu();
                            }
                        });
                        AlertDialog alertDialogDetails = detailDialog.create(); //Вызываем AlertDialog  это для Details
                        alertDialogDetails.show(); //Показываем его.
                        break;
// *************************************************************************************************

//==================================================================================================
//========================================RENAME====================================================
                    // если нажали Rename
                    case "Rename":
                        AlertDialog.Builder renameDialog = new AlertDialog.Builder(getContext());// renameDialog просто название
                        renameDialog.setTitle("Rename File:"); // в renameDialog устанваливаем текст (Title - внимательно, не setText!)
                        final EditText name = new EditText(getContext()); // создаем редактируемый текст в переменной name
                        renameDialog.setView(name); // обращаемся к renameDialog через метод setView и передаем в него значение name

//Кнопки для Ok для Rename и Cancel
// добавляем кнопку Ок с обработчиком нажатия на нее
                        renameDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // Шаг 1: Получаем новое имя от пользователя
                                String newName = name.getEditableText().toString().trim();
                                File parentDir = file.getParentFile(); // Получаем папку, в которой лежит переименовываемый файл/папка.

                                String extension = ""; //Создаём пустую строку extension, куда позже (возможно) запишем расширение. Если файл окажется папкой, или у него нет точки в имени — extension так и останется пустым (""), потому что у папок и некоторых файлов нет расширений.
                                if (file.isFile()) { // Проверяем, является ли file обычным файлом, а не папкой: file.isFile() вернёт true, если это именно файл и false, если это папка
                                    int dotIndex = file.getName().lastIndexOf("."); //Находим индекс последней точки в имени (обычно перед расширением).
                                    if (dotIndex != -1) { //Если lastIndexOf(".") не находит точку, он вернёт -1. В таком случае расширения нет — значит, не трогаем extension.
                                        extension = file.getName().substring(dotIndex); // Получаем подстроку от точки до конца — то есть само расширение вместе с точкой!
                                        //Итого, что делает этот блок? Если это файл, а не папка: Ищем, есть ли расширение (точка в имени). Если есть — берём его и сохраняем. Если файл без расширения или это папка — extension остаётся пустым.
                                    }
                                }

                                File destination = new File(parentDir, newName + extension); //Создаём новый путь — куда хотим переименовать: В ту же папку (parentDir) С новым именем (newName) Плюс расширение (если файл).

                                if (file.renameTo(destination)) { //Пробуем переименовать файл или папку: renameTo(...) возвращает true, если всё прошло успешно.
//+++++++++++++++++++++++++++этот блок убрал и заработало переименование как папки и файла в корне так и файла в папке+++++++++++++++++++++++++++++++++++
//                                    fileList.set(position, destination); //Обновляем элемент в списке fileList на новое значение.
//                                    fileAdapter.notifyItemChanged(position); //Сообщаем адаптеру, что элемент на этой позиции изменился (notifyItemChanged).
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                                    Toast.makeText(getContext(), "Renamed!", Toast.LENGTH_SHORT).show();
                                    displayFiles();
                                } else {
                                    Toast.makeText(getContext(), "Rename Error!", Toast.LENGTH_SHORT).show();
                                }
//  здесь код с урока в нем не работает переименование файлов внутри папок. в корне переименовывает нормально
/*                                String newName = name.getEditableText().toString(); // берём текст из name (это поле ввода из пункта Rename), превращаем его в обычную строку и сохраняешь в newName.
// Создаём объект File, указывающий на текущий файл, который мы хотим переименовать.
                                File current = new File(file.getAbsolutePath()); // переменная для исходного файла который будем переименовывать
                                File destination;
                                if(!file.isDirectory()){
                                // Получаем расширение файла. Здесь от всего пути останется точка и расширение. и сохранится это в extension
                                String extension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".")); // file.getAbsolutePath() Получает полный путь к файлу в виде строки (например "/storage/emulated/0/Download/image.jpg"). lastIndexOf(".")  Ищет последнюю точку в этом пути. Она как раз перед расширением файла (file.getAbsolutePath().lastIndexOf(".") ➝ позиция точки перед ".jpg"). substring(...) Берёт подстроку от этой точки до конца строки, то есть возвращает (".jpg" - да вместе с точкой!). Что будет в переменной extension? - ".jpg"//Если тебе нужно только расширение без точки, можно сделать вот так: String extension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".") + 1);
                                destination = new File(file.getAbsolutePath().replace(file.getName(), newName) + extension); // Эта строка создаёт новый путь для файла, заменяя старое имя файла на новое, и добавляя расширение. file.getAbsolutePath() - получаем полный путью file.getName() - Получаем только имя файла (без пути). .replace(file.getName(), newName) - заменяем исходное имя на новое. + extension - добавляем расширение. Все это сохраняем в destination
                                }
                                else {
                                    destination = new File(file.getAbsolutePath().replace(file.getName(), newName));
                                }
                                 if (current.renameTo(destination)){// если текущий файл или папка (в current попадает и то и другое) имеет расширение
                                    fileList.set(position, destination); // Обновляем список файлов (fileList) — заменяем старый файл на новый по позиции position
                                    fileAdapter.notifyItemChanged(position); // Сообщаем адаптеру  что на позиции position что-то изменилось.
                                    Toast.makeText(getContext(), "Renamed!", Toast.LENGTH_SHORT).show(); // сообщение "Renamed!" — подтверждение успешного действия. getContext() означает что это сообщение появится в этом окне
                                     displayFiles(); // сразу обновляем экран чтобы переименованный файл увидеть
                                }
                                else {
                                    Toast.makeText(getContext(), "Renamed Error!", Toast.LENGTH_SHORT).show(); // если переименование не удалось — выводим сообщение об ошибке.
// Что делает весь блок? Когда пользователь жмёт "ОК" в диалоге переименования: //Читает новый текст, который он ввёл.//Выделяет расширение исходного файла.//Создаёт новый путь с новым именем и тем же расширением.
//Пытается переименовать файл.//Если успешно://Обновляет список файлов.//Обновляет UI.//Показывает тост "Renamed!".//Если неуспешно://Показывает "Renamed Error!"
                            }*/
                            }
                        });
                        // добавляем кнопку Cancel с обработчиком нажатия на нее
                        renameDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                optionDialog.cancel(); // жмем Cancel и окно Rename закрывается
                            }
                        });
                        AlertDialog alertDialogRenaime = renameDialog.create(); //вызываем AlertDialog. это для Renaim
                        alertDialogRenaime.show();
                        break;
//==================================================================================================

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++DELETE+++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    case "Delete":
                        AlertDialog.Builder deleteDialog = new AlertDialog.Builder(getContext()); // создаем диалоговое окно
                        deleteDialog.setTitle("Delete " + file.getName() + "?"); // устанавливаем текст заголовка

// кнопк подтверждения удаления
                        deleteDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                file.delete(); // если нажали yes удаляем файл
                                displayFiles();// вызываем метод который ввепху - он обновляет список файлов и отрисовывает с учетом удаленных
                                Toast.makeText(getContext(), "Deleted file " + file.getName(), Toast.LENGTH_SHORT).show();// сообщение об удалении файла
                            }
                        });
// кнопк отмены удаления
                        deleteDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                optionDialog.cancel();
                            }
                        });

                        AlertDialog alertDialogDelete = deleteDialog.create(); // сохраняем в alertDialogDelete то что сделали выше (диалоговое окно с текстом заголовка)
                        alertDialogDelete.show(); // показываем этот диалог
                        break;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                    // ИТОГ: что делает этот метод? Пользователь долго жмёт на файл. Открывается диалог с действиями (список).  при выборе соответствующего действия оно и происходит
                }
            }
        });

    }

    // Адаптер для контекстного меню: наследуется о базового адаптера
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return items.length; // здесь определяется длина списка (сколько будет элементов в нем)
        }

        @Override
        public Object getItem(int position) {
            return items[position]; // здесь он формирует что именно будет написано в контекстном меню. position это принимаемый аргумент этого метода - здесь текст Details Renaim Delete  из нвшего String[] items в 52 строке
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        // getView() возвращает кастомное представление с текстом и иконкой:
        //🛈 Details
        //✏️ Rename
        //🗑 Delete
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View myView = getLayoutInflater().inflate(R.layout.option_layout, null); // создаем новый view где будет надуваться и размещаться собственно само контекстного меню
            TextView txtOption = myView.findViewById(R.id.txt_option); // доступ к полю в option_layout в таком виде потому что у нас типа как во view все это
            ImageView imgOption = myView.findViewById(R.id.img_option); // доступ к полю в option_layout в таком виде потому что у нас типа как во view все это

            txtOption.setText(items[position]); // здесь текст в элементы списка помещаем в зависимости от позиции

            // здесь иконки элементам списка даем  в зависимости от названия пункта списка
            if (items[position].equals("Details")) {
                imgOption.setImageResource(R.drawable.info_icon);
            } else if (items[position].equals("Rename")) {
                imgOption.setImageResource(R.drawable.edit_icon);
            } else if (items[position].equals("Delete")) {
                imgOption.setImageResource(R.drawable.delete_icon);

            }
            return myView;
        }
    }
}
//Что делает InternalFragment
//Это фрагмент, который:
//Запрашивает разрешения на доступ к хранилищу.
//Получает путь к папке (по умолчанию — /storage/emulated/0, но можно передать другой путь через Bundle).
//Показывает путь в TextView.
//Находит и отображает папки + файлы с нужными расширениями в RecyclerView.
//При клике на папку — открывает её (новый InternalFragment с новым path).
//При длинном  клике на папку — открывает контекстное меню с выбором опций

