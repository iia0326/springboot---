<%--
  Created by IntelliJ IDEA.
  User: zhangyunpeng
  Date: 2021/5/28
  Time: 11:43 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <%@include file="../../basepath.jsp"%>

    <title>菜单列表</title>
    <link href="layui/css/layui.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/common.css?v=<%=Math.random()%>">

</head>
<body>
<span class="layui-breadcrumb">
<%--  <a href="">首页</a>--%>
  <a href="menu/list">菜单管理</a>
  <a >菜单列表</a>
</span>
<table id="table" lay-filter="test" lay-size="lg"></table>

<%--${page}--%>
    <script type="text/javascript" src="layui/layui.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/qs.min.js"></script>
    <script type="text/html" id="btns">
        <shiro:hasPermission name="permission:menu-child">
            <a lay-event="edit" href="menu/list/tree/children/page?id={{d.id}}" class="layui-btn layui-btn-primary layui-btn-xs">查看子菜单</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="permission:update">
            <a lay-event="edit" href="menu/edit/page?id={{d.id}}" class="layui-btn layui-btn-warm layui-btn-xs">修改</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="permission:delete">
            <button lay-event="del" class="layui-btn layui-btn-danger layui-btn-xs">删除</button>
        </shiro:hasPermission>
    </script>
    <script type="text/html" id="icon">
        <i class="layui-icon {{d.icon}}"></i>
    </script>
    <script type="text/html" id="toolbarDemo">
        <form class="layui-form " id="queryForm" lay-filter="queryFrom">
<%--            <div class="layui-inline">--%>
<%--                <div class="layui-form-label">--%>
<%--                    用户名--%>
<%--                </div>--%>
<%--                <div class="layui-input-inline">--%>
<%--                    <input type="text" name="username" class="layui-input " value="{{d.where.username}}"  placeholder="请输入用户名">--%>
<%--                </div>--%>
<%--            </div>--%>
            <div class="layui-inline">
                <shiro:hasPermission name="permission:query">
                    <button type="button" class="layui-btn layui-btn-sm" lay-event="query">查询</button>
                </shiro:hasPermission>
                <shiro:hasPermission name="permission:insert">
                    <a href="menu/add/page" class="layui-btn layui-btn-sm" lay-event="add">添加</a>
                </shiro:hasPermission>

            </div>
        </form>
    </script>
    <script type="text/javascript">

        layui.use('table', function(){
            var table = layui.table;
            console.log(table)
            //第一个实例
            let t = table.render({
                elem: '#table',
                height: 'full-60',
                url: 'menu/list/tree', //数据接口
                page: true, //开启分页
                limit:10,
                limits:[10,20,30,50],
                autoSort:false,
                request:{
                    pageName:"pno",
                    limitName:"psize"
                },
                response:{
                    statusCode:200
                },
                toolbar:'#toolbarDemo',
                // defaultToolbar: ['filter', 'print', 'exports', {
                //     title: '提示' //标题
                //     ,layEvent: 'del' //事件名，用于 toolbar 事件中使用
                //     ,icon: 'layui-icon-tips' //图标类名
                // }],
                cols: [[ //表头
                    {field: 'id', title: '主键',sort:true},
                    {field: 'name', title: '菜单名称'},
                    {title: '图标',templet:'#icon'},

                    {field: '',title:'操作',toolbar:'#btns',fixed:'right'}
                ]],
            });
            table.on('tool(test)',function(obj){
                var id = obj.data.id
                if(obj.event == 'del'){
                    layer.confirm('正在删除',{
                        icon:3,
                        title:'提示'
                    },function(index){
                        console.log('confirm')
                        location.href = '<%=basePath%>menu/delete?id='+id
                        layer.close(index)
                    })
                }
            })
            table.on('toolbar(test)',function(obj){
                if(obj.event == 'query'){
                    // var queryForm =  $("#queryForm").serialize()
                    // var formData = Qs.parse(queryForm)
                    table.reload('table',{
                        initSort:obj
                        // where:formData
                    })
                }
            })
            table.on('sort(test)',function(res){
                table.reload('table',{
                    initSort: res //记录初始排序，如果不设的话，将无法标记表头的排序状态。
                    ,where: { //请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                        sortField: res.field //排序字段
                        ,sortType: res.type //排序方式
                    }
                })
            })
        });
    </script>
</body>
</html>
