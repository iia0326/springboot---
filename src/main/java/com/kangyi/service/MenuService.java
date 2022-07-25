package com.kangyi.service;

import com.kangyi.pojo.Menu;
import com.kangyi.util.Result;

import java.util.List;

public interface MenuService {
    List<Menu> selectMenuListByRoleId(Long roleId);

    List<Menu> selectMenuTree();

    Result selectMenuTreeForObject();

    Result selectMenuTreeById(Long id);

    void insertMenu(Menu menu);

    void deleteMenuById(Long id);

    Menu selectMenuById(Long id);

    void updateMenuById(Menu menu);

    void insertMenuChild(Menu menu);
}
