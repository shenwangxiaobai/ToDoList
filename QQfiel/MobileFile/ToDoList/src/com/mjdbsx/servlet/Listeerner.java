package com.mjdbsx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

import com.mjdbsx.domain.Dbsx;
import com.mjdbsx.domain.User;
import com.mjdbsx.service.DbsxService;
import com.mjdbsx.serviceimpl.DbsxServiceImpl;
import net.sf.json.JSONArray;

public class Listeerner extends HttpServlet {
    public Timer timer = null;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //获取存储在session中的用户名
        User u = (User) req.getSession().getAttribute("user");
        String username = u.getUsername();
        //获取账号
        String phonenumber = u.getPhonenumber();
        DbsxService ds = new DbsxServiceImpl();
            //获取今日日期
        LocalDate date = LocalDate.now();
        System.out.println(date);
        String time01 = date.toString() + " 00:00:00";
        String time02 = date.toString() + " 23:59:59";
        Timestamp timestamp01 = Timestamp.valueOf(time01);
        Timestamp timestamp02 = Timestamp.valueOf(time02);
        Calendar calendar = Calendar.getInstance();
        Date today = new Date();
        calendar.setTime(today);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        String weekinfo = "";
        if(week==1){
            weekinfo = "7";
        }else {
            weekinfo = ""+(week-1);
        }
        List<Dbsx> dbsxToday = ds.checkDbsxToday(username,timestamp01,timestamp02);
        dbsxToday.addAll( ds.checkDbsxToday2(username,timestamp02,timestamp02,weekinfo));
        Dbsx[] dbsx = new Dbsx[dbsxToday.size()];
        int j = 0;
        for(Dbsx d:dbsxToday) {
            if (d != null) {
                Dbsx db = new Dbsx();
                //注入数据
                db.setDbsxid(d.getDbsxid());
                db.setDbsxname(d.getDbsxname());
                db.setToken(d.getToken());
                db.setTagname(d.getTagname());
                db.setTime(d.getTime());
                db.setText(d.getText());
                db.setRemark(d.getRemark());
                db.setWeek(d.getWeek());
                //赋给数组
                dbsx[j] = db;
                j++;
            }
        }
        JSONArray jsonArray = JSONArray.fromArray(dbsx);
        out.println(jsonArray);
    }
}

