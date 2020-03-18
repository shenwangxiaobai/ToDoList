package com.mjdbsx.servlet;

import com.mjdbsx.domain.Dbsx;
import com.mjdbsx.domain.User;
import com.mjdbsx.service.DbsxService;
import com.mjdbsx.serviceimpl.DbsxServiceImpl;
import com.mjdbsx.method.method;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class today_month extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        DbsxService ds = new DbsxServiceImpl();
        //获取存储在session中的用户名
        User u = (User) req.getSession().getAttribute("user");
        String username = u.getUsername();
        //获取账号
        String phonenumber = u.getPhonenumber();
        String a = req.getParameter("today");
        String b =req.getParameter("id");
        String c = req.getParameter("token");
        String selecttime = req.getParameter("selecttime");
        Timestamp timestamp01 = null;
        Timestamp timestamp02 = null;
        List<Dbsx> dbsxToday = null;
        //获取当前时间
        Dbsx dbsx2[] = null;
        List<Dbsx> dbsxToday2 = null;
        LocalDate date = LocalDate.now();
        if(a.equals("今日待办")||a.equals("查询月份")||b!=null){
            if(b!=null){
                if(c!=null){
                    ds.dbsxUpdateToken(b,0);
                }else{
                    ds.dbsxUpdateToken(b,1);
                }
            }
            PrintWriter out = resp.getWriter();
            String time01 = null;
            String time02 = null;
            if(a.equals("今日待办")) {
                time01 = date.toString() + " 00:00:00";
                time02 = date.toString() + " 23:59:59";
                timestamp01 = Timestamp.valueOf(time01);
                timestamp02 = Timestamp.valueOf(time02);
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
                //当前时间
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                Timestamp settimestamp = Timestamp.valueOf(df.format(new Date()));
                Timestamp settime = new Timestamp(settimestamp.getTime());
                //获取当前时间以后且同一周期的待办事项
                dbsxToday = ds.checkDbsxToday(username,timestamp01,timestamp02);
                dbsxToday2 = ds.checkDbsxToday2(username,timestamp02,timestamp02,weekinfo);
            }
            if(a.equals("查询月份")) {
                method me = new method();
                Timestamp[] dates = me.startAndEnd(selecttime);
                timestamp01 = dates[0];
                timestamp02 = dates[1];
                dbsxToday = ds.checkDbsxToday(username, timestamp01, timestamp02);
                dbsxToday2 = ds.checkDbsxToday2(username);
                System.out.println(dbsxToday.size());
            }
            Dbsx dbsx[] = null;
            if(dbsxToday2!=null){
                dbsxToday.addAll(dbsxToday2);
            }
            if(dbsxToday!=null){
                dbsx = new Dbsx[dbsxToday.size()];
            }
            int j = 0;
            for(Dbsx d:dbsxToday){
                if(d!=null) {
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
                    dbsx[j]=db;
                    j++;
                }
            }
            JSONArray data = JSONArray.fromArray(dbsx);
            out.println(data);
        }
    }
}
