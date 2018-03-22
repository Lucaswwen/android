package com.example.ap10;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_3= findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("laizidongbei");
                startActivity(intent);
            }
        });



        Button btn_2 = findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.ap9",
                        "com.example.ap9.MainActivity");
                startActivity(intent);
            }
        });

        //打开内部activity
        Button btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent();
                ComponentName cn = new ComponentName(MainActivity.this,Activity_1.class);
                intent.setComponent(cn);
                startActivity(intent);

                cn = intent.getComponent();
                Log.e("Intent",cn.getClassName());
                Log.e("Intent",cn.getPackageName());


//                Intent intent = new Intent(MainActivity.this,Activity_1.class);
//                startActivity(intent);


//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this,Activity_1.class);
//                startActivity(intent);
            }
        });
    }
}
