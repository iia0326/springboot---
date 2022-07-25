package com.kangyi.service;

import com.kangyi.pojo.Jiaru;

import java.util.List;

public interface JiaruService {
    Jiaru selectOneByTwo(Long orderId, Long userId);

    int insertOne(Jiaru jiaru);

    List<Jiaru> selectManyByStatusUserId(int jiaruStatus, Long FromUserId, Integer parentRead, String sortField, String sortType, Integer type);

    List<Jiaru> selectManyByStatusToUserId(int jiaruStatus, Long ToUserId, Integer parentRead, String sortField, String sortType, Integer type);

    int updateOne(Long jiaruId, Jiaru jiaru);
}
