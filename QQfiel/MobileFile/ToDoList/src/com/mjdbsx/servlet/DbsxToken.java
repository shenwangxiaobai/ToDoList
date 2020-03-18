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

public class DbsxToken extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        String choose = req.getParameter("choose");
        String dbsxid = req.getParameter("dbsxid");
        PrintWriter out =resp.getWriter();
        JSONObject ja = new JSONObject();
        boolean bool = false;
        DbsxService ds = new DbsxServiceImpl();
        if(choose == null){
            bool = ds.dbsxUpdateToken(dbsxid,1);
        }else {
            bool = ds.dbsxUpdateToken(dbsxid,0);
        }
        ja.put("success",bool);
        out.println(ja);
    }
}
