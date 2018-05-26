<%--
  Created by IntelliJ IDEA.
  User: yangchao
  Date: 2018/3/14
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加音乐</title>
</head>
<body>
<form action="/heart_website/music/addMusic" method="post">
    音乐名:<input type="text" name="name"/><br/>
    演唱者:<input type="text" name="musician"/><br/>
    上传日期:<input type="text" name="upload_date"/>
    描述:<textarea name="description" cols="50" rows="30"></textarea>
    类型:<select name="type">
            <option value="1">爱情音乐</option>
            <option value="2">专业音乐</option>
            <option value="3">亲情音乐</option>
        </select><br/>
    播放量:<input type="text" name="play_num" value="0"><br/>
    地址:<input type="text" name="save_addr" value="/static/music/1.mp4"><br/>
    <input type="submit" value="添加"/><br/>
</form>
</body>
</html>
