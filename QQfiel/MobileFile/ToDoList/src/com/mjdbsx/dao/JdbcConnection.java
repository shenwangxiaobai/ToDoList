package com.mjdbsx.dao;

import com.mjdbsx.domain.DBSX2;
import com.mjdbsx.domain.Dbsx;
import com.mjdbsx.domain.Tag;
import com.mjdbsx.domain.User;

import javax.swing.event.ListDataEvent;
import java.util.List;

public interface JdbcConnection {
    //链接数据库,返回用户
    User ConnectionMysql(String sql);
    List<Tag> ConnectionTag(String sql);
    List<Dbsx> ConnectionDbsx(String sql);
    List<String > ConnectionDbsxId(String sql);
    boolean Connectionadddbsx(String sql);
    Dbsx ConnectionOneDbsx(String sql);
    boolean ConnectionUpdateDbsx(String sql);
    boolean ConnectionDeleteDbsx(String sql);
    boolean ConnectionDbsxUpdateToken(String sql);
    boolean ConnectionDbsxTagUpdate(String sql);
    boolean ConnectionAddTag(String sql);
    boolean ConnectionDeleteTag(String sql);
    boolean ConnectionAddUser(String sql);
    int ConnectionSelectUser(String sql);
    boolean ConnectionUpdatePassword(String sql);
    List<User> connectionSelectAllUser(String sql);
    boolean ConnectionDeleteUser(String sql);
    List<DBSX2> ConnectionDbsx2(String sql);
    int ConnectionAll(String sql);
}

