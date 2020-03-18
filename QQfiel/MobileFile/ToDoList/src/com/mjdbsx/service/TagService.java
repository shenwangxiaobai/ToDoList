package com.mjdbsx.service;

import com.mjdbsx.domain.Tag;

import java.util.List;

public interface TagService {
    List<Tag> checkTagService(String phonenumber);
    boolean checkUpdateTagService(String phonenumber,String tagname,String newtagname);
    boolean addtag(String phonenumber,String tagname);
    boolean deleteTag(String phonenumber,String tagname);
}
