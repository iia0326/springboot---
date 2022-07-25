package com.kangyi.service;

import com.kangyi.pojo.Permission;
import com.kangyi.util.Result;

import java.util.List;

public interface PermissionService {
    Result selectPermissionListForPage(int pno, int psize, String sortField, String sortType);

    Permission selectPermissionById(Long id);

    void insertPermission(Permission permission);

    void updatePermissionById(Permission permission);

    void deletePermissionById(Long id);

    List<Permission> selectPermissionAll();

    List<Permission> selectPermissionByRoleId(Long roleId);
}
