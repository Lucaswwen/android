package com.example.anr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.et);
        final TextView textView = findViewById(R.id.tv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String str = editText.getText().toString();
                        long rtn = fib(Long.parseLong(str));
                        textView.setText(rtn+"");
                        Log.e("anr", "run: "+rtn+"当前线程名称"+Thread.currentThread().getName()+"");
                    }
                });
                thread.start();
            }
        });
    }

    private long fib(long n){
        if (1==n||2==n){
            return 1l;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }

}
