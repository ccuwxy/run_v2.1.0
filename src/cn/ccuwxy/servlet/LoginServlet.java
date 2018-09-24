package cn.ccuwxy.servlet;

import cn.ccuwxy.model.UserInfo;
import cn.ccuwxy.service.UserInfoService;
import cn.ccuwxy.service.UserInfoServiceImpl;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession httpSession = request.getSession();
        String stuNum = request.getParameter("stuNum");
        String password = request.getParameter("password");
        UserInfoService userInfoService = new UserInfoServiceImpl();
        UserInfo userInfo = new UserInfo();
        userInfo = userInfoService.findByStuNumber(stuNum);
        if(userInfo==null){
            response.sendRedirect("stop.jsp");
            return;
        }else{
            userInfo.setPassword(password);

        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
