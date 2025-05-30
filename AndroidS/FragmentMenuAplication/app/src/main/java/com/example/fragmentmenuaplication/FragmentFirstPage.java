package com.example.fragmentmenuaplication;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class FragmentFirstPage extends Fragment {

    View view; // *************обязательно так

    RatingBar ratingBar;
    Button ratingBtn;

    Spinner spinnerList;
    Button buttonFindDescription;
    TextView textViewDescription;

    SeekBar seekbar;
    TextView textView;


    SeekBar discreteSeekBar;
    TextView textSize;

    // переменная FloatingActionButton
    FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_first_page, container, false); //*************** обязательно так

// доступ к элементам
        ratingBar = view.findViewById(R.id.ratingBar); // обязательно через view потому что работаем с фрагментами
        ratingBtn = view.findViewById(R.id.ratingBtn);

        floatingActionButton = view.findViewById(R.id.floatingActionButton);

// жмем кнопку
        ratingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float value = ratingBar.getRating(); // переменная для получения рэйтинга

                Toast.makeText(getContext(), "Rating: " + value, Toast.LENGTH_SHORT).show(); // getContext() с фрагментами в Toast вместо this

            }
        });

// доступ к элементам
        spinnerList = view.findViewById(R.id.spinner_list);
        buttonFindDescription = view.findViewById(R.id.button_find_description);
        textViewDescription = view.findViewById(R.id.text_view_description);

        // жмем кнопку
        buttonFindDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//🧠 1. Узнаём выбранный пункт в Spinner:
                int position = spinnerList.getSelectedItemPosition(); // в position попаает индекс выбранного элемента (они же в массиве поэтому есть индексы). эта position будет передана в метод getDesriptionPosition

//📝 2. Получаем описание по индексу:
                //вызываем свой метод getDesriptionPosition(), передаём в него position.
                //Он вернёт строку из массива описаний, и  отображает ее в TextView.
                //👉 То есть, показали текст под выбранным пунктом.
                String description = getDesriptionPosition(position); // создали строковую переменную вызвали метод с переданной в него position
                textViewDescription.setText(description); // в тестковое поле передали значение description

//🎨 3. Получаем цвет по индексу и меняем фон кнопки:
                //Метод getColors(position) возвращает строку с HEX-кодом цвета (например, #FFA500).
                //Color.parseColor() превращает строку в цвет.
                //setBackgroundColor() меняет цвет фона у кнопки.
                String colors = getColors(position); // переменная в которую попадает поситция выбранная в всплывающем меню
                buttonFindDescription.setBackgroundColor(Color.parseColor(colors)); // цвет кнропки меняется в сооттветствии с выбранной позицией

            }
        });

        // доступ к элементам  сикбара
        seekbar = view.findViewById(R.id.seekBar);
        textView = view.findViewById(R.id.text_view);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // с seekbar вместо онклик вот так надо
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textView.setText(progress + "/100"); // progress из строки выше. 0 затираем /100 перезаписываем
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "взялись", Toast.LENGTH_SHORT).show();
                textView.setTextColor(Color.parseColor("green"));

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "отпустили", Toast.LENGTH_SHORT).show();
                textView.setTextColor(Color.parseColor("red"));

            }
        });

        // доступ к элементам  дискретного сикбара
        discreteSeekBar = view.findViewById(R.id.discrete_seek_bar);
        textSize = view.findViewById(R.id.text_size);

        discreteSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // с seekbar вместо онклик вот так надо
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textSize.setTextSize(progress * 5);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // жмем floatingActionButton
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomDialog();// МЕТОД НИЖЕ
            }
        });

        return view; //*************** обязательно так
    }
//==================================================================================================
// ====================метод вызова диалого через кнопку floatingActionButton=======================
    private void showBottomDialog() {
        final Dialog dialog = new Dialog(getContext()); // создаем переменную диалога. getContext() потому что фрагмент. вне фрагмента был бы this
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // убираем заголовок окна диалога
        dialog.setContentView(R.layout.bottom_sheet_layout); // подключаем наш слой с диалогом

// ~~~~~~~~~~~~~~~~~~~~~~~~~~оживляем элементы в самом диалоговом окне.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// получаем доступ к элементам в самом диалоге (это в слое диалога bottom_sheet_layout.xml)
        TextView  second = dialog.findViewById(R.id.second); // через dialog потому что лежат в слое диалога
        TextView  third = dialog.findViewById(R.id.third);
        TextView  fourth = dialog.findViewById(R.id.fourth);
// переходим на 2 фрагмент
        // обрабатываем клик мышкой по элементам
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // закрываем диалог
                replaceFragment(new FragmentSecondPage()); //replaceFragment - метод по замене фрагмента. метрода нет сделаем ниже - наводим на него мышь и во всплывайке выбип=раем создать метод. он появится чуть ниже
            }
        });
// переходим на 3 фрагмент
        // обрабатываем клик мышкой по элементам
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // закрываем диалог
                replaceFragment(new FragmentThirdPage()); //replaceFragment - метод по замене фрагмента. метрода нет сделаем ниже - наводим на него мышь и во всплывайке выбип=раем создать метод. он появится чуть ниже
            }
        });
// переходим на 4 фрагмент
        // обрабатываем клик мышкой по элементам
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // закрываем диалог
                replaceFragment(new FragmentFourthPage()); //replaceFragment - метод по замене фрагмента. метрода нет сделаем ниже - наводим на него мышь и во всплывайке выбип=раем создать метод. он появится чуть ниже
            }
        });

        dialog.show();// вызываем диалог
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT); // программно установили ширину и высоту диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // убираем фон (без этой строки углы закруглеты но под ними виден белый фон)
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // DialogAnimation мы писали в themes в  теге <style>. соответственно мы это и подключаем
        dialog.getWindow().setGravity(Gravity.BOTTOM); // опускаем окно диалога вниз
    }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//++++++++++++++++++++++++++++++++++++++++ метод замены фрагмента+++++++++++++++++++++++++++++++++++
    private void replaceFragment(Fragment fragment) { // в скобках меняем на это (Fragment fragment)

        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction(); // стандартныая запись.

        fragmentTransaction.replace(R.id.frame_layout, fragment); //  заменяет текущий фрагмент, который находится в R.id.frame_layout, на новый, который передали в метод. R.id.frame_layout — это FrameLayout в activity_main.xml (обычно он служит "контейнером" для фрагментов). fragment — это новый фрагмент, который ты хочешь туда загрузить.
        fragmentTransaction.commit(); // подтверждаем изменения
    }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//==================================================================================================

    //📦 Метод getDesriptionPosition
    // Берёт массив строк из ресурсов strings.xml (массив description_of_temp)
    //И возвращает строку с нужным индексом.
    private String getDesriptionPosition(int position) {

        String[] description = getResources().getStringArray(R.array.description_of_temp);//getResources(). - получаем доступ ко всем ресурсам, getStringArray - доступ к строковым  массивым, (R.array.description_of_temp) - доступ к конкретному массиву; То есть по факту конктерный массив description_of_temp  положили в description
        return description[position]; // вернули элементы массива
    }

    //🎨 Метод getColors
    // Похож на предыдущий — только работает с другим массивом: colors_button.
//Возвращает цвет (в виде строки), который ты потом применяешь к кнопке.
    private String getColors(int position) {
        String[] description = getResources().getStringArray(R.array.colors_button); //  colors_button массив в strings
        return description[position];
    }
}