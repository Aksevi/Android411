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
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.filemanagerprojectapplication.FileAdapter;
import com.example.filemanagerprojectapplication.FileOpener;
import com.example.filemanagerprojectapplication.OnFileSelectedListener;
import com.example.filemanagerprojectapplication.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    String[] items = {"Details", "Rename", "Delete"}; // массив для option dialog  пункты меню при долгом нажатии на файл.


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

/*            storage = getSdCardRoot(); // находим корень sd карты через метод getSdCardRoot() (он ниже и тоже закоментирован)*/

//            storage = new File(externalDirs[1].getAbsolutePath().substring(0, 19)); // получаем путь к памяти и обрезам его с по 19 символ. но это не очень правильно. поэтому строкой ниже сделал правильнее
            storage = new File(externalDirs[1].getAbsolutePath().split("/Android")[0]); //берёт полный путь к папке SD-карты, в которой твоё приложение может хранить файлы, и обрезает его до корневой папки SD-карты, чтобы ты мог работать с всеми её файлами, а не только со служебной папкой.
            // sdCardAppPath.getAbsolutePath() Это путь к каталогу files на SD-карте, выделенному только для твоего приложения: (/storage/XXXX-XXXX/Android/data/твоё_приложение/files)
            //.split("/Android")- Метод split() делит строку по подстроке "/Android", и возвращает массив строк:
            // String[] parts = {
            //    "/storage/XXXX-XXXX", // [0]
            //    "/data/твоё_приложение/files" // [1] — всё, что после "/Android"
            //То есть [0] — это всё ДО "/Android" — это и есть корень SD-карты.
            //[0] - Мы берём только первую часть — "до Android":


// если путь к папке был передан через Bundle (например, кликнули по папке):
            if (getArguments() != null) {
                String card_data = getArguments().getString("path");
                storage = new File(card_data);
            }
// то Отображаем путь:
            cardTvPathFolder.setText("SD-карта: " + storage.getAbsolutePath().trim());// Показываешь путь на экране

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
        } else {  // если клик по файлу - открывается файл
            FileOpener.openFile(getContext(), file); // вызываем метод openFile из класса  FileOpener
        }
    }

    @Override
    public void onFileLongClicked(File file, int position) {

        final Dialog optionDialog = new Dialog(getContext()); // константа класса  Dialog c именем optionDialog и в нее кладем экземпляр класса Dialog Создаём новое диалоговое окно Dialog. Это будет наше меню с действиями. getContext() — берёт текущий контекст (активность или фрагмент).
        optionDialog.setContentView(R.layout.option_dialog); // Устанавливаем макет диалога из res/layout/option_dialog.xml
        optionDialog.setTitle("Select Options."); // Задаём заголовок: «Select Options»

        ListView options = optionDialog.findViewById(R.id.list_item); //Ищем внутри диалога ListView, в котором будут отображаться пункты меню.

        CardFragment.CustomAdapter customAdapter = new CardFragment.CustomAdapter(); //Создаём экземпляр  адаптера CustomAdapter, который умеет показывать текст и иконки
        options.setAdapter(customAdapter); //Устанавливаем адаптер для списка.
        optionDialog.show(); //Показываем диалог на экране.

// оживляем элементы контекстного меню
//адаём, что делать при нажатии на пункт меню
        options.setOnItemClickListener(new AdapterView.OnItemClickListener() { // options (см в 187 стр) - это наш список  который берем из поля list_item в option_dialog.xml
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = parent.getItemAtPosition(position).toString(); //Получаем выбранный пункт (Details, Rename, Delete...)

                switch (selectedItem) {
// *************************************************************************************************
// **********************************DETAILS********************************************************
                    case "Details": // если нажали Details
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

                        AlertDialog alertDialogDetails = detailDialog.create(); //Создаём AlertDialog из билдера.
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

// метод поиска корня карты. работает вместе с 79 строкой. его просто вызываем когда получаем доступ к карте
/*    // ищем корень sd карты
    //Цель метода  Из стандартного пути вроде: /storage/XXXX-XXXX/Android/data/com.example.app/files/
    //получить: /storage/XXXX-XXXX То есть корневую директорию SD-карты.
    public File getSdCardRoot() {
        // Метод возвращает массив путей:
        //dirs[0] — внутренняя память: /storage/emulated/0/Android/data/...
        //dirs[1] — SD-карта (если есть): /storage/XXXX-XXXX/Android/data/...
        File[] dirs = ContextCompat.getExternalFilesDirs(getContext(), null);
        //хотим использовать второй путь — dirs[1].
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
    }*/
}



