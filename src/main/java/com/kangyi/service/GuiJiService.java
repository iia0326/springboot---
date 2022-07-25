package com.kangyi.service;

import com.kangyi.pojo.GuiJi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface GuiJiService {
    int insertListGuiJi(ArrayList<GuiJi> listGuiJi, long orderId, Long userId, int type);

    Map<String,Object> getManyByOrderId(Long orderId);

    int updateManyByOrderId(Long orderId, ArrayList<GuiJi> listGuiJi);

    int delectManyByOrderId(Long orderId);

    List<GuiJi> selectManyByJingWeiDu(BigDecimal bigWeiDu, BigDecimal smallWeiDu, BigDecimal bigJingDu, BigDecimal smalJingDu, String etime, String btime, Integer tian);

    GuiJi selectOneById(Long typeId);
}
