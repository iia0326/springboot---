package com.kangyi.service;

import com.kangyi.pojo.QuartzBean;

import java.util.Map;

public interface QuartzBeanService {

    public QuartzBean selectOne(int jobId);

    public int insertOne(QuartzBean quartzBean);

    public int updateOne(QuartzBean quartzBean);

    Map<String, Object> getListForPage(Integer status, String jobName, Integer pno1, Integer psize1);

    int delectOne(int jobId);
}
