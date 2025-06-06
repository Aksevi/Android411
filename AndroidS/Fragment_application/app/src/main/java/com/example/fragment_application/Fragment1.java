package com.example.fragment_application;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment1 extends Fragment {

    View view;

    EditText editText;
    Button send;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //=========
        view = inflater.inflate(R.layout.fragment_1, container, false); // inflater.inflate(...) Это метод, который «надувает» (inflate) XML-разметку в реальный объект View.  Когда ты создаёшь разметку для фрагмента (fragment_1.xml), она по сути просто лежит в ресурсах. Но чтобы она стала живым интерфейсом — с кнопками, текстами и прочим — её нужно «надувать» через LayoutInflater./ R.layout.fragment_1 - Это ссылка на твой XML-файл fragment_1.xml, лежащий в папке res/layout./ container - Это ViewGroup, в который будет вставлена твоя разметка. Обычно это родитель, в который помещается твой фрагмент. Например, FrameLayout в activity_main.xml./ false - Это важный параметр: нужно ли сразу прикреплять разметку к container?   false — говорит: «Просто создай View, но пока не добавляй её в контейнер». Обычно так и делают в Fragment, потому что Android сам добавит эту вьюху позже.

        editText = view.findViewById(R.id.editText); // в таком виде потому что обращаться нужно через view которое создаоли выше и котороебудет появляться
        send = view.findViewById(R.id.send); // в таком виде потому что обращаться нужно через view которое создаоли выше и котороебудет появляться

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class); // внимательнее - тут вот так будет а не как раньше смотрели через this
                intent.putExtra("key", editText.getText().toString());// создаем ключ и переводим его в строку. этот ключ потом получим в mainActivity
                startActivity(intent);
            }
        });

        return view;

    }
}