package com.kangyi.mapper;

import com.kangyi.pojo.GuiJi;
import com.kangyi.pojo.GuiJiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuiJiMapper {
    long countByExample(GuiJiExample example);

    int deleteByExample(GuiJiExample example);

    int deleteByPrimaryKey(Long guijiId);

    int insert(GuiJi record);

    int insertSelective(GuiJi record);

    List<GuiJi> selectByExample(GuiJiExample example);

    GuiJi selectByPrimaryKey(Long guijiId);

    int updateByExampleSelective(@Param("record") GuiJi record, @Param("example") GuiJiExample example);

    int updateByExample(@Param("record") GuiJi record, @Param("example") GuiJiExample example);

    int updateByPrimaryKeySelective(GuiJi record);

    int updateByPrimaryKey(GuiJi record);

    List<GuiJi> selectByOrderStatusAndExample(GuiJiExample guiJiExample);

    int insertList(List<GuiJi> listGuiji);

    int updateListByPrimaryKeySelective(List<GuiJi> listGuiji);

    int genxinList(List<GuiJi> guiJiList);
}