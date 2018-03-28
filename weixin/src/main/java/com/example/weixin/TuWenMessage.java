package com.example.weixin;

/**
 * Created by 王伟健 on 2018-03-24.
 */

public class TuWenMessage {

    public TuWenMessage(int imageResourse, String wenzi, String zhaiyao,String time) {
        this.imageResourse = imageResourse;
        this.wenzi = wenzi;
        this.zhaiyao = zhaiyao;
        this.time = time;
    }

    private int imageResourse;
    private String wenzi;
    private String zhaiyao;
    private String time;

    public void setImageResourse(int imageResourse) {
        this.imageResourse = imageResourse;
    }

    public void setWenzi(String wenzi) {
        this.wenzi = wenzi;
    }

    public void setZhaiyao(String zhaiyao) {
        this.zhaiyao = zhaiyao;
    }

    public int getImageResourse() {
        return imageResourse;
    }

    public String getWenzi() {
        return wenzi;
    }

    public String getZhaiyao() {
        return zhaiyao;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
