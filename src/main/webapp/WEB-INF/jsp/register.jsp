<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangyunpeng
  Date: 2021/5/28
  Time: 1:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%@ include file="basepath.jsp"%>
    <title>便民战疫-疫情排查服务平台</title>
    <link href="layui/css/layui.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        #v{
            position: absolute;
            width: 100%;
            height: 100%;
            left: 0px;
            top: 0px;
            object-fit: cover;
        }
        .login{
            position: absolute;
            left: 50%;
            top:50%;
            transform: translate(-50%,-50%);
            width: 500px;
            background-color: rgba(30,60,120,0.3);
            padding:25px 50px;
            border-radius: 7px;
            border:1px solid rgba(50,70,250,0.7);
            backdrop-filter: blur(5px);
            animation-name: fade-down;
            animation-duration: 1s;
        }
        .login .title{
            text-align: center;
            color: #fff;
            font-weight: bold;
            font-size: 28px;
            padding-bottom: 25px;
            line-height: 60px;
        }
        @keyframes fade-down {
            from{
                transform: translateX(-50%) translateY(-700px);
                opacity: 0;
            }
            to{
                transform: translateX(-50%) translateY(-50%);
                opacity: 1;
            }
        }
        .login .layui-input-block{
            margin-left: 0px;
        }
        .login .layui-input-block .layui-input{
            background-color: rgba(0,0,0,0);
            color: #fff;
        }

        .login .layui-input-block input::-webkit-input-placeholder {
            color: #8a82b8;
        }


        #div1{
            position: absolute;
            margin-left: 0px;
            width:380px;
            height: 30px;
            background-color: rgba(0,0,0,0);
            color: #fff;
            float:left;
        }
        #codeImg{
            float:right;

        }

    </style>

</head>
<body>
    <video id="v" loop="loop" autoplay="autoplay" muted="muted" src="image/bg1.mp4"></video>
    <div class="login">
        <%--<div class="title">--%>
        <%--注册--%>
    <%--</div>--%>
        <div class="title">
            便民战疫-疫情排查服务平台：注册
        </div>


        <form class="layui-form" action="login/register" method="post">
            <div class="layui-form-item">

                <div class="layui-input-block">
                    <td>
                        <input id="username" type="text" name="username" required


                               lay-verify="required"
                               lay-reqText="用户名不可以为空"
                               lay-verType="tips"
                               placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        <%--<span id="isbnMsg2" style="color: #b92c28"></span>--%>
                        <span id="isbnMsg" style="color: #00FF00;"></span>
                    </td>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <input type="text" name="nickname" required

                       lay-verify="required"
                       lay-reqText="昵称不可以为空"
                       lay-verType="tips"
                       placeholder="请输入昵称" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <input type="password"
                           lay-reqText="请输入密码"
                           name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="password"
                       lay-reqText="请确认密码"
                       name="password1" required lay-verify="required" placeholder="请重复输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>

            <div class="layui-form-item">
                <div class="layui-input-block" >
                    <input id="div1" type="text" name="imgCode" required
                           class="layui-input"

                    <%--style="background:url(/login/getCode) no-repeat right;background-size:80px 40px; "--%>

                           lay-reqText="请输入验证码"
                           lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
                    <img  src="/login/getCode" id="codeImg" onclick="refresh()" alt="">

                </div>

            </div>

            <div class="layui-form-item">
                <div class="layui-input-block" style="text-align: center">
                    <button class="layui-btn layui-btn-primary layui-border-blue" lay-submit lay-filter="formDemo">注册</button>
                    <button type="reset" class="layui-btn layui-btn-primary layui-border-green">重置</button>
                </div>
            </div>
        </form>

      <a href="/login/page"  class="layui-btn layui-btn-primary layui-border-blue" > 去登录</a>
            <a href="/index" class="layui-btn layui-btn-primary layui-border-blue" style="margin-left: 330px;" >免登录</a>

    </div>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="layui/layui.js"></script>
    <c:if test="${success}">
        <script>
            layer.msg("注册成功")
        </script>
    </c:if>
    <c:if test="${success == false}">
        <script>
            layer.msg("用户名或密码错误")
        </script>
    </c:if>

    <c:if test="${code == false}">
        <script>
            layer.msg("验证码错误")
        </script>
    </c:if>
    <c:if test="${name == false}">
        <script>
            layer.msg("用户名已存在")
        </script>
    </c:if>
    <script>

        /* 刷新验证码 */
        function refresh() {
            document.getElementById("codeImg").src = "login/getCode?time=" + new Date().getTime();
        }

        //异步请求用户名
        // $(document).ready(function(){//监听文档是否加载完毕
                $("#username").blur(function(){//文档加载完毕后，监听失去焦点事件
                    // alert("11");
                    //1.获取username的值
                    var  username = $("#username").val();
                    //2.校验数据后发送ajax请求到服务器，
                    //使用json发送数据到服务器
                    $.get("login/chectUserName",{"username":username},function(data){
                        //回调函数：发送异步请求到服务器，服务器处理后会返回相关数据，服务器返回后浏览器会自动调用(回调)该函数
                        //3.服务器返回查询结果后，提示用户操作
                        // alert(data);
                        var d = eval(data);//eval函数把返回的字符串转换成json对象
                        if (d) {
                            $("#isbnMsg").text("用户名不可使用，已经存在");
                            $("#isbnMsg").css('color','red');

                            // $("#isbnMsg").style="color: #b92c28";

                        } else {
                            $("#isbnMsg").text("用户名可以使用");
                            $("#isbnMsg").css('color','green');
                            // $("#isbnMsg").css('background-color','red');
                            // $("#isbnMsg").text.style="color: #00FF00";
                        }
                    });
                });
        //     }
        // );



        // layui.use('form', function(){
        //     var form = layui.form;
        //     console.log(form)
        //     //监听提交
        //     form.on('submit(formDemo)', function(data){
        //         // layer.msg(JSON.stringify(data.field));
        //         return true;
        //     });
        //
        // });
    </script>
</body>
</html>
