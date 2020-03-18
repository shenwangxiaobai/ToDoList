package com.mjdbsx.service;

public interface RegisterService {
    boolean insertuser(String phonenumber,String password,String username);
    int selectUser(String phonenumber);
}
