package com.mjdbsx.daoimpl;

import com.mjdbsx.dao.JdbcConnection;
import com.mjdbsx.dao.TagDao;
import com.mjdbsx.domain.Tag;

import java.util.List;

public class TagDaoImpl implements TagDao {
    @Override
    public List<Tag> checkTagDao(String phonenumber) {
        //定义查询tag的Sql语句
        String sql = "select tagname from tag where phonenumber = '"+phonenumber+"'";
        JdbcConnection jc = new JdbcConnectionImpl();
        //获取查询结果
        List<Tag> tag = jc.ConnectionTag(sql);
    return tag;
    }

    @Override
    public boolean checkUpdateTagDao(String phonenumber, String tagname,String newtagname) {
        //定义查询tag的Sql语句update tag set tagname = '快乐' where tagname = '工作' and phonenumber ='1000';
        String sql = "update tag set tagname = '" + newtagname + "' where tagname = '" + tagname + "' and phonenumber ='" + phonenumber + "'";
        JdbcConnection jc = new JdbcConnectionImpl();
        //获取查询结果
        boolean tag = jc.ConnectionDbsxTagUpdate(sql);
        return tag;
    }

    @Override
    public boolean addtag(String phonenumber, String tagname) {
        //INSERT INTO 表名称 VALUES (值1, 值2,....)
        String sql = "insert into tag(phonenumber,tagname) values ('"+phonenumber+"','"+tagname+"') ";
        JdbcConnection jc = new JdbcConnectionImpl();
        boolean bool = jc.ConnectionAddTag(sql);
        System.out.println(sql);
        return bool;
    }

    @Override
    public boolean deleteTag(String phonenumber, String tagname) {
        JdbcConnection jc = new JdbcConnectionImpl();
        String sql = "delete from tag where phonenumber = '"+phonenumber+"' and tagname = '"+tagname+"'";
        System.out.println(sql);
        return jc.ConnectionDeleteTag(sql);
    }
}
