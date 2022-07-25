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
            width: 400px;
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
                /*color: #faf2cc;*/
                /*color: rgba(50,70,250,0.7);*/
            }


        #div1{
            position: absolute;
            margin-left: 0px;
            width:280px;
            height: 30px;
            background-color: rgba(0,0,0,0);
            color: #fff;
            float:left;
        }
        #codeImg{
            float:right;

        }


        /*input {*/
            /*float: left;*/
        /*}*/


        /*<!-- 输入框和验证码对齐-->*/
             /*!*input,img {*!*/
                 /*!*vertical-align: middle;*!*/
             /*!*}*!*/





    </style>

</head>
<body>
    <video id="v" loop="loop" autoplay="autoplay" muted="muted" src="image/bg1.mp4"></video>
    <div class="login">
        <div class="title">
            便民战疫-疫情排查服务平台
        </div>
        <%--<div class="title">--%>
            <%--登录--%>
        <%--</div>--%>
        <form class="layui-form" action="login/admin" method="post">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <input type="text" name="username" required
                           lay-reqText="请输入账号"
                           lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
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
                <div class="layui-input-block" >
                        <input id="div1" type="text" name="imgCode" required
                               class="layui-input "



                        <%--style="background:url(/login/getCode) no-repeat right;background-size:80px 40px; "--%>

                               lay-reqText="请输入验证码"
                               lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
                    <img  src="/login/getCode" id="codeImg" onclick="refresh()" alt="">

                </div>

            </div>



            <div class="layui-form-item">
                <div class="layui-input-block" style="text-align: center">
                    <button class="layui-btn layui-btn-primary layui-border-blue" lay-submit lay-filter="formDemo">登陆</button>
                    <button type="reset" class="layui-btn layui-btn-primary  layui-border-green">重置</button>
                </div>
            </div>
        </form>
        <a href="/login/registerPage" class="layui-btn layui-btn-primary layui-border-blue">去注册</a>
        <a href="/index" class="layui-btn layui-btn-primary layui-border-blue" style="margin-left: 230px;" >免登录</a>
    </div>
    <script type="text/javascript" src="layui/layui.js"></script>
    <c:if test="${success == true}">
        <script>
            layer.msg("登陆成功")
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
    <script>


        /* 刷新验证码 */
        function refresh() {
            document.getElementById("codeImg").src = "login/getCode?time=" + new Date().getTime();
        }



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
