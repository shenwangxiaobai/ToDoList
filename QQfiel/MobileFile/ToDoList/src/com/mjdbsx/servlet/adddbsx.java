package com.mjdbsx.servlet;

import com.mjdbsx.domain.Tag;
import com.mjdbsx.domain.User;
import com.mjdbsx.service.DbsxService;
import com.mjdbsx.service.TagService;
import com.mjdbsx.serviceimpl.DbsxServiceImpl;
import com.mjdbsx.method.method;
import com.mjdbsx.serviceimpl.TagServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
//添加待办事项
public class adddbsx extends HttpServlet {
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
        List<String> dsid = ds.checkDbsxIdService(username);
        String[] dbsxidinfo;
        //加载数据到数据库
        if (dsid.size() > 0) {
            int i = 0;
            dbsxidinfo = new String[dsid.size()];
            for (String dbsxid : dsid) {
                dbsxidinfo[i] = dbsxid;
                System.out.println(dbsxidinfo[i]);
                i++;
            }
        } else {
            dbsxidinfo = null;
        }
        //得到新增dbsxid
        String dbsxid = new method().addId(dbsxidinfo, phonenumber);
        //定义数据
        String dbsxname = req.getParameter("dbsxname");
        String text = req.getParameter("text");
        String tag_name = req.getParameter("tagname");
        String remark = req.getParameter("remark");
        String time02 = req.getParameter("time02");
        String week = req.getParameter("week");
        System.out.println("选择的时间"+week);
        int token = 0;
        //转换时间格式
        //获取当前年月日
        Calendar calendar = Calendar.getInstance();
        //获取月份
        String month = "";
        int monthinfo = calendar.get(Calendar.MONTH)+1;
        if(monthinfo<10){
            month = "0"+monthinfo;
        }else {
            month = ""+monthinfo;
        }
        //获取月份日期
        String day = "";
        if(calendar.get(Calendar.DAY_OF_MONTH)<10){
            day = "0"+calendar.get(Calendar.DAY_OF_MONTH);
        }else {
            day = ""+calendar.get(Calendar.DAY_OF_MONTH);
        }
        String time01 = calendar.get(Calendar.YEAR)+"-"+month+"-"+day;
        if(week.equals("0")){
            time01 = req.getParameter("time01");
        }
        Timestamp timestamp = Timestamp.valueOf(time01 + " " + time02 + ":00");
        Timestamp time = new Timestamp(timestamp.getTime());
        //当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Timestamp settimestamp = Timestamp.valueOf(df.format(new Date()));
        Timestamp settime = new Timestamp(settimestamp.getTime());
        JSONObject object = new JSONObject();
        if (dbsxname == null||dbsxname==""||text==null||text==""||tag_name==null||tag_name==""||remark==null||remark==""||time==null||settime==null) {
            object.put("key",false);
        } else {
            boolean bool = ds.dbsxAddService(dbsxid, dbsxname, token, username, tag_name, time, text, remark,settime,week);
            if (bool == true) {
                object.put("key",true);
            } else {
                object.put("key",false);
            }
        }
        out.println(object);
    }
}
