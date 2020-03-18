package com.mjdbsx.domain;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Dbsx {
    //待办事项ID
    private String dbsxid;
    //待办事项名称
    private String dbsxname;
    //代办事项Tag标签名
    private String tagname;
    //提醒时间
    private Timestamp time;
    //完成情况
    private int token;
    //待办事项内容
    private String text;
    //待办事项备注
    private String remark;
    //周期
    private String week;

    @Override
    public String toString() {
        return "Dbsx{" +
                "dbsxid='" + dbsxid + '\'' +
                ", dbsxname='" + dbsxname + '\'' +
                ", tagname='" + tagname + '\'' +
                ", time=" + time +
                ", token=" + token +
                ", text='" + text + '\'' +
                ", remark='" + remark + '\'' +
                ", week='" + week + '\'' +
                '}';
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDbsxid() {
        return dbsxid;
    }

    public void setDbsxid(String dbsxid) {
        this.dbsxid = dbsxid;
    }

    public String getDbsxname() {
        return dbsxname;
    }

    public void setDbsxname(String dbsxname) {
        this.dbsxname = dbsxname;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
