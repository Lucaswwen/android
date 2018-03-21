package com.example.ap9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    List<Map<String,Object>> list;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        list = new ArrayList<>();
        Map map1 = new HashMap();
        Map map2 = new HashMap();


        map1.put("name","张三");
        map1.put("nickname","小阿三");
        map1.put("id",1);


        map2.put("name","李四");
        map2.put("nickname","小阿四");
        map2.put("id",2);

        list.add(map1);
        list.add(map2);

        PeopleAdapter pa = new PeopleAdapter(this,this,R.layout.item,list);
        lv.setAdapter(pa);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK){
            int id = data.getIntExtra("id",0);
            findViewById(R.id.id);
            String nicknamenew = data.getStringExtra("nickname");
            String namenew = data.getStringExtra("name");
            for (Map map:list){
                if ((int)map.get("id")==id){
                    map.put("id",id);
                    map.put("name",namenew);
                    map.put("nickname",nicknamenew);
                }
            }
            PeopleAdapter pa = new PeopleAdapter(this,this,R.layout.item,list);
            lv.setAdapter(pa);
        }
    }
}
