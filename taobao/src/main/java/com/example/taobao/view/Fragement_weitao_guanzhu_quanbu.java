package com.example.taobao.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.taobao.Adapter.WeiTao_gunzhu_Adapter;
import com.example.taobao.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王伟健 on 2018-03-18.
 */

public class Fragement_weitao_guanzhu_quanbu extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weitao_gaunzhu_quanbu, container, false);
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        map1.put("touxiang",R.drawable.weitaojun);
        map1.put("name","微淘菌");
        map1.put("date","1小时前");
        map1.put("context","花样真实评测，什么才是美丽又实用的好物！微淘君带你探秘，淘宝心选直营货到底怎么样！点击一起来看~》");
        map1.put("images",R.drawable.weitaojunimage);
        map1.put("liulanliang","9999+");
        map1.put("dianzan","36");
        map1.put("pinglun","评论");

        map2.put("touxiang",R.drawable.anta);
        map2.put("name","安踏官方网店");
        map2.put("date","03-16 19:02");
        map2.put("context","KT延续之路 总有一款适合你");
        map2.put("images",R.drawable.xie);
        map2.put("liulanliang","1964");
        map2.put("dianzan","112");
        map2.put("pinglun","评论");
        list.add(map1);
        list.add(map2);
        WeiTao_gunzhu_Adapter wga = new WeiTao_gunzhu_Adapter(view.getContext(),R.layout.layout_weitao_guanzhu_item,list);
        ListView lv = view.findViewById(R.id.lv);
        lv.setAdapter(wga);
        return view;
    }
}
