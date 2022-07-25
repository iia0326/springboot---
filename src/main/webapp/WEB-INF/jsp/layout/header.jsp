<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
    <div class="title">
        <a href=""> <i class="layui-icon layui-icon-auz"></i> 便民战疫-疫情排查服务平台</a>
    </div>
    <c:if test="${userInfo!=null}">

        <%--<li class="layui-nav-item">--%>
        <%--<a href=""><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>--%>
        <%--<dl class="layui-nav-child">--%>
        <%--<dd><a href="">修改信息</a></dd>--%>
        <%--<dd><a href="">安全管理</a></dd>--%>
        <%--<dd><a href="/login/logout;">退了</a></dd>--%>
        <%--</dl>--%>
        <%--</li>--%>
        <div class="user-info" id="user-info">
        <i class="layui-icon layui-icon-user"></i>
        当前用户：${userInfo.nickname}
        <%--当前用户：${userInfo==null?'未登录':userInfo.nickname}--%>
        <i class="layui-icon layui-icon-triangle-d"></i>
       </div>
        <%--class="layui-bg-red"--%>
    </c:if>
    <c:if test="${userInfo==null}">
        <li  class="title">
        <a href="/login/page">登录<span class="layui-badge-dot" ></span></a>
        <a href="/login/registerPage">注册<span ></span></a>
        <%--<i class="layui-icon layui-icon-triangle-d"></i>--%>
        </li>
    </c:if>
</header>
