package com.example.second;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animation);

// подключаем анимацию 7 ур 0-32
        ImageView imageBoy = findViewById(R.id.boy_image);

        imageBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AnimationDrawable) imageBoy.getDrawable()).start();
// реализуем анимацию прозрачности 0-45
//                Animation name1 = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.anim_alpha);
//                Animation name1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_alpha); // то же самое  - getBaseContext() это служ ресурс
//                imageBoy.startAnimation(name1);

// анимиация по экрану
            Animation translate = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.anim_translate);
            imageBoy.startAnimation(translate);



            }
        });



        ImageView myImageView = findViewById(R.id.boy_image_0); // доступ к карт boy_image_0

// вызов анимации юез созд отдельных ресурсов
        ObjectAnimator rotation = ObjectAnimator.ofFloat(myImageView,"rotation", 90);
        ObjectAnimator trY = ObjectAnimator.ofFloat(myImageView, "translationY", 300);

        AnimatorSet set = new AnimatorSet();
        set.play(rotation).with(trY);
        set.setDuration(1000);
        set.setStartDelay(1000);
        set.start();




        Button buttonRotateCenter = findViewById(R.id.rotateCenter); // доступ к кнопке rotateCenter
        Button buttonRotateCorner = findViewById(R.id.rotateCorner); // доступ к кнопке rotateCenter

        Animation animationRotateCenter = AnimationUtils.loadAnimation(this, R.anim.rotate_center); // созд анимацию вращ по центрц

        Animation animationRotateCorner = AnimationUtils.loadAnimation(this, R.anim.rotate_corner); // созд анимацию вращ по углу

// метод вращ через центр
        buttonRotateCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.startAnimation(animationRotateCenter);
            }
        });

// метод вращ через угол
        buttonRotateCorner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.startAnimation(animationRotateCorner);

            }
        });

 // вызов анимации размера. не привязан к кнопкам и будет работать при запуске
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.shrink);
        imageBoy.startAnimation(scale);
    }
}