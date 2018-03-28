package com.example.weixin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王伟健 on 2018-03-24.
 */

public class Data {
    //所有推送
    private static List<List<TuWenMessage>> listView;


    public static List getData(int id){
        switch (id){
            case 1:
                return initQQmusic();
            case 2:
                return initOfo();
            case 3:
                return initQinzhu();
            case 4:
                return initLagou();
            case 5:
                return initGongChandangyuan();
        }
        return null;
    }


    private static List initQQmusic(){
        listView = new ArrayList();

        List<TuWenMessage> listMessage1 = new ArrayList();
        TuWenMessage tuWenMessage1;

        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_1,"张杰/侯明昊：“老干部”与“佛系”鼻祖的二三事",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_2,"什么？你洗澡时竟然不听歌？！",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_3,"The Beatles来了！28张专辑重磅登陆",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        listView.add(listMessage1);

        List<TuWenMessage> listMessage2 = new ArrayList();
        TuWenMessage tuWenMessage2;

        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_1,"张杰/侯明昊：“老干部”与“佛系”鼻祖的二三事",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_2,"什么？你洗澡时竟然不听歌？！",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_3,"The Beatles来了！28张专辑重磅登陆",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        listView.add(listMessage2);



        return listView;
    }

    private static List initOfo(){
        listView = new ArrayList();

        List<TuWenMessage> listMessage1 = new ArrayList();
        TuWenMessage tuWenMessage1;

        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_1,"张杰/侯明昊：“老干部”与“佛系”鼻祖的二三事",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_2,"什么？你洗澡时竟然不听歌？！",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_3,"The Beatles来了！28张专辑重磅登陆",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        listView.add(listMessage1);

        List<TuWenMessage> listMessage2 = new ArrayList();
        TuWenMessage tuWenMessage2;

        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_1,"张杰/侯明昊：“老干部”与“佛系”鼻祖的二三事",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_2,"什么？你洗澡时竟然不听歌？！",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_3,"The Beatles来了！28张专辑重磅登陆",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        listView.add(listMessage2);



        return listView;
    }

    private static List initQinzhu(){
        listView = new ArrayList();

        List<TuWenMessage> listMessage1 = new ArrayList();
        TuWenMessage tuWenMessage1;

        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_1,"张杰/侯明昊：“老干部”与“佛系”鼻祖的二三事",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_2,"什么？你洗澡时竟然不听歌？！",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_3,"The Beatles来了！28张专辑重磅登陆",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        listView.add(listMessage1);

        List<TuWenMessage> listMessage2 = new ArrayList();
        TuWenMessage tuWenMessage2;

        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_1,"张杰/侯明昊：“老干部”与“佛系”鼻祖的二三事","9999999999","下午1:01");
        listMessage2.add(tuWenMessage2);

        listView.add(listMessage2);

        return listView;
    }

    private static List initLagou(){
        listView = new ArrayList();

        List<TuWenMessage> listMessage1 = new ArrayList();
        TuWenMessage tuWenMessage1;

        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_1,"张杰/侯明昊：“老干部”与“佛系”鼻祖的二三事",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_2,"什么？你洗澡时竟然不听歌？！",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_3,"The Beatles来了！28张专辑重磅登陆",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        listView.add(listMessage1);

        List<TuWenMessage> listMessage2 = new ArrayList();
        TuWenMessage tuWenMessage2;

        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_1,"张杰/侯明昊：“老干部”与“佛系”鼻祖的二三事",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_2,"什么？你洗澡时竟然不听歌？！",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_3,"The Beatles来了！28张专辑重磅登陆",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        listView.add(listMessage2);

        return listView;
    }

    private static List initGongChandangyuan(){
        listView = new ArrayList();

        List<TuWenMessage> listMessage1 = new ArrayList();
        TuWenMessage tuWenMessage1;

        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_1,"张杰/侯明昊：“老干部”与“佛系”鼻祖的二三事",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_2,"什么？你洗澡时竟然不听歌？！",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        tuWenMessage1 = new TuWenMessage(R.drawable.qqmusic1_3,"The Beatles来了！28张专辑重磅登陆",null,"下午1:01");
        listMessage1.add(tuWenMessage1);
        listView.add(listMessage1);

        List<TuWenMessage> listMessage2 = new ArrayList();
        TuWenMessage tuWenMessage2;

        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_1,"张杰/侯明昊：“老干部”与“佛系”鼻祖的二三事",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_2,"什么？你洗澡时竟然不听歌？！",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        tuWenMessage2 = new TuWenMessage(R.drawable.qqmusic1_3,"The Beatles来了！28张专辑重磅登陆",null,"下午1:01");
        listMessage2.add(tuWenMessage2);
        listView.add(listMessage2);



        return listView;
    }
}
