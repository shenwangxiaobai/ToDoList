package com.mjdbsx.serviceimpl;

import com.mjdbsx.dao.DbsxAddDao;
import com.mjdbsx.dao.DbsxDao;
import com.mjdbsx.daoimpl.DbsxAdddaoImpl;
import com.mjdbsx.daoimpl.DbsxDaoImpl;
import com.mjdbsx.domain.Dbsx;
import com.mjdbsx.service.DbsxService;

import java.sql.Timestamp;
import java.util.List;

public class DbsxServiceImpl implements DbsxService {
    DbsxDao dd = new DbsxDaoImpl();
    @Override
    public List<Dbsx> checkDbsxService(String username, int token, String tagname) {
        return dd.checkDbsxDao(username,token,tagname);
    }

    @Override
    public List<String> checkDbsxIdService(String username) {
        return dd.checkDbsxId(username);
    }

    @Override
    public boolean dbsxAddService(String dbsxid, String dbsxname, int token, String username, String tagname, Timestamp time, String text, String remark,Timestamp settime,String week) {
        DbsxAddDao dad = new DbsxAdddaoImpl();
        return dad.adddbsx(dbsxid,dbsxname,token,username,tagname,time,text,remark,settime,week);
    }

    @Override
    public Dbsx checkOneDbsx(String dbsxid) {
        return  dd.checkOneDbsx(dbsxid);
    }

    @Override
    public boolean dbsxUpdateService(String dbsxid, String dbsxname, int token, String username, String tagname, Timestamp time, String text, String remark,String week) {
        return dd.checkUpdateDbsx(dbsxid,dbsxname,token,username,tagname,time,text,remark,week);
    }

    @Override
    public boolean dbsxDeleteService(String dbsxid) {
        return dd.checkDeleteDbss(dbsxid);
    }

    @Override
    public boolean dbsxUpdateToken(String dbsxid, int token) {
        return dd.checkUpdareDbsxToken(dbsxid,token);
    }

    @Override
    public List<Dbsx> checkDbsxToday(String username, Timestamp begin, Timestamp end) {
        return  dd.checkDbsxToday(username,begin,end);
    }

    @Override
    public boolean dbsxupdateService(String username, String tagname, String newtagname) {
        return dd.checkUpdatedao(username,tagname,newtagname);
    }
    public List<Dbsx> checkDbsxService(String username, int token) {
        return dd.checkDbsxDao(username,token);
    }

    @Override
    public List<Dbsx> checkDbsxToday2(String username, Timestamp begin, Timestamp end, String week) {
        return dd.checkDbsxToday(username,begin,end,week);
    }

    @Override
    public List<Dbsx> checkDbsxToday2(String username) {
        return dd.checkDbsxToday(username,"0");
    }

    @Override
    public boolean resetDbsxTooday(String username, String week) {
        return dd.resetDbsxToday(username,week);
    }
}
