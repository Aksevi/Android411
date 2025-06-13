package com.example.filemanagerprojectapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

//FileViewHolder Это обёртка для одного элемента списка в RecyclerView.
//У тебя есть список файлов (например, 10 штук).
//Для каждого файла создаётся "визитка" — отдельный layout (например, карточка с названием, иконкой и размером).
//ViewHolder — это класс, который связывает элементы из layout'а с Java-кодом, чтобы мы могли в них что-то писать (например, имя файла, иконку и размер).

//Этот класс расширяет (extends) стандартный ViewHolder,  его будем использовать в своём Adapter.
public class FileViewHolder extends RecyclerView.ViewHolder { // наведи и создай конструктор

// элементы интерфейса, которые будут использоваться в каждой карточке:
    public TextView tvFileName, tvFileSize; // доступ к элементам из file container.xml
    public CardView container; // доступ к элементам из file container.xml
    public ImageView imgFileType; // доступ к элементам из file container.xml


// конструктор. itemView — это одна отдельная карточка (layout для одного файла), которую отдаёт RecyclerView  .
    public FileViewHolder(@NonNull View itemView) {
        super(itemView);

        //доступ к элементам интерфейса:
        tvFileName = itemView.findViewById(R.id.tv_file_name);
        tvFileSize= itemView.findViewById(R.id.tv_file_size);
        container = itemView.findViewById(R.id.container);
        imgFileType = itemView.findViewById(R.id.img_file_type);

    }
}

//Подводим итог:
//🔸 FileViewHolder — это мост между XML-шаблоном одного файла в списке и Java-кодом.
//🔸 Он держит ссылки на нужные TextView, ImageView, и CardView, чтобы адаптер мог работать с ними.
//🔸 Используется внутри RecyclerView.Adapter, который ты, скорее всего, будешь или уже пишешь.