package com.example.calculator.caster.numerator.enumerator.counter;

import android.widget.TextView;

public class Data {
    private final char PlUS = '+';
    private final char MINUS = '-';
    private final char MULTIPLY = 'X';
    private final char DIVIDE = '/';
    private final char PERCENT = '%';
    private char operator;
    private double basicData;
    private double memoryCell;
    private TextView errorTextView;

    public Data() {
        basicData = 0;
        memoryCell = 0;
    }

    public void addData(String resultText) {
        basicData = Double.parseDouble(resultText);
    }

    public void clearAll(){
        basicData = 0;
        memoryCell = 0;
    }

    public void operation(char operator){
        this.operator = operator;
        memoryCell = basicData;
        basicData = 0;
    }

    public double equals(){
        switch (operator){
            case PlUS:
                basicData += memoryCell;
                break;
            case MINUS:
                basicData = memoryCell - basicData;
                break;
            case MULTIPLY:
                basicData *= memoryCell;
                break;
            case DIVIDE:
                basicData = memoryCell / basicData  ;
                break;
            case PERCENT:
                break;
            default:
                break;
        }
        memoryCell = 0;
        return basicData;
    }

}
