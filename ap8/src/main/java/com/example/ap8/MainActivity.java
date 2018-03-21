package com.example.ap8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.tiaozhuan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送请求
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MyActivity.class);
                //放入数据
                intent.putExtra("msg","今天天气不错");
                intent.putExtra("name","cerulean");
                intent.putExtra("age","20");
                //startActivity(intent);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == RESULT_OK){
            String strRtn = data.getStringExtra("return");
            Toast.makeText(this,strRtn,Toast.LENGTH_LONG).show();
        }
    }
}
