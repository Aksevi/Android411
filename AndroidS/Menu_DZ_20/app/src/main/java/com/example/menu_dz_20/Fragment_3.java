package com.example.menu_dz_20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class Fragment_3 extends Fragment {

// получаем доступ к элементам для работы с RecycleView
    private EditText listText;
    private Button addButton;
    private RecyclerView recyclerList;

    private List<String> myDataList = new ArrayList<>(); // это нужно для работы с myDataList который у нас в  MyAdapter.java
    private MyAdapter adapter; // это переменная класса  MyAdapter

    View view; // переменная типа View куда будем помещать фрагмент. нужна чтобы можно было реализовать код внутри фрагмента. без нее будут все работать кроме кода

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_3, container, false);

        // здесь  между view = inflater.inflate(R.layout.fragment_3, container, false);
        // и return view;
        // пишется код - например кнокпи поля ввода реализация нажатий кнопок и тд

//==================================================================================================
//========================работа с добавлением у удалением RecyclerView==========================
// доступ к элементам которые работают с MyAdapter, style_recycler_View.xml и RecyclerView

        listText = view.findViewById(R.id.list_text); // доступ к элементу в Fragment3.xml
        addButton = view.findViewById(R.id.add_button); // доступ к элементу в Fragment3.xml
        recyclerList = view.findViewById(R.id.recycler_list); // доступ к элементу в Fragment3.xml

        recyclerList.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext())); //LayoutManager отвечает за расположение элементов в списке. Ты выбрал вертикальный список (LinearLayoutManager).
        adapter = new MyAdapter(myDataList); //Создаём новый адаптер DataAdapter и передаём в него  список myDataList.
        recyclerList.setAdapter(adapter); //Устанавливаv адаптер в RecyclerView, чтобы он знал, как отрисовывать элементы.

        addButton.setOnClickListener(new View.OnClickListener() { //Обработка нажатия на кнопку "add List":
            @Override
            public void onClick(View v) {

                String data = listText.getText().toString(); //Берёv введённый текст из listText кладем его в локальную переменную data
                if (!data.trim().isEmpty()){ // проверка что в переменной data что то есть - если пользователь что то ввел а не просто настваил пробелов или вообще нажал доавить оставив пустую строку
                    myDataList.add(data); //Добавляем этот текст в  список myDataList.
                    listText.setText(""); //Очищаем поле ввода, чтобы удобно было вводить следующий текст
//                    adapter.notifyDataSetChanged(); //Говорим адаптеру обновить список на экране.
                    adapter.notifyItemInserted(myDataList.size() - 1);
                    recyclerList.scrollToPosition(myDataList.size() - 1); // прокрутка вниз

                }
            }
        });
        return view;
    }
}