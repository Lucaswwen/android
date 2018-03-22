package com.example.ap9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    PeopleAdapter pa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> list;
        ListView lv;
        lv = findViewById(R.id.lv);
        list = new ArrayList<>();
        Map map1 = new HashMap();
        Map map2 = new HashMap();

        map1.put("name","张三");
        map1.put("nickname","小阿三");

        map2.put("name","李四");
        map2.put("nickname","小阿四");

        list.add(map1);
        list.add(map2);

        pa = new PeopleAdapter(this,this,R.layout.item,list);
        lv.setAdapter(pa);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK){
            String nicknamenew = data.getStringExtra("nickname");
            String namenew = data.getStringExtra("name");
            int position = data.getIntExtra("position",0);
            Map map = (Map)pa.getItem(position);
            map.put("name",namenew);
            map.put("nickname",nicknamenew);
        }
    }
}
