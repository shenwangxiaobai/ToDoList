package com.mjdbsx.serviceimpl;

import com.mjdbsx.dao.LoginDao;
import com.mjdbsx.daoimpl.LoginDaoImpl;
import com.mjdbsx.service.LoginService;
import com.mjdbsx.domain.User;

public class LoginServiceImpl implements LoginService {
    LoginDao ld = new LoginDaoImpl();
    @Override
    public User checkLoginService(String phonenumber, String password) {
        return ld.checkLoginDao(phonenumber,password);
    }

    @Override
    public User checkLoginService(String phonenumber) {
        return ld.checkLoginDao(phonenumber);
    }

    @Override
    public User checkLoginServicephoneusername(String phonenumber, String username) {
        return ld.checkLoginDaoResetpassword(phonenumber, username);
    }

    @Override
    public boolean checkLoginDaoResetpasswordImpl(String phonenumber, String password) {
        return ld.checkResetPassword(phonenumber,password);
    }
}
