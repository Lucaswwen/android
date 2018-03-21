package com.example.taobao.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.taobao.R;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王伟健 on 2018-03-16.
 */

public class Fragment_weitao extends Fragment {

    private Map<String,Map<String,Object>> topTabMap;
    private static String LAST_SELECT = "guanzhu";

    private FragmentTabHost myTabHost;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weitao,container,false);
        this.view = view;
        topTabMap = new HashMap<>();
        initTabHost();
        myTabHost.setOnTabChangedListener(new FragmentTabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Map attr = topTabMap.get(LAST_SELECT);
                View view = (View) attr.get("view");
                //修改上一次点击的布局
                TextView tv = view.findViewById(R.id.weitao_tab_tv);
                tv.setTextColor(Color.rgb(255,175,110));
                View vheng = view.findViewById(R.id.hengxian);
                vheng.setBackgroundColor(Color.argb(0,0,0,0));
                LAST_SELECT = tabId;
                //改此次点击的图标
                view = (View)(topTabMap.get(tabId).get("view"));
                tv = view.findViewById(R.id.weitao_tab_tv);
                tv.setTextColor(Color.rgb(255,255,255));
                vheng = view.findViewById(R.id.hengxian);
                vheng.setBackgroundColor(Color.argb(255,255,255,255));
            }
        });
        return view;
    }


    private void initTabHost(){
        myTabHost = view.findViewById(android.R.id.tabhost);
        myTabHost.setup(view.getContext(), getChildFragmentManager(),
                android.R.id.tabcontent);
        addTabSpec("guanzhu","关注",R.id.gaunzhu_content,Weitao_content_guanzhu.class);
        addTabSpec("faxian","发现",R.id.faxian_content,Weitao_content_faxian.class);
        myTabHost.setCurrentTab(0);
        View v = (View)topTabMap.get("faxian").get("view");
        TextView tv = v.findViewById(R.id.weitao_tab_tv);
        tv.setTextColor(Color.rgb(255,175,110));
        View vheng = v.findViewById(R.id.hengxian);
        vheng.setBackgroundColor(Color.argb(0,0,0,0));
    }

    /**
     * @param str 标签名字
     * @param id tabid
     * */
    private void addTabSpec(String id,String str,int view,Class<?> fragment){
        Map<String,Object> attr = new HashMap<>();
        View viewTab = getTabView(str);
        FragmentTabHost.TabSpec tabSpec = myTabHost.newTabSpec(id)
                .setIndicator(viewTab).setContent(view);
        myTabHost.addTab(tabSpec,fragment,null);
        attr.put("view",viewTab);
        attr.put("str",str);
        topTabMap.put(id,attr);
    }

    /**
     * 创建tabview
     * */
    private View getTabView(String str) {
        View view = getLayoutInflater().inflate(R.layout.fragment_weitao_tab, null);
        TextView tv = view.findViewById(R.id.weitao_tab_tv);
        tv.setText(str);
        return view;
    }
}