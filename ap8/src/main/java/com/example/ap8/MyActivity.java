package com.example.ap8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

/**
 * Created by 王伟健 on 2018-03-21.
 */

public class MyActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.my_activity);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
    }
}
