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
    <title>修改主菜单</title>
    <%@include file="../../basepath.jsp"%>
    <link href="layui/css/layui.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/common.css?v=<%=Math.random()%>">
</head>
<body>
<span class="layui-breadcrumb">
<%--  <a href="">首页</a>--%>
  <a href="menu/list">主菜单管理</a>
  <a >主菜单修改</a>
</span>
<form class="layui-form" action="menu/edit" lay-filter="form" method="post">
    <input type="hidden" name="id" value="${formData.id}"/>
    <div class="layui-form-item">
        <label class="layui-form-label">菜单名称</label>
        <div class="layui-input-block">
            <input type="text" name="name"
                   required
                   value="${formData.name}"
                   lay-verify="required"
                   lay-reqText="菜单名不可以为空"
                   lay-verType="tips"
                   placeholder="请输入菜单名"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label">路由</label>--%>
<%--        <div class="layui-input-block">--%>
<%--            <input type="text" name="url"--%>
<%--                   required--%>
<%--                   lay-verify="required"--%>
<%--                    value="${formData.url}"--%>
<%--                   lay-reqText="路由不可以为空"--%>
<%--                   lay-verType="tips"--%>
<%--                   placeholder="请输入路由" autocomplete="off" class="layui-input">--%>
<%--        </div>--%>
<%--    </div>--%>

    <div class="layui-form-item">
        <label class="layui-form-label">图标</label>
        <div class="layui-input-block">
            <select
                    name="icon"
                    required
                    lay-verify="required"
                    lay-search
                    lay-reqText="图标不可以为空"
                    lay-verType="tips">
                <option value="">请选择</option>
                <c:forEach items="${iconList}" var="icon" >
                    <option value="${icon}" ${formData.icon==icon?'selected':''}>${icon}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" placeholder="请输入备注" class="layui-textarea">${formData.remark}</textarea>
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
