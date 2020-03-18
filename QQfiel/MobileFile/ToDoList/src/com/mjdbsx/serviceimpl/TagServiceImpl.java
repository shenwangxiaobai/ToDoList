package com.mjdbsx.serviceimpl;

import com.mjdbsx.dao.TagDao;
import com.mjdbsx.daoimpl.TagDaoImpl;
import com.mjdbsx.domain.Tag;
import com.mjdbsx.service.TagService;

import java.util.List;

public class TagServiceImpl implements TagService {
    @Override
    public List<Tag> checkTagService(String phonenumber) {
        TagDao ts = new TagDaoImpl();
        return ts.checkTagDao(phonenumber);
    }
    public boolean checkUpdateTagService(String phonenumber,String tagname,String newtagname){
        TagDao ts = new TagDaoImpl();
        return ts.checkUpdateTagDao(phonenumber,tagname,newtagname);
    }

    @Override
    public boolean addtag(String phonenumber, String tagname) {
        TagDao ts = new TagDaoImpl();
        return ts.addtag(phonenumber,tagname);
    }

    @Override
    public boolean deleteTag(String phonenumber, String tagname) {
        TagDao ts = new TagDaoImpl();
       return ts.deleteTag(phonenumber,tagname);
    }
}
