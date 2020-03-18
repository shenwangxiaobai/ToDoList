package com.mjdbsx.dao;

public interface RegisterDao {
    boolean insertUser(String phonenumber,String password,String username);
    int seletUserNumber(String phonenumber);
}
