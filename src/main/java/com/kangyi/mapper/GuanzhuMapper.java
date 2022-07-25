package com.kangyi.mapper;

import com.kangyi.pojo.Guanzhu;
import com.kangyi.pojo.GuanzhuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuanzhuMapper {
    long countByExample(GuanzhuExample example);

    int deleteByExample(GuanzhuExample example);

    int deleteByPrimaryKey(Long guanzhuId);

    int insert(Guanzhu record);

    int insertSelective(Guanzhu record);

    List<Guanzhu> selectByExample(GuanzhuExample example);

    Guanzhu selectByPrimaryKey(Long guanzhuId);

    int updateByExampleSelective(@Param("record") Guanzhu record, @Param("example") GuanzhuExample example);

    int updateByExample(@Param("record") Guanzhu record, @Param("example") GuanzhuExample example);

    int updateByPrimaryKeySelective(Guanzhu record);

    int updateByPrimaryKey(Guanzhu record);
}