<%--
  Created by IntelliJ IDEA.
  User: yangchao
  Date: 2018/3/14
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户分页</title>
</head>
<body>
    <c:if test="${not empty userList }">
        <table>
            <thead>
            <tr>
                <td>用户编号</td>
                <td>账号</td>
                <td>性别</td>
                <td>出生日期</td>
                <td>个性签名</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList }" var="user">
                <tr>
                    <td>${user.user_id }</td>
                    <td>${user.account }</td>
                    <td>${user.sex }</td>
                    <td>${user.birthday }</td>
                    <td>${user.signature }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        当前页:${current }&nbsp;&nbsp;总页码:${pageCount }<br/>
        <c:if test="${current==1 }">上一页</c:if><c:if test="${current > 1 }"><a href="/heart_website/user/limitChange?current=${current }&dir=pre">上一页</a></c:if>
        <c:if test="${current==pageCount }">下一页</c:if><c:if test="${current < pageCount }"><a href="/heart_website/user/limitChange?current=${current }&dir=next">下一页</a></c:if>
    </c:if>
</body>
</html>
