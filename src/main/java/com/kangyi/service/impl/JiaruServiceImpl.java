package com.kangyi.service.impl;

import com.kangyi.mapper.JiaruMapper;
import com.kangyi.pojo.Jiaru;
import com.kangyi.pojo.JiaruExample;
import com.kangyi.service.JiaruService;
import com.kangyi.util.ChangeChar;
import com.kangyi.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiaruServiceImpl implements JiaruService {

    @Autowired
    JiaruMapper jiaruMapper;

    @Autowired
    RedisUtil redisUtil;


    @Override
    public Jiaru selectOneByTwo(Long orderId, Long userId) {
        String key="jiaruOId:"+orderId+"jiaruFUId"+userId;
        if (redisUtil.exists( key )){
            Jiaru o = (Jiaru) redisUtil.get( key );
            redisUtil.expire( key,24*60*60 );
            return o;
        }else{
            JiaruExample jiaruExample = new JiaruExample();
            JiaruExample.Criteria criteria = jiaruExample.createCriteria();
            criteria.andOrderIdEqualTo( orderId );
            criteria.andFromUserIdEqualTo( userId );
            List<Jiaru> jiarus = jiaruMapper.selectByExample( jiaruExample );
            if (jiarus==null||jiarus.size()<=0){
                return null;
            }
            Jiaru jiaru = jiarus.get( 0 );
            redisUtil.set( key,jiaru,24*60*60 );
            return jiaru;

        }

    }

    @Override
    public int insertOne(Jiaru jiaru) {
        String key="jiaruOId:"+jiaru.getOrderId()+"jiaruFUId"+jiaru.getFromUserId();
        if (redisUtil.exists( key )){
            redisUtil.del( key );
        }

        jiaru.setParentRead( "0" );
        jiaru.setMessageType( (byte) 0 );
        return jiaruMapper.insert( jiaru );
    }

    @Override
    public List<Jiaru> selectManyByStatusUserId(int jiaruStatus, Long userId, Integer parentRead, String sortField, String sortType, Integer type) {

//        String key="jiaruJiaru:"+jiaruStatus+"jiaruFUId"+userId;
//        if (redisUtil.exists( key )){
//            List<Jiaru> o =(List<Jiaru>) redisUtil.get( key );
//            redisUtil.expire( key,24*60*60 );
//            return o;
//        }else {
            JiaruExample jiaruExample = new JiaruExample();
            JiaruExample.Criteria criteria = jiaruExample.createCriteria();
            if(parentRead!=-1) {
                System.out.println("1"+parentRead);
                criteria.andParentReadEqualTo( String.valueOf( parentRead ) );
            }

            if(jiaruStatus!=-1) {
                System.out.println("2  "+jiaruStatus);

                criteria.andJiaruEqualTo( (byte) jiaruStatus );
            }
            if (type>1&&type<5){
                System.out.println("3  "+type);

                criteria.andTypeEqualTo( String.valueOf( type ) );
            }


            if(sortField!=null&&sortField.trim().length()>0){
                System.out.println("4  "+sortField);

                jiaruExample.setOrderByClause( ChangeChar.camelToUnderline(sortField,2) +" " +sortType);

            }
        System.out.println("5  "+userId);

        criteria.andFromUserIdEqualTo( userId );
            List<Jiaru> jiaruList = jiaruMapper.selectByExample( jiaruExample );
//            redisUtil.set( key,jiaruList,24*60*60 );

        System.out.println("@#$jiarulist  "+jiaruList);
            return jiaruList;
//        }


    }

    @Override
    public List<Jiaru> selectManyByStatusToUserId(int jiaruStatus, Long ToUserId, Integer parentRead, String sortField, String sortType, Integer type) {
//        String key="jiaruJiaru:"+jiaruStatus+"jiaruTUId"+ToUserId;
//        if (redisUtil.exists( key )){
//            List<Jiaru> o =(List<Jiaru>) redisUtil.get( key );
//            redisUtil.expire( key,24*60*60 );
//            return o;
//        }else {
            JiaruExample jiaruExample = new JiaruExample();
            JiaruExample.Criteria criteria = jiaruExample.createCriteria();
            if(jiaruStatus!=-1) {
                criteria.andJiaruEqualTo( (byte) jiaruStatus );
            }
            if (type>1&&type<5){
                criteria.andTypeEqualTo( String.valueOf( type ) );
            }
            if(jiaruStatus!=-1) {
                criteria.andParentReadEqualTo( String.valueOf( parentRead ) );
            }
            if(sortField!=null&&sortField.trim().length()>0){
                jiaruExample.setOrderByClause( ChangeChar.camelToUnderline(sortField,2) +" " +sortType);

            }
            criteria.andToUserIdEqualTo( ToUserId );
            List<Jiaru> jiaruList = jiaruMapper.selectByExample( jiaruExample );
//            redisUtil.set( key,jiaruList,24*60*60 );

            return jiaruList;
//        }

    }

    @Override
    public int updateOne(Long jiaruId, Jiaru jiaru) {

        Jiaru jiaru2 = jiaruMapper.selectByPrimaryKey( jiaruId );
        String key="jiaruOId:"+jiaru2.getOrderId()+"jiaruFUId"+jiaru2.getFromUserId();
        if (redisUtil.exists( key )){
            redisUtil.del( key );
        }

        JiaruExample jiaruExample = new JiaruExample();
        JiaruExample.Criteria criteria = jiaruExample.createCriteria();
        criteria.andJiaruIdEqualTo( jiaruId );
        int i = jiaruMapper.updateByExampleSelective( jiaru,jiaruExample );
        return i;
    }
}
