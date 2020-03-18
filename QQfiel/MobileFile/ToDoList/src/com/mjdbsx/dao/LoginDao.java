package com.mjdbsx.dao;

import com.mjdbsx.domain.User;

public interface LoginDao {
    //登录信息校验
    User checkLoginDao(String phonenumber,String password);
    //Cookie通过phonenumber三天免登录校验
    User checkLoginDao(String phonenumber);
    User checkLoginDaoResetpassword(String phonenumber,String username);
    boolean checkResetPassword(String phonenumber,String password);
}
