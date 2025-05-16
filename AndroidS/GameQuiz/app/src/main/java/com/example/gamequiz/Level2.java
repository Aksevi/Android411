package com.example.gamequiz;

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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    // создаем переменную класса  Dialog с именем  dialog. класс сделали сами - это типа диалоговое окно имя - может быть любое
    Dialog dialog;
    Dialog dialogEnd; // создаем переменную класса  Dialog с именем  dialogEnd. класс сделали сами - это типа диалоговое окно имя - может быть любое  появляется в конце уровня

    // переменные
    public int numLeft; // для левой картинки + текст
    public int numRight; // для правой картинки + текст
    Array array = new Array();
    Random random = new Random(); // для того чтобы рандом заработал
    public int count = 0; // счетчик правильных ответов

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.universal);

        TextView textLevels = findViewById(R.id.textView); // доступ к полю уровень из universal.xml
        textLevels.setText(R.string.level_2); // устанавливаем текст из стрингового ресурса в поле уровень

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);// эта строчка убирает вверху экрана строку состояния и ее можно вызвать потянув сверху шторку. это применяют чтобы при игре не мешала
// получаем доступ к картинкам из universal.xml для скругления углов. помни что для этого в drawable создали style_img_universl.xml и добавили в drawable картинки
        final ImageView imageLeft = findViewById(R.id.imageLeft);
        final ImageView imageRight = findViewById(R.id.imageRight);
// собственно скругление углов
        imageLeft.setClipToOutline(true);
        imageRight.setClipToOutline(true);
// доступ к тексту в universal.xml внизу под картинками
        final TextView textLeft = findViewById(R.id.textLeft);
        final TextView textRight = findViewById(R.id.textRight);

// вызов диалогового окна в начале игры (preview_dialog)
        dialog = new Dialog(this); // создаем новое диалоговое окно и оно откроется в этом же окне (this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок этогг окна(как я помнял сверху не будет плашки с текстом типа новове окно или диалоговое окно)
        dialog.setContentView(R.layout.preview_dialog); // указываем путь к диалоговому окну
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // устанавливаем прозрачность фона диалогового окна (чтобы рамки не было белой хз откуда она там берется)
        dialog.setCancelable(false); // нельзя закрыть окно кликом за его пределами

//=====устанваливаем картинку в диалоговое окно
        ImageView previewImg = dialog.findViewById(R.id.preview_img); // обращаемся к ImageView в  preview_dialog - там где у нас картинка с 3 и 9
        previewImg.setImageResource(R.drawable.number_lev_two); // и кладем в этот ImageView новую картинку из drawable
//==== устаенваливаем описание задания
        TextView textdescription = dialog.findViewById(R.id.textdescription); // обращаемся к TextView в  preview_dialog - там где у нас текст с описанием заданий
        textdescription.setText(R.string.level_two); // и кладем в этот TextView новый текст из values description_leveks - это строковый ресурс поэтому tring

// кнопка назад из preview_dialog
        TextView buttonClose = dialog.findViewById(R.id.buttonClose);
// жмем кнопку
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// при нажатии кнопки переходим с уровня Level1 (диалоговое окно открыто в нем) на уровень GameLevels (мы оттуда сюда приходим)
                Intent intent = new Intent(Level2.this, GameLevels.class);
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


 //========================= вызов диалогового окна в конце игры=====================================
//**************************************************************************************************
        dialogEnd = new Dialog(this); // this - в этом же окне
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок
        dialogEnd.setContentView(R.layout.dialog_end); // путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачность фона чтобы не было белой рамки вокруг
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT); // чтобы диалоговое окно расширялось на всю ширину экрана
        dialogEnd.setCancelable(false); // запрет закрытия кликом за пределами окна

        //добавляем интересный факт. показываем ниже когда count = 20 (2 таких)
        TextView textDescriptionEnd = dialogEnd.findViewById(R.id.textDescriptionEnd);
        textDescriptionEnd.setText(R.string.level_two_end);
// жмем кнопку крестика (Х) - closeButton2
        TextView buttonClose2 = dialogEnd.findViewById(R.id.buttonClose2);
        buttonClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2.this, GameLevels.class); // переходим на окно выбора уровней
                startActivity(intent);
                dialogEnd.dismiss();
            }
        });
// жмем кнопку  - buttonContinue2 чтобы продолжить игру со следующего уровня
        Button buttonContinue2 = dialogEnd.findViewById(R.id.buttonContinue2);
        buttonContinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2.this, Level3.class);
                startActivity(intent);
                dialogEnd.dismiss();
            }
        });
//**************************************************************************************************
//==================================================================================================

