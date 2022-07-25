package com.kangyi.service;

import com.kangyi.pojo.HeSuan;

import java.math.BigDecimal;
import java.util.List;

public interface HeSuanService {
    long inserOne(HeSuan heSuan, long orderId, Long userId, int type);

    HeSuan getOneById(Long typeId);

    int updateOne(HeSuan heSuan);

    int delectOneById(Long typeId);

    List<HeSuan> selectManyByJingWeiDu(BigDecimal bigWeiDu, BigDecimal smallWeiDu, BigDecimal bigJingDu, BigDecimal smalJingDu, String etime, String btime);
}
