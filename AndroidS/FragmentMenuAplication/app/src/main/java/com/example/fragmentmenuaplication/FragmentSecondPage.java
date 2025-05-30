package com.example.fragmentmenuaplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class FragmentSecondPage extends Fragment {

    // получаем доступ к элементам для работы с RecycleView
    private EditText editText; // это для элемента в second_page.xml
    private Button add; // это для элемента в second_page.xml
    private RecyclerView recycleView; // это для элемента в second_page.xml

    private List<String> dataList = new ArrayList<>(); // это нужно для работы с dataList который у нас в  DataAdapter.java
    private DataAdapter adapter; // это переменная класса DataAdapter


    View view;
    // создаем переменные
    EditText dateInput;
    EditText timeInput;
    Calendar calendar; // класс и переменная для работы с методом showDateDialog  и showTimeDialog

    //==================================================================================================
//объявление переменной dateSetListener, которая будет "слушателем" — то есть обработчиком выбора даты в DatePickerDialog. Когда пользователь выбирает дату (день, месяц, год), этот слушатель получает её и выполняет нужный код.
    DatePickerDialog.OnDateSetListener dateSetListener; // DatePickerDialog это стандартный диалог Android, который позволяет пользователю выбрать дату через календарь. OnDateSetListener — это интерфейс внутри DatePickerDialog, который сообщает, когда пользователь выбрал дату. dateSetListener — это переменная, которая будет ссылаться на реализацию этого интерфейса. dateSetListener - наше имя переменной

    //объявление переменной dateSetListener, которая будет "слушателем" — то есть обработчиком выбора даты в TimePickerDialog. Когда пользователь выбирает время, этот слушатель получает её и выполняет нужный код.
    TimePickerDialog.OnTimeSetListener timeSetListener; // TimePickerDialog это стандартный диалог Android, который позволяет пользователю выбрать время. OnTimeSetListener — это интерфейс внутри TimePickerDialog, который сообщает, когда пользователь выбрал время. timeSetListener — это переменная, которая будет ссылаться на реализацию этого интерфейса. timeSetListener - наше имя
    //==================================================================================================

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second_page, container, false);

// доступ к переменным
        dateInput = view.findViewById(R.id.date_input); // доступ к полю ввода даты
        timeInput = view.findViewById(R.id.time_input); // доступ к полю ввода времени
//--------------------------------------------------------------------------------------------------
//--------------------отключаем клавиатуру для полей ввода даты и времени------------------------------
        dateInput.setInputType(InputType.TYPE_NULL); //Эта команда отключает клавиатуру для текстового поля dateInput, чтобы она не появлялась, когда пользователь нажимает на поле. Обычно так делают, если ты хочешь, чтобы пользователь не вводил дату вручную, а выбирал её из календаря (DatePickerDialog). dateInput - переменная, setInputType - метод, который указывает, какой тип ввода будет использоваться (например, текст, число, дата и т.д.), InputType.TYPE_NULL — специальное значение, которое означает: "никакой ввод не нужен".
        dateInput.setFocusable(false);// отключаем возможность фокуса (не будет курсора) Это нужно чтобы совсем не было возможности вводить текст
        dateInput.setClickable(true); // но всё ещё можно кликать (для открытия диалога)

        timeInput.setInputType(InputType.TYPE_NULL);
        timeInput.setFocusable(false); // отключаем возможность фокуса (не будет курсора)
        timeInput.setClickable(true);  // но всё ещё можно кликать (для открытия диалога)
//--------------------------------------------------------------------------------------------------
        // жмем на поле ввода даты
        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(dateInput); // метод. создадим ниже (наведи курсор на метод и нажми создать метод)
            }
        });

        // жмем на поле выбора времени
        timeInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(timeInput); // метод. создадим ниже (наведи курсор на метод и нажми создать метод)
            }
        });
