package com.example.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        progressBar = findViewById(R.id.pb);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开启异步任务
                MyDownLoadTask task = new MyDownLoadTask();
                task.execute();
            }
        });
    }

    private class MyDownLoadTask extends AsyncTask<Integer,Integer,Integer>{

        //1、执行异步任务之前调用（主线程调用）
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.e("AsynTask","onPreExecute()开始下载,当前线程"+
                    Thread.currentThread().getName());
            textView.setText("开始下载...");
        }


        //2、preExecute执行之后调用（主线程调用）
        @Override
        protected Integer doInBackground(Integer... integers) {
            for (int i=0;i<=100;i++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("AsynTask","onPreExecute()已下载"+i+"%,当前线程"+
                        Thread.currentThread().getName());
                publishProgress(i);
            }
            return 0;
        }

        //3、doInBackground中调用publishprogress（）时调用（主线程调用）
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            for (Integer num:values){
                textView.setText("正在下载:["+num+"%]");
                progressBar.setProgress(num);
            }
        }

        //4、当doInbackground（）执行完成之后调用（主线程调用）
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.e("AsynTask","onPostExecute()下载已完成,当前线程"+
                    Thread.currentThread().getName());
            Toast.makeText(MainActivity.this,"下载完成",Toast.LENGTH_SHORT).show();
        }
    }
}
