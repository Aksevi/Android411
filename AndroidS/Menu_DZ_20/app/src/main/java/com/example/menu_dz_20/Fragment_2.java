package com.example.menu_dz_20;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Fragment_2 extends Fragment {

    View view;

    private Button resultButton, resetButton;
    private EditText enterWeight, enterPrice;
    private TextView resultText;
    private TextView unitWeight; // это переменная поля где гр. и шт. написаны
//    private TextView unitWeight;
//    private TextView resultText;

    private FloatingActionButton floatingActionButton;

    private int type = 1; // эта переменная нужна чтобы переключаться когда floatingbutton выбираем что считать цену за кг или за шт

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
        unitWeight = view.findViewById(R.id.unit_weight);

        floatingActionButton = view.findViewById(R.id.floatingActionButton);

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

//                calculatePricePerKg();
                calculatePrice();
            }
        });

// жмем на кнопку
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showSelectionWindow();
            }
        });

        return view;
    }

    //==================================================================================================
// ====================метод вызова диалого через кнопку floatingActionButton=======================
    private void showSelectionWindow() {

        final Dialog dialog = new Dialog(getContext()); // создаем переменную диалога. getContext() потому что фрагмент. вне фрагмента был бы this
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // убираем заголовок окна диалога
        dialog.setContentView(R.layout.floating_window_dialog); // подключаем наш слой с диалогом

        dialog.show();// вызываем диалог
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT); // программно установили ширину и высоту диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // убираем фон (без этой строки углы закруглеты но под ними виден белый фон)
        dialog.getWindow().getAttributes().windowAnimations = R.style.floatingWindowDialogAnimation; // DialogAnimation мы писали в themes в  теге <style>. соответственно мы это и подключаем
        dialog.getWindow().setGravity(Gravity.BOTTOM); // опускаем окно диалога вниз

// ~~~~~~~~~~~~~~~~~~~~~~~~~~оживляем элементы в самом диалоговом окне.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// получаем доступ к элементам в самом диалоге (это в слое диалога floating_window_dialog.xml)

        TextView pricePerKg = dialog.findViewById(R.id.price_per_kg);
        TextView pricePerPiece = dialog.findViewById(R.id.price_per_piece);

// обрабатываем клик мышкой по элементам
        pricePerKg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // закрываем диалог
                type = 1; // считаем цену за кг
                enterPrice.setText(""); // устанавливаем тексты в поля
                enterWeight.setText("");
                resultText.setText("Цена за кг.");
                enterWeight.setHint("Enter Weight");
                unitWeight.setText("gr.");

            }
        });

        pricePerPiece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // закрываем диалог
                type = 2; // считаем цену за шт
                enterPrice.setText(""); // устанавливаем тексты в поля
                enterWeight.setText("");
                resultText.setText("Цена за шт.");
                enterWeight.setHint("Enter the number of pieces");
                unitWeight.setText("pc.");
            }
        });
    }

    // метод рассчета цены
    private void calculatePrice() {

        if (type == 1) { // если выбран в всплфывайке пункт за кг

            String weightString = enterWeight.getText().toString().trim(); // текст из полей введите вес и введите цену парсим в строки
            String priceString = enterPrice.getText().toString().trim();

            if (weightString.isEmpty() || priceString.isEmpty()) {
                Toast.makeText(getContext(), "Введите данные полностью", Toast.LENGTH_SHORT).show(); // ВНИМАТЕЛЬНО! В ФРАГМЕНТАХ ВСПЛЫВАЙКА ПИШЕТСЯ НЕ ЧЕРЕЗ THIS, А ЧЕРЕЗ getContext()!!!!
                return;
            }
//==========блок Try/ Catch лучше поставить чтобы не было проблем с буквами вместо чисел============
//И вот почему - потому что юзеры хитрые и могут вставить букву методом копировать вставить даже если
// программно ограничить тип EditText===============================================================
            try {
                float weight = Float.parseFloat(weightString); // вес и цена в флоат потому что число может быть не целым
                float price = Float.parseFloat(priceString);

                if (weight > 0) {
                    float pricePerKg = (1000 * price) / weight; // сама формула рассчета
                    resultText.setText(String.format("Цена за кг: %.2f", pricePerKg));
                } else {
                    resultText.setText("Вес должен быть больше нуля");
                }
            } catch (NumberFormatException e) {
                Toast.makeText(requireContext(), "Неверный формат числа", Toast.LENGTH_SHORT).show(); // ВНИМАТЕЛЬНО! В ФРАГМЕНТАХ ВСПЛЫВАЙКА ПИШЕТСЯ НЕ ЧЕРЕЗ THIS А ЧЕРЕЗ getContext()!!!!!
            }

        } else  { // если выбран в всплывайке пункт цена за штуку
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
                int weight = Integer.parseInt(weightString); // здесь weight это количество штук поэтому в int
                float price = Float.parseFloat(priceString); // цена в флоат потому что может быть не целым числом

                if (weight > 0) {
                    float pricePerPiece =price / weight; // сама формула рассчета
                    resultText.setText(String.format("Цена за шт: %.2f", pricePerPiece));
                } else {
                    resultText.setText("количество  должно быть больше нуля");
                }
            } catch (NumberFormatException e) {
                Toast.makeText(requireContext(), "Неверный формат числа", Toast.LENGTH_SHORT).show(); // ВНИМАТЕЛЬНО! В ФРАГМЕНТАХ ВСПЛЫВАЙКА ПИШЕТСЯ НЕ ЧЕРЕЗ THIS А ЧЕРЕЗ getContext()!!!!!
            }
        }
//====================================================================================================
    }
}