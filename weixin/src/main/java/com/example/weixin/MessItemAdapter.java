package com.example.weixin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by 王伟健 on 2018-03-23.
 */

public class MessItemAdapter extends BaseAdapter {

    private Context context;
    private int layout_item_id;
    private List<Map<String,Object>> data;
    private Map<String,Object> map;

    public MessItemAdapter(Context context,int layout_item_id,List<Map<String,Object>> data){
        this.context = context;
        this.layout_item_id = layout_item_id;
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
            convertView = mInflater.inflate(layout_item_id,parent,false);
        }

        ImageView ivTouxiang = convertView.findViewById(R.id.touxiang);
        TextView tvName = convertView.findViewById(R.id.name);
        TextView tvTime = convertView.findViewById(R.id.time);
        TextView tvMessage = convertView.findViewById(R.id.lastmessage);

        map = data.get(position);

        ivTouxiang.setImageResource((int)map.get("touxiang"));
        tvName.setText(map.get("name").toString());
        tvTime.setText(map.get("time").toString());
        tvMessage.setText(map.get("lastmessage").toString());

        ViewClickListener vl = new ViewClickListener(map);
        convertView.setOnClickListener(vl);
        return convertView;
    }
    private class ViewClickListener implements View.OnClickListener {
        private Map<String, Object> map;

        public ViewClickListener(Map<String, Object> map) {
            this.map = map;
        }
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(context,ItemContentActivity.class);
            intent.putExtra("name",map.get("name").toString());
            intent.putExtra("id",(int)map.get("id"));
            context.startActivity(intent);
        }
    }
}
