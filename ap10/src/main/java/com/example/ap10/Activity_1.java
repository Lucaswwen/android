package com.example.ap10;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by 王伟健 on 2018-03-22.
 */

public class Activity_1 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_1);
        TextView tv = findViewById(R.id.text);
        tv.setText("国民老公");
    }
}
