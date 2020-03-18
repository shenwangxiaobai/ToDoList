package com.mjdbsx.serviceimpl;

import com.mjdbsx.dao.RegisterDao;
import com.mjdbsx.daoimpl.RegisterDaoImpl;
import com.mjdbsx.service.RegisterService;
import com.mjdbsx.servlet.Register;

public class RegisterServiceImpl implements RegisterService {
    @Override
    public boolean insertuser(String phonenumber, String password, String username) {
        RegisterDao rd = new RegisterDaoImpl();
        return rd.insertUser(phonenumber,password,username);
    }

    @Override
    public int selectUser(String phonenumber) {
        RegisterDao rd = new RegisterDaoImpl();
        return  rd.seletUserNumber(phonenumber);
    }
}
