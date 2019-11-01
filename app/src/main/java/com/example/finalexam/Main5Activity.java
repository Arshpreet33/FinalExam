package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener {

    Button btnUpdate;
    EditText txtInfoEmail;

    Intent intent;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout5);

        btnUpdate = findViewById(R.id.btnUpdateEmail);
        txtInfoEmail = findViewById(R.id.txtInfoEmail);

        btnUpdate.setOnClickListener(this);

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);

        txtInfoEmail.setText(sp.getString(MyVariables.registerEmail, MyVariables.registerEmailDefault));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdateEmail:
                btnUpdateClick();
                break;
            default:
                break;
        }
    }

    private void btnUpdateClick() {
        editor = sp.edit();
        editor.putString(MyVariables.registerEmail, txtInfoEmail.getText().toString());
        editor.apply();

        startActivity(MyVariables.MAD313Geeks(Main5Activity.this, Main3Activity.class));
    }
}
