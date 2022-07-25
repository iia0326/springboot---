package com.kangyi.mapper;

import com.kangyi.pojo.HeSuan;
import com.kangyi.pojo.HeSuanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HeSuanMapper {
    long countByExample(HeSuanExample example);

    int deleteByExample(HeSuanExample example);

    int deleteByPrimaryKey(Long hesuanId);

    int insert(HeSuan record);

    int insertSelective(HeSuan record);

    List<HeSuan> selectByExample(HeSuanExample example);

    HeSuan selectByPrimaryKey(Long hesuanId);

    int updateByExampleSelective(@Param("record") HeSuan record, @Param("example") HeSuanExample example);

    int updateByExample(@Param("record") HeSuan record, @Param("example") HeSuanExample example);

    int updateByPrimaryKeySelective(HeSuan record);

    int updateByPrimaryKey(HeSuan record);

    int insertAndGetId(HeSuan heSuan);

    List<HeSuan> selectByOrderStatusAndExample(@Param("example")HeSuanExample example,@Param( "i" ) int i);
    List<HeSuan> selectByOrderStatusAndExample(HeSuanExample example);
}