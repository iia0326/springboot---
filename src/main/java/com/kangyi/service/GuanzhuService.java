package com.kangyi.service;

import com.kangyi.pojo.Guanzhu;

import java.util.List;

public interface GuanzhuService {
    Guanzhu selectOneByTwo(Long orderId, Long userId);

    int insertOne(Guanzhu guanzhu);

    List<Guanzhu> selectManyByStatusUserId(int guanzhuStatus, Long userId);

    List<Guanzhu> selectManyByStatusOrderId(int guanzhuStatus, Long orderId);
}
