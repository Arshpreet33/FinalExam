package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

    Button btnUpdate;
    EditText txtInfoName;

    Intent intent;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout4);

        btnUpdate = findViewById(R.id.btnUpdateName);
        txtInfoName = findViewById(R.id.txtInfoName);

        btnUpdate.setOnClickListener(this);

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);

        txtInfoName.setText(sp.getString(MyVariables.registerName, MyVariables.registerNameDefault));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdateName:
                btnUpdateClick();
                break;
            default:
                break;
        }
    }

    private void btnUpdateClick() {
        editor = sp.edit();
        editor.putString(MyVariables.registerName, txtInfoName.getText().toString());
        editor.apply();

        startActivity(MyVariables.MAD313Geeks(Main4Activity.this, Main3Activity.class));
    }
}
