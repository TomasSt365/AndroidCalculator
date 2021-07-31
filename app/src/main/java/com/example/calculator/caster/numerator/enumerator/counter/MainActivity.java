package com.example.calculator.caster.numerator.enumerator.counter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.zip.ZipEntry;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultTextView;
    private String resultText = "0";
    private final char BUTTON1_NUMBER = '1';
    private final char BUTTON2_NUMBER = '2';
    private final char BUTTON3_NUMBER = '3';
    private final char BUTTON4_NUMBER = '4';
    private final char BUTTON5_NUMBER = '5';
    private final char BUTTON6_NUMBER = '6';
    private final char BUTTON7_NUMBER = '7';
    private final char BUTTON8_NUMBER = '8';
    private final char BUTTON9_NUMBER = '9';
    private final char BUTTON0_NUMBER = '0';
    private final char COMMA = '.';
    private boolean isCommaNotEntered = true;
    private boolean isZeroFirst = true;
    private final Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultText);
        resultTextView.setText(resultText);

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

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                onSymbolButtonClick(BUTTON1_NUMBER);
                break;
            case R.id.button2:
                onSymbolButtonClick(BUTTON2_NUMBER);
                break;
            case R.id.button3:
                onSymbolButtonClick(BUTTON3_NUMBER);
                break;
            case R.id.button4:
                onSymbolButtonClick(BUTTON4_NUMBER);
                break;
            case R.id.button5:
                onSymbolButtonClick(BUTTON5_NUMBER);
                break;
            case R.id.button6:
                onSymbolButtonClick(BUTTON6_NUMBER);
                break;
            case R.id.button7:
                onSymbolButtonClick(BUTTON7_NUMBER);
                break;
            case R.id.button8:
                onSymbolButtonClick(BUTTON8_NUMBER);
                break;
            case R.id.button9:
                onSymbolButtonClick(BUTTON9_NUMBER);
                break;
            case R.id.button0:
                onSymbolButtonClick(BUTTON0_NUMBER);
                break;
            case R.id.button_comma:
                onSymbolButtonClick(COMMA);
                break;


            case R.id.button_plus:
                break;
            case R.id.button_minus:
                break;
            case R.id.button_multiply:
                break;
            case R.id.button_divide:
                break;
            case R.id.button_percent:
                break;
            case R.id.button_delete_symbol:
                resultText = removeLastChar(resultText);
                resultTextView.setText(resultText);
                break;
            case R.id.button_all_clear:
                data.clearAll();
                resultText = "0";
                isZeroFirst = true;
                isCommaNotEntered = true;
                resultTextView.setText(resultText);
                break;
            case R.id.button_equals:
                resultText = String.valueOf(data.equals());
                resultTextView.setText("= " + resultText);
            default:
                break;
        }
    }


    private void onSymbolButtonClick(char symbol) {
        switch (symbol) {
            case COMMA:
                if (isCommaNotEntered) {
                    isCommaNotEntered = false;
                    isZeroFirst = false;
                    saveAndPrintSymbol(symbol);
                }
                break;

            case BUTTON0_NUMBER:
                if(!isZeroFirst){
                    saveAndPrintSymbol(symbol);
                }
                break;

            default:
                if(isZeroFirst){
                    resultText = "";
                    isZeroFirst = false;
                }
                saveAndPrintSymbol(symbol);
                break;
        }

    }

    private void saveAndPrintSymbol(char symbol){
        resultText += symbol;
        resultTextView.setText(resultText);
        data.addData(resultText);
    }

    private String removeLastChar(String str) {
        if (str == null || str.length() == 0 || str.equals("0")) {
            return str;
        }
        return str.substring(0, str.length()-1);
    }
}