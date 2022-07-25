package com.kangyi.mapper;

import com.kangyi.pojo.LogMap;
import com.kangyi.pojo.LogMapExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMapMapper {
    long countByExample(LogMapExample example);

    int deleteByExample(LogMapExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LogMap record);

    int insertSelective(LogMap record);

    List<LogMap> selectByExample(LogMapExample example);

    LogMap selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LogMap record, @Param("example") LogMapExample example);

    int updateByExample(@Param("record") LogMap record, @Param("example") LogMapExample example);

    int updateByPrimaryKeySelective(LogMap record);

    int updateByPrimaryKey(LogMap record);
}