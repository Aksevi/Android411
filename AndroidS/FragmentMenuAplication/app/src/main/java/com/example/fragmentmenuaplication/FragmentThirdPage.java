package com.example.fragmentmenuaplication;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class FragmentThirdPage extends Fragment {

    // переменные для работы с search
    SearchView  searchView;
    ListView  listView;

    ArrayList<String> arrayList; // массив с которым работать будем

    ArrayAdapter<String> adapter; // пермененная адаптера


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_page, container, false);

        // доступ к элементам из FragmentThirdPage
        searchView = view.findViewById(R.id.search_view);
        listView = view.findViewById(R.id.list_view);

        arrayList = new ArrayList<>(); // заполняем список городами
        arrayList.add("Архангельск");
        arrayList.add("Воронеж");
        arrayList.add("Астрахань");
        arrayList.add("Смоленск");
        arrayList.add("Владимир");
        arrayList.add("Волгоград");
        arrayList.add("Ставрополь");
        arrayList.add("Адлер");
        arrayList.add("Выборг");
        arrayList.add("Самара");

        adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, arrayList); // создаётся адаптер, который соединяет список данных с отображением в интерфейсе. ArrayAdapter — это мост между:  данными (список, массив, и т.п.) и визуальным списком (ListView). getActivity().getApplicationContext() — контекст приложения, android.R.layout.simple_list_item_1 — шаблон строчки (один TextView), arrayList — твой список данных.
        listView.setAdapter(adapter); //Привязываешь адаптер к ListView Список теперь знает, откуда брать данные.

//--------------------------------------------------------------------------------------------------
//------------------------------------жмем на название города--------------------------------------
//этот код реагирует на нажатие по элементу списка (ListView) и Получает текст нажатого элемента (selectedItem) Показывает всплывающее сообщение (Toast) с выбранным значением
//Вместо Toast ты можешь: открыть новый фрагмент, передав туда selectedItem, запустить новую Activity, показать диалоговое окно, сохранить выбор в базу данных, список избранного и т.д
        listView.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedItem = adapter.getItem(position);
            Toast.makeText(getContext(), "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
        });
//--------------------------------------------------------------------------------------------------
//==================================================================================================
// жмем на иконку поиска (или ввод) Настраиваем поиск
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { //onQueryTextSubmit(String query) — вызывается, когда ты нажал Enter или иконку поиска.
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) { //onQueryTextChange(String newText) — вызывается при каждом изменении текста (прямо во время ввода).
                adapter.getFilter().filter(newText);
                return false;
            }
        });
//==================================================================================================

        return view;
    }
}