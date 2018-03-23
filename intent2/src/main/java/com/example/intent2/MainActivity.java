package com.example.intent2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_phone = findViewById(R.id.btn_phone);
        Button btn_message = findViewById(R.id.btn_message);
        Button btn_web = findViewById(R.id.btn_web);
        Button btn_noti = findViewById(R.id.btn_notification);
        btn_noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ZhaoSiActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,
                        intent,PendingIntent.FLAG_CANCEL_CURRENT);
                //获取通知管理器
                NotificationManager manager =
                        (NotificationManager)getApplicationContext()
                                .getSystemService(Context.NOTIFICATION_SERVICE);

                //创建通知管道
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel
                            = new NotificationChannel("myChannel","神奇的通知渠道",
                            NotificationManager.IMPORTANCE_DEFAULT);
                    manager.createNotificationChannel(notificationChannel);
                }

                //创建构造器
                Notification.Builder builder
                        = new Notification.Builder(getApplicationContext());
                builder.setContentTitle("这是一个神奇的通知");
                builder.setContentText("这里一切都很神奇");
                builder.setSmallIcon(R.drawable.icon1);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.icon2));
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    //设置管道信息
                    builder.setChannelId("myChannel");
                }
                Notification noti = builder.build();
                manager.notify(0,noti);
            }
        });

        Button btn_map = findViewById(R.id.btn_map);
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:39.841,116.111"));
                startActivity(intent);
            }
        });


        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        btn_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:10086"));
                intent.putExtra("sms_body","今天天气不错");
                startActivity(intent);
            }
        });




        //打电话
        btn_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_phone = new Intent();
                intent_phone.setAction(Intent.ACTION_DIAL);
                intent_phone.setData(Uri.parse("tel:10086"));
                startActivity(intent_phone);
            }
        });
    }

    private void sendNotification(PendingIntent pendingIntent){


     }

}
