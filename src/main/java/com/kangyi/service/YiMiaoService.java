package com.kangyi.service;

import com.kangyi.pojo.YiMiao;

import java.math.BigDecimal;
import java.util.List;

public interface YiMiaoService {
    long insertOne(YiMiao yiMiao, long orderId, Long userId, int type);

    YiMiao getOneById(Long typeId);

    int updateOne(YiMiao yiMiao);

    int delectOneById(Long typeId);

    List<YiMiao> selectManyByJingWeiDu(BigDecimal bigWeiDu, BigDecimal smallWeiDu, BigDecimal bigJingDu, BigDecimal smalJingDu, String etime, String btime);
}
