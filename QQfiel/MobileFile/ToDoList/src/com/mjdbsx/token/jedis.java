package com.mjdbsx.token;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class jedis {
    private JedisPool jedisPool;
    Jedis jedis = new Jedis("localhost");
    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
    public String  getKey(String key) {
        //连接本地的 Redis 服务
        return jedis.get(key);
    }
    public  void setKey(String key,String value,int expireSecond){
        jedis.set(key,value,"NX", "EX",expireSecond);
    }
    public  void removeKey(String key){
        jedis.del(key);
    }
    //清空
    public void flushdb(){
        jedis.flushAll();
        System.out.println(jedis.dbSize());
    }
    public  boolean select(String key,String token){
        System.out.println(token);
        if(token.equals(jedis.get(key))){
            return true;
        }else{
            return false;
        }
    }
}
