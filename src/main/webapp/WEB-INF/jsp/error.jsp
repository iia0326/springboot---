<%--
  Created by IntelliJ IDEA.
  User: zhangyunpeng
  Date: 2021/8/4
  Time: 1:12 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>error</title>
</head>
<body>
    <h1>发生错误</h1>
    <h4>错误原因：${msg}</h4>
    <h5>
        错误内容：${errorInfo}
    </h5>
    <h5>
        堆栈信息：${stackInfo}
    </h5>
</body>
</html>
