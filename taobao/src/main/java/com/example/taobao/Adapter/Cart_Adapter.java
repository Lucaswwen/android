package com.example.taobao.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taobao.R;

import java.util.List;
import java.util.Map;

/**
 * Created by 王伟健 on 2018-03-19.
 */

public class Cart_Adapter extends BaseAdapter {
    private List<Map<String,Object>> data;
    private Context context;
    private int item_layout_id;

    public Cart_Adapter(Context context,int item_layout_id,List<Map<String,Object>> data){
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
        ImageView leibie = convertView.findViewById(R.id.dianpuleibie);
        TextView dianpu_name = convertView.findViewById(R.id.dianpu_name);
        ImageView shangpin_image = convertView.findViewById(R.id.shangpin_image);
        TextView shangpin_name = convertView.findViewById(R.id.shangpin_name);
        TextView shangpinxiangqing = convertView.findViewById(R.id.xiangqing);
        TextView jiage = convertView.findViewById(R.id.jiage);
        TextView yuanjia  = convertView.findViewById(R.id.yuanjia);
        Map<String,Object> map = data.get(position);

        leibie.setImageResource((int)map.get("leibie"));
        dianpu_name.setText(map.get("dianpu_name").toString());
        shangpin_image.setImageResource((int)map.get("shangpin_image"));
        shangpin_name.setText(map.get("shangpin_name").toString());
        shangpinxiangqing.setText(map.get("jianjie").toString());
        jiage.setText(map.get("jiage").toString());
        yuanjia.setText(map.get("yuanjia").toString());

        yuanjia.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
        return convertView;
    }

}