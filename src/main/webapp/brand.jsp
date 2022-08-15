<%--
  Created by IntelliJ IDEA.
  User: Minami
  Date: 2022/8/7
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Welcome ${user.username}</h2>
<input type="button" value="add 新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>id</th>
        <th>brandName</th>
        <th>companyName</th>
        <th>ordered</th>
        <th>description</th>
        <th>status</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 1}">
                <td>啓用</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>禁用</td>
            </c:if>
            <td><a href="/mavenDemo/selectByIdServlet?id=${brand.id}">修改</a> / <a href="/mavenDemo/deleteServlet?id=${brand.id}">刪除</a></td>
        </tr>
    </c:forEach>
</table>
<script>
    document.getElementById("add").onclick = function () {
        location.href = "/mavenDemo/addBrand.jsp";
    }
</script>
</body>
</html>
