package com.mjdbsx.servlet;

import com.mjdbsx.domain.User;
import com.mjdbsx.service.DbsxService;
import com.mjdbsx.serviceimpl.DbsxServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResetDbsx extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        //获取用户名
        PrintWriter out = resp.getWriter();
        User u = (User) req.getSession().getAttribute("user");
        String username = u.getUsername();
        //获取账号
        String phonenumber = u.getPhonenumber();
        //获取查询的待办事项的Id数据
        DbsxService ds = new DbsxServiceImpl();
        boolean bool = ds.resetDbsxTooday(username,"0");
        JSONObject object = new JSONObject();
        object.put("key",bool);
        out.println(object);
    }
}
