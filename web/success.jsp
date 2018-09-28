<%@ page import="cn.ccuwxy.model.Result" %><%--
  Created by IntelliJ IDEA.
  User: wxy
  Date: 2018/4/20
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跑步完成</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<%Result result=(Result) session.getAttribute("result");  %>

<div class="header">
    <h1>欢迎使用长春大学官方跑步平台</h1>
</div>
<div class="main-content">
    <p>已跑公里数：<%=result.getResult() %></p>
    <input class="but" type="submit" value="重新登录" name="" onclick="window.location.href='login.jsp'"/>
</div>
<div class="footer">
    <p>&copy; WXY</p>
</div>






</body>
</html>
