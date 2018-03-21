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

import com.example.taobao.R;
import com.example.taobao.util.Dp2px;

/**
 * Created by 王伟健 on 2018-03-16.
 */

public class Fragment_home extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        setImageButton(view,"扫一扫",R.drawable.saoyisao,R.id.bt3,26,26);
        setImageButton(view,"会员码",R.drawable.huiyuanma,R.id.bt4,26,26);
        //设置功能区Button
        setImageButton(view,"天猫",R.drawable.tianmao,R.id.tianmao,60,40);
        setImageButton(view,"聚划算",R.drawable.juhuasuan,R.id.juhuasuan,60,40);
        setImageButton(view,"天猫国际",R.drawable.jinkou,R.id.tianmaoguoji,60,40);
        setImageButton(view,"外卖",R.drawable.waimian,R.id.waimai,60,40);
        setImageButton(view,"天猫超市",R.drawable.tianmaochaoshi,R.id.tianmaochaoshi,60,40);
        setImageButton(view,"充值中心",R.drawable.chongzhi,R.id.chongzhizhongxin,60,40);
        setImageButton(view,"飞猪旅行",R.drawable.feizhu,R.id.feizhulvxing,60,40);
        setImageButton(view,"领金币",R.drawable.lingjinbi,R.id.lingjinbi,60,40);
        setImageButton(view,"拍卖",R.drawable.paimai,R.id.paimai,60,40);
        setImageButton(view,"分类",R.drawable.fenlei,R.id.fenlei,60,40);
        setEidtText(view);
        return view;
    }

    private void setImageButton(View v,String str,int drawab,int btn,int dpX,int dpY){
        Drawable drawable = v.getResources().getDrawable(drawab);
        drawable.setBounds(0, 0, Dp2px.dip2px(getContext(),dpX),Dp2px.dip2px(getContext(),dpY));
        Button button = v.findViewById(btn);
        button.setCompoundDrawables(null,drawable,null,null);
        button.setText(str);
    }



    private void setEidtText(View v){
        Drawable camera = v.getResources().getDrawable(R.drawable.android_icon_camera);
        camera.setBounds(0, 0, Dp2px.dip2px(getContext(),22),Dp2px.dip2px(getContext(),22));
        Drawable search = v.getResources().getDrawable(R.drawable.icon_search_little);
        search.setBounds(0, 0, Dp2px.dip2px(getContext(),22),Dp2px.dip2px(getContext(),22));
        LineEditText et = v.findViewById(R.id.search);
        et.setCompoundDrawables(search,null,camera,null);
    }
}
