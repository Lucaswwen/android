package com.example.taobao.view;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.taobao.Adapter.Cart_Adapter;
import com.example.taobao.Adapter.Message_Adapter;
import com.example.taobao.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王伟健 on 2018-03-16.
 */

public class Fragment_cart extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart,container,false);
        setListView(view);
        return view;
    }

    public void setListView(View view){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        Map<String,Object> map3 = new HashMap<>();

        map1.put("leibie",R.drawable.cart_03);
        map1.put("dianpu_name","绮秀芬旗舰店");
        map1.put("shangpin_image",R.drawable.cart_07);
        map1.put("shangpin_name","春秋季男士睡衣纯棉长袖卡通青年薄款夏季全棉学生休闲家居服套装");
        map1.put("jianjie","16171男;[标准码XL]建议身高175CM左右,体重130-155斤");
        map1.put("jiage","￥79");
        map1.put("yuanjia","￥128");

        map2.put("leibie",R.drawable.cart_10);
        map2.put("dianpu_name","天色睡衣店");
        map2.put("shangpin_image",R.drawable.cart_14);
        map2.put("shangpin_name","男士睡衣冬季三层加厚夹棉珊瑚绒 翻领保暖加绒法兰绒家居服棉袄");
        map2.put("jianjie","图片色;XXL【不掉毛】");
        map2.put("jiage","￥126");
        map2.put("yuanjia","￥298");

        map3.put("leibie",R.drawable.cart_03);
        map3.put("dianpu_name","ASUS华硕旗舰店");
        map3.put("shangpin_image",R.drawable.cart99);
        map3.put("shangpin_name","华硕ASUS");
        map3.put("jianjie","i7 16*4G内存 512固态*2 1080-8GSLI");
        map3.put("jiage","￥39999");
        map3.put("yuanjia","");

        list.add(map1);
        list.add(map2);
        list.add(map3);

        Cart_Adapter ca = new Cart_Adapter(view.getContext(),R.layout.layout_cart_item,list);
        ListView lv = view.findViewById(R.id.lv);
        lv.setAdapter(ca);

    }
}
