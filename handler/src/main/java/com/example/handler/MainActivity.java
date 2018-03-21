package com.example.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static private int MSG_MAIN_TO_WORK = 1;
    final static private int MSG_WORK_TO_MAIN = 2;
    private Handler mHandler;
    private Handler wHandler;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.et);
        textView = findViewById(R.id.tv);
        //一直运行
        new WorkThread().start();

        mHandler = new MainHandler();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                Long n = Long.parseLong(str);
                Log.e("点击按钮","发送数据"+n);
                Message message = wHandler.obtainMessage(MSG_MAIN_TO_WORK,n);
                wHandler.sendMessage(message);
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
    class WorkThread extends Thread{

        public WorkThread(){
            setName("work_thread");
        }
        @Override
        public void run() {
            Looper.prepare();
            wHandler = new WorkHandler();
            Looper.loop();
        }
    }
    private class WorkHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_MAIN_TO_WORK:
                    Long n = ((Long)msg.obj);
                    Log.e("workHandler","收到的数据："+n.toString()+
                        "当前线程："+Thread.currentThread().getName());
                    Log.e("workHandler","开始计算第"+n.toString()+"项斐波那契数");
                    Long rtn = fib(n);
                    Log.e("workHandler","计算完成，开始发送数据："+rtn.toString()+"当前线程："+
                            Thread.currentThread().getName());
                    Message message = mHandler.obtainMessage(MSG_WORK_TO_MAIN,rtn);
                    mHandler.sendMessage(message);
                    break;
            }
        }
    }

    private class MainHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MSG_WORK_TO_MAIN:
                    textView.setText(((Long)msg.obj).toString());
            }
        }
    }
}
