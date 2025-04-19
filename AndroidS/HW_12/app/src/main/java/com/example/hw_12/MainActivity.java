package com.example.hw_12;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

// объявляем переменные. private потому что объявил тут а потом использую в нескольких методах
    private int progress; // переменная которая считает прогресс в прогресс баре. ну типа нажал - полосочка на прогресс баре скакнула на количество единиц progress
    private ProgressBar horizontalProgress; // собственно сам прогрессбар
    private EditText enterText; // поле вводимого текста
    private ChipGroup myChipGroup; // оле куда будут добавляться chip
    private Button showText; // кнопка принажатии на которую появляется поле текста
    private Button addButton; // кнопка добавляющая содержимое вводимого текста в chip
    private Button showChipButton; // кнопка при нажатии на которую всплывает окно с текстом с выбранных chip
    private RadioGroup radioGroup2; // радиогруппа в котрой лежат радиокнопки
    private Switch switch2; // переключатель который на день ночь меняет фон
    private ConstraintLayout main; // слой основной в котром фон меняем
    private  TransitionDrawable transition; // переменная  плавной смены фона с анимацией
    private boolean isDay = false; // булевая переменная день. по умолчанию - false. т.е - ночь
    private ToggleButton onOffButton; // доступ к ToggleButton (кнопка с двумя положениями) - в данном примере - activate/deactivate


// метод onCreate - он типа всегда тут
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


//делаем видимыми основные элементы экрана
// жмем кнопку activate/deactivate
// доступ к элементам по id
        onOffButton = findViewById(R.id.onOffButton);
        horizontalProgress = findViewById(R.id.progressBarHorizontal);
        addButton = findViewById(R.id.addButton);
        showChipButton = findViewById(R.id.showChipButton);
        showText = findViewById(R.id.ShowTextButton);
        radioGroup2 = findViewById(R.id.radioGroup2);
        switch2 = findViewById(R.id.switch2);
        enterText = findViewById(R.id.enterText);


        onOffButton.setOnClickListener(new View.OnClickListener() { // жмем кнопку  onOffButton (activate/deactivate)
            @Override
            public void onClick(View v) {

                if (onOffButton.isChecked()) { // если нажата то объекты ниже стали видимые
                    showText.setVisibility(View.VISIBLE);
                    radioGroup2.setVisibility(View.VISIBLE);
                    switch2.setVisibility(View.VISIBLE);
                    horizontalProgress.setVisibility(View.VISIBLE);
                }
                else { // иначе - невидимые
                    addButton.setVisibility(View.INVISIBLE);
                    showChipButton.setVisibility(View.INVISIBLE);
                    showText.setVisibility(View.INVISIBLE);
                    radioGroup2.setVisibility(View.INVISIBLE);
                    switch2.setVisibility(View.INVISIBLE);
                    horizontalProgress.setVisibility(View.INVISIBLE);
                    enterText.setVisibility(View.INVISIBLE);


                }
            }
        });




// делаем видимым поле ввода текста
        showText = findViewById(R.id.ShowTextButton); // доступ к кнопке showText

        showText.setOnClickListener(new View.OnClickListener() { // жмем кнопку
            @Override
            public void onClick(View v) {
                enterText.setVisibility(View.VISIBLE); // поле enterText становится видимым
            }
        });


// делаем видимыми кнопки "'"Add to chip" и "Show chip"
        radioGroup2 = findViewById(R.id.radioGroup2); // доступ к радиогруппе
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // жмем (отмечаем одну из радиокнопок в радиогруппе)
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton3) { // если нажали radioButton3 то
                    addButton.setVisibility(View.VISIBLE); // кнопка addButton стала видима
                    showChipButton.setVisibility(View.INVISIBLE); // кнопка showChipButton стала невидима
                }
                else if (checkedId == R.id.radioButton4) { // если нажали radioButton4 то
                    showChipButton.setVisibility(View.VISIBLE); // кнопка showChipButton стала видима
                    addButton.setVisibility(View.INVISIBLE); // кнопка addButton стала невидима
                }
            }
        });





//меняем плавно фон. перед этим скачал картинки в формате .png в папку drawable и создал новый drawable resource file bg_transition.xml (имя может быть любым). содержимое файла смотри в drawable
// доступ к слою ConstraintLayout и к переключателю switch по id
        main = findViewById(R.id.main);
        switch2 = findViewById(R.id.switch2);

        main.setBackgroundResource(R.drawable.nightsky); // устанавливаем начальным состоянием ночь (так хочу просто. можно и день)

        switch2.setOnCheckedChangeListener((buttonView, isChecked) -> { // бахнули слушатель на switch. обрати внимание  - он именно такой, отличается от слушателя кнопки
            if(isChecked && !isDay) { // если включен switch и сейчас не день (!isDay)
                main.setBackgroundResource(R.drawable.bg_transition); // ставим bg_transition как фон (там у нас 2 изображения - день и ночь)
                transition = (TransitionDrawable) main.getBackground(); //явно  приводим transition к (TransitionDrawable) и получаем текущий фон. Короче вся магия именно  в (TransitionDrawable) - приводя переменную к этому типу мы и запускаем анимацию фона
                transition.startTransition(1000); // запускаем анимацию длительностью 1000 (1 сек)
                isDay = true; // теперь флаг = день
            } else if (!isChecked && isDay) { // если выключен switch и сейчас день
                transition.reverseTransition(1000);// то запускаем обратную анимацию длительностью 1000 (1 сек)
                isDay = false; // теперь флаг = не день (ночь)
            }
        });


