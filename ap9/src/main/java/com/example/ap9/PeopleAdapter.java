package com.example.ap9;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by 王伟健 on 2018-03-21.
 */

public class PeopleAdapter extends BaseAdapter {

    private Activity activity;
    private List<Map<String,Object>> data;
    private Context context;
    private int item_layout_id;
    Map<String,Object> map;

    public PeopleAdapter(Activity activity,Context context,int item_layout_id,List<Map<String,Object>> data){
        this.context = context;
        this.item_layout_id = item_layout_id;
        this.data = data;
        this.activity = activity;
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
        TextView name = convertView.findViewById(R.id.name);
        TextView nickname = convertView.findViewById(R.id.nickname);
        TextView id = convertView.findViewById(R.id.id);
        Button button = convertView.findViewById(R.id.update);
        map =  data.get(position);
        String nameStr =  map.get("name").toString();
        String nicknameStr = map.get("nickname").toString();
        int idI = (int)map.get("id");
        name.setText(nameStr);
        nickname.setText(nicknameStr);
        id.setText(idI+"");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送请求
                Intent intent = new Intent();
                intent.setClass(PeopleAdapter.this.context,ItemDetailActivity.class);
                //放入数据
                TextView tvid = ((View)v.getParent()).findViewById(R.id.id);
                int id = Integer.parseInt(tvid.getText().toString());
                TextView tvname = ((View)v.getParent()).findViewById(R.id.name);
                String name = tvname.getText().toString();
                TextView tvnickname = ((View)v.getParent()).findViewById(R.id.nickname);
                String nickname = tvnickname.getText().toString();
                intent.putExtra("id",id);
                intent.putExtra("name",name);
                intent.putExtra("nickname",nickname);
                activity.startActivityForResult(intent,0);
            }
        });
        return convertView;
    }
}
