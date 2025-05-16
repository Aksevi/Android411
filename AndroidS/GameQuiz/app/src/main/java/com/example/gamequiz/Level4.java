package com.example.gamequiz;

import static com.example.gamequiz.R.anim;
import static com.example.gamequiz.R.color;
import static com.example.gamequiz.R.drawable;
import static com.example.gamequiz.R.id;
import static com.example.gamequiz.R.layout;
import static com.example.gamequiz.R.string;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
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

public class Level4 extends AppCompatActivity {

    // создаем переменную класса  Dialog с именем  dialog. класс сделали сами - это типа диалоговое окно имя - может быть любое
    Dialog dialog;
    Dialog dialogEnd; // создаем переменную класса  Dialog с именем  dialogEnd. класс сделали сами - это типа диалоговое окно имя - может быть любое  появляется в конце уровня

    // переменные
    public int numLeft; // для левой картинки + текст
    public int numRight; // для правой картинки + текст
    Array array = new Array();
    Random random = new Random(); // для того чтобы рандом заработал
    public int count = 0; // счетчик правильных ответов

    @SuppressLint({"ClickableViewAccessibility", "ResourceAsColor"}) // это появилось после того как добавил анотацию прр смене цвета текста
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.universal);

        TextView textLevels = findViewById(id.textView); // доступ к полю уровень из universal.xml
        textLevels.setText(string.level_4); // устанавливаем текст из стрингового ресурса в поле уровень

// меняем цвет текста чтобы лучше видно было его
        textLevels.setTextColor(color.black); // устанавливаем цвет текста. работать будет но будет подчеркиваться красным. чтобы не подчеркивалось добавь анотацию

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);// эта строчка убирает вверху экрана строку состояния и ее можно вызвать потянув сверху шторку. это применяют чтобы при игре не мешала
// получаем доступ к картинкам из universal.xml для скругления углов. помни что для этого в drawable создали style_img_universl.xml и добавили в drawable картинки
        final ImageView imageLeft = findViewById(id.imageLeft);
        final ImageView imageRight = findViewById(id.imageRight);
// собственно скругление углов
        imageLeft.setClipToOutline(true);
        imageRight.setClipToOutline(true);
// доступ к тексту в universal.xml внизу под картинками
        final TextView textLeft = findViewById(id.textLeft);
        textLeft.setTextColor(color.black); // устанавливаем цвет текста. работать будет но будет подчеркиваться красным. чтобы не подчеркивалось добавь анотацию
        final TextView textRight = findViewById(id.textRight);
        textRight.setTextColor(color.black); // устанавливаем цвет текста. работать будет но будет подчеркиваться красным. чтобы не подчеркивалось добавь анотацию

//================ меняем фоновое изображение. так как с 3 уровня у нас другой фон==================
//**************************************************************************************************
        ConstraintLayout main = findViewById(id.main); // в universal.xml основной слой имеет id main. к нему получаем доступ чтобы поменять фон
        main.setBackgroundResource(drawable.level_4); // устанавливаем из drawable картинку
//**************************************************************************************************
//==================================================================================================

// вызов диалогового окна в начале игры (preview_dialog)
        dialog = new Dialog(this); // создаем новое диалоговое окно и оно откроется в этом же окне (this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок этогг окна(как я помнял сверху не будет плашки с текстом типа новове окно или диалоговое окно)
        dialog.setContentView(layout.preview_dialog); // указываем путь к диалоговому окну
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // устанавливаем прозрачность фона диалогового окна (чтобы рамки не было белой хз откуда она там берется)
        dialog.setCancelable(false); // нельзя закрыть окно кликом за его пределами

//===============устанавливаем картинку в диалоговое окно
        ImageView previewImg = dialog.findViewById(id.preview_img); // обращаемся к ImageView в  preview_dialog - там где у нас картинка с 3 и 9
        previewImg.setImageResource(drawable.preview_img_4); // и кладем в этот ImageView новую картинку из drawable
//===============устанавливаем фон диалогового окна
        LinearLayout dialogFon = dialog.findViewById(id.dialogFon);// получаем доступ к основному слою в preview_dialog - он имеет id dialogFon
        dialogFon.setBackgroundResource(drawable.preview_background_4); // делаем фоном картинку из drawable

