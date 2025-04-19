package com.example.third;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.switchmaterial.SwitchMaterial;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // переменные для горизонтального progress bar 203 строка
    private int currentProgress = 0;// переменная текущего прогресса. она нам нужна для подсчета прогресса
    private ProgressBar progressBar;

    // переменные для chip group и текстового поля с кнопками 238 стр
    private EditText editTextKeyword; // доступ к текстовому полю
    private ChipGroup chipGroup; // доступ к chip group


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
// меняем цвет через кнопку
/*        Button changeColor = findViewById(R.id.changeColor); // доступ к кнопке

// жмем на кнопку и меняем цвет
        changeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup radioGroup = findViewById(R.id.radioGroup); // доступ к радиогруппе целиком
                int checkedButtonIndex  = radioGroup.getCheckedRadioButtonId(); // получаем отмеченную радиокнопку по Id/ int потому что радиокнопки вызываются по индексу в радиогруппе

                TextView textColor = findViewById(R.id.textColor); // доступ к текстовому полю

                if (checkedButtonIndex == R.id.radioButton){ // сравниваем checkedButtonIndex с радиокнопкой
                    textColor.setTextColor(Color.parseColor("#009212")); // меняем цвет
                }
                else if (checkedButtonIndex == R.id.radioButton2){
                    textColor.setTextColor(Color.parseColor("#FF6F00")); // меняем цвет
                }

            }
        });*/

// меняем цвет минуя кнопку
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        TextView textView = findViewById(R.id.textColor);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) { // int checkedId - id радиокнопки

                if (checkedId == R.id.radioButton) {
                    textView.setTextColor(Color.parseColor("#009212"));

                } else if (checkedId == R.id.radioButton2) {
                    textView.setTextColor(Color.parseColor("#FF6F00"));

                }
            }
        });

// работаем с ToggleButton (кнопка pressed) с ее помощью меняем цвет на кнопке выбор цвета

        ToggleButton toggleButton = findViewById(R.id.toggleButton); // доступ к ToggleButton
        Button changeColor = findViewById(R.id.changeColor); // доступ к кнопке

        toggleButton.setOnClickListener(new View.OnClickListener() { // жмем на нее
            @Override
            public void onClick(View v) {

                if (toggleButton.isChecked()) { // если ToggleButton нажата (.isChecked) меняем цвет на кнопках

                    changeColor.setBackgroundColor(Color.GREEN); // можно и через parseColor можно и так
                    toggleButton.setBackgroundColor(Color.RED); // можно и через parseColor можно и так
                } else {
                    changeColor.setBackgroundColor(Color.RED); // можно и через parseColor можно и так
                    toggleButton.setBackgroundColor(Color.GREEN); // можно и через parseColor можно и так
                }

            }
        });

// переключатель подсветки
        Switch mySwitch = findViewById(R.id.switch1);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    mySwitch.setTextColor(Color.parseColor("#FF6F00"));
                } else {
                    mySwitch.setTextColor(Color.BLACK);
                }
            }
        });


        // переключатель turn on day/ nigth mode
        ConstraintLayout constraintLayout = findViewById(R.id.main);
        SwitchMaterial switchMaterial = findViewById(R.id.switchMaterial);

        switchMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchMaterial.isChecked()) {
                    switchMaterial.setThumbDrawable(getDrawable(R.drawable.baseline_add_reaction_24));
                    switchMaterial.setText("Turn on Night mode");
                    constraintLayout.setBackgroundResource(R.color.bg);
                    switchMaterial.setThumbTintList(ColorStateList.valueOf(Color.BLUE));
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#004CFF")));

                } else {
                    switchMaterial.setThumbDrawable(getDrawable(R.drawable.baseline_wb_sunny_24));
                    switchMaterial.setText("Turn on Day mode");
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#FF6F00")));
                    constraintLayout.setBackgroundResource(R.color.yellow);
                }
            }
        });

// работаем с текстом.
        CheckBox boldCheckBox = findViewById(R.id.boldCheckBox);
        CheckBox italicCheckBox = findViewById(R.id.italicCheckBox);
        TextView sampleText = findViewById(R.id.sampleText);

