<<%@ page import="com.alibaba.fastjson.JSONObject" %>
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
    <title>Title</title>
</head>
<body>


多个轨迹test的post
<form class="layui-form" action="http://localhost:8083/upload/add" lay-filter="form" method="post">
    <div class="layui-form-item" >
        <label class="layui-form-label">轨迹test的post</label>

        <!-- 第一个资料 -->
        <div class="control-group" id="download">
            <label class="control-label">轨迹：</label>
            <div class="controls">
                <input type="text" name="userId" placeholder="userId"  maxlength="255" class="input-xlarge">
                <input id="type" type="text" name="type" placeholder="type"  onchange="fileChange(this);" class="input-xlarge"/>

                <label >第0个：</label>
                <input id="jindu" type="text" name="GuiJi[0].jindu" placeholder="jindu" onchange="fileChange(this);" class="input-xlarge"/>
                <input id="weidu" type="text" name="GuiJi[0].weidu" placeholder="weidu"  onchange="fileChange(this);" class="input-xlarge"/>

            </div>
        </div>
        <div class="control-group" id="addDiv">
            <div class="controls">
                <input id="count" type="hidden" value="0">
                <input type="button" id="addDetail" value="添加资料" class="btn btn-primary"/>
            </div>
        </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>









post展示订单http://localhost:8083/upload/list
<form class="layui-form" action="http://localhost:8083/upload/list" lay-filter="form" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">list的post</label>
        <div class="layui-input-block">
            <input  type="text" name="userId" placeholder="userId"  />
            <input  type="text" name="pno" placeholder="pno"  />
            <input  type="text" name="psize" placeholder="psize"  />
            <input  type="text" name="type" placeholder="type"  />
            <input  type="text" class="time" placeholder="btime" name="btime"  />

            <input  type="text" name="sortType" placeholder="sortType" />
            <input  type="text" name="sortField" placeholder="sortField" />
            <input  type="text " class="time" placeholder="etime" name="etime" />

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


post上传：上传的地址http://localhost:8083/upload/add,
<form class="layui-form" action="http://localhost:8083/upload/add" lay-filter="form" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">add的post</label>
        <div class="layui-input-block">
            <input  type="text" name="userId" placeholder="userId"  />
            <input  type="text" name="type" placeholder="type"  />
            <input  type="text" name="jindu" placeholder="jindu" />
            <input type="text" name="weidu" placeholder="weidu"  />
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


get看订单详情地址http://localhost:8083/upload/orderSee,
<form class="layui-form" action="http://localhost:8083/upload/orderSee" lay-filter="form" method="get">
    <div class="layui-form-item">
        <label class="layui-form-label">orderSee的post</label>
        <div class="layui-input-block">
            <input  type="text" name="type" placeholder="type"  />
            <input  type="text" name="typeId" placeholder="typeId" />
            <input type="text" name="orderId" placeholder="orderId"  />
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>



post带一个修改功能，就是修改的回显，http://localhost:8083/upload/update，
<form class="layui-form" action="http://localhost:8083/upload/update" lay-filter="form" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">update的post</label>
        <div class="layui-input-block">
            <input  type="text" name="type" placeholder="type"  />
            <input  type="text" name="typeId" placeholder="typeId" />
            <input type="text" name="orderId" placeholder="orderId"  />
            <input  type="text" name="jindu" placeholder="jindu" />
            <input type="text" name="weidu" placeholder="weidu"  />
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

get删除订单地址http://localhost:8083/upload/delect,参数：type，typeId，orderId
<form class="layui-form" action="http://localhost:8083/upload/delect" lay-filter="form" method="get">
    <div class="layui-form-item">
        <label class="layui-form-label">delect的post</label>
        <div class="layui-input-block">
            <input  type="text" name="type" placeholder="type"  />
            <input  type="text" name="typeId" placeholder="typeId" />
            <input type="text" name="orderId" placeholder="orderId"  />
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


//地图
<form class="layui-form" action="https://apis.map.qq.com/ws/geocoder/v1/" lay-filter="form" method="get">
    <div class="layui-form-item">
        <label class="layui-form-label">test的get</label>
        <div class="layui-input-block">
            <input type="text" name="address" placeholder="请输入address">
            <input type="text" name="key" placeholder="key"  value="JYXBZ-3C5CJ-UBRF6-FOPY3-L546H-2BFIS" />
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


//地图11
<form class="layui-form" action="http://localhost:8083/indexMap/jingweidu" lay-filter="form" method="get">
    <div class="layui-form-item">
        <label class="layui-form-label">test的get</label>
        <div class="layui-input-block">
            <input type="text" name="address" placeholder="请输入address">
            <%--<input type="text" name="key" placeholder="key"  value="JYXBZ-3C5CJ-UBRF6-FOPY3-L546H-2BFIS" />--%>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

//getuser
<form class="layui-form" action="http://localhost:8083/login/getuser" lay-filter="form" method="get">
    <div class="layui-form-item">
        <label class="layui-form-label">getuser的get</label>
        <div class="layui-input-block">
            <%--<input type="text" name="address" placeholder="请输入address">--%>
            <%--<input type="text" name="key" placeholder="key"  value="JYXBZ-3C5CJ-UBRF6-FOPY3-L546H-2BFIS" />--%>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


<%--<script type="text/javascript" src="js/common.js"></script>--%>
<!-- 引入jQuery -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript"  src="js/qs.min.js"></script>
<script type="text/javascript">

$("#addDetail").click(function() {
var count = $("#count").val();
count++;
$("#count").attr("value",count);
// var html = '<div class="control-group"><label class="control-label">轨迹</label>' +
//     '           <div class="controls"><input type="text" name="list['+ count +'].name" maxlength="255" class="input-xlarge">'
//     +'                <label >userId：</label>' +
//     '                 <input id="imgFile" type="file" name="list['+ count +'].file" onchange="fileChange(this);" class="input-xlarge"/>' +
//     '                ' +
//     '          </div>' +
//     '       </div>';

var html = '<label >'+count+'：</label>\n' +
    '                <input id="jindu" type="text" name="GuiJi['+count+'].jindu" placeholder="jindu" onchange="fileChange(this);" class="input-xlarge"/>\n' +
    '                <input id="weidu" type="text" name="GuiJi['+count+'].weidu" placeholder="weidu"  onchange="fileChange(this);" class="input-xlarge"/>'
$("#addDiv").before(html);
});
</script>


<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '.time', //指定元素
            type:'datetime',
            format:'yyyy-MM-dd HH:mm:ss'
        });
    });
</script>
</body>
</html>
