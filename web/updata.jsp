<%--
  Created by IntelliJ IDEA.
  User: wxy
  Date: 2018/4/19
  Time: 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.ccuwxy.model.Log" %>
<%@ page import="cn.ccuwxy.model.Result" %>
<%@ page import="cn.ccuwxy.model.UserInfo" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>长春大学官方跑步平台</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<%Result result = (Result) session.getAttribute("result"); %>
<%UserInfo userInfo = (UserInfo) session.getAttribute("userInfo"); %>
<%Log log = (Log) session.getAttribute("log"); %>
<div class="header">
    <h1>欢迎使用长春大学官方跑步平台</h1>
</div>
<div class="main-content">
    <p>学号：<%=userInfo.getStuNumber() %> 性别：
        <%
            if (log.getSex().equals("M")) {
        %> 男<%
        } else {
        %> 女<%

            } %></p>
    <p>已跑公里数：<%=result.getResult() %>
    </p>
    <form action="/updataServlet" method="post" >
        <p>你想要跑多少公里？</p>
        <input type="text" name="result" placeholder="公里数" id="R">
        <p>(女1.01-2.89；男2.01-4.89)</p>
        <input class="but" type="submit" value="开跑" onclick="return checkSubmit1();">
    </form>

    <script type="text/javascript">
        function checkSubmit1() {
            var flag;
            var result = document.getElementById("R").value;
            if (result == "") {
                alert("请输入公里数！");
                return false;
            }
            return true;
        }

    </script>
</div>
<div class="footer">
    <p>&copy; WXY</p>
</div>
</body>
</html>
