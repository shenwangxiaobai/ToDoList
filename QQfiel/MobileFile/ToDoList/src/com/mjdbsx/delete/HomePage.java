package com.mjdbsx.delete;

import com.mjdbsx.domain.Dbsx;
import com.mjdbsx.domain.Tag;
import com.mjdbsx.service.DbsxService;
import com.mjdbsx.service.TagService;
import com.mjdbsx.serviceimpl.DbsxServiceImpl;
import com.mjdbsx.serviceimpl.TagServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class HomePage extends HttpServlet {
    @Override
    protected void  service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        //获取存储在session中的用户名
        String username = req.getSession().getAttribute("username").toString();
        //获取存储在session中的账号
        String phonenumber = req.getSession().getAttribute("phonenumber").toString();
        //链接service层
        TagService ts = new TagServiceImpl();
        //获取待办事项选择信息
        DbsxService ds = new DbsxServiceImpl();
        //如果未取得页面的待办事项的ID或转发的编辑或删除类型
        if (req.getParameter("dbsxid") == null||req.getParameter("type")==null) {
            System.out.println("无id或无类型");
        }
        else {
                String homepage_dbsxid = req.getParameter("dbsxid");
                String editOrdelete = req.getParameter("type");
                if (editOrdelete.equals("编辑")) {
                    Dbsx d = ds.checkOneDbsx(homepage_dbsxid);
                    req.setAttribute("edit_dbsx", d);
                    req.getRequestDispatcher("jsp/dbsxedit.jsp").forward(req, resp);
                }
                if (editOrdelete.equals("删除")) {
                    boolean bool = ds.dbsxDeleteService(homepage_dbsxid);
                    if(bool == true)
                    System.out.println("删除成功");
                    //req.getRequestDispatcher("homepage?dbsxid=null&type=null").forward(req,resp);
                }
        }
        //设置token信息
        int token = -1;
        //初始化session
        HttpSession hs = req.getSession();
        //初始化dbsx信息
        List<Dbsx> dbsx = null;
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
        String homepage_token = req.getParameter("token");
        if(homepage_token != null){
            if(homepage_token.equals("全部"))
                token = -1;
            if(homepage_token.equals("ToDo"))
                token = 0;
            if(homepage_token.equals("Token"))
                token = 1;
        }
        else {
            token = -1;
        }
        hs.setAttribute("token_number",homepage_token);
        String homepage_tagame = req.getParameter("tag_name");
        if(homepage_tagame == null){
            homepage_tagame = "默认";
        }
        hs.setAttribute("tag_name",homepage_tagame);
        System.out.println(homepage_tagame);
        System.out.println(req.getSession().getAttribute("token_number")+"&&"+req.getSession().getAttribute("tag_name"));
        if(token == 0) {
            dbsx = ds.checkDbsxService(username, 0, homepage_tagame);
        }
        if(token == 1) {
            dbsx = ds.checkDbsxService(username, 1, homepage_tagame);
        }
        if(token == -1) {
            dbsx = ds.checkDbsxService(username, 0, homepage_tagame);
            dbsx.addAll(ds.checkDbsxService(username, 1, homepage_tagame));
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
                db.setDbsxname(d.getDbsxname().toString());
                db.setToken(d.getToken());
                db.setTagname(d.getTagname().toString());
                db.setTime(d.getTime());
                db.setText(d.getText().toString());
                db.setRemark(d.getRemark().toString());
                //赋给数组
                dbsxinfo[j]=db;
                j++;
            }
        }
        hs.setAttribute("tagname_session",tagname);
        req.setAttribute("tagname",tagname);
        req.setAttribute("dbsxinfo",dbsxinfo);
        req.getRequestDispatcher("jsp/homepage.jsp").forward(req,resp);
    }
}
