package com.mjdbsx.dao;

import java.sql.Timestamp;

public interface DbsxAddDao {
    boolean adddbsx(String dbsxid, String dbsxname, int token, String username, String tagname, Timestamp time,String text,String remark,Timestamp settime,String week);
}
