package com.mjdbsx.daoimpl;

import com.mjdbsx.dao.JdbcConnection;
import com.mjdbsx.dao.LoginDao;
import com.mjdbsx.domain.User;

//通过账号密码链接数据库
public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkLoginDao(String phonenumber, String password) {
        JdbcConnection jc =new JdbcConnectionImpl();
        //链接Sql语句进行查询
        String sql = "select * from user where phonenumber = '"+phonenumber+"'and password = '"+password+"'";
        User u = jc.ConnectionMysql(sql);
        return u;
    }
    //通过Cookie中的phonenumber进行查询
    @Override
    public User checkLoginDao(String phonenumber) {
        //链接Sql语句进行查询
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "select * from user where phonenumber = '"+phonenumber+"'";
        User u = jc.ConnectionMysql(sql);
        System.out.println(u);
        return u;
    }

    @Override
    public User checkLoginDaoResetpassword(String phonenumber, String username) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "select * from user where phonenumber = '"+phonenumber+"' and username ='"+username+"'";
        User u = jc.ConnectionMysql(sql);
        System.out.println(u);
        return  u;
    }

    @Override
    public boolean checkResetPassword(String phonenumber, String password) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "update user set password = '"+password+"' where phonenumber = '"+phonenumber+"'";
        boolean bool = jc.ConnectionUpdatePassword(sql);
        return bool;
    }
}
