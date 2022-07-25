package com.kangyi.redisRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;

//import com.root.sy45.entity.Student;
import com.kangyi.pojo.GuiJi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

//@Component
@Slf4j
@Repository
public class GuijiRepository {
    @SuppressWarnings("unused")
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @SuppressWarnings("unused")
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private RedisTemplate redisTemplate2;
    /**
     * 使用@Resource注解指定stringRedisTemplate，可注入基于字符串的简单属性操作方法
     * ValueOperations<String, String> valueOpsStr = stringRedisTemplate.opsForValue();
     */
    @Resource(name="stringRedisTemplate")
    ValueOperations<String, String> valueOpsStr;
    /**
     * 使用@Resource注解指定redisTemplate，可注入基于对象的简单属性操作方法
     * ValueOperations<Object, Object> valueOpsObject = redisTemplate.opsForValue();
     */
    @Resource(name="redisTemplate")
    ValueOperations<Object, Object> valueOpsObject;




    /**
     * 为指定key设置过期时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate2.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis 处理错误：", e);
            return false;
        }
    }

    /**
     * 根据key获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long ttl(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在；false不存在
     */
    public boolean exists(String key) {
        try {
            return redisTemplate2.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis 处理错误：", e);
            return false;
        }
    }

    /**
     * 删除key
     *
     * @param key 可以传一个或多个值
     */
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate2.delete(key[0]);
            } else {
                redisTemplate2.delete( CollectionUtils.arrayToList(key));
            }
        }
    }


    /**
     * 保存字符串到redis
     */
    public void saveString(String key, String value) {
        valueOpsStr.set(key, value);
    }
    /**
     * 保存对象到redis
     */
    public void saveObject(String key,GuiJi guiJi) {
        valueOpsObject.set(key, guiJi);
    }
    /**
     * 保存List数据到redis
     */
    public void saveMultiStudents(Object key, List<GuiJi> guiJis) {
        valueOpsObject.set(key, guiJis);
    }
    /**
     * 从redis中获得字符串数据
     */
    public String getString(String key) {
        return valueOpsStr.get(key);
    }
    /**
     * 从redis中获得对象数据
     */
    public Object getObject(Object key) {
        return valueOpsObject.get(key);
    }
}