package com.mjdbsx.daoimpl;

import com.mjdbsx.dao.JdbcConnection;
import com.mjdbsx.dao.RegisterDao;

public class RegisterDaoImpl implements RegisterDao {
    @Override
    public boolean insertUser(String phonenumber, String password, String username) {
        JdbcConnection jc = new JdbcConnectionImpl();
        //INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
        String sql = "insert into user(phonenumber,password,username) values('"+phonenumber+"','"+password+"','"+username+"')";
        boolean bool = jc.ConnectionAddUser(sql);
        return bool;
    }

    @Override
    public int seletUserNumber(String phonenumber) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "select * from user where phonenumber = '"+phonenumber+"'";
        System.out.println(sql);
        int number = jc.ConnectionSelectUser(sql);
        System.out.println(number);
        return number;
    }
}
