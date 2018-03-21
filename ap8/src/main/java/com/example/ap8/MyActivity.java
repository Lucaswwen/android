package com.example.ap8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 王伟健 on 2018-03-21.
 */

public class MyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);

        Intent intent = getIntent();
        String strMsg = intent.getStringExtra("msg");

        TextView tvMsg = findViewById(R.id.msg);

        tvMsg.setText(strMsg);
        Button btn = findViewById(R.id.fanhui);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRtn = new Intent();
                intentRtn.putExtra("return","返回");
                setResult(RESULT_OK,intentRtn);//负责设置result
                finish();//这个才是负责关闭当前activity
            }
        });
    }
}
