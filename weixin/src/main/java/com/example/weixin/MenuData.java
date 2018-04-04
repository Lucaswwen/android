package com.example.weixin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王伟健 on 2018-03-29.
 */

public class MenuData {

    //所有功能
    private static List<BottomMenu> list;

    public static List getData(int id){
        switch (id){
            case 1:
                return initQQmusic();
            case 2:
                return initOfo();
//            case 3:
//                return initQinzhu();
//            case 4:
//                return initLagou();
//            case 5:
//                return initGongChandangyuan();
            default:
                return null;
        }
    }

    private static List<BottomMenu> initQQmusic(){
        list = new ArrayList<>();
        List<String> qqmisic;
        BottomMenu bottomMenu;

        qqmisic = new ArrayList<>();
        qqmisic.add("每日流行");
        qqmisic.add("内地榜");
        qqmisic.add("欧美榜");
        qqmisic.add("韩国榜");
        qqmisic.add("港台榜");
        bottomMenu = new BottomMenu("巅峰榜","1",qqmisic);
        list.add(bottomMenu);

        qqmisic = new ArrayList<>();
        qqmisic.add("我要上梦声");
        qqmisic.add("专辑商城");
        qqmisic.add("已购专辑");
        qqmisic.add("中国新歌声");
        bottomMenu = new BottomMenu("我要上梦声","1",qqmisic);
        list.add(bottomMenu);

        qqmisic = new ArrayList<>();
        qqmisic.add("立即开通");
        qqmisic.add("一元升级");
        qqmisic.add("我的VIP");
        qqmisic.add("购买乐币");
        qqmisic.add("有奖活动");
        bottomMenu = new BottomMenu("豪华绿钻","1",qqmisic);
        list.add(bottomMenu);

        return list;
    }

    private static List<BottomMenu> initOfo(){
        list = new ArrayList<>();
        List<String> qqmisic;
        BottomMenu bottomMenu;

        qqmisic = new ArrayList<>();
        qqmisic.add("立即用车");
        bottomMenu = new BottomMenu("立即用车","1",qqmisic);
        list.add(bottomMenu);

        qqmisic = new ArrayList<>();
        qqmisic.add("点击签到");
        qqmisic.add("商城首页");
        qqmisic.add("积分规则");
        qqmisic.add("ofo骑行福利");
        bottomMenu = new BottomMenu("优惠","1",qqmisic);
        list.add(bottomMenu);

        qqmisic = new ArrayList<>();
        qqmisic.add("我的客服");

        bottomMenu = new BottomMenu("我的客服","1",qqmisic);
        list.add(bottomMenu);

        return list;
    }
}
