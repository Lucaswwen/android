package com.example.ap4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by 王伟健 on 2018-03-09.
 */

public class CustomAdapter extends BaseAdapter {
    private List<Map<String,Object>> data;
    private Context context;
    private int item_layout_id;

    public CustomAdapter(Context context,int item_layout_id,List<Map<String,Object>> data){
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
            LayoutInflater mInflater = LayoutInflater.from(context);
            convertView = mInflater.inflate(item_layout_id,null);
        }
        ImageView iv = convertView.findViewById(R.id.image);
        TextView tvNmae = convertView.findViewById(R.id.name);
        TextView tvShuo = convertView.findViewById(R.id.shuo);
        Map<String,Object> map = data.get(position);
        Log.e("图片位置" ,(int)map.get("src")+"");
        iv.setImageResource((int)map.get("src"));
        tvNmae.setText(map.get("name").toString());
        tvShuo.setText(map.get("shuo").toString());

        return convertView;
    }
}
