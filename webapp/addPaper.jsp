<%--
  Created by IntelliJ IDEA.
  User: yangchao
  Date: 2018/3/25
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加测试题</title>
</head>
<body>
<form action="/heart_website/paper/addTestPaper" method="post">
    类型:<select name="type">
            <option value="1">爱情测试</option>
            <option value="2">专业测试</option>
            <option value="3">亲情测试</option>
        </select><br/>
    名称:<input type="text" name="test_name"/><br/>
    测试人数:<input type="text" name="test_num" value="0"/><br/>
    图片地址:<input type="text" name="picture_addr"/><br/>
    <input type="submit" value="添加测试题"/><br/>
</form>
</body>
</html>
