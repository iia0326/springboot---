package com.kangyi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kangyi.pojo.Log;
import com.kangyi.pojo.LogExample;
import com.kangyi.mapper.LogMapper;
import com.kangyi.service.LogService;
import com.kangyi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void insertLog(Log log) {
        logMapper.insert(log);
    }

    @Override
    public Result getListForPage(int pno, int psize, String url, String username, String action, String beginTime, String endTime, String sortField, String sortType) {
        Page<Log> p = PageHelper.startPage(pno, psize);
        LogExample le = new LogExample();
        LogExample.Criteria criteria = le.createCriteria();
        if(url.trim().length()>0){
            criteria.andUrlLike("%"+url+"%");
        }
        if(username.trim().length()>0){
            criteria.andUsernameLike("%"+username+"%");
        }
        if(action.trim().length()>0){
            criteria.andActionLike("%"+action+"%");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(beginTime.trim().length()>0){
            beginTime = beginTime + " 00:00:00";


            Date beginTimeDate = null;
            try {
                beginTimeDate = sdf.parse(beginTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            criteria.andTimeGreaterThanOrEqualTo(beginTimeDate);
        }
        if(endTime.trim().length()>0){
            endTime = endTime + " 23:59:59";
            Date endTimeDate = null;
            try {
                endTimeDate = sdf.parse(endTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            criteria.andTimeLessThanOrEqualTo(endTimeDate);
        }
        if(sortField.trim().length()>0){
            le.setOrderByClause( sortField+ " " + sortType);
        }
        logMapper.selectByExampleWithBLOBs(le);
        return Result.end(200,p.getResult(),"查询成功",p.getTotal());
    }
}
