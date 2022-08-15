<%--
  Created by IntelliJ IDEA.
  User: Minami
  Date: 2022/8/9
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<form action="/mavenDemo/signupServlet" method="post">
    <table>
        <tr>
            <td>Username</td>
            ${signup_msg}
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
    </table>
    <input type="submit" value="submit">
</form>


</body>
</html>
