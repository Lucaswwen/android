package com.example.ap9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 王伟健 on 2018-03-21.
 */

public class ItemDetailActivity extends Activity{

    TextView tvname;
    TextView tvnickname;
    int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_activity);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String nickname = intent.getStringExtra("nickname");
        id = intent.getIntExtra("id",0);

        tvname = findViewById(R.id.name);
        tvnickname = findViewById(R.id.nickname);

        tvname.setText(name);
        tvnickname.setText(nickname);


        Button cancel = findViewById(R.id.cancel);
        Button queding = findViewById(R.id.quding);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namenew = tvname.getText().toString();
                String nicknamenew = tvnickname.getText().toString();
                Intent intentRtn = new Intent();
                intentRtn.putExtra("id",id);
                intentRtn.putExtra("name",namenew);
                intentRtn.putExtra("nickname",nicknamenew);
                setResult(RESULT_OK,intentRtn);//负责设置result
                finish();//这个才是负责关闭当前activity
            }
        });
    }
}