// кнопку bold  жмем.
        boldCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (isChecked) {
                    if (italicCheckBox.isChecked()) { // если италик выбран то текст стал bold italic
                        sampleText.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else { // если италик не выбран просто bold
                        sampleText.setTypeface(null, Typeface.BOLD);
                    }
                } else {
                    if (italicCheckBox.isChecked()) { // если просто италик выбран
                        sampleText.setTypeface(null, Typeface.ITALIC);// то текст просто италик
                    } else {// если ни то ни то - то текст обычный
                        sampleText.setTypeface(null, Typeface.NORMAL);
                    }
                }
            }
        });
// кнопку italic  жмем.
        italicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    if (boldCheckBox.isChecked()) { // если болд выбран то текст стал bold italic
                        sampleText.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else { // если болд не выбран просто италик
                        sampleText.setTypeface(null, Typeface.ITALIC);
                    }
                } else { // если просто болд выбран
                    if (boldCheckBox.isChecked()) {
                        sampleText.setTypeface(null, Typeface.BOLD); // то текст просто болд
                    } else { // если ни то ни то - то текст обычный
                        sampleText.setTypeface(null, Typeface.NORMAL);
                    }
                }
            }
        });

// работа с круглым  progress bar
        Button buttonForProgress = findViewById(R.id.buttonForProgress);// доступ к кнопке
// жмем на кнопку
        buttonForProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressBar progressBar = findViewById(R.id.progressBar); // доступ к progressBar
                progressBar.setVisibility(View.VISIBLE); // делаем его видимым
            }
        });

// горизонтальный ProgressBar
        progressBar = findViewById(R.id.progressBarHorizontal); // доступ к progressBarHorizontal
        Button startProgress = findViewById(R.id.startProgress); // доступ к кнопке startProgress
// жмем на кнопку
        startProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentProgress = currentProgress + 10; // с каждым нажатием кнопки увеличиваем currentProgress на 10
                progressBar.setProgress(currentProgress); // обращаемся к progressBar и через метод setProgress() передаем значение currentProgress
                progressBar.setMax(100); // устанавливаем максимальное значение для progressBar
            }
        });

// работаем с элементом chip
/*        Chip chip1 = findViewById(R.id.chip); // доступ к chip
// жмем на chip
        chip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Action Complete", Toast.LENGTH_SHORT).show(); // Toast это всплывающая подсказка. набираешь Toast и он сам это все добавит кроме текста в ""

            }
        });*/


// работаем с элементом chip group

        progressBar = findViewById(R.id.progressBarHorizontal); // доступ к progressBarHorizontal ЧИСТО МОЙ ПРИКОЛЬЧИК ПРИВЯЗАЛ ГОРИЗОНТАЛ ПРОГРЕСС К НАЖАТИЮ ADD

        editTextKeyword = findViewById(R.id.editTextKeyword);// доступ к текстовому полю
        chipGroup = findViewById(R.id.chipGroup); // доступ к chip group
        Button buttonAdd = findViewById(R.id.buttonAdd); // доступ к кнопкам. тут они с типом данных потому что они не нужны глобально а нужны только в этом методе поэтому нет смысла их объявлять вверху
        Button buttonShow = findViewById(R.id.buttonShow);


//нажимаем кнопкуbuttonAdd
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// вызываем метод addNewChip этот метод создаем ниже за пределами onCreate
                addNewChip();

// ЧИСТО МОЙ ПРИКОЛЬЧИК ПРИВЯЗАЛ ГОРИЗОНТАЛ ПРОГРЕСС К НАЖАТИЮ
                currentProgress = currentProgress + 10; // с каждым нажатием кнопки увеличиваем currentProgress на 10
                progressBar.setProgress(currentProgress); // обращаемся к progressBar и через метод setProgress() передаем значение currentProgress
                progressBar.setMax(100); // устанавливаем максимальное значение для progressBar
            }
        });

