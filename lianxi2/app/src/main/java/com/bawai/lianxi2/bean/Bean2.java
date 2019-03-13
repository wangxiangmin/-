package com.bawai.lianxi2.bean;

import java.util.ArrayList;

/**
 * @Author：不要不要
 * @E-mail： 2930851278@qq.com
 * @Date：2019/3/13 19:12
 * @Description：描述信息
 */
public class Bean2 {
    private int id;
    private String name;
    private ArrayList<Bean> commodityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bean> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(ArrayList<Bean> commodityList) {
        this.commodityList = commodityList;
    }
}
