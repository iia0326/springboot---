package com.kangyi.service.impl;

import com.kangyi.pojo.Menu;
import com.kangyi.pojo.MenuExample;
import com.kangyi.mapper.MenuMapper;
import com.kangyi.service.MenuService;
import com.kangyi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectMenuListByRoleId(Long roleId) {
        List<Menu> list = menuMapper.selectMenuByRoleId(roleId);
        List<Menu> baseMenu = list.stream().filter(menuFather -> menuFather.getPid() == -1).collect(Collectors.toList());
        System.out.println(baseMenu);
        baseMenu.stream().forEach(menuFather -> {
            list.stream().forEach(menuChild -> {
                if(menuFather.getId() == menuChild.getPid()){
                    if(menuFather.getChildren() == null){
                        menuFather.setChildren(new ArrayList<Menu>());
                    }
                    menuFather.getChildren().add(menuChild);
                }
            });
        });
        return baseMenu;
    }

    @Override
    public List<Menu> selectMenuTree() {
        List<Menu> list = menuMapper.selectByExample(null);
        List<Menu> baseMenuList = new ArrayList<Menu>();
        list.stream().forEach(menu ->  {
            if(menu.getPid() == -1){
                baseMenuList.add(menu);
            }
        });
        baseMenuList.stream().forEach(menuParent -> {
            list.stream().forEach(menuChild -> {
                if(menuParent.getId() == menuChild.getPid()){
                    if(menuParent.getChildren() == null){
                        menuParent.setChildren(new ArrayList<Menu>());
                    }
                    menuParent.getChildren().add(menuChild);
                }
            });
        });
        return baseMenuList;
    }

    @Override
    public Result selectMenuTreeForObject() {
        List<Menu> list = menuMapper.selectByExample(null);
        List<Menu> baseMenuList = new ArrayList<Menu>();
        list.stream().forEach(menu ->  {
            if(menu.getPid() == -1){
                baseMenuList.add(menu);
            }
        });
//        baseMenuList.stream().forEach(menuParent -> {
//            list.stream().forEach(menuChild -> {
//                if(menuParent.getId() == menuChild.getPid()){
//                    if(menuParent.getChildren() == null){
//                        menuParent.setChildren(new ArrayList<Menu>());
//                    }
//                    menuParent.getChildren().add(menuChild);
//                }
//            });
//        });
        return Result.end(200,baseMenuList,"查询成功",0);
    }

    @Override
    public Result selectMenuTreeById(Long id) {
        MenuExample me = new MenuExample();
        MenuExample.Criteria criteria = me.createCriteria();
        criteria.andPidEqualTo(id);
        List<Menu> list = menuMapper.selectByExample(me);
        return Result.end(200,list,"查询成功",0);
    }

    @Override
    public void insertMenu(Menu menu) {
        menu.setPid(Long.valueOf(-1));
        menu.setIsLink(0);
        menuMapper.insert(menu);
    }

    @Override
    public void deleteMenuById(Long id) {
        menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Menu selectMenuById(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateMenuById(Menu menu) {
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public void insertMenuChild(Menu menu) {
        menuMapper.insert(menu);
    }
}
