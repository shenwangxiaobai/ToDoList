package com.mjdbsx.daoimpl;

import com.mjdbsx.dao.DbsxAddDao;
import com.mjdbsx.dao.DbsxDao;
import com.mjdbsx.dao.JdbcConnection;
import com.mjdbsx.domain.Dbsx;

import java.sql.Timestamp;
import java.util.List;

public class DbsxDaoImpl implements DbsxDao {
    @Override
    public List<Dbsx> checkDbsxDao(String username, int token, String tagname) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "select * from dbsx where username = '"+username+"' and token = '"+token+"' and tagname = '"+tagname+"' ";
        List<Dbsx> dbsx = jc.ConnectionDbsx(sql);
        return dbsx;
    }

    @Override
    public List<String> checkDbsxId(String username) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "select dbsxid from dbsx where username = '"+username+"'";
        List<String> dbsxid = jc.ConnectionDbsxId(sql);
        return dbsxid;
    }

    @Override
    public Dbsx checkOneDbsx(String dbsxid) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "select * from dbsx where dbsxid = '"+dbsxid+"'";
        Dbsx d = jc.ConnectionOneDbsx(sql);
        return d;
    }

    @Override
    public boolean checkUpdateDbsx(String dbsxid, String dbsxname, int token, String username, String tagname, Timestamp time, String text, String remark,String week) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "update dbsx set dbsxname='"+dbsxname+"',tagname='"+tagname+"',time='"+time+"',text='"+text+"',remark='"+remark+"',week='"+week+"'where dbsxid='"+dbsxid+"'";
        return jc.ConnectionUpdateDbsx(sql);

    }

    @Override
    public boolean checkDeleteDbss(String dbsxid) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "delete from dbsx where dbsxid = '"+dbsxid+"'";
        return jc.ConnectionDeleteDbsx(sql);
    }

    @Override
    public boolean checkUpdareDbsxToken(String dbsxid, int token) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "update dbsx set token = "+token+" where dbsxid = '"+dbsxid+"'";
        return jc.ConnectionDeleteDbsx(sql);
    }

    @Override
    public List<Dbsx> checkDbsxToday(String username, Timestamp begin, Timestamp end) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "select * from dbsx where username ='"+username+"' and time >='"+begin+"' and time <='"+end+"' and week ='0'" ;
        return jc.ConnectionDbsx(sql);
    }

    @Override
    public boolean checkUpdatedao(String username, String tagname, String newtagname) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "update dbsx set tagname = '"+newtagname+"' where tagname = '"+tagname+"' and username ='"+username+"'";
        return jc.ConnectionDbsxTagUpdate(sql);
    }

    @Override
    public List<Dbsx> checkDbsxDao(String username, int token) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "select * from dbsx where username = '"+username+"' and token = "+token+"";
        List<Dbsx> dbsx = jc.ConnectionDbsx(sql);
        return dbsx;
    }

    @Override
    public List<Dbsx> checkDbsxToday(String username, Timestamp begin, Timestamp end, String week) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "select * from dbsx where username ='"+username+"' and time <='"+begin+"' and week like '%"+week+"%'";
        return jc.ConnectionDbsx(sql);
    }

    @Override
    public List<Dbsx> checkDbsxToday(String username, String week) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "select * from dbsx where username ='"+username+"' and week != '0'";
        return jc.ConnectionDbsx(sql);
    }

    @Override
    public boolean resetDbsxToday(String username, String week) {
        JdbcConnection jc = new JdbcConnectionImpl();
        int token = 0;
        String sql = "update dbsx set token = "+token+" where week !='0' and username ='"+username+"'";
        System.out.println(sql);
        return jc.ConnectionUpdateDbsx(sql);
    }
}
