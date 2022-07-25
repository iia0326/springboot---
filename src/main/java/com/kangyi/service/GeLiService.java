package com.kangyi.service;

import com.kangyi.pojo.GeLi;

import java.math.BigDecimal;
import java.util.List;

public interface GeLiService {
    long insertGeLi(GeLi geLi, long orderId, Long userId, int type);

    GeLi getOneById(Long typeId);

    int updateOne(GeLi geLi);

    int delectOneById(Long geLiId);

    List<GeLi> selectManyByJingWeiDu(BigDecimal bigWeiDu, BigDecimal smallWeiDu, BigDecimal bigJingDu, BigDecimal smalJingDu, String etime, String btime);
}
