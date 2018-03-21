package com.example.taobao.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taobao.R;
import com.example.taobao.util.Dp2px;

import java.util.List;
import java.util.Map;

/**
 * Created by 王伟健 on 2018-03-18.
 */

public class Message_Adapter extends BaseAdapter {
    private List<Map<String,Object>> data;
    private Context context;
    private int item_layout_id;

    public Message_Adapter(Context context,int item_layout_id,List<Map<String,Object>> data){
        this.context = context;
        this.item_layout_id = item_layout_id;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
            convertView = mInflater.inflate(item_layout_id,parent,false);
        }
        ImageView touxiang = convertView.findViewById(R.id.touxiang);
        TextView name = convertView.findViewById(R.id.name);
        TextView tvDate = convertView.findViewById(R.id.date);
        TextView message = convertView.findViewById(R.id.message);
        TextView leibie = convertView.findViewById(R.id.leibie);

        Map<String,Object> map = data.get(position);
        touxiang.setImageResource((int)map.get("touxiang"));
        name.setText(map.get("name").toString());
        tvDate.setText(map.get("date").toString());
        message.setText(map.get("message").toString());
        leibie.setText(map.get("leibie").toString());

        return convertView;
    }

}
