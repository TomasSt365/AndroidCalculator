package com.example.calculator.caster.numerator.enumerator.counter;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
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
    private final String PlUS = "+";
    private final String MINUS = "-";
    private final String MULTIPLY = "X";
    private final String DIVIDE = "÷";
    private final String PERCENT = "%";
    private final int LIMIT_SYMBOLS = 12;
    private final byte TRUE = 1;
    private final byte FALSE = 0;

    private int numberOfEnteredSymbols;
    private double basicData;
    private double memoryCell;
    private String operator;
    private String resultText;
    private String memoryCellText;
    private byte isCommaNotEntered;
    private byte isZeroFirst;
    private byte isOperatorNotEntered;

    public Data(){
        numberOfEnteredSymbols = 0;
        resultText = "0";
        memoryCellText = " ";
        isCommaNotEntered = TRUE;
        isZeroFirst = TRUE;
        isOperatorNotEntered = TRUE;
    }


    protected Data(Parcel in) {
        numberOfEnteredSymbols = in.readInt();
        basicData = in.readDouble();
        memoryCell = in.readDouble();
        operator = in.readString();
        resultText = in.readString();
        memoryCellText = in.readString();
        isCommaNotEntered = in.readByte();
        isZeroFirst = in.readByte();
        isOperatorNotEntered = in.readByte();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public int getNumberOfEnteredSymbols() {
        return numberOfEnteredSymbols;
    }

    public String  getOperator() {
        return operator;
    }

    public double getBasicData() {
        return basicData;
    }

    public double getMemoryCell() {
        return memoryCell;
    }

    public String getResultText() {
        return resultText;
    }

    public String getMemoryCellText() {
        return memoryCellText;
    }

    public byte getIsCommaNotEntered() {
        return isCommaNotEntered;
    }

    public byte getIsZeroFirst() {
        return isZeroFirst;
    }

    public byte getIsOperatorNotEntered() {
        return isOperatorNotEntered;
    }

    public char getBUTTON1_NUMBER() {
        return BUTTON1_NUMBER;
    }

    public char getBUTTON2_NUMBER() {
        return BUTTON2_NUMBER;
    }

    public char getBUTTON3_NUMBER() {
        return BUTTON3_NUMBER;
    }

    public char getBUTTON4_NUMBER() {
        return BUTTON4_NUMBER;
    }

    public char getBUTTON5_NUMBER() {
        return BUTTON5_NUMBER;
    }

    public char getBUTTON6_NUMBER() {
        return BUTTON6_NUMBER;
    }

    public char getBUTTON7_NUMBER() {
        return BUTTON7_NUMBER;
    }

    public char getBUTTON8_NUMBER() {
        return BUTTON8_NUMBER;
    }

    public char getBUTTON9_NUMBER() {
        return BUTTON9_NUMBER;
    }

    public char getBUTTON0_NUMBER() {
        return BUTTON0_NUMBER;
    }

    public char getCOMMA() {
        return COMMA;
    }

    public String getPlUS() {
        return PlUS;
    }

    public String getMINUS() {
        return MINUS;
    }

    public String getMULTIPLY() {
        return MULTIPLY;
    }

    public String getDIVIDE() {
        return DIVIDE;
    }

    public String getPERCENT() {
        return PERCENT;
    }

    public int getLIMIT_SYMBOLS() {
        return LIMIT_SYMBOLS;
    }

    public byte getTRUE() {
        return TRUE;
    }

    public byte getFALSE() {
        return FALSE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numberOfEnteredSymbols);
        dest.writeDouble(basicData);
        dest.writeDouble(memoryCell);
        dest.writeString(operator);
        dest.writeString(resultText);
        dest.writeString(memoryCellText);
        dest.writeByte(isCommaNotEntered);
        dest.writeByte(isZeroFirst);
        dest.writeByte(isOperatorNotEntered);
    }

    public void onSymbolButtonClick(char symbol) {
        switch (symbol) {
            case COMMA:
                if (isCommaNotEntered == TRUE) {
                    isCommaNotEntered = FALSE;
                    isZeroFirst = FALSE;
                    saveAndPrintSymbol(symbol);
                }
                break;

            case BUTTON0_NUMBER:
                if (isZeroFirst == FALSE) {
                    saveAndPrintSymbol(symbol);
                }
                break;

            default:
                if (isZeroFirst == TRUE) {
                    resultText = "";
                    isZeroFirst = FALSE;
                }
                saveAndPrintSymbol(symbol);
                break;
        }
    }

    public void onOperatorButtonClick(String operator){
        if(isOperatorNotEntered == TRUE){
            isCommaNotEntered = TRUE;
            isZeroFirst = FALSE;
            isOperatorNotEntered = FALSE;
            this.operator = operator;
            memoryCell = basicData;
            basicData = 0;
            numberOfEnteredSymbols = 0;
            memoryCellText = resultText + " " + operator + " ";
            resultText = "";
        }
    }

    private void saveAndPrintSymbol(char symbol) {
        if(LIMIT_SYMBOLS != numberOfEnteredSymbols){
            resultText += symbol;
            basicData = Double.parseDouble(resultText);
            numberOfEnteredSymbols++;
        }
    }

    public void reset(){
        basicData = 0;
        memoryCell = 0;
        numberOfEnteredSymbols = 0;
        resultText = "0";
        memoryCellText = " ";
        isZeroFirst = TRUE;
        isCommaNotEntered = TRUE;
        isOperatorNotEntered = TRUE;
        basicData = Double.parseDouble(resultText);
    }

    public double calculationResult(){
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

    public void equals() {
        resultText = String.valueOf(calculationResult());
        memoryCellText = " ";
        isOperatorNotEntered = TRUE;
        isCommaNotEntered = FALSE;
    }
}