//===============устаенваливаем описание задания
        TextView textdescription = dialog.findViewById(id.textdescription); // обращаемся к TextView в  preview_dialog - там где у нас текст с описанием заданий
        textdescription.setText(string.level_four); // и кладем в этот TextView новый текст из values description_levels - это строковый ресурс поэтому sring

// кнопка назад из preview_dialog
        TextView buttonClose = dialog.findViewById(id.buttonClose);
// жмем кнопку
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// при нажатии кнопки переходим с уровня Level3 (диалоговое окно открыто в нем) на уровень 2 (мы оттуда сюда приходим)
                Intent intent = new Intent(Level4.this, Level2.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });

//доступ к кнопке buttonContinue из preview_dialog
        Button buttonContinue = dialog.findViewById(id.buttonContinue);
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


 //========================= вызов диалогового окна в конце игры=====================================
//**************************************************************************************************
        dialogEnd = new Dialog(this); // this - в этом же окне
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок
        dialogEnd.setContentView(layout.dialog_end); // путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачность фона чтобы не было белой рамки вокруг
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT); // чтобы диалоговое окно расширялось на всю ширину экрана
        dialogEnd.setCancelable(false); // запрет закрытия кликом за пределами окна

// меняем фон диалогового окна в конце уровня
        LinearLayout dialogFonEnd = dialogEnd.findViewById(id.dialogFon);// получаем доступ к основному слою в preview_dialog_end - он имеет id dialogFon
        dialogFonEnd.setBackgroundResource(R.drawable.preview_background_4); // делаем фоном картинку из drawable

        //добавляем интересный факт. показываем ниже когда count = 20 (2 таких)
        TextView textDescriptionEnd = dialogEnd.findViewById(id.textDescriptionEnd);
        textDescriptionEnd.setText(string.level_four_end);


// жмем кнопку крестика (Х) - closeButton2
        TextView buttonClose2 = dialogEnd.findViewById(id.buttonClose2);
        buttonClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level4.this, GameLevels.class); // переходим на окно выбора уровней
                startActivity(intent);
                dialogEnd.dismiss();
            }
        });
// жмем кнопку  - buttonContinue2 чтобы продолжить игру со следующего уровня
        Button buttonContinue2 = dialogEnd.findViewById(id.buttonContinue2);
        buttonContinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level4.this, GameLevels.class);
                startActivity(intent);
                dialogEnd.dismiss();
            }
        });
//**************************************************************************************************
//==================================================================================================

// доступ к кнопке  buttonBackLevel1 из universal.xml
        Button buttonBackLevel1 = findViewById(id.buttonBackLevel1);

        buttonBackLevel1.setBackgroundResource(drawable.button_stroke_black_opacity_press_white); // меняем внешний вид кнопки назад в Level 3/ несмотря на то что сам кнопка изначально  находится  в universal но она каждый раз и на уровне появляется
// жмем кнопку
        buttonBackLevel1.setTextColor(color.black); // меняем цвет тектса на кнопке

        buttonBackLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// возвращаемся назад с Level1 (level 1 это universal - он для всех, универсален) на GameLevels
                Intent intent = new Intent(Level4.this, GameLevels.class);
                startActivity(intent);
            }
        });

// подключаем анимацию которую создали в res anim и назвали alpha
        final Animation animation = AnimationUtils.loadAnimation(Level4.this, anim.alpha);


// ===================генерим случайное значение для левой картинки=================================
// здесь и ниже у нас вместо просто numLeft или numRight уже  массив array.images4[numLeft.numRight] потмоу что для сравнения съедобного или несъедобного сделали массив из 0 и 1 в array (см 4 уровень)
        numLeft = random.nextInt(20); // генерируем случ число от 0 до 10 но 10 не попадет
        imageLeft.setImageResource(array.images4[numLeft]); //в левую картинку также кладем случайную картинку
        textLeft.setText(array.text4[numLeft]); // достаем из массива текст и передаем его в поле textLeft

// генерим случайное значение для правой картинки
        numRight = random.nextInt(20); // генерируем случ число от 0 до 10 но 10 не попадет

        while (array.choise[numLeft] == array.choise[numRight]) { // исключаем совпадение значений перед помещением значения в правое поле. если совпадает то генерация заново
            numRight = random.nextInt(20);
        }
        imageRight.setImageResource(array.images4[numRight]); //в левую картинку также кладем случайную картинку
        textRight.setText(array.text4[numRight]); // достаем из массива текст и передаем его в поле numRight

