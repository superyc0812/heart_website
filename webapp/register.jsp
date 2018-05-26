<%--
  Created by IntelliJ IDEA.
  User: yangchao
  Date: 2018/3/11
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
                pageEncoding="UTF-8"%>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<form action="/heartWebsite/user/register" method="post">
    账号:<input type="text" name="account"/><br/>
    密码:<input type="password" name="password"/><br/>
    性别:<input type="radio" name="sex" value="1"/>男
    <input type="radio" name="sex" value="0"/>女<br>
    生日:<input type="text" name="birthday"/><br/>
    个性签名:<input type="text" name="signature"/><br/>
    <input type="submit" value="注册"/><br/>
</form>
</body>
</html>
