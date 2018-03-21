package com.example.ap4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        Map<String,Object> map3 = new HashMap<>();
        Map<String,Object> map4 = new HashMap<>();
        Map<String,Object> map5 = new HashMap<>();

        map1.put("name","赵一");
        map1.put("src",R.drawable.h01);
        map1.put("shuo","安抚万粉丝");

        map2.put("name","倩儿");
        map2.put("src",R.drawable.h02);
        map2.put("shuo","爱疯舞富翁");

        map3.put("name","孙三");
        map3.put("src",R.drawable.h03);
        map3.put("shuo","阿尔法让国人");

        map4.put("name","李四");
        map4.put("src",R.drawable.h04);
        map4.put("shuo","发生更让人");

        map5.put("name","周五");
        map5.put("src",R.drawable.h05);
        map5.put("shuo","规划投入给对方");

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);

        CustomAdapter adapter = new CustomAdapter(this,R.layout.list_item_layout,list);
        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);

    }
}
