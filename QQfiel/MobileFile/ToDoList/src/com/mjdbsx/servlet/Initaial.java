package com.mjdbsx.servlet;

import com.mjdbsx.service.LoginService;
import com.mjdbsx.serviceimpl.LoginServiceImpl;
import com.mjdbsx.domain.User;
import com.mjdbsx.token.jedis;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Initaial")
public class Initaial extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        LoginService ls = new LoginServiceImpl();
        JSONObject object = new JSONObject();
        String key = req.getParameter("key");
        String token =req.getParameter("token");
        jedis jedis = new jedis();
        boolean bool = jedis.select(key,token);
        if(bool==true){
            User u = ls.checkLoginService(key);
            HttpSession hs = req.getSession();
            hs.removeAttribute("user");
            hs.setAttribute("user",u);
        }
        object.put("token",bool);
        out.println(object);
    }
}
