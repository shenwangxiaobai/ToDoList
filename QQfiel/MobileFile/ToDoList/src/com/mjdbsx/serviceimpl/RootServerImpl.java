package com.mjdbsx.serviceimpl;

import com.mjdbsx.dao.RootDao;
import com.mjdbsx.daoimpl.RootDaoImpl;
import com.mjdbsx.domain.DBSX2;
import com.mjdbsx.domain.User;
import com.mjdbsx.service.RootService;

import java.util.List;

public class RootServerImpl implements RootService {
    RootDao rd = new RootDaoImpl();
    @Override
    public List<DBSX2> selecctDbsx(String type,int page,int limit) {
        return rd.selecctDbsx(type,(page-1)*limit,limit);
    }

    @Override
    public List<User> selectUsers(String type,int page,int limit) {
        return rd.selectUsers(type,(page-1)*limit                                                                                         ,limit);
    }

    @Override
    public boolean deletDbsx(String dbsxid) {
        return rd.deletDbsx(dbsxid);
    }

    @Override
    public boolean deletUser(String phonenumber,String username) {
        return rd.deletUser(phonenumber,username);
    }

    @Override
    public int total() {
        return rd.total();
    }

    @Override
    public int count() {
        return rd.count();
    }
}
