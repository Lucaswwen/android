package com.example.ap6;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost myTabHost;
    private Map<String,View> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = new HashMap<>();

        //初始化
        initTabHost();
        myTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

                FragmentTabHost tabHost = MainActivity.this.myTabHost;
                TabWidget tabw = tabHost.getTabWidget();

                for (int i = 0; i < tabw.getChildCount(); i++) {
                    View view = tabw.getChildAt(i);
                    ImageView vi = (ImageView) view.findViewById(R.id.imageId);
                    TextView tv = (TextView) view.findViewById(R.id.textId);
                    if (i==0){
                        vi.setImageResource(R.drawable.xiaoxi);
                    }
                    if (i==1){
                        vi.setImageResource(R.drawable.lianxiren);
                    }
                    if (i==2){
                        vi.setImageResource(R.drawable.faxian);
                    }
                    if (i==3){
                        vi.setImageResource(R.drawable.wo);
                    }
                    tv.setTextColor(Color.rgb(0, 0, 0));
                    if (i == tabHost.getCurrentTab()) {
                        String str = tabId + "lv";
                        vi.setImageResource(getResource(str));
                        tv.setTextColor(Color.rgb(70, 192, 27));
                    }
                }
            }
        });
    }

    /**
     * 初始化
     */
    private void initTabHost() {
        myTabHost = findViewById(android.R.id.tabhost);
        myTabHost.setup(this, getSupportFragmentManager(),
                android.R.id.tabhost);

        addTabSpec("xiaoxi","微信",R.drawable.xiaoxi,FragmentTab1.class);
        addTabSpec("lianxiren","通讯录",R.drawable.lianxiren,FragmentTab2.class);
        addTabSpec("faxian","发现",R.drawable.faxian,FragmentTab3.class);
        addTabSpec("wo","我",R.drawable.wo,FragmentTab4.class);

        ((TextView) myTabHost.getTabWidget().getChildTabViewAt(0)
                .findViewById(R.id.textId)).setTextColor(Color.rgb(70, 192, 27));
        ((ImageView) myTabHost.getTabWidget().getChildTabViewAt(0)
                .findViewById(R.id.imageId)).setImageResource(R.drawable.xiaoxilv);

        myTabHost.setCurrentTab(0);
    }

    /**
     * @param drawable 图片资源id
     * @param fragment
     * @param id tabid
     * @param text 文字
     * */

    private void addTabSpec(String id,String text,int drawable,Class<?> fragment){
        View viewTab = getTabView(text,drawable);
        TabHost.TabSpec tabSpec = myTabHost.newTabSpec(id)
                .setIndicator(viewTab);
        myTabHost.addTab(tabSpec,fragment,null);
        map.put(id,viewTab);
    }

    /**
     * 创建tabview
     * */
    private View getTabView(String str, int drawable) {
        View view = getLayoutInflater().inflate(R.layout.fragment_tab, null);
        ImageView imageView = view.findViewById(R.id.imageId);
        imageView.setImageResource(drawable);
        TextView textView = view.findViewById(R.id.textId);
        textView.setText(str);
        return view;
    }

    /**
     * 获取图片名称获取图片的资源id的方法
     *
     * @param imageName
     * @return
     */
    public int getResource(String imageName) {
        Context ctx = getBaseContext();
        int resId = getResources().getIdentifier(imageName, "drawable", ctx.getPackageName());
        return resId;
    }
}
