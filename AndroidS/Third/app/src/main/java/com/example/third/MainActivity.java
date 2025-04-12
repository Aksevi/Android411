package com.example.third;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

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

// работаем с ToggleButton

        ToggleButton toggleButton = findViewById(R.id.toggleButton); // доступ к ToggleButton
        Button changeColor = findViewById(R.id.changeColor); // доступ к кнопке

        toggleButton.setOnClickListener(new View.OnClickListener() { // жмем на нее
            @Override
            public void onClick(View v) {

                if (toggleButton.isChecked()){ // если ToggleButton нажата (.isChecked)

                    changeColor.setBackgroundColor(Color.GREEN); // можно и через parseColor можно и так
                    toggleButton.setBackgroundColor(Color.RED); // можно и через parseColor можно и так
                }
                else {
                    changeColor.setBackgroundColor(Color.RED); // можно и через parseColor можно и так
                    toggleButton.setBackgroundColor(Color.GREEN); // можно и через parseColor можно и так
                }

            }
        });

        Switch mySwitch = findViewById(R.id.switch1);

       mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

               if (isChecked){
                   mySwitch.setTextColor(Color.parseColor("#FF6F00"));
               }
               else {
                   mySwitch.setTextColor(Color.BLACK);
               }
           }
       });

        ConstraintLayout constraintLayout = findViewById(R.id.main);
        SwitchMaterial switchMaterial = findViewById(R.id.switchMaterial);

        switchMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchMaterial.isChecked()){
                    switchMaterial.setThumbDrawable(getDrawable(R.drawable.baseline_add_reaction_24));
                    switchMaterial.setText("Turn on Night mode");
                    constraintLayout.setBackgroundResource(R.color.bg);
                    switchMaterial.setThumbTintList(ColorStateList.valueOf(Color.BLUE));
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#004CFF")));

                }
                else { switchMaterial.setThumbDrawable(getDrawable(R.drawable.baseline_wb_sunny_24));
                    switchMaterial.setText("Turn on Day mode");
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#FF6F00")));
                    constraintLayout.setBackgroundResource(R.color.yellow);
                }
            }
        });

        CheckBox boldCheckBox = findViewById(R.id.boldCheckBox);
        CheckBox italicCheckBox = findViewById(R.id.italicCheckBox);
        TextView sampleText = findViewById(R.id.sampleText);

        boldCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    if (italicCheckBox.isChecked()) {
                        sampleText.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else {
                        sampleText.setTypeface(null, Typeface.BOLD);
                    }
                } else {
                    if (italicCheckBox.isChecked()) {
                        sampleText.setTypeface(null, Typeface.ITALIC);
                    } else {
                        sampleText.setTypeface(null, Typeface.NORMAL);
                    }
                }
            }
        });

        italicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    if (boldCheckBox.isChecked()) {
                        sampleText.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else {
                        sampleText.setTypeface(null, Typeface.ITALIC);
                    }
                } else {
                    if (boldCheckBox.isChecked()){
                        sampleText.setTypeface(null, Typeface.BOLD);
                } else {
                    sampleText.setTypeface(null, Typeface.NORMAL);
                }
                }
            }
        });


    }
}