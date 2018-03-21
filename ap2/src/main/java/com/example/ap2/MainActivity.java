package com.example.ap2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText username;

    public static int USERNAME_ISWRITE = 0;
    public static int PASSWORD_ISWRITE = 0;
    public static int SEX_ISCHECK      = 0;
    public static int HOBBY_ISCKECK    = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setText("Cancel");

        //初试化爱好列表
        final List<CheckBox> list = new ArrayList<>();
        CheckBox musicbox = findViewById(R.id.music);
        CheckBox readbox  = findViewById(R.id.read);
        CheckBox sportbox = findViewById(R.id.sport);
        CheckBox gamebox  = findViewById(R.id.game);
        list.add(musicbox);
        list.add(readbox);
        list.add(sportbox);
        list.add(gamebox);

        Button btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户名
                EditText editText = findViewById(R.id.username);
                String username = editText.getText().toString();
                //获取密码
                EditText psText = findViewById(R.id.password);
                String password = psText.getText().toString();
                //获取性别
                RadioGroup rg = findViewById(R.id.sex);
                RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
                String sex = rb.getText().toString();
                //获取爱好
                String hobby = "";
                for(CheckBox ck:list){
                   if(ck.isChecked()) {
                       hobby += ck.getText().toString() + "\t";
                   }
                }
                Log.e("info",username+"\t"+password+"\t"+sex+"\t"+hobby);
            }
        });

        username  = findViewById(R.id.username);
        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String username = MainActivity.this.username.getText().toString();
                //失去焦点
                if(!hasFocus){
                    if(username.equals("")){
                        Log.e("username","无值!");
                        MainActivity.this.username.setBackgroundColor(Color.argb(60, 255, 0, 0));
                        MainActivity.this.username.setHint("渣渣,你好像忘了点儿什么");
                        MainActivity.USERNAME_ISWRITE = 0;
                    }else{
                        Log.e("username",username);
                        MainActivity.this.username.setBackgroundColor(Color.argb(0, 255, 255, 255));
                        MainActivity.USERNAME_ISWRITE = 1;
                    }
                }
            }
        });
    }
}
