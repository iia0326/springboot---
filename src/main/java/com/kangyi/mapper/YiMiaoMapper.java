package com.kangyi.mapper;

import com.kangyi.pojo.YiMiao;
import com.kangyi.pojo.YiMiaoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YiMiaoMapper {
    long countByExample(YiMiaoExample example);

    int deleteByExample(YiMiaoExample example);

    int deleteByPrimaryKey(Long yimiaoId);

    int insert(YiMiao record);

    int insertSelective(YiMiao record);

    List<YiMiao> selectByExample(YiMiaoExample example);

    YiMiao selectByPrimaryKey(Long yimiaoId);

    int updateByExampleSelective(@Param("record") YiMiao record, @Param("example") YiMiaoExample example);

    int updateByExample(@Param("record") YiMiao record, @Param("example") YiMiaoExample example);

    int updateByPrimaryKeySelective(YiMiao record);

    int updateByPrimaryKey(YiMiao record);

    int insertAndGetId(YiMiao record);

    List<YiMiao> selectByOrderStatusAndExample(YiMiaoExample yiMiaoExample);
}