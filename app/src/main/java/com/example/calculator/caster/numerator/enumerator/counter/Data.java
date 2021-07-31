package com.example.calculator.caster.numerator.enumerator.counter;

public class Data {
    private final char PlUS = '+';
    private final char MINUS = '-';
    private final char MULTIPLY = '*';
    private final char DIVIDE = '/';
    private final char PERCENT = '%';
    private char operator;
    private double basicData;
    private double memoryCell;

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
                memoryCell = 0;
                break;
            case MINUS:
                break;
            case MULTIPLY:
                break;
            case DIVIDE:
                break;
            case PERCENT:
                break;
            default:
                break;
        }
        return basicData;
    }

}
