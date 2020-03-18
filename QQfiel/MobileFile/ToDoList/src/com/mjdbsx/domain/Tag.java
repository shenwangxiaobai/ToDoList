package com.mjdbsx.domain;

public class Tag {
    //分类标签名称
    private String tagname;
    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagname='" + tagname + '\'' +
                '}';
    }
}
