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

    <title>日志</title>
    <link href="layui/css/layui.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/common.css?v=<%=Math.random()%>">

</head>
<body>
<span class="layui-breadcrumb">
<%--  <a href="">首页</a>--%>
  <a href="log/list">日志管理</a>
  <a >日志列表</a>
</span>
<table id="table" lay-filter="test" lay-size="lg"></table>

<br>
<%--${page}--%>
    <script type="text/javascript" src="layui/layui.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/qs.min.js"></script>
    <script type="text/html" id="btns">


    </script>
    <script type="text/html" id="toolbarDemo">
        <form class="layui-form " id="queryForm" lay-filter="queryFrom">
            <div class="layui-inline">
                <div class="layui-form-label" style="width: auto">
                    用户名
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="username" class="layui-input " value="{{d.where.username==undefined?'':d.where.username}}"  placeholder="请输入用户名">
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-form-label" style="width: auto">
                    url
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="url"
                           class="layui-input "
                           value="{{d.where.url==undefined?'':d.where.url}}"
                           placeholder="请输入url">
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-form-label" style="width: auto">
                    行为
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="action"
                           class="layui-input "
                           value="{{d.where.action==undefined?'':d.where.action}}"
                           placeholder="请输入行为">
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-form-label" style="width: auto">
                    日期
                </div>
                <div class="layui-input-inline">
                    <input type="text"
                           placeholder="请选择日期"
                           value="{{d.where.time==undefined?'':d.where.time}}"
                           name="time" class="layui-input" id="date" />
                </div>
            </div>

            <div class="layui-inline">
                <shiro:hasPermission name="permission:query">
                    <button type="button" class="layui-btn layui-btn-sm" lay-event="query">查询</button>
                </shiro:hasPermission>
            </div>
        </form>
    </script>
    <script type="text/javascript">
        var layer
        layui.use('layer',function(){
            layer = layui.layer
        })

        layui.use('table', function(){
            var table = layui.table;
            var laydate = layui.laydate
            // console.log(table)
            //第一个实例
            let t = table.render({
                elem: '#table',
                height: 'full-60',
                url: 'log/list/page', //数据接口
                page: true, //开启分页
                limit:10,
                limits:[10,20,30,50],
                autoSort:false,
                request:{
                    pageName:"pno",
                    limitName:"psize"
                },
                where:{
                    username:'',
                    url:'',
                    action:'',
                    sortField: 'time',
                    sortType:'desc'
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
                    {field: 'id', title: '主键', width:80},
                    {field: 'username', title: '用户名'},
                    {field: 'time', title: '创建时间', width: 177,sort:true},
                    {field: 'url', title: '请求url', width: 80},
                    {field: 'method', title: '请求方法' },
                    {field: 'action', title: '请求行为'},
                    {field: 'ip', title: '请求ip'},
                    {field: 'request', title: '请求数据'},
                    // {field: '',title:'操作',toolbar:'#btns',fixed:'right'}
                ]],
            });
            table.on('tool(test)',function(obj){
                console.log(obj)
                var id = obj.data.id
            })
            table.on('toolbar(test)',function(obj){
                if(obj.event == 'query') {
                    var queryForm = $("#queryForm").serialize()
                    var formData = Qs.parse(queryForm)

                    formData.beginTime = formData.time.split(' - ')[0]
                    formData.endTime = formData.time.split(' - ')[1]
                    // console.log(formData)
                    table.reload('table', {
                        initSort: obj,
                        where: formData,
                        done:function () {
                            console.log('done')
                            laydate.render({
                                elem:'#date',
                                range:true,
                                format:'yyyy-MM-dd',
                                type:'date'
                            })
                        }
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

            laydate.render({
                elem:'#date',
                range:true,
                format:'yyyy-MM-dd',
                type:'date'
            })

        });
    </script>

</body>
</html>
