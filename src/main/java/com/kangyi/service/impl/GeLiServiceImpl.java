package com.kangyi.service.impl;

import com.kangyi.mapper.GeLiMapper;
import com.kangyi.pojo.GeLi;
import com.kangyi.pojo.GeLiExample;
import com.kangyi.service.GeLiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static com.kangyi.util.StringToDate.*;

@Service
public class GeLiServiceImpl implements GeLiService {

    @Autowired
    GeLiMapper geLiMapper;

    @Override
    public long insertGeLi(GeLi geLi, long orderId, Long userId, int type) {
        geLi.setUserId( userId );
        geLi.setOrderId( orderId );

        geLiMapper.insertAndGetId(geLi);
        long geliId =geLi.getGeliId();
        return geliId;
    }

    @Override
    public GeLi getOneById(Long typeId) {
        return geLiMapper.selectByPrimaryKey( typeId );
    }

    @Override
    public int updateOne(GeLi geLi) {
        int i = geLiMapper.updateByPrimaryKeySelective( geLi );
        return i;
    }

    @Override
    public int delectOneById(Long geLiId) {
        return geLiMapper.deleteByPrimaryKey( geLiId );
    }

    @Override
    public List<GeLi> selectManyByJingWeiDu(BigDecimal bigWeiDu, BigDecimal smallWeiDu, BigDecimal bigJingDu, BigDecimal smalJingDu, String etime, String btime) {
        GeLiExample geLiExample = new GeLiExample();
        GeLiExample.Criteria criteria = geLiExample.createCriteria();
        criteria.andJinduBetween( smalJingDu,bigJingDu );
        criteria.andWeiduBetween( smallWeiDu,bigWeiDu );
        if (etime!=null&&!"null".equals( etime )&&etime.trim().length()>0){
            criteria.andEnddateBetween( YMDmToDate(btime),YMDmToDate(etime) );
        }else {
            criteria.andEnddateGreaterThanOrEqualTo( dateAddTian(new Date(  ),1));
        }

        System.out.println("@#$ "+bigJingDu+" mj "+smalJingDu+" bw "+bigWeiDu+" mw "+smallWeiDu);
        List<GeLi> geLiList = geLiMapper.selectByOrderStatusAndExample( geLiExample );
        System.out.println("@#$ "+geLiList);

        return geLiList;

    }
}
