package com.mjdbsx.servlet;

import com.mjdbsx.service.RegisterService;
import com.mjdbsx.service.TagService;
import com.mjdbsx.serviceimpl.RegisterServiceImpl;
import com.mjdbsx.serviceimpl.TagServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        String phonenumber = req.getParameter("phonenumber");
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        String selectuser = req.getParameter("selectuser");
        System.out.println(selectuser+"+++++"+password+"====="+username);
        RegisterService rs = new RegisterServiceImpl();
        TagService ts = new TagServiceImpl();
        if(selectuser!=null) {
            if (selectuser.equals("selectuser")) {
                PrintWriter out = resp.getWriter();
                int selectusernumber = rs.selectUser(phonenumber);
                String uu = "" + selectusernumber;
                JSONObject number = new JSONObject();
                number.put("number", selectusernumber);
                out.println(number);
            }
        }
        else {
            boolean bool1 = rs.insertuser(phonenumber,password,username);
            boolean bool2 = ts.addtag(phonenumber,"默认");
            System.out.println(bool1+"-----"+bool2);
            if(bool1 == true&&bool2 == true) {
                resp.sendRedirect("./jsp/login.jsp");
            }else {
                resp.sendRedirect("./jsp.regist .jsp");
            }
        }
    }
}