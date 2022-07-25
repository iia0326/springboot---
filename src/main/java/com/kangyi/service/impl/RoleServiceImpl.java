package com.kangyi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kangyi.pojo.*;
import com.kangyi.pojo.vo.RoleMenuVO;
import com.kangyi.mapper.MenuRoleMapper;
import com.kangyi.mapper.RoleMapper;
import com.kangyi.mapper.RolePermissionMapper;
import com.kangyi.service.RoleService;
import com.kangyi.util.ChangeChar;
import com.kangyi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Role> selectRoleListAll() {
        return roleMapper.selectByExample(null);
    }

    @Override
    public Result getListForPage(int pno, int psize, String sortField, String sortType) {
        Page<Role> p = PageHelper.startPage(pno, psize);
        RoleExample re = new RoleExample();
        if(sortField.trim().length()>0){
            re.setOrderByClause(ChangeChar.camelToUnderline(sortField,2) +" "+sortType);
        }
        roleMapper.selectByExample(re);
        return Result.end(200,p.getResult(),"查询成功",p.getTotal());
    }

    @Override
    public Role findRoleById(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void editRole(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public void deleteRoleByid(Long id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertRoleMenu(RoleMenuVO roleMenuVO) {
        Long roleId = roleMenuVO.getId();
        MenuRoleExample mre = new MenuRoleExample();
        MenuRoleExample.Criteria criteria = mre.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        menuRoleMapper.deleteByExample(mre);
        Arrays.stream(roleMenuVO.getIds()).forEach(menuId -> {
            MenuRole menuRole = new MenuRole();
            menuRole.setRoleId(roleId);
            menuRole.setMenuId(menuId);
            menuRoleMapper.insert(menuRole);
        });
    }

    @Override
    public void bindPermission(RoleMenuVO roleMenuVO) {
        Long roleId = roleMenuVO.getId();
        Long[] permissionIds = roleMenuVO.getIds();
        RolePermissionExample rpe = new RolePermissionExample();
        RolePermissionExample.Criteria criteria = rpe.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        rolePermissionMapper.deleteByExample(rpe);

        Arrays.stream(permissionIds).forEach(permissionId -> {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            rolePermissionMapper.insert(rolePermission);
        });
    }

    @Override
    public Long[] selectPermissionIdByRoleId(Long id) {
        return rolePermissionMapper.selectPermissionByRoleId(id);
    }


}
