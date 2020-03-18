package com.mjdbsx.dao;

import com.mjdbsx.domain.Dbsx;

import java.sql.Timestamp;
import java.util.List;

public interface DbsxDao {
    List<Dbsx> checkDbsxDao(String username,int token,String tagname);
    List<String> checkDbsxId(String username);
    Dbsx checkOneDbsx(String dbsxid);
    boolean checkUpdateDbsx(String dbsxid, String dbsxname, int token, String username, String tagname, Timestamp time, String text, String remark,String week);
    boolean checkDeleteDbss(String dbsxid);
    boolean checkUpdareDbsxToken(String dbsxid,int token);
    List<Dbsx> checkDbsxToday(String username,Timestamp begin,Timestamp end);
    boolean checkUpdatedao(String username,String tagname,String newtagname);
    List<Dbsx> checkDbsxDao(String username,int token);
    List<Dbsx> checkDbsxToday(String username,Timestamp begin,Timestamp end,String week);
    List<Dbsx> checkDbsxToday(String username,String week);
    boolean resetDbsxToday(String username,String week);
}
