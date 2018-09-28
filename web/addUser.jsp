<%--
  Created by IntelliJ IDEA.
  User: Mr.Wang
  Date: 2018/9/28
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<div class="header">
    <h1>欢迎使用长春大学官方跑步平台</h1>
</div>
<div class="main-content">
    <form action="/AddUserServlet" method="post">
        学号：<input type="text"  name="stuNumber" />
        密码：<input type="text"  name="password"  value="123456"/>
        电话：<input type="text" name="phoneNumber" value="123"/>
        User_Agent:<input type="text" name="User_Agent" value="Dalvik/2.1.0(Linux; U; Anfroid 8.1.0; EML-AL00 BUILD/HUAWEIEML-AL00"/>
        device:<input type="text" name="device" value="Android,27,8.0.1"/>
        IMEI:<input type="text" name="IMEI"/>
        IMSI:<input type="text" name="IMSI"/>
        Model:<input type="text" name="model" value="EML-AL00">
        screen:<input type="text" name="screen" value="1080x2244">
        <input class="but" type="submit" value="登录" onclick="return checkSubmit();">
    </form>
</div>
<div class="footer">
    <p>&copy; WXY</p>
</div>
</body>
</html>
