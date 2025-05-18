package com.example.fragmentdz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button fragment_1_btn;
    Button fragment_2_btn;
    Button fragment_3_btn;

    View flash_frame_1;
    View flash_frame_2;
    View flash_frame_3;

    Fragment_1 fragment_1 = new Fragment_1();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        fragment_1_btn = findViewById(R.id.fragment_1_btn);
        fragment_2_btn = findViewById(R.id.fragment_2_btn);
        fragment_3_btn = findViewById(R.id.fragment_3_btn);

        flash_frame_1 = findViewById(R.id.flash_frame_1);
        flash_frame_2 = findViewById(R.id.flash_frame_2);
        flash_frame_3 = findViewById(R.id.flash_frame_3);

        flash_frame_1.setVisibility(View.VISIBLE);
        replaceFragment(R.id.frame_layout, new Fragment_1());

        fragment_1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flash_frame_1.setVisibility(View.VISIBLE);
                flash_frame_2.setVisibility(View.INVISIBLE);
                flash_frame_3.setVisibility(View.INVISIBLE);
                replaceFragment(R.id.frame_layout, new Fragment_1());

            }
        });
        fragment_2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flash_frame_2.setVisibility(View.VISIBLE);
                flash_frame_3.setVisibility(View.INVISIBLE);
                flash_frame_1.setVisibility(View.INVISIBLE);
                replaceFragment(R.id.frame_layout, new Fragment_2());
            }
        });
        fragment_3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flash_frame_3.setVisibility(View.VISIBLE);
                flash_frame_2.setVisibility(View.INVISIBLE);
                flash_frame_1.setVisibility(View.INVISIBLE);
                replaceFragment(R.id.frame_layout, new Fragment_3());
            }
        });

    }

    private void replaceFragment(@IdRes int containerId, Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerId, fragment);
        fragmentTransaction.commit();
    }
}
