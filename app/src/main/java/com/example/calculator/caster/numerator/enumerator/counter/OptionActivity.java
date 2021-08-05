package com.example.calculator.caster.numerator.enumerator.counter;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class OptionActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        initView();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radio_button_light_theme:

                break;
            case R.id.radio_button_night_theme:

                break;
            default:
                break;
        }
    }

    private void initView(){
        RadioButton radioButtonLightTheme = findViewById(R.id.radio_button_light_theme);
        RadioButton radioButtonNightTheme = findViewById(R.id.radio_button_night_theme);

        radioButtonLightTheme.setOnClickListener(this);
        radioButtonNightTheme.setOnClickListener(this);
    }
}