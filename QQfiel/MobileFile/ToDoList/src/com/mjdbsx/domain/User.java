package com.mjdbsx.domain;

//定义用户信息
public class User {
    //手机号-->登录注册账号
    private String phonenumber;
    //用户昵称
    private String username;
    //用户密码
    private String password;
    //getter+setter方法
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //tostring方法重写

    @Override
    public String toString() {
        return "User{" +
                "phonenumber=" + phonenumber +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
