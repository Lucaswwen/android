package com.example.ap7;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private static Integer CLICK_NUM = 0;
//    private static Long FIRST_CLICK_TIME=0L;
    private long mCurTime=0l;
    Toast toast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertDialog1();
        alertDialog2();
        popWindow();
        toast();
        sendNotification();
    }

    private void sendNotification(){
        Button button = findViewById(R.id.btn_notification);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager =
                        (NotificationManager)getApplicationContext()
                        .getSystemService(Context.NOTIFICATION_SERVICE);
                Notification.Builder builder
                        = new Notification.Builder(getApplicationContext());
                builder.setContentTitle("这是一个神奇的通知");
                builder.setContentText("这里一切都很神奇");
                builder.setSmallIcon(R.drawable.h01);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.h02));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    builder.setChannelId("myChannel");
                }

                Notification noti = builder.build();
                manager.notify(0,noti);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel
                            = new NotificationChannel("myChannel","神奇的通知渠道",
                            NotificationManager.IMPORTANCE_DEFAULT);
                    manager.createNotificationChannel(notificationChannel);
                }
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder adBuilder
                = new AlertDialog.Builder(this);
        adBuilder.setTitle("提高\"我的位置\"精确度");
        View view = getLayoutInflater().inflate(R.layout.layout_alertdialog2,null);
        adBuilder.setView(view);
        adBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e("12","被点击");
            }
        });
        adBuilder.setNegativeButton("取消",null);
        return adBuilder.create();
    }

    private void alertDialog2(){
        Button button = findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });
    }
    private void popWindow(){
        Button button = findViewById(R.id.btn3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_popupwindow,null);
                PopupWindow window = new PopupWindow(view,600,600,true);
                window.showAsDropDown(v,0,0);
            }
        });
    }

    private void alertDialog1(){
        Button button = findViewById(R.id.quit_alertdialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adBuilder =
                        new AlertDialog.Builder(MainActivity.this);
                adBuilder.setTitle("温馨提示");
                adBuilder.setMessage("尊敬的您是否确认退出本程序呢？");
                adBuilder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();//最小化
                    }
                });
                adBuilder.setNegativeButton("取消",null);
                AlertDialog dialog = adBuilder.create();
                dialog.show();
            }
        });
    }
    private void toast(){
        Button button = findViewById(R.id.btn_toast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast toast = Toast.makeText(MainActivity.this,
//                        "请再次点击退出按钮",Toast.LENGTH_SHORT);
//                if (CLICK_NUM==0){
//                    FIRST_CLICK_TIME = System.currentTimeMillis();
//                    CLICK_NUM++;
//                    toast.show();
//                } else if(CLICK_NUM==1){
//                    CLICK_NUM=0;
//                    if (System.currentTimeMillis()-FIRST_CLICK_TIME<=2000){
//                        finish();
//                        toast.cancel();
//                    }else {
//                        //视为第一次点击
//                        onClick(v);
//                    }
//                }
                if (System.currentTimeMillis()-mCurTime>2000){
                    toast = Toast.makeText(MainActivity.this,
                        "请再次点击退出按钮",Toast.LENGTH_SHORT);
                    toast.show();
                    toast.setGravity(Gravity.CENTER,0,0);
                    mCurTime=System.currentTimeMillis();
                }else {
                    if (toast!=null){
                        toast.cancel();
                    }
                    finish();
                }
            }
        });
    }
}
