package com.lixin.diskmonitor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class LocalStorage {

    private SharedPreferences p;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    public LocalStorage(Context context, String name){
        p = context.getSharedPreferences("app", MODE_PRIVATE);
        editor = p.edit();
    }

    public void putStr(String key, String val){
        editor.putString(key, val);
        editor.apply();
    }

    public String getStr(String key, String def){
        return p.getString(key, def);
    }

    public void putInt(String key, int val){
        editor.putInt(key, val);
        editor.apply();
    }

    public int getInt(String key, int def){
        return p.getInt(key, def);
    }

    public void putLong(String key, long val){
        editor.putLong(key, val);
        editor.apply();
    }

    public long getLong(String key, long def){
        return p.getLong(key, def);
    }

    public void putFloat(String key, float val){
        editor.putFloat(key, val);
        editor.apply();
    }

    public float getFloat(String key, float def){
        return p.getFloat(key, def);
    }

    public void putBool(String key, Boolean val){
        editor.putBoolean(key, val);
        editor.apply();
    }

    public Boolean getBool(String key, Boolean def){
        return p.getBoolean(key, def);
    }

    public void clear(){
        editor.clear();
        editor.apply();
    }
}