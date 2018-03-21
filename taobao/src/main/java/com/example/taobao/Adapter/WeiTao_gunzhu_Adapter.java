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

public class WeiTao_gunzhu_Adapter extends BaseAdapter {

    private List<Map<String,Object>> data;
    private Context context;
    private int item_layout_id;

    public WeiTao_gunzhu_Adapter(Context context,int item_layout_id,List<Map<String,Object>> data){
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
        TextView contenxt = convertView.findViewById(R.id.context);
        ImageView ivIamges = convertView.findViewById(R.id.images);
        ImageView liulan = convertView.findViewById(R.id.liulan);
        TextView liulanliang = convertView.findViewById(R.id.liulanliang);
        Map<String,Object> map = data.get(position);

        touxiang.setImageResource((int)map.get("touxiang"));
        name.setText(map.get("name").toString());
        tvDate.setText(map.get("date").toString());
        contenxt.setText(map.get("context").toString());
        ivIamges.setImageResource((int)map.get("images"));
        liulan.setImageResource(R.drawable.liulan);
        liulanliang.setText(map.get("liulanliang").toString());

        setImageButton(convertView,map.get("dianzan").toString(),R.drawable.zan,R.id.dianzan,13.5F,10);
        setImageButton(convertView,map.get("pinglun").toString(),R.drawable.pinglun,R.id.pinglun,13.5F,10);
        return convertView;
    }

    private void setImageButton(View v,String str,int drawab,int btn,float dpX,float dpY){
        Drawable drawable = v.getResources().getDrawable(drawab);
        drawable.setBounds(9, 0, Dp2px.dip2px(v.getContext(),dpX),Dp2px.dip2px(v.getContext(),dpY));
        Button button = v.findViewById(btn);
        button.setCompoundDrawables(drawable,null,null,null);
        button.setText(str);
    }
}
