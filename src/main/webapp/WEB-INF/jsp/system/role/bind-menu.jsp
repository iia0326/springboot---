<%--
  Created by IntelliJ IDEA.
  User: zhangyunpeng
  Date: 2021/8/2
  Time: 10:02 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>绑定菜单</title>
    <%@include file="../../basepath.jsp"%>
    <link href="layui/css/layui.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/common.css?v=<%=Math.random()%>">
</head>
<body>
<span class="layui-breadcrumb">
<%--  <a href="">首页</a>--%>
  <a href="role/list">角色管理</a>
  <a >绑定菜单</a>
</span>
<%--${menuList}--%>
<form class="layui-form" id="role-form" action="role/bind/menu" lay-filter="form" method="post">
    <input type="hidden" name="id" value="${formData.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-block">
            <input type="text" name="roleName"
                   required
                   readonly
                   lay-verify="required"
                   lay-reqText="角色名称不可以为空"
                   lay-verType="tips"
                   value="${formData.roleName}"
                   placeholder="请输入角色名称"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">绑定菜单</label>
        <div class="layui-input-block">
            <div id="menu-tree"></div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
    var tree;
    var menuList = ${menuList};
    var hasMenuList = ${hasMenuList};
    console.log(hasMenuList)
    var checkedIdArr = []
    var halfChecked = []
    var fullChecked = []
    hasMenuList.forEach(function(item){
        checkedIdArr.push(item.id)
        halfChecked.push(item.id)
        item.children.forEach(function(itemChild){
            fullChecked.push(itemChild.id)
            checkedIdArr.push(itemChild.id)
        })
    })
    console.log(checkedIdArr)
    menuList.forEach(function(item){
        item.title = item.name;
        item.spread = true;
        item.children.forEach(function(itemChild){
            itemChild.title = itemChild.name
            itemChild.spread = true;
        })
    })
    layui.use('tree',function(){
        tree = layui.tree;
        var treeObj = tree.render({
            elem: '#menu-tree',
            id: 'tree',
            data: menuList,
            showCheckbox: true,
            oncheck: function(obj){
                // console.log(obj)
            }
        })
        // console.log(treeObj)
        tree.setChecked('tree',fullChecked)
    })
    layui.use('form',function(){
        var form = layui.form;
        var layer = layui.layer;
        form.on('submit(form)',function(res){
            // console.log(res)

            $('[name="ids"]').remove()
            var checkedArr = tree.getChecked('tree')
            checkedIdArr = []
            if(checkedArr.length == 0){
                layer.msg('请选择菜单')
                return false
            }

            checkedArr.forEach(function(item){
                checkedIdArr.push(item.id)
                item.children.forEach(function(itemChild){
                    checkedIdArr.push(itemChild.id)
                })
            })
            console.log(checkedIdArr)
            checkedIdArr.forEach(function(item){
                $('#role-form').append('<input type="hidden" name="ids" value="'+item+'"/>')
            })

            // return false
            // return false
        })
    })
</script>
</body>
</html>
