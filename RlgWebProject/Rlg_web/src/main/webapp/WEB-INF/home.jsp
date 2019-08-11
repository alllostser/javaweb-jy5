<%--
  Created by IntelliJ IDEA.
  User: 谷新宇
  Date: 2019/8/10
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pojo.Users" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!--输出,条件,迭代标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> <!--数据格式化标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%> <!--数据库相关标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> <!--常用函数标签库-->

<html>
<head>
    <title>主页</title>
</head>
<body>
    <%--<%--%>
       <%--HttpSession hs = request.getSession();--%>
        <%--Users u = (Users) hs.getAttribute("user");--%>
    <%--%>--%>
    <%--<p>--%>
        <%--欢迎管理员<%=u.getUname()%>--%>
    <%--</p>--%>
<div>欢迎管理员：${user.uname}</div>
    <ul>
        <li><a href="list.do">用户列表</a></li>
        <li><a href="">商品列表</a></li>
    </ul>

</body>
</html>
