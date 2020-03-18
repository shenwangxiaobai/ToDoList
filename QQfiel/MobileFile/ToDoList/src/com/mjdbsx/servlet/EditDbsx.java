package com.mjdbsx.servlet;

import com.mjdbsx.domain.Dbsx;
import com.mjdbsx.domain.User;
import com.mjdbsx.service.DbsxService;
import com.mjdbsx.serviceimpl.DbsxServiceImpl;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class EditDbsx extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        DbsxService ds = new DbsxServiceImpl();
        //获取id
        User u = (User) req.getSession().getAttribute("user");
        String username = u.getUsername();
        //获取账号
        String phonenumber = u.getPhonenumber();
        String dbsxid = req.getParameter("dabsx_id");
        String dbsxxiugai = req.getParameter("dbsxxiugai");
        if(dbsxxiugai==null) {
            System.out.println(username + "--" + dbsxid);
            Dbsx dbsxone = new Dbsx();
            dbsxone = ds.checkOneDbsx(dbsxid);
            JSONObject object = new JSONObject();
            object.put("dbsxid", dbsxone.getDbsxid());
            object.put("dbsxname", dbsxone.getDbsxname());
            object.put("tagname", dbsxone.getTagname());
            object.put("remark", dbsxone.getRemark());
            object.put("text", dbsxone.getText());
            String time = dbsxone.getTime().toString();
            object.put("time", time);
            object.put("week",dbsxone.getWeek());
            out.println(object);
        }else {
            JSONObject object = new JSONObject();
            String dbsxname = req.getParameter("dbsxname");
            String tagname = req.getParameter("tagname");
            String date="";
            String time01 = req.getParameter("time01");
            System.out.println(time01);
            String text = req.getParameter("text");
            String remark = req.getParameter("remark");
            String week = req.getParameter("week");
            if(week.equals("0")){
                date = req.getParameter("date");
            }else {
                Calendar calendar = Calendar.getInstance();
                //获取月份
                String month = "";
                if(calendar.get(Calendar.MONTH)<10){
                    month = "0"+calendar.get(Calendar.MONTH);
                }else {
                    month = ""+calendar.get(Calendar.MONTH);
                }
                //获取月份日期
                String day = "";
                if(calendar.get(Calendar.DAY_OF_MONTH)<10){
                    day = "0"+calendar.get(Calendar.DAY_OF_MONTH);
                }else {
                    day = ""+calendar.get(Calendar.DAY_OF_MONTH);
                }
                 date = calendar.get(Calendar.YEAR)+"-"+month+"-"+day;
            }
            System.out.println(date);
            int token = 0;
            Timestamp time = Timestamp.valueOf(date + " " + time01 + ":00");
            boolean bool = ds.dbsxUpdateService(dbsxid, dbsxname, token, username, tagname, time, text, remark,week);

            if(bool==true){
                object.put("key",1);
            }else {
                object.put("key",0);
            }
            out.println(object);
        }
    }
}
