package com.mjdbsx.servlet;

import com.mjdbsx.domain.DBSX2;
import com.mjdbsx.domain.User;
import com.mjdbsx.service.RootService;
import com.mjdbsx.serviceimpl.RootServerImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Root extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        //输出
        PrintWriter out = resp.getWriter();
        String choose = req.getParameter("choose");
        RootService rs = new RootServerImpl();
        JSONObject jsonObject = new JSONObject();
        JSONObject object = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        int page = 0;
        int limit = 10;
        if(choose.equals("selectuser")){
            String type = req.getParameter("type");
            page = Integer.parseInt(req.getParameter("page"));
            limit = Integer.parseInt(req.getParameter("limit"));
            List<User> userList = rs.selectUsers(type,page,limit);
            int count = rs.count();
            jsonObject.put("count",count);
            jsonObject.put("data",JSONArray.fromCollection(userList));
            out.println(jsonObject.toString());
        }else if(choose.equals("selectdbsxs")){
            page = Integer.parseInt(req.getParameter("page"));
            limit = Integer.parseInt(req.getParameter("limit"));
            String type = req.getParameter("type");
            List<DBSX2> dbsxList = rs.selecctDbsx(type,page,limit);
            int count = rs.total();
            jsonObject.put("count",count);
            jsonObject.put("data",JSONArray.fromCollection(dbsxList));
            out.println(jsonObject.toString());
        }else if(choose.equals("deleteuser")){
            String username = req.getParameter("username");
            String phonenumber = req.getParameter("phonenumber");
            boolean bool = rs.deletUser(phonenumber,username);
            object.put("key",true);
            out.println(object);
        }else if(choose.equals("deletedbsx")){
            String dbsxid = req.getParameter("dbsxid");
            boolean bool = rs.deletDbsx(dbsxid);
            object.put("key",bool);
            out.println(object);
        }
    }
}
