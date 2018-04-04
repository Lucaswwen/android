package com.example.file;

import android.content.SharedPreferences;
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

        Button baocun = findViewById(R.id.baocun);
        Button duqu = findViewById(R.id.duqu);

        baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("myPre",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name","yanzu");
                editor.putString("id","00000");
                editor.putInt("age",18);
                editor.commit();
            }
        });
        duqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("myPre",MODE_PRIVATE);
                String name = preferences.getString("name","-1");
                String id = preferences.getString("id","-1");
                int age = preferences.getInt("age",-1);
                Log.e("message",name+"\t"+id+"\t"+age);
            }
        });
    }
}
