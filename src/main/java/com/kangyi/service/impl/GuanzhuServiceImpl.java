package com.kangyi.service.impl;

import com.kangyi.mapper.GuanzhuMapper;
import com.kangyi.pojo.Guanzhu;
import com.kangyi.pojo.GuanzhuExample;
import com.kangyi.service.GuanzhuService;
import com.kangyi.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuanzhuServiceImpl implements GuanzhuService {
    @Autowired
    GuanzhuMapper guanzhuMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public Guanzhu selectOneByTwo(Long orderId, Long userId) {
        String key="guanzhuOId:"+orderId+"guanzhuUId"+userId;
        if (redisUtil.exists( key )){
            Guanzhu o = (Guanzhu) redisUtil.get( key );
            redisUtil.expire( key,24*60*60 );
            return o;
        }else{
            GuanzhuExample example = new GuanzhuExample();
            GuanzhuExample.Criteria criteria = example.createCriteria();
            criteria.andOrderIdEqualTo( orderId );
            criteria.andUserIdEqualTo( userId );
            List<Guanzhu> guanzhus = guanzhuMapper.selectByExample( example );
            if (guanzhus==null||guanzhus.size()<=0){
                return null;
            }
            Guanzhu o = guanzhus.get( 0 );
            redisUtil.set( key,o,24*60*60 );
            return o;

        }
    }

    @Override
    public int insertOne(Guanzhu guanzhu) {
        byte gz;
        if (guanzhu.getGuanzhu()==1){
            gz=0;
        }else
        {
            gz=1;
        }
        String key="guanzhuOId:"+guanzhu.getOrderId()+"guanzhuUId"+guanzhu.getUserId();
        String SUkey="guanzhuStatus:"+gz+"guanzhuUId"+guanzhu.getUserId();
        String SOkey="guanzhuStatus:"+gz+"guanzhuOId"+guanzhu.getOrderId();
        if (redisUtil.exists( key )){
            redisUtil.del( key );
        }
        if (redisUtil.exists( SUkey )){
//            System.out.println("@#$redisUtil.del  "+SUkey);
            redisUtil.del( SUkey );
        }
        if (redisUtil.exists( SOkey )){
            redisUtil.del( SOkey );
        }
        return guanzhuMapper.insert( guanzhu );
    }

    @Override
    public List<Guanzhu> selectManyByStatusUserId(int guanzhuStatus, Long userId) {

        String key="guanzhuStatus:"+guanzhuStatus+"guanzhuUId"+userId;
        if (redisUtil.exists( key )){
            List<Guanzhu> o =(List<Guanzhu>) redisUtil.get( key );
            redisUtil.expire( key,24*60*60 );
            return o;
        }else {
            GuanzhuExample oe = new GuanzhuExample();
            GuanzhuExample.Criteria criteria = oe.createCriteria();
            criteria.andGuanzhuEqualTo( (byte)guanzhuStatus );
            criteria.andUserIdEqualTo( userId );
            List<Guanzhu> list = guanzhuMapper.selectByExample( oe );
            redisUtil.set( key,list,24*60*60 );

            return list;
        }
    }

    @Override
    public List<Guanzhu> selectManyByStatusOrderId(int guanzhuStatus, Long orderId) {
//        String key="guanzhuStatus:"+guanzhuStatus+"guanzhuOId"+orderId;
//        if (redisUtil.exists( key )){
//            List<Guanzhu> o =(List<Guanzhu>) redisUtil.get( key );
//            redisUtil.expire( key,24*60*60 );
//            return o;
//        }else {
            GuanzhuExample oe = new GuanzhuExample();
            GuanzhuExample.Criteria criteria = oe.createCriteria();
            criteria.andGuanzhuEqualTo( (byte)guanzhuStatus );
            criteria.andOrderIdEqualTo( orderId );
            List<Guanzhu> list = guanzhuMapper.selectByExample( oe );
//            redisUtil.set( key,list,24*60*60 );

            return list;
//        }
    }
}

