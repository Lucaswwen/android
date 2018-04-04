package com.example.weixin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weixin.util.Dp2px;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王伟健 on 2018-03-24.
 */

public class ItemContentActivity extends Activity{

    List<ArrayList<View>> dataSourse = new ArrayList<>();
    List<List<TuWenMessage>> data;

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
        data = Data.getData(id);
        initMenu(id);

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
        TextView time = view.findViewById(R.id.time);
        iv.setImageResource(tuWenMessage.getImageResourse());
        wenzi.setText(tuWenMessage.getWenzi());
        zhaiyao.setText(tuWenMessage.getZhaiyao());
        time.setText(tuWenMessage.getTime());
        return view;
    }
    public void initMenu(int id){
        List<BottomMenu> list = MenuData.getData(id);
        if (list!=null) {
            Button button;
            final View view = findViewById(R.id.caidan);
            for (int i = 0; i < list.size(); i++) {
                final BottomMenu bottomMenu = list.get(i);
                String text = bottomMenu.getText();
                button = new Button(this);
                button.setBackgroundColor(Color.parseColor("#00000000"));
                button.setText(text);
                button.setTextSize(16);
                button.setWidth(0);
                Drawable drawable = getDrawable(R.drawable.menu_button_bg);
                button.setBackground(drawable);
                ((LinearLayout) view).addView(button);
                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(0,
                        LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
                button.setLayoutParams(param);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View popWindowView = getLayoutInflater()
                                .inflate(R.layout.layout_popupmenu, null);
                        for (int j = 0; j < bottomMenu.getPopMenu().size(); j++) {
                            Button button1 = new Button(popWindowView.getContext());
                            button1.setText(bottomMenu.getPopMenu().get(j));
                            button1.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);

                            Drawable drawable1 = getDrawable(R.drawable.menu_button_list_bg);
                            button1.setBackground(drawable1);
                            button1.setTextSize(16);
                            button1.setPadding(Dp2px.dip2px(ItemContentActivity.this.getApplicationContext(), 20),
                                    0, Dp2px.dip2px(ItemContentActivity.this.getApplicationContext(), 20), 0);
                            ((LinearLayout) popWindowView).addView(button1);
                        }

                        PopupWindow popupWindow = new PopupWindow
                                (popWindowView, ViewGroup.LayoutParams.WRAP_CONTENT,
                                        ViewGroup.LayoutParams.WRAP_CONTENT,
                                        true);
                        popupWindow.setBackgroundDrawable(new BitmapDrawable());
                        //    popupWindow.showAsDropDown(v);
                        int[] location = new int[2];

                        v.getLocationOnScreen(location);
                        popupWindow.showAtLocation(v, Gravity.START | Gravity.TOP, location[0], location[1] - popupWindow.getHeight());
                    }
                });
            }
        }
    }
}
