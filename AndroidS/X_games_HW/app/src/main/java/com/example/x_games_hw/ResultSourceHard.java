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

public class ResultSourceHard extends Dialog {

    private final String message;
    private final Hard_Level hardLevel;

    public ResultSourceHard(@NonNull Context context, String message, Hard_Level hardLevel) {
        super(context);
        this.message = message;
        this.hardLevel = hardLevel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result_source_hard);

        TextView messageText = findViewById(R.id.messageText);
        Button startAgainButton = findViewById(R.id.restartButton);

        messageText.setText(message);

        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hardLevel.restartMatch(); // вызов метода перезапуска из PlayingField
                dismiss(); // закрытие окна
            }
        });


    }
}
