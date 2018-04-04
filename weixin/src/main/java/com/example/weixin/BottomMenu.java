package com.example.weixin;

import java.util.List;

/**
 * Created by 王伟健 on 2018-03-29.
 */

public class BottomMenu {

    public BottomMenu(String text, String type, List<String> popMenu) {
        this.text = text;
        this.type = type;
        this.popMenu = popMenu;
    }

    public BottomMenu(String text, String type, String link) {
        this.text = text;
        this.type = type;
        this.link = link;
    }

    private String text;
    //弹出菜单是1
    //跳转链接是2
    //回复消息是3
    private String type;
    private List<String> popMenu;
    private String link;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getPopMenu() {
        return popMenu;
    }

    public void setPopMenu(List<String> popMenu) {
        this.popMenu = popMenu;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
