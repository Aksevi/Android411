package com.example.x_games_hw;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultSource extends Dialog { // делаем не новым окном а диалоговым то есть меняем текст после extends на Dialog

  private final String message;
  private final Easy_Level easyLevel;


    public ResultSource(@NonNull Context context, String message, Easy_Level easyLevel) {
        super(context);
        this.message = message;
        this.easyLevel = easyLevel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result_source);

        TextView messageText = findViewById(R.id.messageText);
        Button  startAgainButton = findViewById(R.id.restartButton);

        messageText.setText(message);

        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                easyLevel.restartMatch(); // вызов метода перезапуска из PlayingField
                dismiss(); // закрытие окна
            }
        });


    }
}