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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
            convertView = mInflater.inflate(item_layout_id,parent,false);
        }
        TextView name = convertView.findViewById(R.id.name);
        TextView nickname = convertView.findViewById(R.id.nickname);
        Button button = convertView.findViewById(R.id.update);
        Map<String,Object> map =  data.get(position);

        String nameStr =  map.get("name").toString();
        String nicknameStr = map.get("nickname").toString();

        name.setText(nameStr);
        nickname.setText(nicknameStr);

        button.setOnClickListener(new EditButtonListener(map,position));
        return convertView;
    }

    private class EditButtonListener implements View.OnClickListener {
        private Map<String, Object> map;
        private int position;

        public EditButtonListener(Map<String, Object> map,int position) {
            this.map = map;
            this.position = position;
        }
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(PeopleAdapter.this.context,ItemDetailActivity.class);
            intent.putExtra("name", map.get("name").toString());
            intent.putExtra("nickname", map.get("nickname").toString());
            intent.putExtra("position", position);
            activity.startActivityForResult(intent, 0);
        }
    }
}
