<%--
  Created by IntelliJ IDEA.
  User: Minami
  Date: 2022/8/8
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>addBrand</title>
</head>
<body>
<h3>addBrand</h3>
<form action="/mavenDemo/addServlet" method="post">
    brandName:<input name="brandName"><br>
    companyName:<input name="companyName"><br>
    ordered:<input name="ordered"><br>
    description:<textarea rows="5" cols="20" name="description"></textarea><br>
    status:
    <input type="radio" name="status" value="0">禁用
    <input type="radio" name="status" value="1">啓用<br>

    <input type="submit">
</form>

</body>
</html>
