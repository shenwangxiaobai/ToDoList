package com.mjdbsx.method;

import java.util.HashMap;
import java.util.List;

public class layui extends HashMap <String,Object>{
    public static layui data(Integer count, List<?> data){
        layui r = new layui();
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", count);
        r.put("data", data);
        System.out.println(r);
        return r;
    }
}