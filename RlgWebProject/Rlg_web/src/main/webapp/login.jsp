<%--
  Created by IntelliJ IDEA.
  User: 谷新宇
  Date: 2019/8/10
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>互助网-登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1 maximum-scale=1">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/zhaoshi.css">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style type="text/css">
        .error{
            color:red;
        }
        .show1{
            display:none;
        }
    </style>
    <script language="javascript">
        function myReload() {
            document.getElementById("CreateCheckCode").src = document
                    .getElementById("CreateCheckCode").src
                + "?" + Math.random();
        }
    </script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header"  >
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="javascript:void;">互助网</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="ZhaoLing" id="color yuyuu" >招领平台</a></li>
                <li><a href="ShiWuServlet" id="color">失物平台</a></li>
                <li><a href="news" id="color">大家说法</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-sm-3"></div>
        <div class="col-md-4 col-sm-6">
            <div class="btn btn-primary btn-block btn-lg text-center" style="margin: 40px 0 30px;">登录账号 <span style="color:red;">${message }</span></div>
            <form action="Login" method="post">
                <div class="form-group">
                    <label>学号<span id="spannumber" class="error show1">(学号应该在10到15个字符之内)</span></label>
                    <input type="text" id="number" name="number" required placeholder="Enter Number......" class="form-control" maxlength="25">
                </div>
                <div class="form-group">
                    <label>密码<span id="spanpassword" class="error show1">(密码应该在6到15个字符之内)</span></label>
                    <input type="password" id="password" name="password" required placeholder="Enter Password...." class="form-control" maxlength="30">
                </div>
                <div class="form-group">
                    <label>验证码</label>
                    <input type="text" id="checkCode" name="checkCode" id="checkCode" required placeholder="Enter VerificationCode...." class="form-control" maxlength="4">
                    <img src="PictureCheckCode" id="CreateCheckCode" align="middle">
                    <span style="cursor:pointer; color:blue;" onclick="myReload()"> 看不清,换一个</span>
                    <span id="checktext"></span>
                </div>
                <div class="btn-group" role="group" aria-label="..." style="left: 9%;margin-bottom: 10px;">
                    <button type="submit" disabled="disabled" id="submit" class="btn btn-primary">登录</button>
                    <button type="button" class="btn btn-primary" onclick="return forgetPwd();">忘记密码</button>
                    <button type="button" class="btn btn-primary" onclick="return backToSign();">注册</button>
                    <button type="button" class="btn btn-primary" onclick="return backToHome();">返回</button>
                </div>
            </form>
            <footer>
                <!-- <p class="pull-right"><a href="#">Back to top</a></p>-->
                <div style="width: 100%; height: 50px;color: #fff;background-color: black;line-height: 50px; border-radius: 5px;">
                    <div style="text-align: center;">
                        Copyright <span class="glyphicon glyphicon-copyright-mark"></span>
                        <span style="text-align: center;">设计制作：2016级网络工程</span>
                    </div>
                </div>
            </footer>
            <script type="text/javascript">
                function backToHome(){
                    window.location.href = "ZhaoLing";
                    return false;
                }
                function backToSign(){
                    window.location.href = "Sign";
                    return false;
                }
                function forgetPwd() {
                    window.location.href = "Forget";
                    return false;
                }
            </script>
        </div>
        <div class="col-md-4 col-sm-3"></div>
    </div>
</div>
<script src="js/jquery-1.12.0.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $(function(){
        $("#number").blur(function(){
            $.get("LoginAjax",{number:$(this).val()},function(data,textstatus){
                if(data){
                    alert("你已经登录了！");
                }
            })
        });
        $("#password").blur(function(){
            $.get("LoginAjax",{number:$("#number").val(),password:$(this).val()},function(data,textStatus){
                if(data) {
                    //alert("true");
                    $("#number").css("border-color","#ccc");
                    $("#password").css("border-color","#ccc");
                }else {
                    alert("学号或者密码不正确，请重新输入！");
                    $("#number").css("border-color","red");
                    $("#password").css("border-color","red");
                }
            });
        });
        $("#checkCode").keyup(function(){
            $.get("LoginAjax",{checkCode:$(this).val()},function(data,textStatus){
                if(data) {
                    $("#checktext").css({"color":"green"}).text("填写正确！");
                    $("#submit").removeAttr("disabled");
                } else{
                    $("#checktext").css({"color":"red"}).text("填写不正确！");
                    $("#submit").attr("disabled","disabled");
                }
            });
        });
        //检查学号的正确性
        $("#number").keyup(function(){
            //alert($.trim($(this).val()).length);
            if($.trim($(this).val()).length == "" || $.trim($(this).val()).length < 10 || $.trim($(this).val()).length > 15) {
                $("#spannumber").css("display","block");
            } else {
                $("#spannumber").css("display","none");
            }
        });
        //检查密码的正确性
        $("#password").keyup(function(){
            //alert($.trim($(this).val()).length);
            if($.trim($(this).val()).length == "" || $.trim($(this).val()).length < 6 || $.trim($(this).val()).length > 15) {
                $("#spanpassword").css("display","block");
            } else {
                $("#spanpassword").css("display","none");
            }
        });
    });
</script>
</body>
</html>