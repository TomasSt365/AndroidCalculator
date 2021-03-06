package com.example.calculator.caster.numerator.enumerator.counter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY_SP = "SP";
    private static final String KEY_NIGHT_MODE = "Night Mode";
    private final static String KEY = "Data";

    private TextView resultTextView;
    private TextView errorTextView;
    private static Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new Data();
        applyNightModeDependingOnSettings();
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                onSymbolButtonClick(data.getBUTTON1_NUMBER());
                break;
            case R.id.button2:
                onSymbolButtonClick(data.getBUTTON2_NUMBER());
                break;
            case R.id.button3:
                onSymbolButtonClick(data.getBUTTON3_NUMBER());
                break;
            case R.id.button4:
                onSymbolButtonClick(data.getBUTTON4_NUMBER());
                break;
            case R.id.button5:
                onSymbolButtonClick(data.getBUTTON5_NUMBER());
                break;
            case R.id.button6:
                onSymbolButtonClick(data.getBUTTON6_NUMBER());
                break;
            case R.id.button7:
                onSymbolButtonClick(data.getBUTTON7_NUMBER());
                break;
            case R.id.button8:
                onSymbolButtonClick(data.getBUTTON8_NUMBER());
                break;
            case R.id.button9:
                onSymbolButtonClick(data.getBUTTON9_NUMBER());
                break;
            case R.id.button0:
                onSymbolButtonClick(data.getBUTTON0_NUMBER());
                break;
            case R.id.button_comma:
                onSymbolButtonClick(data.getCOMMA());
                break;


            case R.id.button_plus:
                onOperatorButtonClick(data.getPlUS());
                break;
            case R.id.button_minus:
                onOperatorButtonClick(data.getMINUS());
                break;
            case R.id.button_multiply:
                onOperatorButtonClick(data.getMULTIPLY());
                break;
            case R.id.button_divide:
                onOperatorButtonClick(data.getDIVIDE());
                break;


            case R.id.button_percent:
                errorTextView.setText("???????????????? % ????????????????????!");
                break;
            case R.id.button_delete_symbol:
                errorTextView.setText("???????????????? DEL ????????????????????!");
                break;


            case R.id.button_all_clear:
                errorTextView.setText("");
                reset();
                break;
            case R.id.button_equals:
                errorTextView.setText("");
                if (data.getIsOperatorNotEntered() == data.getFALSE()) {
                    data.equals();
                }
                if (data.getResultText().equals("Infinity") || data.getResultText().equals("NaN")) {
                    errorTextView.setText("ERROR!");
                    reset();
                    break;
                }
                setResultText();
                break;

            case R.id.option_button:
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
                finish();
                break;
            default:
                break;
        }
    }

    private void onSymbolButtonClick(char symbol) {
        errorTextView.setText("");
        data.onSymbolButtonClick(symbol);
        setResultText();
    }

    private void onOperatorButtonClick(String operator) {
        errorTextView.setText("");
        if (data.getIsOperatorNotEntered() == data.getTRUE()) {
            data.onOperatorButtonClick(operator);
            setResultText();
        }
    }

    private void reset() {
        data.reset();
        setResultText();
    }

    private void initView() {
        resultTextView = findViewById(R.id.resultText);
        errorTextView = findViewById(R.id.errorText);
        resultTextView.setText(data.getResultText());

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
        Button option_button = findViewById(R.id.option_button);

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
        option_button.setOnClickListener(this);
    }

    private void setResultText() {
        if (data.getIsEqualsEntered() == data.getTRUE())
            resultTextView.setText(String.format("= %s", data.getResultText()));
        else {
            resultTextView.setText(String.format("%s%s", data.getMemoryCellText(), data.getResultText()));
        }
    }

    public void applyNightModeDependingOnSettings() {
        switch (getNightModeValue()) {
            case AppCompatDelegate.MODE_NIGHT_NO:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case AppCompatDelegate.MODE_NIGHT_YES:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            default:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
        }
    }

    private int getNightModeValue() {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_NIGHT_MODE, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY, data);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        data = savedInstanceState.getParcelable(KEY);
        setResultText();
    }

}