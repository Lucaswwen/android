package com.example.ap5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * @Author 王伟健
 * @Date 2018-03-13 10:42
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();//初始化
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1")
                .setIndicator(getTabView("短信",R.drawable.h01)).setContent(R.id.tab1);
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2")
                .setIndicator(getTabView("电话",R.drawable.h02)).setContent(R.id.tab2);
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3")
                .setIndicator(getTabView("相册",R.drawable.h03)).setContent(R.id.tab3);

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);

    }
    private View getTabView(String str, int drawable){
        LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.layout_tab,null);
        ImageView imageView = layout.findViewById(R.id.tabs_image);
        imageView.setImageResource(drawable);
        TextView textView = layout.findViewById(R.id.tabs_text);
        textView.setText(str);
        return layout;
    }


}
