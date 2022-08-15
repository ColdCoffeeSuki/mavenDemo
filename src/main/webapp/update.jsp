<%--
  Created by IntelliJ IDEA.
  User: Minami
  Date: 2022/8/9
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>updateBrand</title>
</head>
<body>
<h3>updateBrand</h3>
<form action="/mavenDemo/updateServlet" method="post">
<%--隱藏域，提交id--%>
    <input type="hidden" name="id" value="${brand.id}">
    brandName:<input name="brandName" value="${brand.brandName}"><br>
    companyName:<input name="companyName" value="${brand.companyName}"><br>
    ordered:<input name="ordered" value="${brand.ordered}"><br>
    description:<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
    status:
    <c:if test="${brand.status == 0}">
        <input type="radio" name="status" value="0" checked>禁用
        <input type="radio" name="status" value="1">啓用<br>
    </c:if>
    <c:if test="${brand.status == 1}">
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1" checked>啓用<br>
    </c:if>

    <input type="submit">
</form>

</body>
</html>
