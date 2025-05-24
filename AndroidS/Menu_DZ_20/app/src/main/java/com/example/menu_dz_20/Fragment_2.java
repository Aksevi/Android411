package com.example.menu_dz_20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment_2 extends Fragment {

    View view;

    private Button resultButton, resetButton;
    private EditText enterWeight, enterPrice;
    private TextView resultText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_2, container, false);
        // здесь  между view = inflater.inflate(R.layout.fragment_3, container, false);
        // и return view;
        // пишется код - например кнокпи поля ввода реализация нажатий кнопок и тд

        resultButton = view.findViewById(R.id.result_button);
        resetButton = view.findViewById(R.id.reset_button);
        enterPrice = view.findViewById(R.id.enter_price);
        enterWeight = view.findViewById(R.id.enter_weight);
        resultText = view.findViewById(R.id.result_text);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterPrice.setText("");
                enterWeight.setText("");
                resultText.setText("Стоимость за 1 кг.");
            }
        });

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculatePricePerKg();
            }
        });

        return view;
    }

    // метод рассчета цены за кг
    private void calculatePricePerKg() {

        String weightString = enterWeight.getText().toString().trim(); // текст из полей введите вес и введите цену парсим в строки
        String priceString = enterPrice.getText().toString().trim();

        if (weightString.isEmpty() || priceString.isEmpty()) {
            Toast.makeText(getContext(), "Введите данные полностью", Toast.LENGTH_SHORT).show(); // ВНИМАТЕЛЬНО! В ФРАГМЕНТАХ ВСПЛЫВАЙКА ПИШЕТСЯ НЕ ЧЕРЕЗ THIS, А ЧЕРЕЗ getContext()!!!!
            return;
        }
//==========блок Try/ Catch лучше поставить чтобы не было проблемм с буквами вместо чисел============
//И вот почему - потому что юзеры хитрые и могут вставить букву методом копировать вставить даже если
// программно ограничить тип EditText===============================================================
        try {
            float weight = Float.parseFloat(weightString);
            float price = Float.parseFloat(priceString);

            if (weight > 0) {
                float pricePerKg = (1000 * price) / weight;
                resultText.setText(String.format("Цена за кг: %.2f", pricePerKg));
            } else {
                resultText.setText("Вес должен быть больше нуля");
            }
        } catch (NumberFormatException e){
            Toast.makeText(requireContext(),"Неверный формат числа", Toast.LENGTH_SHORT).show(); // ВНИМАТЕЛЬНО! В ФРАГМЕНТАХ ВСПЛЫВАЙКА ПИШЕТСЯ НЕ ЧЕРЕЗ THIS А ЧЕРЕЗ getContext()!!!!!
        }
//====================================================================================================
    }
}