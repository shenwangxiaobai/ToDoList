package com.mjdbsx.servlet;

import com.mjdbsx.service.DbsxService;
import com.mjdbsx.serviceimpl.DbsxServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class deleteDbsx extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        DbsxService ds = new DbsxServiceImpl();
        String dbsxid = req.getParameter("dbsxid");
        boolean bool = ds.dbsxDeleteService(dbsxid);
        JSONObject object = new JSONObject();
        System.out.println(bool);
        object.put("delete",bool);
        out.println(object);
    }
}
