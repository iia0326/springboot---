package com.kangyi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kangyi.mapper.QuartzBeanMapper;
import com.kangyi.pojo.QuartzBean;
import com.kangyi.pojo.QuartzBeanExample;
import com.kangyi.service.QuartzBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuartzBeanServiceImpl implements QuartzBeanService {

    @Autowired
    QuartzBeanMapper quartzBeanMapper;



    @Override
    public QuartzBean selectOne(int jobId) {
        return quartzBeanMapper.selectByPrimaryKey( jobId );
    }

    @Override
    public int insertOne(QuartzBean quartzBean) {
        return quartzBeanMapper.insert( quartzBean );
    }

    @Override
    public int updateOne(QuartzBean quartzBean) {
            QuartzBeanExample quartzBeanExample = new QuartzBeanExample();
            QuartzBeanExample.Criteria criteria = quartzBeanExample.createCriteria();
            criteria.andIdEqualTo( quartzBean.getId() );
            return quartzBeanMapper.updateByExampleSelective( quartzBean,quartzBeanExample );
        }

    @Override
    public Map<String, Object> getListForPage(Integer status, String jobName, Integer pno, Integer psize) {

        Page<QuartzBean> p = PageHelper.startPage( pno, psize );
        QuartzBeanExample oe = new QuartzBeanExample();
        QuartzBeanExample.Criteria criteria = oe.createCriteria();

        if(status!=null&&status!=0){
            criteria.andStatusEqualTo( status );
            System.out.println("111");
        }
        if(jobName!=null&&jobName.trim().length()>0&&!"null".equals( jobName )){
            criteria.andJobNameLike("%"+jobName+"%");
            System.out.println(jobName+"123");
        }
        System.out.println(status+jobName+pno);
        List<QuartzBean> quartzBeans = quartzBeanMapper.selectByExample( oe );
//        System.out.println("@#$qua "+quartzBeans);

        Map<String, Object> map = new HashMap<>(3);
        map.put("quartzBeans", quartzBeans);
        map.put("pno", pno);
        map.put("psize", psize);
        map.put("count",p.getTotal());
        return map;
//        return null;
    }

    @Override
    public int delectOne(int jobId) {
        return quartzBeanMapper.deleteByPrimaryKey( jobId );
    }
}
