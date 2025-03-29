package com.example.hw_animation;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HandAnimationActivity extends AppCompatActivity {

    private MediaPlayer sound; // переменная для звука



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hand_animation);

        ImageView image = findViewById(R.id.hand_image); // доступ к анимации
        sound = MediaPlayer.create(this, R.raw.xcom); // доступ к переменной звука


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((AnimationDrawable) image.getDrawable()).start();// вызов анимации
                soundPlay(sound);// вызов метода проигрывания звука

            }
        });

    }
// метод проигрывания звука
    public void soundPlay (MediaPlayer sound){
        sound.start();
    }
}