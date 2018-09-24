<%--
  Created by IntelliJ IDEA.
  User: wxy
  Date: 2018/3/29
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>

<head>
  <meta charset="UTF-8">
  <title>长春大学官方跑步平台</title>
  <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<div class="header">
  <h1>欢迎使用长春大学官方跑步平台</h1>
</div>
<div class="main-content">
  <form action="/LoginServlet" method="post" enctype="multipart/form-data">
    学号：<input type="text"  placeholder="学号" name="stuNum" id="u"></input>
    密码：<input type="text"  placeholder="密码" name="password" id="p" value="123456"></input>
    <input class="but" type="submit" value="登录" onclick="return checkSubmit();">
  </form>

  <script type="text/javascript">
      function checkSubmit(){
          var flag;
          var your_name = document.getElementById("u").value;
          var your_mima = document.getElementById("p").value;
          if( your_name == "" ){
              alert("请输入账号");
              return false;
          }
          if( your_mima == "" ){
              alert("请输入密码");
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
