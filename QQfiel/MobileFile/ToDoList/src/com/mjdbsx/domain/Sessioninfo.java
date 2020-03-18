package com.mjdbsx.domain;

public class Sessioninfo {
    private String phonenumber;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "Session{" +
                "phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
