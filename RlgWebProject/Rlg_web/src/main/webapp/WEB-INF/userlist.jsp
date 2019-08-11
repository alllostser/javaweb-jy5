<%--
  Created by IntelliJ IDEA.
  User: 谷新宇
  Date: 2019/8/10
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> <!--数据格式化标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%> <!--数据库相关标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> <!--常用函数标签库-->
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <div>超级管理员${user.uname}</div>
    <c:forEach items="${uli.data}" var="us">
        ${us.uname}
    </c:forEach>
    <table>
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>电话</th>
            <th>权限</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${uli.data}" var="us">
            <tr>
                <td>${us.uid}</td>
                <td>${us.uname}</td>
                <td>${us.psd}</td>
                <td>${us.tel}</td>
                <td>${us.type}</td>
                <td>${us.states}</td>
                <td>
                    <a href="">添加</a>
                    <a href="">删除</a>
                    <a href="/manage/user/disableuser.do?uid=${us.uid}">修改</a>
                </td>
            </tr>

        </c:forEach>
    </table>
</body>
</html>
