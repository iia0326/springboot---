package com.kangyi.service;

import com.kangyi.pojo.Log;
import com.kangyi.util.Result;

public interface LogService {
    void insertLog(Log log);

    Result getListForPage(int pno, int psize, String url, String username, String action, String beginTime, String endTime, String sortField, String sortType);
}
