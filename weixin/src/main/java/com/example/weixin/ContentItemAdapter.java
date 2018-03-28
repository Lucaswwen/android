package com.example.weixin;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.weixin.util.Dp2px;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王伟健 on 2018-03-24.
 */

public class ContentItemAdapter extends BaseAdapter {

    private Context context;
    private int item_layout_id;
    private List<ArrayList<View>> list;

    public ContentItemAdapter(Context context, int item_layout_id, List<ArrayList<View>> list) {
        this.context = context;
        this.item_layout_id = item_layout_id;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
            convertView = mInflater.inflate(item_layout_id,parent,false);
        }
        TextView tv = convertView.findViewById(R.id.time);
        for (int i = 0; i < list.get(position).size(); i++) {
            View view = list.get(position).get(i);
            TextView messageTime = view.findViewById(R.id.time);
            String time = messageTime.getText().toString();
            tv.setText(time);
            ((LinearLayout)convertView).addView(view);
            if (list.get(position).size()==1){
                view.getLayoutParams().height= Dp2px.dip2px(context,200);
            }else {
                if (i==0){
                    view.getLayoutParams().height= Dp2px.dip2px(context,184);
                }else{
                    view.getLayoutParams().height= Dp2px.dip2px(context,73);
                    if (i==list.get(position).size()-1){
                        View singline = view.findViewById(R.id.singleline);
                        singline.setVisibility(View.INVISIBLE);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((LinearLayout)view).getLayoutParams();
                        layoutParams.setMargins(0,0,0,Dp2px.dip2px(context,13));
                    }
                }
            }
        }

        return convertView;
    }
}
