package com.example.calculator.caster.numerator.enumerator.counter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTextView;
    private String resultText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultText);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);
        Button button_plus = findViewById(R.id.button_plus);
        Button button_minus = findViewById(R.id.button_minus);
        Button button_multiply = findViewById(R.id.button_multiply);
        Button button_divide = findViewById(R.id.button_divide);
        Button button_percent = findViewById(R.id.button_percent);
        Button button_delete_symbol = findViewById(R.id.button_delete_symbol);
        Button button_all_clear = findViewById(R.id.button_all_clear);
        Button button_comma = findViewById(R.id.button_comma);
        Button button_equals = findViewById(R.id.button_equals);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);

        button_plus.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_percent.setOnClickListener(this);
        button_delete_symbol.setOnClickListener(this);
        button_all_clear.setOnClickListener(this);
        button_comma.setOnClickListener(this);
        button_equals.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        final int BUTTON1_NUMBER = 1;
        final int BUTTON2_NUMBER = 2;
        final int BUTTON3_NUMBER = 3;
        final int BUTTON4_NUMBER = 4;
        final int BUTTON5_NUMBER = 5;
        final int BUTTON6_NUMBER = 6;
        final int BUTTON7_NUMBER = 7;
        final int BUTTON8_NUMBER = 8;
        final int BUTTON9_NUMBER = 9;
        final int BUTTON0_NUMBER = 0;
        switch (v.getId()){
            case R.id.button1:
                onNumberButtonClick(BUTTON1_NUMBER);
                break;
            case R.id.button2:
                onNumberButtonClick(BUTTON2_NUMBER);
                break;
            case R.id.button3:
                onNumberButtonClick(BUTTON3_NUMBER);
                break;
            case R.id.button4:
                onNumberButtonClick(BUTTON4_NUMBER);
                break;
            case R.id.button5:
                onNumberButtonClick(BUTTON5_NUMBER);
                break;
            case R.id.button6:
                onNumberButtonClick(BUTTON6_NUMBER);
                break;
            case R.id.button7:
                onNumberButtonClick(BUTTON7_NUMBER);
                break;
            case R.id.button8:
                onNumberButtonClick(BUTTON8_NUMBER);
                break;
            case R.id.button9:
                onNumberButtonClick(BUTTON9_NUMBER);
                break;
            case R.id.button0:
                onNumberButtonClick(BUTTON0_NUMBER);
                break;

            case R.id.button_plus:
            case R.id.button_minus:
            case R.id.button_multiply:
            case R.id.button_divide:
            case R.id.button_percent:
            case R.id.button_delete_symbol:
            case R.id.button_all_clear:
            case R.id.button_comma:
            case R.id.button_equals:

            default:
                break;
        }
    }

    private void onNumberButtonClick(int buttonNumber) {
        resultText += String.valueOf(buttonNumber);
        resultTextView.setText(resultText);
    }

}