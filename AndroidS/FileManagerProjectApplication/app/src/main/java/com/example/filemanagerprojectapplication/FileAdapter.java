package com.example.filemanagerprojectapplication;

import android.content.Context;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;

import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileViewHolder> { // имплементируй методы (3 шт)

    // Поля класса
    private Context context; //context — нужен для загрузки ресурсов, инфлейтера и форматирования размера файлов.
    private List<File> file; //file — список объектов File, который адаптер будет отображать.
    private OnFileSelectedListener listener; // listener — интерфейс, чтобы сообщать активности/фрагменту, какой файл кликнули или удержали.



    //конструктор alt+ins
    //передаёшь сюда:
    //context — от активности или фрагмента,
    //file — список файлов,
    //listener — чтобы обрабатывать нажатия.
    public FileAdapter(Context context, List<File> file, OnFileSelectedListener listener) {
        this.context = context;
        this.file = file;
        this.listener = listener;

    }


// этот метод определяет какой слой использовать в зависимости от того в какой памяти находимся - внутренней или внешней
    // грубо говоря  - выбрали в проводнике тип памяти - программа бежит по списку файлов в этой памяти и смотрит какой к этим файлам путь. если в этом пути есть "sdcard" то возвращает 1 если нет - 0
    @Override
    public int getItemViewType(int position) {
        File currentFile = file.get(position); // position — индекс элемента из списка файлов. currentFile — файл по этому индексу.
        String path = currentFile.getAbsolutePath().toLowerCase(); // path — строка с полным путём к этому файлу в нижнем регистре.

        if (path.contains("sdcard")) { // если путь содержит "sdcard"
            return 1; // возвращаем 1
        } else { // иначе возвращаем 2
            return 0;
        }
    }

//Метод onCreateViewHolder() Здесь приходит viewType из getItemViewType
    //
    @NonNull
    @Override
    public FileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

// соответственно здесь если в методе выше вернулось 1 то один стиль используем если 0 - другой
        int layoutId = (viewType == 1) ? R.layout.file_container: R.layout.file_container_external; // в зависимости от того что пришло из метода getItemViewType выше 1 или 0 в layoutId попадает стиль file_container или file_container_external
        View view  = LayoutInflater.from(context).inflate(layoutId, parent, false); // соотвественно создаем view и в него уже дуем соответствующий стиль
        return new FileViewHolder(view);

    }

//    Метод onBindViewHolder() Здесь происходит заполнение карточки файла — иконка, название, размер или количество вложенных файлов:
    @Override
    public void onBindViewHolder(@NonNull FileViewHolder holder, int position) {
//Название файла
        holder.tvFileName.setText(file.get(position).getName()); //Отображаем имя файла.
        holder.tvFileName.setSelected(true); //setSelected(true) — нужно, чтобы TextView мог прокручиваться (например, если ellipsize="marquee" в XML).

        int items = 0; // просто счетчик

//Проверка: если элемент — это папка.
        if (file.get(position).isDirectory()){
            File[] files = file.get(position).listFiles();
            for (File singleFile : files){
                if (!singleFile.isHidden()){ //Считаем все НЕ скрытые файлы внутри.
                    items += 1;
                }
            }
            holder.tvFileSize.setText(items + " Files"); //Показываем количество файлов.
        }
        //Если это файл:
        else {
            holder.tvFileSize.setText(Formatter.formatShortFileSize(context, file.get(position).length())); //Показываем размер файла, форматируя его (например: 1.2 MB).
        }
//Выбор иконки по расширению Подбираем иконку в зависимости от расширения файла.
        if (file.get(position).getName().toLowerCase().endsWith(".jpeg")){
            holder.imgFileType.setImageResource(R.drawable.image_icon);
        } else if (file.get(position).getName().toLowerCase().endsWith(".jpg")){
            holder.imgFileType.setImageResource(R.drawable.image_icon);
        }
        else if (file.get(position).getName().toLowerCase().endsWith(".png")){
            holder.imgFileType.setImageResource(R.drawable.image_icon);
        }
        else if (file.get(position).getName().toLowerCase().endsWith(".pdf")){
            holder.imgFileType.setImageResource(R.drawable.pdf_icon);
        }
        else if (file.get(position).getName().toLowerCase().endsWith(".doc")){
            holder.imgFileType.setImageResource(R.drawable.doc_icon);
        }
        else if (file.get(position).getName().toLowerCase().endsWith(".docx")){
            holder.imgFileType.setImageResource(R.drawable.doc_icon);
        }
        else if (file.get(position).getName().toLowerCase().endsWith(".mp3")){
            holder.imgFileType.setImageResource(R.drawable.audio_icon);
        }
        else if (file.get(position).getName().toLowerCase().endsWith(".wav")){
            holder.imgFileType.setImageResource(R.drawable.audio_icon);
        }
        else if (file.get(position).getName().toLowerCase().endsWith(".apk")){
            holder.imgFileType.setImageResource(R.drawable.apk_icon);
        }
        else if (file.get(position).getName().toLowerCase().endsWith(".mp4")){
            holder.imgFileType.setImageResource(R.drawable.video_icon);
        }
        else {
            holder.imgFileType.setImageResource(R.drawable.fold_ico);
        }
//Обработка нажатий
// короткое нажатие Вызывается метод onFileClicked() из интерфейса — например, откроет папку или файл.
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFileClicked(file.get(position)); // onFileClicked из интерфеса
            }
        });

// длинное нажатие  вызывает другой метод — например, можно выбрать файл, вызвать контекстное меню или начать копирование
        holder.container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                listener.onFileLongClicked(file.get(position)); // onFileLongClicked из интерфеса
                return true;
            }
        });
    }

//Метод getItemCount() Сколько элементов в списке — столько и карточек будет в RecyclerView.
    @Override
    public int getItemCount() {
        return file.size();
    }
}

//
//Создаёт карточки для файлов/папок.
//Показывает иконку, имя, размер или кол-во вложенных файлов.
//Реагирует на нажатия и передаёт информацию через интерфейс.
//Работает с разными типами данных: папки, фото, музыка, документы.
