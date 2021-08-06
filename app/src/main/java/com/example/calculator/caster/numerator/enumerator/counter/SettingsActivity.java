package com.example.calculator.caster.numerator.enumerator.counter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.RadioButton;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY_SP = "SP";
    private static final String KEY_NIGHT_MODE = "Night Mode";
    private final static String KEY = "Data";

    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        data = new Data();

        applyNightModeDependingOnSettings();
        initView();

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radio_button_light_theme:
                setNightModeValue(AppCompatDelegate.MODE_NIGHT_NO);
                restartActivity();
                break;
            case R.id.radio_button_night_theme:
                setNightModeValue(AppCompatDelegate.MODE_NIGHT_YES);
                restartActivity();
                break;
            default:
                break;
        }
    }

    private void initView() {
        RadioButton radioButtonLightTheme = findViewById(R.id.radio_button_light_theme);
        RadioButton radioButtonNightTheme = findViewById(R.id.radio_button_night_theme);

        radioButtonLightTheme.setOnClickListener(this);
        radioButtonNightTheme.setOnClickListener(this);

        switch (getNightModeValue()) {
            case AppCompatDelegate.MODE_NIGHT_NO:
                radioButtonLightTheme.setChecked(true);
                break;
            case AppCompatDelegate.MODE_NIGHT_YES:
                radioButtonNightTheme.setChecked(true);
                break;
            default:
                break;
        }
    }

    private void restartActivity() {
        Intent SettingsActivityIntent = new Intent(SettingsActivity.this, this.getClass());
        this.startActivity(SettingsActivityIntent);
        finish();
    }

    private void setNightModeValue(int nightModeCode) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_NIGHT_MODE, nightModeCode);
        editor.apply();
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
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(SettingsActivity.this, MainActivity.class);
        startActivity(i);
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

    }
}