// массив для прогресса игры
        final int[] progress = {id.point1, id.point2, id.point3, id.point4, id.point5, id.point6, id.point7, id.point8, id.point9, id.point10, id.point11, id.point12, id.point13, id.point14, id.point15, id.point16, id.point17, id.point18, id.point19, id.point20}; // это получили доступ к маленьким картинкам из universl.xml .

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

// обрабатываем нажатие на левую картинку
        imageLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // условия касания картинки
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imageRight.setEnabled(false);  // блокируем правую картинку
                    if (array.choise[numLeft] > array.choise[numRight]) {
                        imageLeft.setImageResource(drawable.img_true);
                    } else {
                        imageLeft.setImageResource(drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {  // если отпустили палец
                    if (array.choise[numLeft] > array.choise[numRight]) {
                        if (count < 20) {
                            count++;
                        }

                        // закрашиваем прогресс серым цветом
                        for (int j : progress) {
                            TextView tv = findViewById(j);
                            tv.setBackgroundResource(drawable.style_points);
                        }

                        // определяем правильные ответы и закрашивает зеленым
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(drawable.style_points_green);
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
                                tv.setBackgroundResource(drawable.style_points);
                            }
                            // определяем правильные ответы и закрашиваем зеленым цветом
                            for (int i = 0; i < count; i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(drawable.style_points_green);
                            }
                        }
                    }
                    if (count == 20) {  // выход из уровня
                        dialogEnd.show(); // запуск диалога с интересными фактами



                    } else {
                        numLeft = random.nextInt(20); // потому что 21 картинка
                        imageLeft.setImageResource(array.images4[numLeft]);  // достаем из массива картинку
                        imageLeft.startAnimation(animation);  // запускаем анимацию для левой картинки
                        textLeft.setText(array.text4[numLeft]);  // достаем из массива текст

                        do {
                            numRight = random.nextInt(20); // потому что 21 картинка
                        } while (array.choise[numLeft] == array.choise[numRight]);
                        imageRight.setImageResource(array.images4[numRight]);  // достаем из массива картинку
                        imageRight.startAnimation(animation);  // запускаем анимацию для правой картинки
                        textRight.setText(array.text4[numRight]);  // достаем из массива текст
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
                    if (array.choise[numLeft] < array.choise[numRight]) {
                        imageRight.setImageResource(drawable.img_true);
                    } else {
                        imageRight.setImageResource(drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {  // если отпустили палец
                    if (array.choise[numLeft] < array.choise[numRight]) {
                        if (count < 20) {
                            count++;
                        }

                        // закрашиваем прогресс серым цветом
                        for (int j : progress) {
                            TextView tv = findViewById(j);
                            tv.setBackgroundResource(drawable.style_points);
                        }

                        // определяем правильные ответы и закрашивает зеленым
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(drawable.style_points_green);
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
                                tv.setBackgroundResource(drawable.style_points);
                            }
                            // определяем правильные ответы и закрашиваем зеленым цветом
                            for (int i = 0; i < count; i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(drawable.style_points_green);
                            }
                        }
                    }
                    if (count == 20) {  // выход из уровня
                        dialogEnd.show(); // запуск диалога с интересными фактами


                    } else {
                        numLeft = random.nextInt(20); // потому что 21 картинка
                        imageLeft.setImageResource(array.images4[numLeft]);  // достаем из массива картинку
                        imageLeft.startAnimation(animation);  // запускаем анимацию для левой картинки
                        textLeft.setText(array.text4[numLeft]);  // достаем из массива текст

                        do {
                            numRight = random.nextInt(20); // потому что 21 картинка
                        } while (array.choise[numLeft] ==array.choise[numRight]);
                        imageRight.setImageResource(array.images4[numRight]);  // достаем из массива картинку
                        imageRight.startAnimation(animation);  // запускаем анимацию для правой картинки
                        textRight.setText(array.text4[numRight]);  // достаем из массива текст
                        imageLeft.setEnabled(true);  // включаем обратно правую картинку
                    }

                }

                return true;
            }
        });

    }
}