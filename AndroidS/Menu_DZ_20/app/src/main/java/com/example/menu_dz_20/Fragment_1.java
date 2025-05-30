package com.example.menu_dz_20;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class Fragment_1 extends Fragment {

    View view; // обязательный элемент при работе с фрагментами
// объявляем переменные
    int[] cityImages;
    Button buttonCityInfo;
    TextView textCityInfo;
    Spinner spinnerCities;
    ImageView cityImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_1, container, false); // обязательный элемент при работе с фрагментами

        // здесь  между view = inflater.inflate(R.layout.fragment_3, container, false);
        // и return view;
        // пишется код - например кнокпи поля ввода реализация нажатий кнопок и тд

// ************заполняем массив изображениями. предварительно их закинул в drawable****************************
        cityImages = new int[]{
                R.drawable.vologda,
                R.drawable.cherepovets,
                R.drawable.kirillov,
                R.drawable.v_ustug,
                R.drawable.griazovets
        };
//**************************************************************************************************
        // доступ к элементам интерфейса
        spinnerCities = view.findViewById(R.id.spinner_cities);
        buttonCityInfo = view.findViewById(R.id.button_city_info);
        textCityInfo = view.findViewById(R.id.text_city_info);
        cityImage = view.findViewById(R.id.city_image);
// жмем кнопку
        buttonCityInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = spinnerCities.getSelectedItemPosition(); // получаем номер выбранного пункта (position) спиннера. Названия городов в спиннере получаем из массива который создали в String. Сам массив с названиями указываем в xml коде в блоке spinner (android:entries="@array/citys")
                cityImage.setImageResource(cityImages[position]); // устанавливаем в ImageView картинку из массива cityImages соответствующей позиции и
                textCityInfo.setText(getImageAndDescription(position));// ВЫЗЫВАЕМ МЕТОД ImageAndDescription И  показываем описание соответствующего города. описание берем из массива созданного в String

            }
        });

        return view;// обязательный элемент при работе с фрагментами
    }

//========================== метод выводв описания и  позиции спиннера=========================
    private String getImageAndDescription(int position){

        String [] imageAndDescription = getResources().getStringArray(R.array.citys_description); // создаем строковый массив String [], getResources() - получаем доступ ко всем ресурсам в папке res, getStringArray  - достать строковый массив, R.array.citys_description - собственно путь к самому массиву с описанием городов. и все это чудо мы сохраняем в переменной imageAndDescription
        return imageAndDescription[position]; // достаем imageAndDescription нужной позиции [position] и возвращаем это в ту строку где вызвали этот метод

    }
//===============================================================================================
}