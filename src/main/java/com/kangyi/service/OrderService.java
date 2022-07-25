package com.kangyi.service;

import com.kangyi.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<String, Object> getListForPage(int type, String btime, String etime, int pno, int psize, Long userId, String sortField, String sortType);

    long insertOrder(Long userId, int type);

    long insertOrder(Long userId, int type,int status,String ydata);

    int updateTypeIdOrderById(long orderId, long typeId);

    int updateAllOrderById(Order order);

    int delectOneById(Long orderId);

    int updateManyAllOrderById(List<Order> orderList);

    Order selectOneById(Long orderId);

    Map<String, Object> getListForPageByIdList(Integer type, String btime, String etime, Integer pno, Integer psize, List<Long> orderList, String sortField, String sortType, String gOrj);

    List<Order> selectManyByUserId(Long userId);
}
