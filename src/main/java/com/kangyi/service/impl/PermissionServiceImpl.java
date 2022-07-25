package com.kangyi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kangyi.pojo.Permission;
import com.kangyi.pojo.PermissionExample;
import com.kangyi.mapper.PermissionMapper;
import com.kangyi.service.PermissionService;
import com.kangyi.util.ChangeChar;
import com.kangyi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Result selectPermissionListForPage(int pno, int psize, String sortField, String sortType) {
        Page<Permission> p = PageHelper.startPage(pno, psize);
        PermissionExample pe = new PermissionExample();
        if(sortField.trim().length()>0){
            pe.setOrderByClause(ChangeChar.camelToUnderline(sortField,2) +" " + sortType);
        }
        permissionMapper.selectByExample(pe);
        return Result.end(200,p.getResult(),"查询成功",p.getTotal());
    }

    @Override
    public Permission selectPermissionById(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertPermission(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    public void updatePermissionById(Permission permission) {
        permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public void deletePermissionById(Long id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Permission> selectPermissionAll() {
        return permissionMapper.selectByExample(null);
    }

    @Override
    public List<Permission> selectPermissionByRoleId(Long roleId) {
        return permissionMapper.selectPermissionListByRoleId(roleId);
    }
}
