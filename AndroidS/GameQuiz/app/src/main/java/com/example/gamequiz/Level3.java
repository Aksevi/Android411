package com.example.gamequiz;

import static com.example.gamequiz.R.*;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class Level3 extends AppCompatActivity {
// эти переменные для того чтобы можно было диалоговые окна вызывать
    // создаем переменную класса  Dialog с именем  dialog. класс сделали сами - это типа диалоговое окно имя - может быть любое
    Dialog dialog;
    Dialog dialogEnd; // создаем переменную класса  Dialog с именем  dialogEnd. класс сделали сами - это типа диалоговое окно имя - может быть любое  появляется в конце уровня

// переменные
    public int numLeft; // для левой картинки + текст. в нее рандомом генерируются числа. напрмер рандомно прищдл 3 - в левую картинку попадает картинка из массива с индексом 3 а в тектсовое поле под картинкой текст из массива с индексом 3
    public int numRight; // для правой картинки + текст
    Array array = new Array(); // это соотвтетственно чтобы массив работал
    Random random = new Random(); // для того чтобы рандом заработал
    public int count = 0; // счетчик правильных ответов

    @SuppressLint({"ClickableViewAccessibility", "ResourceAsColor"}) // это появилось после того как добавил анотацию при смене цвета текста
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView textLevels = findViewById(R.id.textView); // доступ к полю уровень из universal.xml(в нем пишет на каком уровне игрок находится)
        textLevels.setText(R.string.level_3); // устанавливаем текст из стрингового ресурса в поле уровень

// меняем цвет текста чтобы лучше видно было его
        textLevels.setTextColor(R.color.black); // устанавливаем цвет текста. работать будет но будет подчеркиваться красным. чтобы не подчеркивалось добавь анотацию

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);// эта строчка убирает вверху экрана строку состояния и ее можно вызвать потянув сверху шторку. это применяют чтобы при игре не мешала

// получаем доступ к картинкам из universal.xml для скругления углов. помни что для этого в drawable создали style_img_universl.xml и добавили в drawable картинки
        final ImageView imageLeft = findViewById(R.id.imageLeft);
        final ImageView imageRight = findViewById(R.id.imageRight);
// собственно скругление углов
        imageLeft.setClipToOutline(true);
        imageRight.setClipToOutline(true);
// доступ к тексту в universal.xml внизу под картинками
        final TextView textLeft = findViewById(R.id.textLeft);
        textLeft.setTextColor(R.color.black); // устанавливаем цвет текста. работать будет но будет подчеркиваться красным. чтобы не подчеркивалось добавь анотацию
        final TextView textRight = findViewById(R.id.textRight);
        textRight.setTextColor(R.color.black); // устанавливаем цвет текста. работать будет но будет подчеркиваться красным. чтобы не подчеркивалось добавь анотацию

//================ меняем фоновое изображение. так как с 3 уровня у нас другой фон==================
//**************************************************************************************************
        ConstraintLayout main = findViewById(R.id.main); // в universal.xml основной слой имеет id main. к нему получаем доступ чтобы поменять фон
        main.setBackgroundResource(R.drawable.level_3); // устанавливаем из drawable картинку
//**************************************************************************************************
//==================================================================================================

//====================вызов диалогового окна в начале игры (preview_dialog) //======================
//**************************************************************************************************
        dialog = new Dialog(this); // создаем новое диалоговое окно и оно откроется в этом же окне (this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок этогг окна(как я помнял сверху не будет плашки с текстом типа новове окно или диалоговое окно)
        dialog.setContentView(R.layout.preview_dialog); // указываем путь к диалоговому окну
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // устанавливаем прозрачность фона диалогового окна (чтобы рамки не было белой хз откуда она там берется)
        dialog.setCancelable(false); // нельзя закрыть окно кликом за его пределами

//===============устанавливаем картинку  в диалоговое окно
        ImageView previewImg = dialog.findViewById(R.id.preview_img); // обращаемся к ImageView в  preview_dialog - там где у нас картинка с 3 и 9
        previewImg.setImageResource(R.drawable.preview_img_3); // и кладем в этот ImageView новую картинку из drawable
//===============устанавливаем фон диалогового окна
        LinearLayout dialogFon = dialog.findViewById(R.id.dialogFon);// получаем доступ к основному слою в preview_dialog - он имеет id dialogFon
        dialogFon.setBackgroundResource(R.drawable.preview_background_3); // делаем фоном картинку из drawable
//===============устанаваливаем описание задания
        TextView textdescription = dialog.findViewById(R.id.textdescription); // обращаемся к TextView в  preview_dialog - там где у нас текст с описанием заданий
        textdescription.setText(R.string.level_three); // и кладем в этот TextView новый текст из values description_levels - это строковый ресурс поэтому sring

