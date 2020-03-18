package com.mjdbsx.servlet;

import com.mjdbsx.domain.Dbsx;
import com.mjdbsx.domain.Tag;
import com.mjdbsx.domain.User;
import com.mjdbsx.service.DbsxService;
import com.mjdbsx.service.TagService;
import com.mjdbsx.serviceimpl.DbsxServiceImpl;
import com.mjdbsx.serviceimpl.TagServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HomePage2 extends HttpServlet {
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
        String choose = req.getParameter("choose");
        //链接service层
        TagService ts = new TagServiceImpl();
        //获取待办事项选择信息
        DbsxService ds = new DbsxServiceImpl();
        //获取Tag信息
        List<Tag> tag = ts.checkTagService(phonenumber);
        //将Tag信息添加为数组类型
        String tagname[] = null;
        //初始化待办事项
        int i = 0;
        tagname = new String[tag.size()];
        //加载Tag数据到数组中
        for(Tag t:tag){
            tagname[i] = t.getTagname();
            i++;
        }
        JSONArray jsonArray = JSONArray.fromArray(tagname);
        if(choose.equals("initial")) {
            out.println(jsonArray);
        }else if(choose.equals("select")){
            String token = req.getParameter("token");
            String tag_name = req.getParameter("tagname");
            List<Dbsx> dbsx = null;
            if(tag_name.equals("全部")){
                if (token.equals("ToDo")) {
                    dbsx = ds.checkDbsxService(username, 0);
                }else if (token.equals("Done")) {
                    dbsx = ds.checkDbsxService(username, 1);
                } else {
                    dbsx = ds.checkDbsxService(username, 0);
                    dbsx.addAll(ds.checkDbsxService(username, 1));
                }
            }else {
                if (token.equals("ToDo")) {
                    dbsx = ds.checkDbsxService(username, 0, tag_name);
                }else if (token.equals("Done")) {
                    dbsx = ds.checkDbsxService(username, 1, tag_name);
                }else {
                    dbsx = ds.checkDbsxService(username, 0, tag_name);
                    dbsx.addAll(ds.checkDbsxService(username, 1, tag_name));
                }
            }
            //加载待办事项数据到数组中
            Dbsx dbsxinfo[] = null;
            if(dbsx!=null){
                dbsxinfo = new Dbsx[dbsx.size()];
            }
            int j = 0;
            for(Dbsx d:dbsx){
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
                    dbsxinfo[j]=db;
                    j++;
                }
            }
            JSONArray selectdbsx = JSONArray.fromArray(dbsxinfo);
            out.println(selectdbsx);
        }

    }
}
