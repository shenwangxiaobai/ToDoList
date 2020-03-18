package com.mjdbsx.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TimerTask;

public class Test extends TimerTask{
    @Override
    public void run() {
        System.out.println("hhhhhhh");
    }
    public void run(String phonenumber){

    }
}