// кнопка назад из preview_dialog
        TextView buttonClose = dialog.findViewById(R.id.buttonClose);
// жмем кнопку
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// при нажатии кнопки переходим с уровня Level3 (диалоговое окно открыто в нем) на уровень 2 (мы оттуда сюда приходим)
                Intent intent = new Intent(Level3.this, Level2.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
//доступ к кнопке buttonContinue из preview_dialog
        Button buttonContinue = dialog.findViewById(R.id.buttonContinue);
// жмем кнопку
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// закрываем диалоговое окно и получаем доступ к уровню. (окно было открыто на level1)
                dialog.dismiss();
            }
        });
// показываем диалоговое окно
        dialog.show();
//**************************************************************************************************
 //========================= вызов диалогового окна в конце игры=====================================
//**************************************************************************************************
        dialogEnd = new Dialog(this); // this - в этом же окне
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок
        dialogEnd.setContentView(R.layout.dialog_end); // путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачность фона чтобы не было белой рамки вокруг
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT); // чтобы диалоговое окно расширялось на всю ширину экрана
        dialogEnd.setCancelable(false); // запрет закрытия кликом за пределами окна
// меняем фон диалоового окна в конце уровня
        LinearLayout dialogFonEnd = dialogEnd.findViewById(id.dialogFon);// получаем доступ к основному слою в preview_dialog_end - он имеет id dialogFon
        dialogFonEnd.setBackgroundResource(R.drawable.preview_background_3); // делаем фоном картинку из drawable
//добавляем интересный факт. показываем ниже когда count = 20 (2 таких)
        TextView textDescriptionEnd = dialogEnd.findViewById(R.id.textDescriptionEnd);
        textDescriptionEnd.setText(string.level_three_end);
// жмем кнопку крестика (Х) - closeButton2
        TextView buttonClose2 = dialogEnd.findViewById(R.id.buttonClose2);
        buttonClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level3.this, GameLevels.class); // переходим на окно выбора уровней
                startActivity(intent);
                dialogEnd.dismiss();
            }
        });
// жмем кнопку  - buttonContinue2 чтобы продолжить игру со следующего уровня
        Button buttonContinue2 = dialogEnd.findViewById(R.id.buttonContinue2);
        buttonContinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level3.this, Level4.class);
                startActivity(intent);
                dialogEnd.dismiss();
            }
        });
//**************************************************************************************************
//==================================================================================================

// доступ к кнопке  buttonBackLevel1 из universal.xml
        Button buttonBackLevel1 = findViewById(R.id.buttonBackLevel1);
// меняем внешний вид кнопки назад в Level 3/ несмотря на то что сам кнопка изначально  находится  в universal но она каждый раз и на уровне появляется
        buttonBackLevel1.setBackgroundResource(drawable.button_stroke_black_opacity_press_white);
        buttonBackLevel1.setTextColor(color.black); // меняем цвет текста на кнопке
// жмем кнопку
        buttonBackLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// возвращаемся назад с Level1 (level 3 это universal - он для всех, универсален) на GameLevels
                Intent intent = new Intent(Level3.this, GameLevels.class);
                startActivity(intent);
            }
        });

// подключаем анимацию которую создали в res anim и назвали alpha
        final Animation animation = AnimationUtils.loadAnimation(Level3.this, R.anim.alpha);

//+++++++++++++++++++++++++++генерим случайное значение для левой картинки++++++++++++++++++++++++++
        numLeft = random.nextInt(21); // генерируем случ число от 0 до 10 но 10 не попадет
        imageLeft.setImageResource(array.images3[numLeft]); //в левую картинку  кладем случайную картинку с индексом numLeft
        textLeft.setText(array.text3[numLeft]); // достаем из массива текст с индексом numLeft и передаем его в поле textLeft

// +++++++++++++++++++++++++++генерим случайное значение для правой картинки++++++++++++++++++++++++++
        numRight = random.nextInt(21); // генерируем случ число от 0 до 10 но 10 не попадет

        while (numLeft == numRight) { // исключаем совпадение значений перед помещением значения в правое поле. если совпадает то генерация заново
            numRight = random.nextInt(21);
        }
        imageRight.setImageResource(array.images3[numRight]); //в правую картинку также кладем случайную картинку с индексом numRight
        textRight.setText(array.text3[numRight]); // достаем из массива текст с индексом numRight  и передаем его в поле textRight