// доступ к кнопке  buttonBackLevel1 из universal.xml
        Button buttonBackLevel1 = findViewById(R.id.buttonBackLevel1);
// жмем кнопку
        buttonBackLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// возвращаемся назад с Level1 (level 1 это universal - он для всех, универсален) на GameLevels
                Intent intent = new Intent(Level2.this, GameLevels.class);
                startActivity(intent);
            }
        });
// подключаем анимацию которую создали в res anim и назвали alpha
        final Animation animation = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);


// генерим случайное значение для левой картинки
        numLeft = random.nextInt(10); // генерируем случ число от 0 до 10 но 10 не попадет
        imageLeft.setImageResource(array.images2[numLeft]); //в левую картинку также кладем случайную картинку
        textLeft.setText(array.text2[numLeft]); // достаем из массива текст и передаем его в поле textLeft

// генерим случайное значение для правой картинки
        numRight = random.nextInt(10); // генерируем случ число от 0 до 10 но 10 не попадет

        while (numLeft == numRight) { // исключаем совпадение значений перед помещением значения в правое поле. если совпадает то генерация заново
            numRight = random.nextInt(10);
        }
        imageRight.setImageResource(array.images2[numRight]); //в левую картинку также кладем случайную картинку
        textRight.setText(array.text2[numRight]); // достаем из массива текст и передаем его в поле numRight

// массив для прогресса игры
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

// обрабатываем нажатие на левую картинку
        imageLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // условия касания картинки
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imageRight.setEnabled(false);  // блокируем правую картинку
                    if (numLeft > numRight) {
                        imageLeft.setImageResource(R.drawable.img_true);
                    } else {
                        imageLeft.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {  // если отпустили палец
                    if (numLeft > numRight) {
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
                        final int level = save.getInt("Level", 2); // В этой строке извлекается значение, сохранённое под ключом "Level".Если такого ключа нет (например, файл пуст или данных ещё нет), то используется значение по умолчанию — 1.
                        if (level <= 2){ //Здесь проверяется, равен ли текущий уровень (level) единице.
                            SharedPreferences.Editor editor = save.edit(); //Если уровень равен 1, то создаётся объект SharedPreferences.Editor для редактирования данных.
                            editor.putInt("Level", 3);//Метод putInt() записывает новое значение для ключа "Level", устанавливая его равным 2.
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
                        numLeft = random.nextInt(10);
                        imageLeft.setImageResource(array.images2[numLeft]);  // достаем из массива картинку
                        imageLeft.startAnimation(animation);  // запускаем анимацию для левой картинки
                        textLeft.setText(array.text2[numLeft]);  // достаем из массива текст

                        do {
                            numRight = random.nextInt(10);
                        } while (numLeft == numRight);
                        imageRight.setImageResource(array.images2[numRight]);  // достаем из массива картинку
                        imageRight.startAnimation(animation);  // запускаем анимацию для правой картинки
                        textRight.setText(array.text2[numRight]);  // достаем из массива текст
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
//два таких кода (второй ниже) потому что завершить може игру и на левой и на правой картинке. второй выше
//**************************************************************************************************
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE); //создаётся объект SharedPreferences, который будет использовать файл с именем "Save". Метод getSharedPreferences() получает доступ к файлу настроек приложения. MODE_PRIVATE означает, что этот файл будет доступен только текущему приложению (он не будет доступен другим приложениям).
                        final int level = save.getInt("Level", 2); // В этой строке извлекается значение, сохранённое под ключом "Level".Если такого ключа нет (например, файл пуст или данных ещё нет), то используется значение по умолчанию — 1.
                        if (level <= 2){ //Здесь проверяется, равен ли текущий уровень (level) единице.
                            SharedPreferences.Editor editor = save.edit(); //Если уровень равен 1, то создаётся объект SharedPreferences.Editor для редактирования данных.
                            editor.putInt("Level", 3);//Метод putInt() записывает новое значение для ключа "Level", устанавливая его равным 2.
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
                        numLeft = random.nextInt(10);
                        imageLeft.setImageResource(array.images2[numLeft]);  // достаем из массива картинку
                        imageLeft.startAnimation(animation);  // запускаем анимацию для левой картинки
                        textLeft.setText(array.text2[numLeft]);  // достаем из массива текст

                        do {
                            numRight = random.nextInt(10);
                        } while (numLeft == numRight);
                        imageRight.setImageResource(array.images2[numRight]);  // достаем из массива картинку
                        imageRight.startAnimation(animation);  // запускаем анимацию для правой картинки
                        textRight.setText(array.text2[numRight]);  // достаем из массива текст
                        imageLeft.setEnabled(true);  // включаем обратно правую картинку
                    }

                }

                return true;
            }
        });

    }
}