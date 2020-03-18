package com.mjdbsx.service;

import com.mjdbsx.domain.Dbsx;

import java.sql.Timestamp;
import java.util.List;

public interface DbsxService {
    List<Dbsx> checkDbsxService(String username,int token,String tagname);
    List<String> checkDbsxIdService(String username);
    boolean dbsxAddService(String dbsxid, String dbsxname, int token, String username, String tagname, Timestamp time, String text, String remark,Timestamp settime,String week);
    Dbsx checkOneDbsx(String dbsxid);
    boolean dbsxUpdateService(String dbsxid, String dbsxname, int token, String username, String tagname, Timestamp time, String text, String remark,String week);
    boolean dbsxDeleteService(String dbsxid);
    boolean dbsxUpdateToken(String dbsxid,int token);
    List<Dbsx> checkDbsxToday(String username,Timestamp begin,Timestamp end);
    boolean dbsxupdateService(String username,String tagname,String newtagname);
    List<Dbsx> checkDbsxService(String username,int token);
    List<Dbsx> checkDbsxToday2(String username,Timestamp begin,Timestamp end,String week);
    List<Dbsx> checkDbsxToday2(String username);
    boolean resetDbsxTooday(String username,String week);
}
