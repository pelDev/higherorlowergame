package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int mN;
    private EditText mGuessNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNumber();

        mGuessNumberEditText = findViewById(R.id.editTextNumber_guessNumber);
        Button guessButton = findViewById(R.id.button_guess);

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

    }

    private void checkGuess() {
        int userGuess = Integer.parseInt(mGuessNumberEditText.getText().toString());

        if (userGuess > mN) {
            showToast("Lower!");
        } else  if (userGuess < mN) {
            showToast("Higher!");
        } else {
            showToast("That is Correct! Try again!");
            generateNumber();
        }
    }

    private void generateNumber() {
        Random random = new Random();
        mN = random.nextInt(20) + 1;
    }

    private void showToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}