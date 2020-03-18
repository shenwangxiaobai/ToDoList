package com.mjdbsx.domain;

public class DBSX2 {
    private String dbsxid;
    private String dbsxname;
    private  String username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "DBSX2{" +
                "dbsxid='" + dbsxid + '\'' +
                ", dbsxname='" + dbsxname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
