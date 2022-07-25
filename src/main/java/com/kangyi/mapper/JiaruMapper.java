package com.kangyi.mapper;

import com.kangyi.pojo.Jiaru;
import com.kangyi.pojo.JiaruExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JiaruMapper {
    long countByExample(JiaruExample example);

    int deleteByExample(JiaruExample example);

    int deleteByPrimaryKey(Long jiaruId);

    int insert(Jiaru record);

    int insertSelective(Jiaru record);

    List<Jiaru> selectByExample(JiaruExample example);

    Jiaru selectByPrimaryKey(Long jiaruId);

    int updateByExampleSelective(@Param("record") Jiaru record, @Param("example") JiaruExample example);

    int updateByExample(@Param("record") Jiaru record, @Param("example") JiaruExample example);

    int updateByPrimaryKeySelective(Jiaru record);

    int updateByPrimaryKey(Jiaru record);
}