//==================================================================================================
//========================работа с добавлением у удалением RecyclerView==========================
// доступ к элементам которые работают с dataadapter, item_style и RecyclerView
        editText = view.findViewById(R.id.editText); // доступ к элементу в  second_page.xml
        add = view.findViewById(R.id.add); // доступ к элементу в  second_page.xml
        recycleView = view.findViewById(R.id.recycle_view); // доступ к элементу в  second_page.xml

        recycleView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext())); //LayoutManager отвечает за расположение элементов в списке. Ты выбрал вертикальный список (LinearLayoutManager).
        adapter = new DataAdapter(dataList); //Создаёшь новый адаптер DataAdapter и передаёшь в него свой список dataList.
        recycleView.setAdapter(adapter); //Устанавливаешь адаптер в RecyclerView, чтобы он знал, как отрисовывать элементы.

        add.setOnClickListener(new View.OnClickListener() { //Обработка нажатия на кнопку "add":
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString(); //Берёшь введённый текст из editText кладем его в локальную переменную data
                if (!data.trim().isEmpty()) { // исключаем добавление пустой строки
                    dataList.add(data);//Добавляешь этот текст в твой список dataList.
                    editText.setText(""); //Очищаешь поле ввода, чтобы удобно было вводить следующий текст
                    adapter.notifyDataSetChanged(); //Говоришь адаптеру обновить список на экране.
                }
            }
        });
//==================================================================================================
        return view;
    }

    //----------------------------------- метод открытия диалога выбора времени-------------------------
//выбранное значение потом вставляем в EditText, который ты передаём как параметр.
    private void showTimeDialog(EditText timeInput) {
        calendar = Calendar.getInstance(); //Получаем текущее время. Класс Calendar нужен, чтобы потом вставить выбранные часы и минуты, и правильно их отформатировать.
// Создаём слушателя выбора времени. Это такой интерфейс, который срабатывает, когда пользователь нажал "OK" в диалоге времени.
        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) { // Метод, который вызывается, когда пользователь выбрал время. В аргументы тебе прилетают: hourOfDay — часы (от 0 до 23) minute — минуты
                // Устанавливаем выбранные значения в наш календарь — чтобы потом получить объект времени, пригодный для форматирования
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm"); //Создаём формат, в котором хотим отобразить время. Создаём формат: "часы:минуты" в 24-часовом формате (HH — именно 24-часовой, hh — был бы 12-часовой).
                timeInput.setText(simpleDateFormat.format(calendar.getTime())); //Форматируем время и вставляем в поле EditText. Пользователь видит красиво: например, 09:45 или 18:30.
            }
        };
        new TimePickerDialog(getContext(), timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show(); // Показываем сам TimePickerDialog. Что здесь: getContext() — откуда брать контекст (текущий фрагмент). timeSetListener — что делать, когда выбрано время. calendar.get(...) — текущее время (чтобы диалог открылся с "сегодняшним" временем). false/true — указываем формат времени 12 или 24 часа

    }

    //--------------------------------------------------------------------------------------------------
//+++++++++++++++++++++++++метод открытия диалога выбора даты,+++++++++++++++++++++++++++++++++++++++
//пользователь выбирает дату, и эта дата автоматически вставляется в EditText в формате дд/мм/гггг для работы с ним создали класс и переменную Calendar в самом начале
    private void showDateDialog(EditText dateInput) {

        calendar = Calendar.getInstance(); //  Получаем текущую дату. Calendar.getInstance() создаёт объект календаря, с которым будем работать.
// создаём слушателя события — что делать, когда пользователь выберет дату.
        dateSetListener = new DatePickerDialog.OnDateSetListener() { // dateSetListener наша переменная выше. остальное стандарт
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year); // стандартная запись calendar - наша переменная, .set - установить, Calendar.YEAR - константа, year - пришел из аргументов метода
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); //Создаём формат, в котором хотим отобразить дату.

                dateInput.setText(simpleDateFormat.format(calendar.getTime()));//Получаем дату из календаря (calendar.getTime()), форматируем её и вставляем в EditText.

            }
        };
        new DatePickerDialog(getContext(), dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show(); // Создаём и сразу показываем диалог выбора даты. getContext() — контекст (например, активити или фрагмент). dateSetListener — наш обработчик. Текущие год, месяц, день — чтобы диалог открылся с сегодняшней датой.
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    }
}