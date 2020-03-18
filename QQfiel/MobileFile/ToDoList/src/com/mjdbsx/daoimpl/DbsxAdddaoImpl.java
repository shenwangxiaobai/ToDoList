package com.mjdbsx.daoimpl;

import com.mjdbsx.dao.DbsxAddDao;
import com.mjdbsx.dao.JdbcConnection;

import java.sql.Timestamp;

public class DbsxAdddaoImpl implements DbsxAddDao {
    @Override
    public boolean adddbsx(String dbsxid, String dbsxname, int token, String username, String tagname, Timestamp time, String text, String remark,Timestamp settime,String week) {
        String sql = "insert into dbsx (dbsxid,dbsxname,username,token,tagname,time,text,remark,settime,week) values('"+dbsxid+"','"+dbsxname+"','"+username+"',"+token+",'"+tagname+"','"+time+"','"+text+"','"+remark+"','"+settime+"','"+week+"')";
        System.out.println(sql);
        JdbcConnection jc = new JdbcConnectionImpl();
        boolean bool = jc.Connectionadddbsx(sql);
        return bool;
    }
}
