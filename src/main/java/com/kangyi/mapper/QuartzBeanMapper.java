package com.kangyi.mapper;

import com.kangyi.pojo.QuartzBean;
import com.kangyi.pojo.QuartzBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuartzBeanMapper {
    long countByExample(QuartzBeanExample example);

    int deleteByExample(QuartzBeanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuartzBean record);

    int insertSelective(QuartzBean record);

    List<QuartzBean> selectByExample(QuartzBeanExample example);

    QuartzBean selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuartzBean record, @Param("example") QuartzBeanExample example);

    int updateByExample(@Param("record") QuartzBean record, @Param("example") QuartzBeanExample example);

    int updateByPrimaryKeySelective(QuartzBean record);

    int updateByPrimaryKey(QuartzBean record);
}