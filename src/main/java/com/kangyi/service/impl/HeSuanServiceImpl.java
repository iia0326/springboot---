package com.kangyi.service.impl;

import com.kangyi.mapper.HeSuanMapper;
import com.kangyi.mapper.OrderMapper;
import com.kangyi.pojo.HeSuan;
import com.kangyi.pojo.HeSuanExample;
import com.kangyi.service.HeSuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.kangyi.util.StringToDate.*;


@Service
public class HeSuanServiceImpl implements HeSuanService {

    @Autowired
    HeSuanMapper heSuanMapper ;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public long inserOne(HeSuan heSuan, long orderId, Long userId, int type) {
        heSuan.setUserId( userId );
        heSuan.setOrderId( orderId );

        heSuanMapper.insertAndGetId(heSuan );
        Long hesuanId = heSuan.getHesuanId();
        return hesuanId;
    }

    @Override
    public HeSuan getOneById(Long typeId) {

        return heSuanMapper.selectByPrimaryKey( typeId );
    }

    @Override
    public int updateOne(HeSuan heSuan) {
        return heSuanMapper.updateByPrimaryKeySelective( heSuan );
//        return heSuanMapper.updateByPrimaryKey( heSuan );
    }

    @Override
    public int delectOneById(Long typeId) {
        return heSuanMapper.deleteByPrimaryKey( typeId );
    }

    @Override
    public List<HeSuan> selectManyByJingWeiDu(BigDecimal bigWeiDu, BigDecimal smallWeiDu, BigDecimal bigJingDu, BigDecimal smalJingDu, String etime, String btime) {

        List<HeSuan> heSuanList = new ArrayList<HeSuan>();
        HeSuanExample heSuanExample = new HeSuanExample();
        HeSuanExample.Criteria criteria = heSuanExample.createCriteria();

        if (etime!=null&&!"null".equals( etime )&&etime.trim().length()>0){
            System.out.println("etime  "+etime);
            criteria.andEnddateLessThanOrEqualTo( YMDmToDate(etime) );
            criteria.andStartdateGreaterThanOrEqualTo( YMDmToDate(btime) );
        }else {
            criteria.andEnddateGreaterThan( dateAddTian(new Date(  ),1));

        }
        criteria.andJinduBetween( smalJingDu,bigJingDu );
        criteria.andWeiduBetween( smallWeiDu,bigWeiDu );
        heSuanList=heSuanMapper.selectByOrderStatusAndExample( heSuanExample );
//        System.out.println(smallWeiDu+" :1@#$hesuan: "+bigWeiDu+"   "+smalJingDu+"  JingDu  "+bigJingDu+"  实体"+heSuanList);
        return heSuanList;
    }
}