// массив для прогресса игры. это шкала прогресса состоит из кучи прямоугольничков типа TextView в universl.xml
        final int[] progress = {R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10, R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20}; // это получили доступ к маленьким картинкам из universl.xml .

/*
// орабатываем нажатие на левую картинку
        imageLeft.setOnTouchListener(new View.OnTouchListener() { // setOnTouchListener для картинок правильно так но сработает и setOnClick.
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // если нажали на левую то блокируем правую чтобы не нажать было
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imageRight.setEnabled(false); // блокируем правую картинку

                    if (numLeft > numRight) { // если левая картинка больше правой  то
// ставим в левую картинку правильно
                        imageLeft.setImageResource(R.drawable.img_true);
                    } else { // если нет то
// ставим в левую картинку неправильно
                        imageLeft.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) { // если отпустили палец
// проверяем если левое значение больше правой
                    if (numLeft > numRight) {
                        if (count < 20) { // и счетчик очков меньше 20
                            count++; // увеличиваем счетчик на 1
                        }
// программно закрашиваем прогресс серым цветом - чтобы при неправильном ответе при вычете ответов не пропадали
                        for (int j : progress) {
                            TextView tv = findViewById(j); // переменная в которую кладем индекс массива прогрессов
                            tv.setBackgroundResource(R.drawable.style_points); // устанавливаем в tv цвет  style_points из дравабле}

                        }
// определяем правильные ответы и закрашиваем зеленым прогресс
                        for (int i = 0; i < count; i++) { // ограничиваем значением count
                            TextView tv1 = findViewById(progress[i]); // переменная в которую кладем индекс массива прогрессов
                            tv1.setBackgroundResource(R.drawable.style_points_green);
                        }

                    } else { // еcли левая картинка меньше правой
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {

                                count = count - 2;
                            }
// программно закрашиваем прогресс серым цветом/ чтобы при неправильном ответе при вычете ответов не пропадали
                            for (int i = 0; i < progress.length - 1; i++) { // массив с 0 алементов 10
                                TextView tv2 = findViewById(progress[i]);
                                tv2.setBackgroundResource(R.drawable.style_points);
                            }
// определяем правильные ответы и закрашиваем зеленым прогресс

                            for (int i = 0; i < count; i++) {
                                TextView tv4 = findViewById(progress[i]);
                                tv4.setBackgroundResource(R.drawable.style_points_green);

                            }
                        }
                    }
// выход из уровня если набрали 20 очков
                    if (count == 20) {

                    } else { // пока на набрали 20 очков
                        numLeft = random.nextInt(10);
                        imageLeft.setImageResource(array.images1[numLeft]); // достаем картинку
                        imageLeft.startAnimation(animation); // запуск анимации для левой картинки
                        textLeft.setText(array.text1[numLeft]); // достаем из массива текст

                        numRight = random.nextInt(10);

                        while (numLeft == numRight) ;
                        numRight = random.nextInt(10);
                    }
                    imageRight.setImageResource(array.images1[numRight]); // достаем картинку
                    imageRight.startAnimation(animation); // запуск анимации для правой картинки
                    textRight.setText(array.text1[numRight]); // достаем из массива текст

                    imageRight.setEnabled(true); // включаем возможность нажать на правую картинку

                }

            }


                return true;
        }
    });

    // по факту это копия из начала сотых строк
// орабатываем нажатие на правую картинку
        imageRight.setOnTouchListener(new View.OnTouchListener()

    { // setOnTouchListener для картинок правильно так но сработает и setOnClick.
        @Override
        public boolean onTouch (View v, MotionEvent event){
        // если нажали на левую то блокируем правую чтобы не нажать было
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            imageLeft.setEnabled(false); // блокируем левую картинку

            if (numLeft < numRight) { // если левая картинка больше правой  то
// ставим в левую картинку правильно
                imageRight.setImageResource(R.drawable.img_true);
            } else { // если нет то
// ставим в левую картинку неправильно
                imageRight.setImageResource(R.drawable.img_false);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) { // если отпустили палец
// проверяем если левое значение больше правой
            if (numLeft < numRight) {
                if (count < 20) { // и счетчик очков меньше 20
                    count++; // увеличиваем счетчик на 1
                }
// программно закрашиваем прогресс серым цветом/ чтобы при неправильном ответе при вычете ответов не пропадали
                for (int j : progress) {
                    TextView tv = findViewById(j); // переменная в которую кладем индекс массива прогрессов
                    tv.setBackgroundResource(R.drawable.style_points); // устанавливаем в tv цвет  style_points из дравабле}

                }
// определяем правильные ответы и закрашиваем зеленым прогресс
                for (int i = 0; i < count; i++) { // ограничиваем значением count
                    TextView tv1 = findViewById(progress[i]); // переменная в которую кладем индекс массива прогрессов
                    tv1.setBackgroundResource(R.drawable.style_points_green);
                }

            } else { // еcли левая картинка меньше правой
                if (count > 0) {
                    if (count == 1) {
                        count = 0;
                    } else {

                        count = count - 2;
                    }
// программно закрашиваем прогресс серым цветом/ чтобы при неправильном ответе при вычете ответов не пропадали
                    for (int i = 0; i < progress.length - 1; i++) { // массив с 0 алементов 10
                        TextView tv3 = findViewById(progress[i]);
                        tv3.setBackgroundResource(R.drawable.style_points);
                    }
// определяем правильные ответы и закрашиваем зеленым прогресс

                    for (int i = 0; i < count; i++) {
                        TextView tv4 = findViewById(progress[i]);
                        tv4.setBackgroundResource(R.drawable.style_points_green);

                    }
                 }
                }
// выход из уровня если набрали 20 очков
                if (count == 20) {

                } else { // пока на набрали 20 очков
                    numLeft = random.nextInt(10);
                    imageLeft.setImageResource(array.images1[numLeft]); // достаем картинку
                    imageLeft.startAnimation(animation); // запуск анимации для левой картинки
                    textLeft.setText(array.text1[numLeft]); // достаем из массива текст

                    numRight = random.nextInt(10);

                    while (numLeft == numRight) ;
                    numRight = random.nextInt(10);
                }
                imageRight.setImageResource(array.images1[numRight]); // достаем картинку
                imageRight.startAnimation(animation); // запуск анимации для правой картинки
                textRight.setText(array.text1[numRight]); // достаем из массива текст

                imageLeft.setEnabled(true); // включаем возможность нажать на правую картинку

            }

        }


        return true;
    }
    });
    }
}*/

