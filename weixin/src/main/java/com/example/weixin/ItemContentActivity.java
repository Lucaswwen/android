package com.example.weixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.weixin.util.Dp2px;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王伟健 on 2018-03-24.
 */

public class ItemContentActivity extends Activity{

    List<ArrayList<View>> dataSourse = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_item_content_activity);

        ImageView ivBack = findViewById(R.id.back);
        Intent intent = getIntent();

        //获取公众号名称
        String name = intent.getStringExtra("name");
        int id = intent.getIntExtra("id",0);

        //设置返回动作
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView tvName = findViewById(R.id.name);
        tvName.setText(name);

        //获取数据信息
        List<List<TuWenMessage>> data = Data.getData(id);

        //获取消息列表
        ListView messagelist = findViewById(R.id.listmessage);

        if (data!=null&&data.size()>0) {
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).size() == 1) {
                    View view = LayoutInflater.from(this).inflate(R.layout.layout_content__single, null);
                    setTuWenView(view, data.get(i).get(0));
                    ArrayList<View> message = new ArrayList<>();
                    message.add(view);
                    dataSourse.add(message);
                } else {
                    ArrayList<View> message = new ArrayList<>();
                    for (int j = 0; j < data.get(i).size(); j++) {
                        View view;
                        if (j == 0) {
                            view = LayoutInflater.from(this).inflate(R.layout.layout_content_toutiao, null);
                        }else {
                            view = LayoutInflater.from(this).inflate(R.layout.layout_content_is_not_first, null);
                        }
                        setTuWenView(view, data.get(i).get(j));
                        message.add(view);
                    }
                    dataSourse.add(message);
                }
            }
        }

        messagelist.setVerticalScrollBarEnabled(false);
        ContentItemAdapter cit = new ContentItemAdapter(this,R.layout.layout_content_list,dataSourse);
        messagelist.setAdapter(cit);
    }

    public View setTuWenView(View view,TuWenMessage tuWenMessage){
        ImageView iv = view.findViewById(R.id.image);
        TextView wenzi = view.findViewById(R.id.wenzi);
        TextView zhaiyao = view.findViewById(R.id.zhaiyao);
        iv.setImageResource(tuWenMessage.getImageResourse());
        wenzi.setText(tuWenMessage.getWenzi());
        zhaiyao.setText(tuWenMessage.getZhaiyao());
        return view;
    }
}
