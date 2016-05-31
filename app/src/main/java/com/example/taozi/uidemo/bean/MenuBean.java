package com.example.taozi.uidemo.bean;

/**
 * Created by Taozi on 2016/5/31.
 */
public class MenuBean {
    private int menuImage;
    private String menuName;

    public MenuBean(int menuImage, String menuName) {
        this.menuImage = menuImage;
        this.menuName = menuName;
    }

    public int getMenuImage() {
        return menuImage;
    }

    public String getMenuName() {
        return menuName;
    }

}
