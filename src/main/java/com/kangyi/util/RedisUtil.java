package com.kangyi.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis操作工具类
 */
@Repository
@Component
@Slf4j
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

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
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
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
        System.out.println(key);
        try {
            return redisTemplate.hasKey(key);
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
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete( CollectionUtils.arrayToList(key));
            }
        }
    }

    //============================字符串 string============================

    /**
     * 获取指定key的值
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置指定key的值
     *
     * @param key   键
     * @param value 值
     * @return true成功；false失败
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis 处理错误：", e);
            return false;
        }

    }

    /**
     * 设置指定key的值并设置过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  过期时间(秒) time要大于0，如果time小于等于0，将设置无限期
     * @return true成功；false 失败
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis 处理错误：", e);
            return false;
        }
    }

    /**
     * 将key所储存的值加上给定的增量值
     *
     * @param key 键
     * @param delta 要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 将key所储存的值减去给定的增量值
     *
     * @param key 键
     * @param delta 要减少几(小于0)
     * @return
     */
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    //============================哈希 hash============================

    /**
     * 获取hash表key中指定字段的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 获取hash表key中所有的字段和值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 设置hash表key中指定字段的值
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return true 成功；false失败
     */
    public boolean hset(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置hash表key中指定字段的值，并设置过期时间
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒)
     * @return true 成功；false失败
     */
    public boolean hset(String key, String item, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将多个字段和值设置到hash表key中
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis 处理错误：", e);
            return false;
        }
    }

    /**
     * 将多个字段和值设置到hash表key中，并设置过期时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis 处理错误：", e);
            return false;
        }
    }

    /**
     * 删除hash表key中指定的字段
     *
     * @param key  键 不能为null
     * @param item 项 可以为多个，不能为null
     */
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断hash表key中是否有该字段的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在；false不存在
     */
    public boolean hexists(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * 为hash表key中的指定字段的值加上增量
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * 为hash表key中的指定字段的值减去增量
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    public double hdecr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    //============================集合 set============================

    /**
     * 返回集合key中的所有成员
     *
     * @param key 键
     * @return
     */
    public Set<Object> smembers(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断元素是否是集合key的成员
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean sismember(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向集合key中添加成员
     *
     * @param key    键
     * @param values 值，可以是多个
     * @return 成功个数
     */
    public long sadd(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 向集合key中添加成员并设置过期时间
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值，可以是多个
     * @return 成功个数
     */
    public long sadd(String key, long time, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取集合key的成员数
     *
     * @param key 键
     * @return
     */
    public long scard(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除值集合key中的指定的成员
     *
     * @param key    键
     * @param values 值，可以是多个
     * @return 移除的个数
     */
    public long srem(String key, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    //============================列表 list============================

    /**
     * 获取list指定范围内的元素
     *
     * @param key   键
     * @param start 开始
     * @param end   结束，0 到 -1代表所有值
     * @return
     */
    public List<Object> lrange(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list的长度
     *
     * @param key 键
     * @return
     */
    public long llen(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 通过索引获取list中的值
     *
     * @param key   键
     * @param index 索引，index>=0时，0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lindex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 在list中尾部添加元素
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean lrpush(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 在list中尾部添加元素并设置过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean lrpush(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 在list中尾部添加多个元素
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean lrpush(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 在list中尾部添加多个元素并设置过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean lrpush(String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据索引设置list元素的值
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    public boolean lset(String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除list元素
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public long lrem(String key, long count, Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //============================有序集合 sort set============================
    /**
     * 向有序集合set添加成员
     *
     * @param key   键
     * @param value 值
     * @param score 分数
     * @return
     */
    public boolean zadd(String key, Object value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 向有序集合set添加多个成员
     *
     * @param key    键
     * @param typles 成员集合
     * @return
     */
    public long zadd(String key, Set<ZSetOperations.TypedTuple> typles) {
        return redisTemplate.opsForZSet().add(key, typles);
    }

    /**
     * 有序集合set指定成员的分数加上增量
     * @param key   键
     * @param value 值
     * @param delta 分数增量
     */
    public void zincr(String key, Object value, long delta) {
        redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }

    /**
     * 计算多个有序集合的并集
     * @param key       键
     * @param otherKeys 其他有序集合的键
     * @param destKey   并集的键
     */
    public void zunionstore(String key, Collection otherKeys, String destKey) {
        redisTemplate.opsForZSet().unionAndStore(key, otherKeys, destKey);
    }

    /**
     * 获取有序集合key中指定成员的分数值
     * @param key   键
     * @param value 值
     * @return
     */
    public long zscore(String key, Object value) {
        Double score = redisTemplate.opsForZSet().score(key, value);
        if(score==null){
            return 0;
        }else{
            return score.longValue();
        }
    }

    /**
     * 返回有序集合key中指定索引区间内的成员，score从大到小排序
     * @param key   键
     * @param start 开始索引
     * @param end   结束索引
     * @return
     */
    public Set<ZSetOperations.TypedTuple> zrevrange(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(key, start, end);
    }

}