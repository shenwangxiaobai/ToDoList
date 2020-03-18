package com.mjdbsx.daoimpl;

import com.mjdbsx.dao.JdbcConnection;
import com.mjdbsx.dao.RootDao;
import com.mjdbsx.domain.DBSX2;
import com.mjdbsx.domain.Dbsx;
import com.mjdbsx.domain.User;

import java.util.List;

public class RootDaoImpl implements RootDao {
    JdbcConnection jdbcConnection = new JdbcConnectionImpl();
    @Override
    public List<User> selectUsers(String type,int page,int limit) {
        String sql = "select phonenumber,username from user where username != 'root' order by phonenumber " + type+" limit "+page+","+limit;
        System.out.println(sql);
        List<User> userList = jdbcConnection.connectionSelectAllUser(sql);
        return userList;
    }

    @Override
    public List<DBSX2> selecctDbsx(String type,int page,int limit) {
        String sql = "select * from dbsx order by dbsxid " +type +" limit "+page+","+limit;
        List<DBSX2> dbsxList = jdbcConnection.ConnectionDbsx2(sql);
        return dbsxList;
    }

    @Override
    public boolean deletUser(String phonenumber,String username) {
        boolean bool = false;
        String sql_1 = "delete from tag where phonenumber ='"+phonenumber+"'";
        boolean bool_1 = jdbcConnection.ConnectionDeleteUser(sql_1);
        String sql_2 = "delete from user where phonenumber ='"+phonenumber+"'";
        boolean bool_2 = jdbcConnection.ConnectionDeleteTag(sql_2);
        String sql_3 = "delete from dbsx where username = '"+username+"";
        boolean bool_3 = jdbcConnection.ConnectionDeleteDbsx(sql_3);
        if(bool_1==true&&bool_2==true&&bool_3==true){
            bool = true;
        }
        return bool;
    }

    @Override
    public boolean deletDbsx(String dbsxid) {
        String sql = "delete from dbsx where dbsxid = '"+dbsxid+"'";
        boolean bool = jdbcConnection.ConnectionDeleteDbsx(sql);
        return bool;
    }

    @Override
    public int total() {
        String sql = "select count(*) from dbsx";
        int total = jdbcConnection.ConnectionAll(sql);
        return  total;
    }

    @Override
    public int count() {
        String sql = "select count(*) from user";
        int total = jdbcConnection.ConnectionAll(sql);
        return  total-1;
    }
}
