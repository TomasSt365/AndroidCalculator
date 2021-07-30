package com.example.calculator.caster.numerator.enumerator.counter;

public class Data {
    private long data = 0;
    private long factor = 1;

    public Data(){
    }

    public void addData(int buttonNumber){
        data += buttonNumber*factor;
        factor *= 10;
    }


}
