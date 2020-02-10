package com.example.umpire_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

        final ImageButton infoButton = findViewById(R.id.info);

        final Intent aboutIntent = new Intent(this, AboutActivity.class);

        final AlertDialog.Builder outDialog = new AlertDialog.Builder(this);
        outDialog.setTitle(R.string.out)
                .setMessage(R.string.alertMessage)
                .setCancelable(true)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                })
                .create();

        final AlertDialog.Builder walkDialog = new AlertDialog.Builder(this);
        walkDialog.setTitle(R.string.walk)
                .setMessage(R.string.alertMessage)
                .setCancelable(true)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                })
                .create();

        strikeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                strikeCounter++;
                strikeCountView.setText(String.valueOf(strikeCounter));
                if (strikeCounter >= 3) {
                    outDialog.show();
                    disableButtons(strikeButton, ballButton);
                }
            }
        });

        ballButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ballCounter++;
                ballCountView.setText(String.valueOf(ballCounter));
                if (ballCounter >= 4) {
                    walkDialog.show();
                    disableButtons(strikeButton, ballButton);
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clearCounter(strikeCountView, ballCountView);
                enableButtons(strikeButton, ballButton);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(0);
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(aboutIntent);
            }
        });
    }

    private void disableButtons(Button button1, Button button2){
        button1.setEnabled(false);
        button2.setEnabled(false);
    }

    private void enableButtons(Button button1, Button button2){
        button1.setEnabled(true);
        button2.setEnabled(true);
    }

    private void clearCounter(TextView strikeView, TextView ballView) {
        ballCounter = 0;
        strikeCounter = 0;
        strikeView.setText(String.valueOf(ballCounter));
        ballView.setText(String.valueOf(strikeCounter));
    }


}
