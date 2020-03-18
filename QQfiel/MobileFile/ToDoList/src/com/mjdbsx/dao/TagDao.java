package com.mjdbsx.dao;

import com.mjdbsx.domain.Tag;

import java.util.List;

public interface TagDao {
    List<Tag> checkTagDao(String phonenumber);
    boolean checkUpdateTagDao(String phonenumber,String tagname,String newTagname);
    boolean addtag(String phonenumber,String tagname);
    boolean deleteTag(String phonenumber,String tagname);
}
