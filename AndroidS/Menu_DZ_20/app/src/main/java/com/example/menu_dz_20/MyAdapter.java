package com.example.menu_dz_20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// создаем переменную которая является списком строковых значений
    private List<String> myDataList; //  список строк — это  данные, которые будут отображаться в карточках.
// создаем конструктор (alt+ins) Конструктор принимает список данных и кладёт его в переменную this.dataList. Чтобы адаптер знал, с чем работать.
    public MyAdapter(List<String> myDataList) {
        this.myDataList = myDataList;
    }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//================================================================================================
// Создаём представление карточки из XML-файла item_style.xml и оборачиваем его в ViewHolder.
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//Тут мы "надуваем" (inflate) макет карточки item_style.xml — как бы создаём её визуальный шаблон.Возвращаем новый ViewHolder, который содержит ссылки на элементы внутри этой карточки.Это как построить пустую коробочку, в которую потом положим наши данные.
//LayoutInflater.from(parent.getContext()) — берёт "надуватель" разметки из контекста родительского ViewGroup (то есть из экрана, где находится RecyclerView).
//.inflate(R.layout.style_recycle_view, parent, false) — надувает (создаёт из XML) представление (View) на основе файла style_recycle_view.xml.
//parent — родитель, для правильных параметров layout, false — говорит, что сразу в иерархию этот View добавлять не надо, RecyclerView это сделает сам.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_recycle_view, parent, false);
        return new ViewHolder(view); // возвращаеv новый ViewHolder(view) и передаём туда созданный View
    }
//================================================================================================

//------------------------------------------------------------------------------------------------
// Устанавливаем текст в карточку.Назначаем слушатель на иконку удаления.Удаляем элемент из списка и обновляем список.
//для каждой позиции в списке мы кладём нужный текст в TextView карточки.
//position — это индекс текущей карточки, для которой вызывается метод.
//Далее мы добавляем слушатель на иконку корзины (deleteIcon). Если пользователь нажмёт на корзину — удаляем этот элемент из списка.

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.recycleTextStyle.setText(myDataList.get(position)); // мы обращаемся к holder это первый принимаемый аргумент этого метода (ViewHolder holder), передаем в него текст из myDataList по  position - второй принимаемый аргумент (int position)

        holder.deleteSharkIcon.setOnClickListener(new View.OnClickListener() {// жмем на иконку удаления
            @Override
            public void onClick(View v) {
                myDataList.remove(position); // удаляем элемент из myDataList по position
//                notifyDataSetChanged();// стандартный метод для обновления данных на экране. ЭТО ЛУЧШЕ ЗАМЕНИТЬ НА ДВЕ СТРОКИ НИЖЕ
                notifyItemRemoved(position); //говорит RecyclerView, что элемент с позиции position удалён. Тогда список плавно анимирует удаление.
                notifyItemRangeChanged(position, myDataList.size()); //говорит, что теперь надо обновить диапазон элементов начиная с position до конца списка, чтобы позиции элементов подстроились (иначе могут быть баги с неправильными индексами).
            }
        });
    }
//------------------------------------------------------------------------------------------------

//*************************************************************************************************
// метод возвращает количество элементов в списке.
    @Override
    public int getItemCount() {
        return myDataList.size();
    }
//*************************************************************************************************

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// метод находит элементы внутри  style_recycle_view.xml
    public class ViewHolder extends RecyclerView.ViewHolder{

// создаем переменные для доступа к элементам в style_recycle_view.xml
        TextView recycleTextStyle;
        ImageView deleteSharkIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
// доступ к элементам в MyAdapter. через itemView потому что в методе к нам приходит super(itemView)
            recycleTextStyle = itemView.findViewById(R.id.recycle_text_style);
            deleteSharkIcon = itemView.findViewById(R.id.delete_shark_icon);
        }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    }
}
