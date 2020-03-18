package com.mjdbsx.servlet;

import com.mjdbsx.domain.Dbsx;
import com.mjdbsx.domain.User;
import com.mjdbsx.service.DbsxService;
import com.mjdbsx.serviceimpl.DbsxServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ChooseDay extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        DbsxService ds = new DbsxServiceImpl();
        //获取存储在session中的用户名
        User u = (User) req.getSession().getAttribute("user");
        String username = u.getUsername();
        //获取账号
        String phonenumber = u.getPhonenumber();
        String a = req.getParameter("today");
        String y_m_d = req.getParameter("y_m_d");
        Timestamp timestamp01 = null;
        Timestamp timestamp02 = null;
        //获取当前时间
        Dbsx dbsx[] = null;
        List<Dbsx> dbsxToday = null;
        List<Dbsx> dbsxToday2 = null;
            String time01 = y_m_d + " 00:00:00";
            String time02 = y_m_d + " 23:59:59";
            timestamp01 = Timestamp.valueOf(time01);
            timestamp02 = Timestamp.valueOf(time02);
            Calendar calendar = Calendar.getInstance();
            //获取周几
            Date today = new Date();
            today.setTime(timestamp02.getTime());
            calendar.setTime(today);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            String weekinfo = "";
            if(week==1){
                weekinfo = "7";
            }else {
                weekinfo = ""+(week-1);
            }
            //当前时间
            //获取当前时间以后且统一周期的待办事项
            dbsxToday = ds.checkDbsxToday(username,timestamp01,timestamp02);
            dbsxToday2 = ds.checkDbsxToday2(username,timestamp02,timestamp02,weekinfo);
            dbsxToday.addAll(dbsxToday2);
            dbsx =new Dbsx[dbsxToday.size()];
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
