package com.example.fragmentmenuaplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

 // создаем переменную которая является списком строковых значений
    private List<String> dataList; // Тут у тебя список строк — это твои данные, которые будут отображаться в карточках.
// создаем конструктор (alt+ins) Конструктор принимает список данных и кладёт его в переменную this.dataList. Чтобы адаптер знал, с чем работать.

    public DataAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

// Создаём представление карточки из XML-файла item_style.xml и оборачиваем его в ViewHolder.
    //Тут мы "надуваем" (inflate) макет карточки item_style.xml — как бы создаём её визуальный шаблон.Возвращаем новый ViewHolder, который содержит ссылки на элементы внутри этой карточки.Это как построить пустую коробочку, в которую потом положим наши данные.
    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_style, parent, false);
        return new ViewHolder(view);
    }

// Устанавливаем текст в карточку.Назначаем слушатель на иконку удаления.Удаляем элемент из списка и обновляем список.
//для каждой позиции в списке мы кладём нужный текст в TextView карточки.
//position — это индекс текущей карточки, для которой вызывается метод.
//Далее мы добавляем слушатель на иконку корзины (deleteIcon). Если пользователь нажмёт на корзину — удаляем этот элемент из списка.

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        holder.itemStyleText.setText(dataList.get(position)); // мы обращаемся к holder это первый принимаемый аргумент этого метода (ViewHolder holder), передаем в него текст из dataList по  position - второй принимаемый аргумент (int position).

        holder.deleteIcon.setOnClickListener(new View.OnClickListener() {// устанавливаем в holder иконку корзины и обрабатываем нажатие на нее
            @Override
            public void onClick(View v) {
                dataList.remove(position); // удаляем элемент из dataList по position
                notifyDataSetChanged(); //После удаления вызываем notifyDataSetChanged(), чтобы RecyclerView обновил экран и убрал удалённый элемент. метод (стандартный) для обновления отображения данных на экране
            }
        });
    }
// метод возвращает количество элементов в списке.
    @Override
    public int getItemCount() {
        return dataList.size();
    }


// метод находит элементы внутри item_style.xml.
    public class ViewHolder extends RecyclerView.ViewHolder { //ViewHolder — это “коробочка” для каждого отдельного элемента списка.

        // создаем переменные для доступа к элементам в стиле CardView (он у нас называется item_style)
        TextView itemStyleText; // переменная для работы с элементом в item_style.xml
        ImageView deleteIcon;

        public ViewHolder(@NonNull View itemView) { //В конструкторе мы находим нужные элементы в макете карточки (TextView и ImageView), чтобы потом к ним легко обращаться.
            super(itemView);

            itemStyleText = itemView.findViewById(R.id.item_style_text); // доступ к элементам в DataAdapter. через itemView потому что в методе к нам приходит super(itemView)
            deleteIcon = itemView.findViewById(R.id.delete_icon);
        }
    }
}
