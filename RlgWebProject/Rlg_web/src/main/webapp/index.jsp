<%--
  Created by IntelliJ IDEA.
  User: 谷新宇
  Date: 2019/7/25
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/manage/user/login.do" method="post" style="background: greenyellow; margin: 100px auto; width: 200px; height: 200px;" >
    <span>账户： </span><input type="text" placeholder="账户" name="username"> <br>
    <span>密码： </span><input type="password" placeholder="密码" name="password"><br>
    <span>需要禁用的id号： </span><input type="text" placeholder="输入要禁用的id号" name="uid"><br>
    <input type="submit" value="提交">
</form>
</body>uid
</html>
