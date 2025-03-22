package com.example.second;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

// созд переменные для звуков   MediaPlayer - тип переменных
    private MediaPlayer sound1, sound2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

// доступ к кнопкам
        ImageButton img1 = findViewById(R.id.buttonImg1);
        ImageButton img2 = findViewById(R.id.buttonImg2);




// подключаем к переменной звук
//        sound1 = MediaPlayer.create(this, R.raw.sound_1);
        sound1 = MediaPlayer.create(this, R.raw.xcom);

        sound2 = MediaPlayer.create(this, R.raw.sound_2);

 // метод срабатывания при нажатии на картинку 1
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(sound1, sound2); // вызов метода проигрывания звука две переменных потому что 2 звука - один выключает второй
            }
        });

// метод срабатывания при нажатии на картинку 2
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(sound2, sound1); // вызов метода проигрывания звука две переменных потому что 2 звука - один выключает второй
            }
        });


// второй способ кнопки возврата назад
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class); // тут вот так надо указывать

                startActivity(intent);

            }
        });

// метод остановки звуков по кнопке стоп. pause чтобы можно было снова запустить. seekTo(0) позволяет запускать с начала(0 - это с какой миллисекунды запускать)
        Button stpButton = findViewById(R.id.stop_button);
        stpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sound1.pause();
                sound1.seekTo(0);

                sound2.pause();
                sound2.seekTo(0);
            }
        });

    }

// метод проигрывания звука
    public void soundPlayButton(MediaPlayer sound1, MediaPlayer sound2){ // две переменных потому что два звука

// в ifах реализуем остановку одного звука если запущен второй
        if (sound1.isPlaying()){
            sound1.pause();
            sound2.seekTo(0);// мелодия после паузы начнется с начала
            sound1.setLooping(false);
        }
        if (sound2.isPlaying()){
            sound2.pause();
            sound1.seekTo(0);// мелодия после паузы начнется с начала
            sound2.setLooping(false);
        }
        sound1.start(); // запуск звука
        sound1.setLooping(true); // зацикливание звука


    }




// первый способ кнопки возврата назад
/*    public void goBack(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/
}
