package com.zxs.mine.infra.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisClient {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取key对应list的长度
     * @param key
     * @return
     */
    public long getListSize(String key) {
        Long size = stringRedisTemplate.opsForList().size(key);
        return size;
    }

    /**
     * 根据key获取list
     * @param key
     * @param i
     * @return
     */
    public String getListData(String key,int i) {
        String json = stringRedisTemplate.opsForList().index(key,i);
        return json;
    }

    /**
     * 逐条加入数据到key所在的list
     * @param key
     * @param json
     */
    public void setListData(String key,String json) {
        stringRedisTemplate.opsForList().rightPush(key, json);
    }

    /**
     * 修改index的数据
     * @param key
     * @param index
     * @param json
     */
    public void updateListData(String key, int index, String json) {
        stringRedisTemplate.opsForList().set(key, index, json);
    }

    /**
     * 获取key的值
     * @param key
     * @return
     */
    public String getValue(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 设置key的值
     * @param key
     * @param json
     */
    public void setValue(String key,String json){
        stringRedisTemplate.opsForValue().set(key, json);
    }
}