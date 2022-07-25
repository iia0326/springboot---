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
    <title>新增用户</title>
    <%@include file="../../basepath.jsp"%>
    <link href="layui/css/layui.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/common.css?v=<%=Math.random()%>">
</head>
<body>
<span class="layui-breadcrumb">
<%--  <a href="">首页</a>--%>
  <a href="user/list">用户管理</a>
  <a >用户新增</a>
</span>
<form class="layui-form" action="user/add" lay-filter="form" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username"
                   required
                   lay-verify="required"
                   lay-reqText="用户名不可以为空"
                   lay-verType="tips"
                   placeholder="请输入用户名"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">昵称</label>
        <div class="layui-input-block">
            <input type="text" name="nickname"
                   required
                   lay-verify="required"
                   lay-reqText="昵称不可以为空"
                   lay-verType="tips"
                   placeholder="请输入昵称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="password" name="password"
                   required
                   lay-verify="required"
                   lay-reqText="密码不可以为空"
                   lay-verType="tips"
                   placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色</label>
        <div class="layui-input-block">
            <select
                    name="roleId" lay-verify="required"
                    lay-verify="required"
                    lay-reqText="角色不可以为空"
                    lay-verType="tips">
                <option value="">请选择</option>
                <c:forEach items="${roleList}" var="role" >
                    <option value="${role.id}">${role.roleName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" placeholder="请输入备注" class="layui-textarea"></textarea>
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
    layui.use('form',function(){
        var form = layui.form
        form.on('submit(form)',function(res){
            console.log(res)
            // return false

        })
    })
</script>
</body>
</html>
