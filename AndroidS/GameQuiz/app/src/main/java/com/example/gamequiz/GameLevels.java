package com.example.gamequiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levels);
// создали переменную чтобы работать с сохраненным прогрессом
        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); // эта строчка убирает вверху экрана строку состояния и ее можно вызвать потянув сверху шторку. это применяют чтобы при игре не мешала

        Button buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameLevels.this, MainActivity.class); // собственно возврат с GameLevels на MainActivity
                startActivity(intent);

            }
        });
//================================== кнопка перехода на 1 уровень====================================
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 1) {
                    Intent intent = new Intent(GameLevels.this, Level1.class); // переход с GameLevels на Level1
                    startActivity(intent);
                }
            }
        });
//====================================================================================================
        //================================== кнопка перехода на 2 уровень====================================
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 2) {
                    Intent intent = new Intent(GameLevels.this, Level2.class); // переход с GameLevels на Level1
                    startActivity(intent);
                }
            }
        });
//====================================================================================================
        //================================== кнопка перехода на 3 уровень====================================
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 3) {
                    Intent intent = new Intent(GameLevels.this, Level3.class); // переход с GameLevels на Level1
                    startActivity(intent);
                }
            }
        });
//====================================================================================================
        //================================== кнопка перехода на 4 уровень====================================
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 4) {
                    Intent intent = new Intent(GameLevels.this, Level4.class); // переход с GameLevels на Level1
                    startActivity(intent);
                }
            }
        });
//====================================================================================================

        final int[] x = { // Здесь создаётся массив x, в котором хранятся ID четырёх TextView из твоего XML-лайаута.
                R.id.textView1, //Здесь создаётся массив x, в котором хранятся ID четырёх TextView из твоего XML-лайаута.
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
        };
        for (int i = 0; i < level; i++) { //Запускается цикл, который идёт от 0 до level (не включая). Переменная level скорее всего — число, определяющее, сколько TextView нужно задействовать (например, ты выше сохранял уровень в SharedPreferences — так что это  он)
            TextView tv = findViewById(x[i]); //findViewById(x[i]) — по индексу i из массива x получаем нужный TextView.
            tv.setText("" + (i + 1)); //tv.setText("" + (i + 1)) — устанавливаем текст в этом TextView. "" + (i + 1) — хитрый способ превратить число в строку. i + 1 потому что счёт начинается с 1, а не с 0 (так привычнее пользователю).
//((((((((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))
//           Что получится:
//            Если level == 3, то:
//            textView1 → "1"
//            textView2 → "2"
//            textView3 → "3"
//            textView4 останется как был, его не тронут
//((((((((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))
        }
// сбросить уровень (или другое значение) обратно на 1 в SharedPreferences
        Button restart = findViewById(R.id.buttonRestart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = save.edit(); //создаётся редактор настроек. save — это объект SharedPreferences, полученный раньше через getSharedPreferences(...).
                editor.putInt("Level", 1); // устанавливаем значение ключа "Level" в 1.   Если в настройках уже есть "Level", он перезапишется.  Если нет — создастся новый. Это как сказать: "Запомни, что уровень теперь 1".
                editor.apply(); // Сохраняем изменения

            }
        });
  }
}