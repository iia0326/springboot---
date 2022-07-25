package com.kangyi.service.impl;

import com.kangyi.mapper.YiMiaoMapper;
import com.kangyi.pojo.YiMiao;
import com.kangyi.pojo.YiMiaoExample;
import com.kangyi.service.YiMiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static com.kangyi.util.StringToDate.*;

@Service
public class YiMiaoServiceImpl implements YiMiaoService {
    @Autowired
    YiMiaoMapper yiMiaoMapper;

    @Override
    public long insertOne(YiMiao yiMiao, long orderId, Long userId, int type) {
        yiMiao.setUserId( userId );
        yiMiao.setOrderId( orderId );
        yiMiaoMapper.insertAndGetId( yiMiao );
        Long yimiaoId = yiMiao.getYimiaoId();
        return yimiaoId;
    }

    @Override
    public YiMiao getOneById(Long typeId) {
        return yiMiaoMapper.selectByPrimaryKey( typeId );
    }

    @Override
    public int updateOne(YiMiao yiMiao) {
        return yiMiaoMapper.updateByPrimaryKeySelective( yiMiao );
    }

    @Override
    public int delectOneById(Long typeId) {
        return yiMiaoMapper.deleteByPrimaryKey( typeId );
    }

    @Override
    public List<YiMiao> selectManyByJingWeiDu(BigDecimal bigWeiDu, BigDecimal smallWeiDu, BigDecimal bigJingDu, BigDecimal smalJingDu, String etime, String btime) {
        YiMiaoExample yiMiaoExample = new YiMiaoExample();
        YiMiaoExample.Criteria criteria = yiMiaoExample.createCriteria();
        if (etime!=null&&!"null".equals( etime )&&etime.trim().length()>0){
            criteria.andEnddateLessThanOrEqualTo( YMDmToDate(etime) );
            criteria.andStartdateGreaterThanOrEqualTo( YMDmToDate(btime) );
        }else {
            criteria.andEnddateGreaterThanOrEqualTo( dateAddTian(new Date(  ),1) );
        }
        criteria.andJinduBetween( smalJingDu,bigJingDu );
        criteria.andWeiduBetween( smallWeiDu,bigWeiDu );




        List<YiMiao> yiMiaoList = yiMiaoMapper.selectByOrderStatusAndExample( yiMiaoExample );


        return yiMiaoList;
    }
}
