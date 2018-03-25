package com.example.weixin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Map<String,Object> map6 = new HashMap<>();
        Map<String,Object> map7 = new HashMap<>();
        Map<String,Object> map8 = new HashMap<>();
        Map<String,Object> map9 = new HashMap<>();


        map1.put("touxiang",R.drawable.qqyinyue);
        map1.put("name","QQ音乐");
        map1.put("time","下午1:01");
        map1.put("id",1);
        map1.put("lastmessage","[17条]世界上赚钱第二多的音乐人|音乐史上的今天");


        map2.put("touxiang",R.drawable.ofo);
        map2.put("name","ofo小黄车石家庄");
        map2.put("time","昨天");
        map2.put("id",2);
        map2.put("lastmessage","ofo发布首个全国城市苏醒图,看完有点震撼");

        map3.put("touxiang",R.drawable.qinzhu);
        map3.put("name","河北师范大学勤助中心");
        map3.put("time","昨天");
        map3.put("id",3);
        map3.put("lastmessage","青春,神采飞扬");


        map4.put("touxiang",R.drawable.lagou);
        map4.put("name","互联网OFFER之路");
        map4.put("time","昨天");
        map4.put("id",4);
        map4.put("lastmessage","4h后截止！唯品会春招网申22号是最后一天！超多岗位快投快投？");

        map5.put("touxiang",R.drawable.gongchandangyuan);
        map5.put("name","共产党员");
        map5.put("time","早上9:02");
        map5.put("id",5);
        map5.put("lastmessage","爱，是唯一理智的行为！");

        map6.put("touxiang",R.drawable.guangmingribao);
        map6.put("name","光明日报");
        map6.put("time","早上11:31");
        map6.put("id",6);
        map6.put("lastmessage","刚刚，副总理刘鹤与美国财长通话:中方有实力捍卫国家利益");

        map7.put("touxiang",R.drawable.hebeigongqingtuan);
        map7.put("name","河北共青团");
        map7.put("time","早上11:39");
        map7.put("id",7);
        map7.put("lastmessage","再见，直屏手机！快看，新出的手机......");

        map8.put("touxiang",R.drawable.tushuguan);
        map8.put("name","河北师范大学图书馆");
        map8.put("time","昨天");
        map8.put("id",8);
        map8.put("lastmessage","新书快递");

        map9.put("touxiang",R.drawable.yuanmingyuan);
        map9.put("name","圆明园遗址公园");
        map9.put("time","昨天");
        map9.put("id",9);
        map9.put("lastmessage","春在枝头已十分");

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        list.add(map7);
        list.add(map8);
        list.add(map9);

        MessItemAdapter messItemAdapter = new MessItemAdapter
                (this,R.layout.layout_message_list_item,list);
        ListView listView = findViewById(R.id.lv);
        listView.setAdapter(messItemAdapter);
    }
}
