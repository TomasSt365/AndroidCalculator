package com.example.calculator.caster.numerator.enumerator.counter;

public class Data {
    private double basicData;

    public Data() {
        basicData = 0;
    }

    public void addData(String resultText) {
        basicData = Double.parseDouble(resultText);
    }

    public void clearAll(){
        basicData = 0;
    }

    public double equals(){
        return basicData;
    }

}
