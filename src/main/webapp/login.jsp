<%--
  Created by IntelliJ IDEA.
  User: Minami
  Date: 2022/8/7
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>log in or sign up</title>
</head>
<body>
<form action="/mavenDemo/loginServlet">
    <h1 id="loginMsg">Log in</h1>
    <div>${login_msg}${signup_msg}</div>
    <p>Username:<input type="text" name="username"  ></p>
    <p>Password:<input type="password" name="password"></p>
    <!--<p>Remember:<input type="checkbox" name="remember" value="1"></p>-->

    <input type="submit" value="Log in登錄">
    <input type="reset" value="Reset重置">
    <a href="signup.jsp">Sign up注冊</a>

</form>
</body>
</html>