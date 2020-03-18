package com.mjdbsx.servlet;

import com.mjdbsx.domain.User;
import com.mjdbsx.service.LoginService;
import com.mjdbsx.serviceimpl.LoginServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class forgetpassword extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String phonenumber = req.getParameter("phonenumber");
        String username =  req.getParameter("username");
        String type = req.getParameter("editorsave");
        if(type.equals("edit")){
            JSONObject editinfo = new JSONObject();
            LoginService ls = new LoginServiceImpl();
            User u = ls.checkLoginServicephoneusername(phonenumber,username);
            if(u!=null){
                editinfo.put("editinfo","gosave");
            }
            else {
                editinfo.put("editinfo","nouser");
            }
            out.println(editinfo);
        }
        else if(type.equals("save")){
            String password = req.getParameter("password");
            JSONObject editpassword = new JSONObject();
            LoginService ls = new LoginServiceImpl();
            boolean bool = ls.checkLoginDaoResetpasswordImpl(phonenumber,password);
            if(bool==true){
                editpassword.put("success","true");
            }
            else {
                editpassword.put("success","false");
            }
            out.println(editpassword);
        }
    }
}
