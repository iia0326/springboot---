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
  <a >系统设置</a>
  <a >密码修改</a>
</span>
<%--${error}--%>
<form class="layui-form" action="user/password/change" lay-filter="form" method="post">
    <input type="hidden" name="id" value="${formData.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username"
                   required
                   <%--readonly--%>
                   lay-verify="required"
                   lay-reqText="用户名不可以为空"
                   lay-verType="tips"
                   value="${formData.username}"
                   placeholder="请输入用户名"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">昵称</label>
        <div class="layui-input-block">
            <input type="text" name="nickname"
                   required
                   <%--readonly--%>
                   value="${formData.nickname}"
                   lay-verify="required"
                   lay-reqText="昵称不可以为空"
                   lay-verType="tips"
                   placeholder="请输入昵称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">原密码</label>
        <div class="layui-input-block">
            <input type="password" name="password"
                   required
                   value="${formData.password}"
                   lay-verify="required"
                   lay-reqText="密码不可以为空"
                   lay-verType="tips"
                   placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-block">
            <input type="password" name="password1"
                   required
                   value="${formData.password1}"
                   lay-verify="required"
                   lay-reqText="新密码不可以为空"
                   lay-verType="tips"
                   placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-block">
            <input type="password" name="password2"
                   required
                   value="${formData.password2}"
                   lay-verify="required"
                   lay-reqText="确认密码不可以为空"
                   lay-verType="tips"
                   placeholder="请输入密码" autocomplete="off" class="layui-input">
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
<c:if test="${error}">
    <script>
        layui.use('layer',function(){
            var layer = layui.layer
            layer.msg('${msg}');
        })

    </script>
</c:if>
<c:if test="${complete}">
    <script>
        window.parent.frames.location.href="<%=basePath%>login/logout"
    </script>
</c:if>
</body>
</html>