// жмем на кнопку buttonShow (show Selection)
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showSelections(); // вызываем метод который

            }
        });

    }

    //создаем метод addNewChip. он отвечает за добавление данных в chip. он void потому что ничего не возвращает
    private void addNewChip() {


        String keyword = editTextKeyword.getText().toString(); //создаем переменную keyword типа String и обращаемся к editTextKeyword чтобы забрать те данные которые пользователь введет в поле Edit text. getText - получаем текстовое содержимое, .toString() - преобразуем в строковое значение (мы же переменную типа String создали)

        if (keyword.isEmpty()) { // проверяем если текстовое поле пустое то выводим всплывающее окно с предупреждением
            Toast.makeText(this, "Введите текст!", Toast.LENGTH_SHORT).show();
            return;// обязательно чтобы прервать метод
        }
// добавляем chipы
        LayoutInflater inflater = LayoutInflater.from(this); //это необходимо для добавления элемента которого не существовало

        Chip newChip = (Chip) inflater.inflate(R.layout.layout_chip_entry, this.chipGroup, false); // создаем новый Chip(тип данных) newChip (просто имя), явно преобразуем его к типу данных (Chip), .(R.layout.layout_chip_entry) его внешний вид мы создавали в res/layout под именем layout_chip_entry, (this.chipGroup) - располагаться будет в этом chipGroup, (false) - привязки к корневому элементу нет - ну тьипа создается не в корне проекта а в конктреном chipGroup

        newChip.setText(keyword); // устанавливаем текст в chip. keyword - это то что мы получили из текстового поля
        chipGroup.addView(newChip); // помещаем содержимое newChip в chipGroup. ну типа сперва забрали текст из текстового поля, затем создали новый элемент chip, положили в это chip текст из текстового поля, а затем chip с текстом поместили в chipGroup

        this.editTextKeyword.setText("");//этот код очищает текстовое поле  после ввода текста в текстовое полде и добавления его в chip

// при нажатии на крестик в chip -  элемент удаляется
        newChip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleChipCloseIconClicked((Chip) v); // View это любой элемент и мы явно указываем что приходит (Chip). метод  handleChipCloseIconClicked принимает Chip (cм метод ниже). короче сюда (в Chip) приходит тот элемент на котором мы жмем крестик

            }
        });

    }

    // метод котрый будет удалять при нажатии на крестик  в chip
    private void handleChipCloseIconClicked(Chip chip) { // handleChipCloseIcinClicked - просто имя, (Chip chip) - работает с типом данных Chip а chip -это тот элемент на котором мы жмем крестик  в newChip.setOnCloseIconClickListener
        ChipGroup parent = (ChipGroup) chip.getParent(); // так как удалять будем из родительского элемента то создаем переменную parent (просто имя) типа ChipGroup ( потому что это родитель chip). приводим parent к типу данных (ChipGroup). обращаемся к chip с которым работаем и вызываем метод .getParent /получить родительский элемент/

        parent.removeView(chip); // у переменной parent через метод removeView() -/служ метод/ - удаляем элемент chip который пришел в методе handleChipCloseIconClicked(Chip chip) - грубо говоря по которому делаем клик на крестик


    }

    // метод котрый вызывает всплывающее окно c отмеченными элементами
    private void showSelections() {

        int count = chipGroup.getChildCount(); // создаем переменную count для посдчета элементов в chipGroup/ chipGroup - это группа наших элементов/ .getChildCount() - это метод для подсчета количества потомков. соответсвенно int count = chipGroup.getChildCount(); подсчитает сколько элементов в chipGroup

        String s = null;  // создаем  строку которую будем передавать в всплывающее окно Toast. изначально  в ней ничего нет - null

        for (int i = 0; i < count; i++) { // идем в цикле по количеству (count) элементов
            Chip child = (Chip) chipGroup.getChildAt(i); // создаем переменную child приводим ее к типу  (Chip), обращаемся к chipGroup получаем (.getChildAt(i)) дочерний элемент по индексу. Проще - идем по циклу и кладем в child элементы из chipGroup

            if (!child.isChecked()) { // если элемент child не отмечен !child.isChecked
                continue; // пропускаем элемент - continue в цикле пропустит текущую итерацию. то есть не отмеченные элементы в if попадут  а отмеченные if пропустят
            }
            if (s == null) { // если s пустая
                s = child.getText().toString(); // в нее попадает текст из child (child это дочерний элемент (читай chipоф) в который по очереди попадают все элементы из chipGroup кроме не отмеченных. см if выше)
            } else { // иначе (если s не пустая )
                s += ", " + child.getText().toString(); // то добавляем к ее содержимому через запятую содержимое следующих child в котрые попадают отмеченные chip которые отметил пользователь
            }
        }
// если ничего из chip не отмечено то чтобы не крашилось делаем так
        if (s == null) {
            Toast.makeText(this, "Ничего не выбрано", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        }
    }
}