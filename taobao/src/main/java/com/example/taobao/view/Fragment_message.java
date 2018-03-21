package com.example.taobao.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.taobao.Adapter.Message_Adapter;
import com.example.taobao.Adapter.WeiTao_gunzhu_Adapter;
import com.example.taobao.R;
import com.example.taobao.util.Dp2px;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王伟健 on 2018-03-16.
 */

public class Fragment_message extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message,container,false);
        setImageButton(view,"交易物流",R.drawable.jiaoyiwuliu,R.id.jiaoyiwuliu,50,50);
        setImageButton(view,"互动",R.drawable.hudong,R.id.hudong,50,50);
        setImageButton(view,"通知",R.drawable.tongzhi,R.id.tongzhi,50,50);
        setListView(view);

        return view;
    }


    private void setImageButton(View v,String str,int drawab,int btn,int dpX,int dpY){
        Drawable drawable = v.getResources().getDrawable(drawab);
        drawable.setBounds(0, 0, Dp2px.dip2px(getContext(),dpX),Dp2px.dip2px(getContext(),dpY));
        Button button = v.findViewById(btn);
        button.setCompoundDrawables(null,drawable,null,null);
        button.setText(str);
    }

    public void setListView(View view){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        Map<String,Object> map3 = new HashMap<>();
        Map<String,Object> map4 = new HashMap<>();
        Map<String,Object> map5 = new HashMap<>();
        Map<String,Object> map6 = new HashMap<>();
        Map<String,Object> map7 = new HashMap<>();
        map1.put("touxiang",R.drawable.m1);
        map1.put("name","淘宝头条");
        map1.put("date","星期五");
        map1.put("message","别说懂女人，你连她的消费清单都看不懂");
        map1.put("leibie","官方");

        map2.put("touxiang",R.drawable.m2);
        map2.put("name","拾月半1015");
        map2.put("date","18/03/05");
        map2.put("message","公共课，在百度网盘【分享】界面添加...");
        map2.put("leibie","官方");

        map3.put("touxiang",R.drawable.m3);
        map3.put("name","绮秀芬旗舰店");
        map3.put("date","18/02/26");
        map3.put("message","[成交]");
        map3.put("leibie","官方");

        map4.put("touxiang",R.drawable.m4);
        map4.put("name","天色睡衣点");
        map4.put("date","18/02/19");
        map4.put("message","你好，亲，正常初八发货哈");
        map4.put("leibie","官方");

        map5.put("touxiang",R.drawable.m5);
        map5.put("name","贝多莎旗舰店");
        map5.put("date","星期五");
        map5.put("message","亲亲可以看别的花型哦");
        map5.put("leibie","官方");

        map6.put("touxiang",R.drawable.m1);
        map6.put("name","淘宝头条");
        map6.put("date","星期五");
        map6.put("message","别说懂女人，你连她的消费清单都看不懂");
        map6.put("leibie","官方");

        map7.put("touxiang",R.drawable.m1);
        map7.put("name","淘宝头条");
        map7.put("date","星期五");
        map7.put("message","别说懂女人，你连她的消费清单都看不懂");
        map7.put("leibie","官方");

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        list.add(map7);

        ScrollView sc = view.findViewById(R.id.sc);
        sc.smoothScrollTo(0, 0);

        Message_Adapter ma = new Message_Adapter(view.getContext(),R.layout.layout_message_item,list);
        ListView lv = view.findViewById(R.id.lv);
        lv.setAdapter(ma);
    }
}

