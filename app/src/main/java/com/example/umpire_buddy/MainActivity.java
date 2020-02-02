package com.example.umpire_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer strikeCounter = 0;
    Integer ballCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton exitButton = findViewById(R.id.exit);
        final Button clearButton = findViewById(R.id.clear);

        final Button strikeButton = findViewById(R.id.strike_button);
        final Button ballButton = findViewById(R.id.ball_button);

        final TextView strikeCountView = findViewById(R.id.strike_count);
        final TextView ballCountView = findViewById(R.id.ball_count);

        strikeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                strikeCounter++;
                strikeCountView.setText(String.valueOf(strikeCounter));
            }
        });

        ballButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ballCounter++;
                ballCountView.setText(String.valueOf(ballCounter));
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ballCounter = 0;
                strikeCounter = 0;
                ballCountView.setText(String.valueOf(ballCounter));
                strikeCountView.setText(String.valueOf(strikeCounter));
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }


}