// обрабатываем нажатие на ЛЕВУЮ КАРТИНКУ
        imageLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // условия касания картинки
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imageRight.setEnabled(false);  // блокируем правую картинку
                    if (numLeft > numRight) { // если numLeft > numRight
                        imageLeft.setImageResource(R.drawable.img_true); // то в левом изображении картинка правильный ответ
                    } else { // если нет
                        imageLeft.setImageResource(R.drawable.img_false);// то в левом изображении картинка неправильный ответ
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {  // когда  отпустили палец
                    if (numLeft > numRight) { // если numLeft > numRight
                        if (count < 20) { // и счетчик меньше 20
                            count++; // увеличиваем счетчик на 1
                        }

// закрашиваем прогресс серым цветом чтобы просле вычета очков прогресс стал снова серым
                        for (int j : progress) {
                            TextView tv = findViewById(j);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        // определяем правильные ответы и закрашивает зеленым
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {  // если левая картинка меньше
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count -= 2;
                            }
                            // закрашиваем прогресс серым цветом
                            for (int i = 0; i < progress.length - 1; i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points);
                            }
                            // определяем правильные ответы и закрашиваем зеленым цветом
                            for (int i = 0; i < count; i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points_green);
                            }
                        }
                    }
                    if (count == 20) {  // выход из уровня

//================================= Сохраняем прогресс==============================================
//два таких кода (второй ниже) потому что завершить може игру и на левой и на правой картинке. второй ниже
//**************************************************************************************************
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE); //создаётся объект SharedPreferences, который будет использовать файл с именем "Save". Метод getSharedPreferences() получает доступ к файлу настроек приложения. MODE_PRIVATE означает, что этот файл будет доступен только текущему приложению (он не будет доступен другим приложениям).
                        final int level = save.getInt("Level", 3); // В этой строке извлекается значение, сохранённое под ключом "Level".Если такого ключа нет (например, файл пуст или данных ещё нет), то используется значение по умолчанию — 1.
                        if (level <= 3){ //Здесь проверяется, равен ли текущий уровень (level) единице.
                            SharedPreferences.Editor editor = save.edit(); //Если уровень равен 1, то создаётся объект SharedPreferences.Editor для редактирования данных.
                            editor.putInt("Level", 4);//Метод putInt() записывает новое значение для ключа "Level", устанавливая его равным 2.
                            editor.apply();//Вызов apply() сохраняет изменения в SharedPreferences.
//((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))))))))
//Что происходит в итоге:
//Когда этот код выполняется, он проверяет уровень игрока (или какой-то другой параметр, связанный с ключом "Level").
//
//Если уровень равен 1, то он изменяет его на 2 и сохраняет это изменение.
//
//После этого при следующем запуске приложения будет извлечено уже новое значение (2), если оно было изменено.
//((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))))))))
                        }
