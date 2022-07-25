package com.kangyi.service;

import com.kangyi.pojo.Role;
import com.kangyi.pojo.vo.RoleMenuVO;
import com.kangyi.util.Result;

import java.util.List;

public interface RoleService {
    List<Role> selectRoleListAll();

    Result getListForPage(int pno, int psize, String sortField, String sortType);

    Role findRoleById(Long id);

    void insertRole(Role role);

    void editRole(Role role);

    void deleteRoleByid(Long id);

    void insertRoleMenu(RoleMenuVO roleMenuVO);

    void bindPermission(RoleMenuVO roleMenuVO);

    Long[] selectPermissionIdByRoleId(Long id);


}
