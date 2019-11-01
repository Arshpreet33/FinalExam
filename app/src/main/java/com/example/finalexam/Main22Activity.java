package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main22Activity extends AppCompatActivity implements View.OnClickListener, SensorEventListener {

    Button btn1, btn2, btn3, btn4, btnSignOut, btnInfo;
    TextView txtScore;

    private SensorManager sm;

    int score = 0, highScore = 0;

    Intent intent;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout6);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btnSignOut = findViewById(R.id.btnSignOut);
        btnInfo = findViewById(R.id.btnInfo);
        txtScore = findViewById(R.id.txtScore);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnSignOut.setOnClickListener(this);

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        highScore = sp.getInt(MyVariables.highScoreKey, MyVariables.highScoreKeyDefault);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                btn1Click();
                break;
            case R.id.btn2:
                btn2Click();
                break;
            case R.id.btn3:
                btn3Click();
                break;
            case R.id.btn4:
                btn4Click();
            case R.id.btnSignOut:
                btnSignOutClick();
                break;
            case R.id.btnInfo:
                btnInfoClick();
                break;
            default:
                break;
        }
    }

    private void btn1Click() {

        score++;
        updateScore();
    }

    private void btn2Click() {

        score = score + 10;
        updateScore();
    }

    private void btn3Click() {

        score = score + 100;
        updateScore();
    }

    private void btn4Click() {
        editor = sp.edit();
        editor.putInt(MyVariables.highScoreKey, 0);
        editor.apply();
    }

    private void updateScore() {

        txtScore.setText(Integer.toString(score));
        saveHighScore();
    }

    private void saveHighScore() {

        if (score > highScore) {
            highScore = score;
            editor = sp.edit();
            editor.putInt(MyVariables.highScoreKey, highScore);
            editor.apply();
        }
    }

    public void onSensorChanged(SensorEvent event) {

        if ((event.sensor.getType() == Sensor.TYPE_ACCELEROMETER))
        {
            getSensor(event);
        }
    }

    private void getSensor(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accSqrt = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

        if (accSqrt >= 40) {
            score = score + 5;
            updateScore();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    private void btnSignOutClick() {
        startActivity(MyVariables.MAD313Geeks(Main22Activity.this, Main2Activity.class));
    }

    private void btnInfoClick() {
        startActivity(MyVariables.MAD313Geeks(Main22Activity.this, Main3Activity.class));
    }

}
