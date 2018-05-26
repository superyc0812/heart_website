<%--
  Created by IntelliJ IDEA.
  User: yangchao
  Date: 2018/3/13
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>更新文章</title>
</head>
<body>
<form action="/heart_website/article/updateArticle" method="post">
    <input name="article_id" value="${article.article_id}" type="hidden"/>
    标题:<input type="text" name="title" value="${article.title}"/><br/>
    上传日期:<input type="text" name="upload_date" value="${article.upload_date}"/><br/>
    类型:<select name="type">
            <option value="1">爱情文章</option>
            <option value="2">专业文章</option>
            <option value="3">亲情文章</option>
        </select><br/>
    作者:<input type="text" name="author" value="${article.author}"/><br/>
    内容:<textarea name="content" cols="60" rows="20">${article.content}</textarea><br/>
    阅读量:<input type="text" name="read_num" value="${article.read_num}"><br/>
    <input type="submit" value="更新"/><br/>
</form>
</body>
</html>
