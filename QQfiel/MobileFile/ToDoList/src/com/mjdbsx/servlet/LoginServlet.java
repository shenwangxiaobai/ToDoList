package com.mjdbsx.servlet;

import com.mjdbsx.service.LoginService;
import com.mjdbsx.domain.User;
import com.mjdbsx.serviceimpl.LoginServiceImpl;
import com.mjdbsx.token.encode;
import com.mjdbsx.token.jedis;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        //获取账号
        String phonenumber = req.getParameter("phonenumber");
        //获取密码
        String password = req.getParameter("password");
        //加载数据
        PrintWriter out = resp.getWriter();
        JSONObject login = new JSONObject();
        LoginService ls = new LoginServiceImpl();
        //与数据库进行比对，返回用户信息
        User u = ls.checkLoginService(phonenumber,password);
        //打印用户信息
        if(u!=null) {
            if(u.getPhonenumber().equals("0000")){
                login.put("login","Root");
            }
            else {
                encode encode = new encode();
                String token = encode.getResult(phonenumber + "_" + password);
                jedis jedis = new jedis();
                jedis.removeKey(phonenumber);
                jedis.setKey(phonenumber, token, 60 * 60);
                login.put("login", token);
                HttpSession hs = req.getSession();
                hs.removeAttribute("user");
                hs.setAttribute("user", u);
            }
        }
        else {
            //请求转发
            login.put("login","");
        }
        out.println(login);
    }
}
