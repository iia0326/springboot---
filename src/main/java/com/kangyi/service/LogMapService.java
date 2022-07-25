package com.kangyi.service;

import com.kangyi.pojo.LogMap;
import com.kangyi.util.Result;

public interface LogMapService {
    Result getListForPage(int pno, int psize, String url, String sortField, String sortType);

    LogMap selectLogMapById(Long id);

    void insertLogMap(LogMap logMap);

    void updateLogMap(LogMap logMap);

    void deleteLogMapById(Long id);
}