// добавляем содержимое текстового поля в chip
// доступ к элементам по id
        horizontalProgress = findViewById(R.id.progressBarHorizontal);
        enterText = findViewById(R.id.enterText);
        myChipGroup = findViewById(R.id.myChipGroup);
        addButton = findViewById(R.id.addButton);
        showChipButton = findViewById(R.id.showChipButton);

        addButton.setOnClickListener(new View.OnClickListener() { // жмем кнопку addButton
            @Override
            public void onClick(View v) {
                addMyChip(); // вызываем метод добавления


            }
        });


// выводим содержимое выбранных chip в всплывающем окне
        showChipButton.setOnClickListener(new View.OnClickListener() { // жмем кнопку showChipButton
            @Override
            public void onClick(View v) {
                showSelectedChip(); // вызываем метод вывода
            }
        });
    }



// метод добавления текста из поля enterText в chip
    private void addMyChip(){

        String putText = enterText.getText().toString(); // стринговая переменная в которую попадает текст из enterText/ .toString() - переводит текст к типу String
        if (putText.isEmpty()){ // если текстовое поле пустое то
            Toast.makeText(this, "Please enter text!", Toast.LENGTH_SHORT).show(); // всплывающее коно с этим текстом
            return;
        }

        LayoutInflater inflater = LayoutInflater.from(this); // это необходимо для добавления элемента которого не существовало. (так как у нас пока нет chip в chipGroup)

        Chip addChip = (Chip) inflater.inflate(R.layout.layout_chip_entry, this.myChipGroup, false); // создаем новый Chip с именеам addChip/ R.layout.layout_chip_entry это XML-разметка одного чипа (ее мы сделали в res/layout)/ this.myChipGroup — это родитель, куда мы собираемся вставить чип/ false - означает что нет привязки к корневому элементу/ inflater.inflate - означает создание нового элемента на основе моей xml разметки (типа XML-шаблона в реальные объекты в памяти, чтобы с ними можно было работать.)
        addChip.setText(putText);// помещаем в чип те5ст из тектсового поля
        myChipGroup.addView(addChip); // помещаем chip в chipGroup

// тут немного шалости - привязываем прогресс бар к чипам. добавили чип - прогрессбар заполнился на 10
        progress = progress + 10; // увеличиваем progress на 10
        horizontalProgress.setProgress(progress); //  прогрессбар помещаем значение progress
        horizontalProgress.setMax(100); // макс размер прогрессбара = 100
        this.enterText.setText(""); // обнуляем поле вводимого текста. типа ввели текст, нажали кнопку addButton, текст улетел в chip, chip улетел в chipGroup, текстовое поле сбросилось




// жмем на крестик на chip (для закрытия самого chip)
        addChip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeByIcon((Chip) v); // View это любой элемент и мы явно указываем что приходит (Chip). метод  closeByIcon принимает Chip (cм метод ниже). короче сюда (в Chip) приходит тот элемент на котором мы жмем крестик
            }
        });
    }




// метод показа текста с выбранных chip во всплывающем окне
    private void showSelectedChip(){

        int selected = myChipGroup.getChildCount(); // создаем переменную selected для посдчета элементов в chipGroup/ myChipGroup - это группа наших элементов/ .getChildCount() - это метод для подсчета количества потомков. соответсвенно int selected = chipGroup.getChildCount(); подсчитает сколько элементов в myChipGroup
         String temp = null; // создаем  строку которую будем передавать в всплывающее окно Toast. изначально  в ней ничего нет - null

        for (int i = 0; i < selected; i++) { // идем в цикле по количеству (selected) элементов
            Chip child = (Chip) myChipGroup.getChildAt(i); // создаем переменную child приводим ее к типу  (Chip), обращаемся к myChipGroup получаем (.getChildAt(i)) дочерний элемент по индексу. Проще - идем по циклу и кладем в child элементы из myChipGroup

            if (!child.isChecked()){ // если элемент child не отмечен !child.isChecked
                continue;  // пропускаем элемент - continue в цикле пропустит текущую итерацию. то есть не отмеченные элементы в if попадут  а отмеченные if пропустят
            }
            if (temp == null){ // если s пустая
                temp = child.getText().toString(); // в нее попадает текст из child (child это дочерний элемент (читай chipоф) в который по очереди попадают все элементы из chipGroup кроме не отмеченных. см if выше)
            }
            else { // иначе (если s не пустая )
                temp += "' " + child.getText().toString(); // то добавляем к ее содержимому через запятую содержимое следующих child в котрые попадают отмеченные chip которые отметил пользователь
            }
        }
// если ничего из chip не отмечено то чтобы не крашилось делаем так
        if (temp == null){
            Toast.makeText(this, "Ничего не выбрано", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();
        }
    }



// метод закрытия chip по крестику
    private void  closeByIcon(Chip chip){ // closeByIcon - просто имя, (Chip chip) - работает с типом данных Chip а chip -это тот элемент на котором мы жмем крестик  в newChip.setOnCloseIconClickListener

        ChipGroup parent = (ChipGroup) chip.getParent(); // так как удалять будем из родительского элемента то создаем переменную parent (просто имя) типа ChipGroup ( потому что это родитель chip). приводим parent к типу данных (ChipGroup). обращаемся к chip с которым работаем и вызываем метод .getParent /получить родительский элемент/
        parent.removeView(chip); // у переменной parent через метод removeView() -/служ метод/ - удаляем элемент chip который пришел в методе closeByIcon(Chip chip) - грубо говоря по которому делаем клик на крестик

    }


}
