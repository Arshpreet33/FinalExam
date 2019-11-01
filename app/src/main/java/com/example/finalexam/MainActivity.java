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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister;
    EditText txtName, txtEmail, txtPassword;
    TextView lblLogin;

    Intent intent;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        btnRegister = findViewById(R.id.btnRegister);
        txtName = findViewById(R.id.txtRegisterName);
        txtEmail = findViewById(R.id.txtRegisterEmail);
        txtPassword = findViewById(R.id.txtRegisterPassword);
        lblLogin = findViewById(R.id.lblLogin);

        btnRegister.setOnClickListener(this);
        lblLogin.setOnClickListener(this);

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                btnRegisterClick();
                break;
            case R.id.lblLogin:
                lblLoginClick();
                break;
            default:
                break;
        }
    }

    private void btnRegisterClick() {
        SaveDataInFile();
        GoToLoginPage();
    }

    private void lblLoginClick() {
        GoToLoginPage();
    }

    private void GoToLoginPage() {
        startActivity(MyVariables.MAD313Geeks(MainActivity.this, Main2Activity.class));
    }

    private void SaveDataInFile() {
        editor = sp.edit();
        editor.putString(MyVariables.registerEmail, txtEmail.getText().toString().trim());
        editor.putString(MyVariables.registerName, txtName.getText().toString().trim());
        editor.putString(MyVariables.registerPassword, txtPassword.getText().toString().trim());
        editor.apply();
    }
}
