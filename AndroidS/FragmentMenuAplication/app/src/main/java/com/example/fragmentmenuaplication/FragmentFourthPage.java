package com.example.fragmentmenuaplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;


public class FragmentFourthPage extends Fragment {

// переменные для чисел
    TextView textViewNumberPicker; //текст, в котором будет отображаться выбранное число
    NumberPicker numberPicker; //собственно, колесико с числами.

    // переменные для языков
    TextView textViewCountryPicker; //textViewCountryPicker — это элемент текста, в котором будешь показывать выбранный язык (или страну)
    NumberPicker cityPicker; //cityPicker — вот тут главный герой, NumberPicker. Это такой бегунок с цифрами, где пользователь может выбрать число (в твоём случае — индекс языка).


    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_fourth_page, container, false);

//Подключаешь TextView и NumberPicker по ID из XML, чтобы можно было с ними работать в коде.
        textViewNumberPicker = view.findViewById(R.id.textview_number_picker);
        numberPicker = view.findViewById(R.id.number_picker);
//Настройка NumberPicker
        numberPicker.setMaxValue(10); // макс значение
        numberPicker.setMinValue(0); // мин значение
        numberPicker.setValue(5); // значение по умолчанию

// Слушатель изменения значения. устанавливаем обработчик событий: каждый раз, когда пользователь меняет значение на NumberPicker, текст в TextView обновляется и показывает: "Selected: " + newVal(новое значение)
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                textViewNumberPicker.setText("Selected: " + newVal);
            }
        });

//доступ к элементам для стран. связываем переменные с реальными элементами интерфейса из XML, чтобы с ними работать.
        textViewCountryPicker = view.findViewById(R.id.textview_country_picker);
        cityPicker = view.findViewById(R.id.city_picker);

        Language.initLanguage(); // инициализируем (зашружаем данные) отдельный класс Language, который хранит список языков или стран.
//Настройка NumberPicker
        cityPicker.setMaxValue(Language.getLanguageArrayList().size() - 1); // МАКС значение. обратились к длине массива в классе Language/ минус один потому что длина всегла на 1 меньше
        cityPicker.setMinValue(0); // МИН знач
        cityPicker.setDisplayedValues(Language.languageNames()); // ставим, какие названия будут отображаться вместо чисел — массив с названиями языков

//Слушатель изменений. Как только пользователь выберет другой язык, сработает этот код. берём выбранный язык из списка и показываешь его название в textViewCountryPicker.
       cityPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
           @Override
           public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
               textViewCountryPicker.setText("Selected: " + Language.getLanguageArrayList().get(newVal).getName());
           }
       });

        return view;
    }
}