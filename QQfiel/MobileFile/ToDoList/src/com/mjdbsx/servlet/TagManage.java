package com.mjdbsx.servlet;

import com.mjdbsx.domain.Dbsx;
import com.mjdbsx.domain.Tag;
import com.mjdbsx.domain.User;
import com.mjdbsx.service.DbsxService;
import com.mjdbsx.service.TagService;
import com.mjdbsx.serviceimpl.DbsxServiceImpl;
import com.mjdbsx.serviceimpl.TagServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TagManage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");
        //设置相应格式
        resp.setContentType("text/html;charset=utf-8");
        boolean bool = false;
        String initial = req.getParameter("initial");
        User u = (User) req.getSession().getAttribute("user");
        String username = u.getUsername();
        //获取账号
        String phonenumber = u.getPhonenumber();
        TagService ts = new TagServiceImpl();
        PrintWriter out = resp.getWriter();
        if(initial.equals("initial")){

        }
        else if(initial.equals("edittag")){
            String tagname =  req.getParameter("tagname").toString();
            String newtagname = req.getParameter("newtagname").toString();
            bool = ts.checkUpdateTagService(phonenumber,tagname,newtagname);
            DbsxService ds = new DbsxServiceImpl();
            ds.dbsxupdateService(username,tagname,newtagname);
        }
        else if(initial.equals("deletetag")){
            String tagname =  req.getParameter("tagname").toString();
            DbsxService ds = new DbsxServiceImpl();
            ds.dbsxupdateService(username,tagname,"默认");
            ts.deleteTag(phonenumber,tagname);
        }
        else  if(initial.equals("addtagname")){
            String tagname =  req.getParameter("newtagname");
            ts.addtag(phonenumber,tagname);
        }
        List<Tag> tagList = ts.checkTagService(phonenumber);
        String[] taginfo = null;
        if(tagList!=null){
            taginfo = new String[tagList.size()];
            int j = 0;
            for(Tag tl:tagList){
                taginfo[j] = tl.getTagname();
                j++;
            }
        }
        JSONArray data = JSONArray.fromArray(taginfo);
        out.println(data);
    }
}
