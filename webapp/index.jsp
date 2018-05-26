<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
    <form action="/heart_website/admin/login" method="post">
        账号:<input type="text" name="account"/><br/>
        密码:<input type="password" name="password"/><br/>
        <input type="submit" value="登录"/><br/>
    </form>
    <a href="/heart_website/user/getUserList">获取用户列表</a><br/>
    <a href="/heart_website/user/getUserById/1">根据用户编号获取用户信息</a><br/>
    <br/><br/>
    <a href="/heart_website/addArticle.jsp">添加文章</a><br/>
    <a href="/heart_website/article/getArticleById/1">更新文章</a>
    <br/><br/>
    <a href="/heart_website/addMusic.jsp">添加音乐</a><br/>
    <a href="/heart_website/music/getMusicById/1">更新音乐</a><br/>
    <br/><br/>
    <a href="/heart_website/filterForum.jsp">过滤论坛铭感文字</a><br/>
    <br/><br/>
    <a href="/heart_website/addPaper.jsp">添加测试试题</a><br/>
    <a href="/heart_website/paper/deletePaper/3">删除测试试题</a><br/>
</body>
</html>
