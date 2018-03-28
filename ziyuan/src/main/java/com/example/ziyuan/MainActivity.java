package com.example.ziyuan;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.my_theme);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        String[] userName = res.getStringArray(R.array.user_name);
        for(String str:userName){
            Log.e("username", str);
        }
    }
}
