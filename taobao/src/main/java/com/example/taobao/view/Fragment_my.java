package com.example.taobao.view;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.taobao.R;
import com.example.taobao.util.Dp2px;

import java.util.zip.CheckedOutputStream;

/**
 * Created by 王伟健 on 2018-03-16.
 */

public class Fragment_my extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my,container,false);
        setImageButton(view,"待付款",R.drawable.my_10,R.id.daifukuan,28,30);
        setImageButton(view,"待发货",R.drawable.my_12,R.id.daifahuo,28,30);
        setImageButton(view,"待收货",R.drawable.my_14,R.id.daishouhuo,30,30);
        setImageButton(view,"待评价",R.drawable.my_16,R.id.daipingjia,23,30);
        setImageButton(view,"退款/售后",R.drawable.my_18,R.id.tuihuo,30,30);
        setImageButton(view,"卡券包",R.drawable.my_26,R.id.kaquanbao,30,32);
        setImageButton(view,"领券中心",R.drawable.my_28,R.id.lingquanzhongxin,30,32);
        setImageButton(view,"机票火车票",R.drawable.my_31,R.id.jipiaohuochepiao,30,30);
        setImageButton(view,"客服小蜜",R.drawable.my_33,R.id.kefuxiaomi,30,32);
        setImageButton(view,"花呗",R.drawable.my_39,R.id.huabei,30,32);
        setImageButton(view,"阿里宝卡",R.drawable.my_40,R.id.alibaoka,30,32);
        setImageButton(view,"我的评价",R.drawable.my_41,R.id.wodepingjia,30,32);
        setImageButton(view,"更多",R.drawable.my_42,R.id.gengduo,30,32);
        return view;
    }
    private void setImageButton(View v,String str,int drawab,int btn,int dpX,int dpY){
        Drawable drawable = v.getResources().getDrawable(drawab);
        drawable.setBounds(0, 0, Dp2px.dip2px(getContext(),dpX),Dp2px.dip2px(getContext(),dpY));
        Button button = v.findViewById(btn);
        button.setBackgroundColor(Color.argb(0,0,0,0));
        button.setCompoundDrawables(null,drawable,null,null);
        button.setTextColor(Color.parseColor("#666666"));
        button.setTextSize(14);
        button.setText(str);
    }
}
