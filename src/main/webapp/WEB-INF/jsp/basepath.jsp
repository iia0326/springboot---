<%--
  Created by IntelliJ IDEA.
  User: zhangyunpeng
  Date: 2021/5/28
  Time: 11:47 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", -10);
    String path = request.getContextPath();

    String basePath =request.getScheme()+"://"+request.getServerName()+":"

            +request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">

