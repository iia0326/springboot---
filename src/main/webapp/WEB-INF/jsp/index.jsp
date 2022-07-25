<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kangyi.pojo.Menu" %><%--
  Created by IntelliJ IDEA.
  User: zhangyunpeng
  Date: 2021/5/28
  Time: 11:43 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="basepath.jsp"%>

    <title>便民战疫-疫情排查服务平台</title>
    <link href="layui/css/layui.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/common.css?v=<%=Math.random()%>">
</head>
<body>
    <%@include file="layout/header.jsp"%>
    <section class="section">

        <%@include file="layout/aside.jsp"%>

        <main class="main">
            <%@include file="layout/tabbar.jsp"%>

            <iframe id="iframe" name="inner-page" ></iframe>
        </main>
        <button class="layui-btn menu-btn layui-hide-md layui-show-xs-block" id="toggle-menu">

            <i class="layui-icon layui-icon-spread-left"></i>
        </button>
        <div class="toggle-menu-bg" ></div>
    </section>
    <script type="text/javascript" src="layui/layui.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        <%
            List<Menu> list = (List<Menu>)session.getAttribute("menuList");
            String mList = JSONObject.toJSON(list).toString();
        %>
        var menuList = <%=mList%>
        var baseUrl = '<%=path%>'
        iframe.src = menuList[0].children[0].url
    </script>
    <script type="text/javascript" src="js/common.js"></script>

</body>
</html>
