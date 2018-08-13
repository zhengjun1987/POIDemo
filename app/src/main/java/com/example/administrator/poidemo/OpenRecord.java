package com.example.administrator.poidemo;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/8/14  00:10
 * Summary : 在这里描述Class的主要功能
 */

public class OpenRecord {
    private final String name;
    private final String date;
    private final String openWay;
    private final String userId;

    public OpenRecord(String name, String date, String openWay, String userId) {
        this.name = name;
        this.date = date;
        this.openWay = openWay;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return name+"_"+date+"_"+openWay+"_"+userId;
    }
}
