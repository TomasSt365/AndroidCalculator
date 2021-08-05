package com.example.calculator.caster.numerator.enumerator.counter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

public class OptionActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int LIGHT_MODE = 0;
    private static final int NIGHT_MODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        initView();
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radio_button_light_theme:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                restartActivity();
                break;
            case R.id.radio_button_night_theme:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                restartActivity();
                break;
            default:
                break;
        }
    }

    private void initView() {
        (findViewById(R.id.radio_button_light_theme)).setOnClickListener(this);
        (findViewById(R.id.radio_button_night_theme)).setOnClickListener(this);
    }

    private void restartActivity(){
        Intent i = new Intent(OptionActivity.this, this.getClass());
        finish();
        this.startActivity(i);
    }

}