package com.example.finalexam;

import android.content.Context;
import android.content.Intent;

public class MyVariables {

    public static final String cacheFile = "cacheRegisterFile";

    public static final String registerName = "keyRegisterName";
    public static final String registerNameDefault = "";

    public static final String registerEmail = "keyRegisterEmail";
    public static final String registerEmailDefault = "";

    public static final String registerPassword = "keyRegisterPassword";
    public static final String registerPasswordDefault = "";

    public static final String highScoreKey = "keyHighScore";
    public static final int highScoreKeyDefault = 0;

    //Our New Secret.
    public static Intent MAD313Geeks(Context packageContext, Class<?> cls) {
        return new Intent(packageContext, cls);
    }

}
