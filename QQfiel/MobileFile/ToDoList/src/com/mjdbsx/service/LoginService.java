package com.mjdbsx.service;

import com.mjdbsx.domain.User;

public interface LoginService {
    User checkLoginService(String phonenumber,String password);
    User checkLoginService(String uid);
    User checkLoginServicephoneusername(String phonenumber,String username);
    boolean checkLoginDaoResetpasswordImpl (String  phonenumber,String password);
}