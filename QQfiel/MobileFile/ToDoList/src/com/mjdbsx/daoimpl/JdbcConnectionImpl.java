package com.mjdbsx.daoimpl;

import com.mjdbsx.dao.JdbcConnection;
import com.mjdbsx.domain.DBSX2;
import com.mjdbsx.domain.Dbsx;
import com.mjdbsx.domain.Tag;
import com.mjdbsx.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mjdbsx.method.method;

public class JdbcConnectionImpl implements JdbcConnection {
    //连接数据库，获取用户信息
    @Override
    public User ConnectionMysql(String sql) {
        method me= new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            //初始化
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setPhonenumber(rs.getString("phonenumber"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
            }
            rs.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        me.close(conn);
        return u;
    }
    //获取Tag信息
    @Override
    public List<Tag> ConnectionTag(String sql) {
        //初始化
        method me = new method();
        Connection conn = me.open();
        //声明数据存储对象
        List<Tag> tag = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            //打开数据库
            ps = conn.prepareStatement(sql);
            //执行
            rs = ps.executeQuery();
            //遍历执行结果
            while (rs.next()) {
                //定义数据类型
                Tag t = new Tag();
                //获取数据
                t.setTagname(rs.getString("tagname"));
                //加载数据
                tag.add(t);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return tag;
    }
    //获取待办事项
    @Override
    public List<Dbsx> ConnectionDbsx(String sql) {
        //初始化
        method me = new method();
        Connection conn = me.open();
        List<Dbsx> dbsx = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            //创建SQL命令
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery();
            //遍历执行结果
            while (rs.next()) {
                //定义数据类型
                Dbsx d = new Dbsx();
                //获取数据
                d.setDbsxid(rs.getString("dbsxid"));
                d.setDbsxname(rs.getString("dbsxname"));
                d.setTagname(rs.getString("tagname"));
                d.setTime(rs.getTimestamp("time"));
                d.setText(rs.getString("text"));
                d.setRemark(rs.getString("remark"));
                d.setToken(rs.getInt("token"));
                d.setWeek(rs.getString("week"));
                //加载数据
                dbsx.add(d);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return dbsx;
    }
    //获取dbsiid
    @Override
    public List<String> ConnectionDbsxId(String sql) {
        //初始化
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明数据存储对象
        List<String> dbsxid = new ArrayList<>();
        try {
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            //遍历执行结果
            while (rs.next()) {
                String dbsx_id = rs.getString("dbsxid");
                //加载数据
                dbsxid.add(dbsx_id);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return dbsxid;
    }
    //新增待办事项
    @Override
    public boolean Connectionadddbsx(String sql) {
        //初始化
        boolean bool = false;
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        //声明数据存储对象
        try {
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            int b = ps.executeUpdate();
            if(b>0){
                bool = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return bool;
    }
    //更新待办事项
    @Override
    public boolean ConnectionUpdateDbsx(String sql) {
        boolean bool = false;
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        //声明数据存储对象
        try {
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            int b = ps.executeUpdate();
            if(b>0){
                bool = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return bool;
    }

    @Override
    public Dbsx ConnectionOneDbsx(String sql) {
        Dbsx d = new Dbsx();
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                d.setDbsxid(rs.getString("dbsxid"));
                d.setDbsxname(rs.getString("dbsxname"));
                d.setTagname(rs.getString("tagname"));
                d.setTime(rs.getTimestamp("time"));
                d.setText(rs.getString("text"));
                d.setRemark(rs.getString("remark"));
                d.setWeek(rs.getString("week"));
            }else {
                d = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return d;
    }

    @Override
    public boolean ConnectionDeleteDbsx(String sql) {
        boolean bool = false;
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        //声明数据存储对象
        try {
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            int b = ps.executeUpdate();
            if (b > 0) {
                bool = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return bool;
    }

    @Override
    public boolean ConnectionDbsxUpdateToken(String sql) {
        boolean bool = false;
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        //声明数据存储对象
        try {
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            int b = ps.executeUpdate();
            if (b > 0) {
                bool = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return bool;
    }

    @Override
    public boolean ConnectionDbsxTagUpdate(String sql) {
        boolean bool = false;
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        //声明数据存储对象
        try {
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            int b = ps.executeUpdate();
            if (b > 0) {
                bool = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return bool;
    }

    @Override
    public boolean ConnectionAddTag(String sql) {
        boolean bool = false;
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        //声明数据存储对象
        try {
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            int b = ps.executeUpdate();
            if (b > 0) {
                bool = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return bool;
    }

    @Override
    public boolean ConnectionDeleteTag(String sql) {
        boolean bool = false;
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        //声明数据存储对象
        try {
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            int b = ps.executeUpdate();
            if (b > 0) {
                bool = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return bool;
    }

    @Override
    public boolean ConnectionAddUser(String sql) {
        boolean bool = false;
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        //声明数据存储对象
        try {
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            int b = ps.executeUpdate();
            if (b > 0) {
                bool = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return bool;
    }

    @Override
    public int ConnectionSelectUser(String sql) {
        int number = 0;
        method me= new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //初始化
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                number = 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        me.close(conn);
        return number;
    }

    @Override
    public boolean ConnectionUpdatePassword(String sql) {
        boolean bool = false;
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        //声明数据存储对象
        try {
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            int b = ps.executeUpdate();
            if (b > 0) {
                bool = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return bool;
    }

    @Override
    public List<User> connectionSelectAllUser(String sql) {
        //初始化
        method me = new method();
        Connection conn = me.open();
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            //创建SQL命令
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            //遍历执行结果
            while (rs.next()) {
                //定义数据类型
               User u = new User();
                //获取数据
                u.setUsername(rs.getString("username"));
                u.setPhonenumber(rs.getString("phonenumber"));
                //加载数据
                users.add(u);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return users;
    }

    @Override
    public boolean ConnectionDeleteUser(String sql) {
        boolean bool = false;
        method me = new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        //声明数据存储对象
        try {
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            int b = ps.executeUpdate();
            if (b > 0) {
                bool = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return bool;
    }
    public List<DBSX2> ConnectionDbsx2(String sql) {
        //初始化
        method me = new method();
        Connection conn = me.open();
        List<DBSX2> dbsx2s = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            //创建SQL命令
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery();
            //遍历执行结果
            while (rs.next()) {
                //定义数据类型
                DBSX2 d = new DBSX2();
                //获取数据
                d.setDbsxid(rs.getString("dbsxid"));
                d.setDbsxname(rs.getString("dbsxname"));
                d.setUsername(rs.getString("username"));
                //加载数据
                dbsx2s.add(d);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.close(conn);
        return dbsx2s;
    }

    @Override
    public int ConnectionAll(String sql) {
        method me= new method();
        Connection conn = me.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            //初始化
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            System.out.println(count);
            rs.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        me.close(conn);
        return count;
    }
}