//**************************************************************************************************
//==================================================================================================
                        dialogEnd.show(); // запуск диалога с интересными фактами



                    } else {
                        numLeft = random.nextInt(21); // потому что 21 картинка
                        imageLeft.setImageResource(array.images3[numLeft]);  // достаем из массива картинку
                        imageLeft.startAnimation(animation);  // запускаем анимацию для левой картинки
                        textLeft.setText(array.text3[numLeft]);  // достаем из массива текст

                        do {
                            numRight = random.nextInt(21); // потому что 21 картинка
                        } while (numLeft == numRight);
                        imageRight.setImageResource(array.images3[numRight]);  // достаем из массива картинку
                        imageRight.startAnimation(animation);  // запускаем анимацию для правой картинки
                        textRight.setText(array.text3[numRight]);  // достаем из массива текст
                        imageRight.setEnabled(true);  // включаем обратно правую картинку
                    }
                }
                return true;
            }
        });

        // обрабатываем нажатие на правую картинку
        imageRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // условия касания картинки
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imageLeft.setEnabled(false);  // блокируем левую картинку
                    if (numLeft < numRight) {
                        imageRight.setImageResource(R.drawable.img_true);
                    } else {
                        imageRight.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {  // если отпустили палец
                    if (numLeft < numRight) {
                        if (count < 20) {
                            count++;
                        }

                        // закрашиваем прогресс серым цветом
                        for (int j : progress) {
                            TextView tv = findViewById(j);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        // определяем правильные ответы и закрашивает зеленым
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]); // создали переменную TextView tv и через нее получили доступ к элементам массива progress (создали выше). соответственно идем по этому массиву
                            tv.setBackgroundResource(R.drawable.style_points_green);// и по очереди закрашиваем их зеленым
                        }
                    } else {  // если левая картинка меньше
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count -= 2;
                            }
                            // закрашиваем прогресс серым цветом
                            for (int i = 0; i < progress.length - 1; i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points);
                            }
                            // определяем правильные ответы и закрашиваем зеленым цветом
                            for (int i = 0; i < count; i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points_green);
                            }
                        }
                    }
                    if (count == 20) {  // выход из уровня

//================================= Сохраняем прогресс==============================================
//два таких кода (второй ниже) потому что завершить може игру и на левой и на правой картинке. второй выше
//**************************************************************************************************
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE); //создаётся объект SharedPreferences, который будет использовать файл с именем "Save". Метод getSharedPreferences() получает доступ к файлу настроек приложения. MODE_PRIVATE означает, что этот файл будет доступен только текущему приложению (он не будет доступен другим приложениям).
                        final int level = save.getInt("Level", 3); // В этой строке извлекается значение, сохранённое под ключом "Level".Если такого ключа нет (например, файл пуст или данных ещё нет), то используется значение по умолчанию — 1.
                        if (level <= 3){ //Здесь проверяется, равен ли текущий уровень (level) единице.
                            SharedPreferences.Editor editor = save.edit(); //Если уровень равен 1, то создаётся объект SharedPreferences.Editor для редактирования данных.
                            editor.putInt("Level", 4);//Метод putInt() записывает новое значение для ключа "Level", устанавливая его равным 2.
                            editor.apply();//Вызов apply() сохраняет изменения в SharedPreferences.
//((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))))))))
//Что происходит в итоге:
//Когда этот код выполняется, он проверяет уровень игрока (или какой-то другой параметр, связанный с ключом "Level").
//
//Если уровень равен 1, то он изменяет его на 2 и сохраняет это изменение.
//
//После этого при следующем запуске приложения будет извлечено уже новое значение (2), если оно было изменено.
//((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))))))))
                        }
//**************************************************************************************************
//==================================================================================================
                        dialogEnd.show(); // запуск диалога с интересными фактами


                    } else {
                        numLeft = random.nextInt(21); // потому что 21 картинка
                        imageLeft.setImageResource(array.images3[numLeft]);  // достаем из массива картинку
                        imageLeft.startAnimation(animation);  // запускаем анимацию для левой картинки
                        textLeft.setText(array.text3[numLeft]);  // достаем из массива текст

                        do {
                            numRight = random.nextInt(21); // потому что 21 картинка
                        } while (numLeft == numRight);
                        imageRight.setImageResource(array.images3[numRight]);  // достаем из массива картинку
                        imageRight.startAnimation(animation);  // запускаем анимацию для правой картинки
                        textRight.setText(array.text3[numRight]);  // достаем из массива текст
                        imageLeft.setEnabled(true);  // включаем обратно правую картинку
                    }

                }

                return true;
            }
        });

    }
}