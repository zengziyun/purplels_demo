<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 123456
  Date: 2019/1/24
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html lang="en">
<html>
<head>
    <title>测试jstl</title>
</head>
<body>
    <h3>这是一行h3的标题</h3>
    <p>

        今天的日期是：<%= new Date()%>
    </p>
    你的ip地址是:
    <%
        out.println("your ip is "+ request.getRemoteAddr()+"</br>");
        out.println("这是一段代码");
    %>

    <h3>for循环实例</h3>
    <%
        int count = (int)session.getAttribute("count");
        for (int i = 0;i < count;i++) {
    %>
        <p>循环</p>
    <%
        }
    %>

    <h3>标签 c:if</h3>
        <c:if test="${username !=null}">
        <p>用户名为：username<p>
        </c:if>
    <h3>标签 c:choose</h3>
    <c:choose>
        <c:when test="${salary <= 0}">
            太惨了。
        </c:when>
        <c:when test="${salary > 1000}">
            不错的薪水，还能生活。
        </c:when>
        <c:otherwise>
            什么都没有。
        </c:otherwise>
    </c:choose>
    <h3>布局</h3>
    <%@include file="footer.jsp"%>
</body>
</html>
