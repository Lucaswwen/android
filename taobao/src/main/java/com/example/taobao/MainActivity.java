package com.example.taobao;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import com.example.taobao.view.Fragment_cart;
import com.example.taobao.view.Fragment_home;
import com.example.taobao.view.Fragment_message;
import com.example.taobao.view.Fragment_my;
import com.example.taobao.view.Fragment_weitao;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost myTabHost;
    private Map<String,Map<String,Object>> map;
    private static String LAST_SELECT = "home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = new HashMap<>();
        initTabHost();
        //底部tabhost改变图标
        myTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                //将上一次点击的图标改回
                Map attr = map.get(LAST_SELECT);
                View view = (View) attr.get("view");
                ImageView iv = view.findViewById(R.id.imageId);
                iv.setImageResource((int)attr.get("img"));
                LAST_SELECT = tabId;
                //改此次点击的图标
                if(tabId.equals("home")){
                    view = (((View)(map.get(tabId).get("view"))).findViewById(R.id.imageId));
                    iv = view.findViewById(R.id.imageId);
                    iv.setImageResource(R.drawable.uik_nav_home_selected);
                }
                if(tabId.equals("weitao")){
                    view = (((View)(map.get(tabId).get("view"))).findViewById(R.id.imageId));
                    iv = view.findViewById(R.id.imageId);
                    iv.setImageResource(R.drawable.uik_nav_weitao_selected);
                }
                if(tabId.equals("message")){
                    view = (((View)(map.get(tabId).get("view"))).findViewById(R.id.imageId));
                    iv = view.findViewById(R.id.imageId);
                    iv.setImageResource(R.drawable.ic_nav_message_selected);
                }
                if(tabId.equals("cart")){
                    view = (((View)(map.get(tabId).get("view"))).findViewById(R.id.imageId));
                    iv = view.findViewById(R.id.imageId);
                    iv.setImageResource(R.drawable.uik_nav_cart_selected);
                }
                if(tabId.equals("my")){
                    view = (((View)(map.get(tabId).get("view"))).findViewById(R.id.imageId));
                    iv = view.findViewById(R.id.imageId);
                    iv.setImageResource(R.drawable.uik_nav_my_selected);
                }
            }
        });
    }

    /**
     * 初始化tabhost
     * */
    private void initTabHost(){
        myTabHost = this.findViewById(android.R.id.tabhost);
        myTabHost.setup(this, getSupportFragmentManager(),
                android.R.id.tabcontent);
        addTabSpec("home",R.drawable.uik_nav_home_normal, Fragment_home.class);
        addTabSpec("weitao",R.drawable.uik_nav_weitao_normal, Fragment_weitao.class);
        addTabSpec("message",R.drawable.ic_nav_message_normal, Fragment_message.class);
        addTabSpec("cart",R.drawable.uik_nav_cart_normal, Fragment_cart.class);
        addTabSpec("my",R.drawable.uik_nav_my_normal, Fragment_my.class);
        ImageView iv =  (myTabHost.getTabWidget().getChildTabViewAt(0).findViewById(R.id.imageId));
        iv.setImageResource(R.drawable.uik_nav_home_selected);
        myTabHost.setCurrentTab(0);
    }

    /**
     * @param drawable 图片资源id
     * @param fragment
     * @param id tabid
     * */
    private void addTabSpec(String id,int drawable,Class<?> fragment){
        Map<String,Object> attr = new HashMap<>();
        View viewTab = getTabView(drawable);
        TabHost.TabSpec tabSpec = myTabHost.newTabSpec(id)
                .setIndicator(viewTab);
        myTabHost.addTab(tabSpec,fragment,null);
        attr.put("view",viewTab);
        attr.put("img",drawable);
        map.put(id,attr);
    }

    /**
     * 创建tabview
     * */
    private View getTabView(int drawable) {
        View view = getLayoutInflater().inflate(R.layout.fragment_tab, null);
        ImageView imageView = view.findViewById(R.id.imageId);
        imageView.setImageResource(drawable);
        return view;
    }
}
