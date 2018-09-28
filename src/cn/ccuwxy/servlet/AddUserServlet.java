package cn.ccuwxy.servlet;

import cn.ccuwxy.model.HttpHeaderss;
import cn.ccuwxy.model.UserInfo;
import cn.ccuwxy.service.HttpHeadersService;
import cn.ccuwxy.service.HttpHeadersServiceImpl;
import cn.ccuwxy.service.UserInfoService;
import cn.ccuwxy.service.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String stuNumber = request.getParameter("stuNumber");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String User_Agent = request.getParameter("User_Agent");
        String device = request.getParameter("device");
        String IMEI = request.getParameter("IMEI");
        String IMSI = request.getParameter("IMSI");
        String model = request.getParameter("model");
        String screen = request.getParameter("screen");
        UserInfo userInfo = new UserInfo();
        UserInfoService userInfoService = new UserInfoServiceImpl();
        userInfo.setStuNumber(stuNumber);
        userInfo.setPassword(password);
        userInfo.setPhoneNumber(phoneNumber);
        HttpHeaderss httpHeaderss = new HttpHeaderss();
        HttpHeadersService httpHeadersService = new HttpHeadersServiceImpl();
        httpHeaderss.setStuNumber(stuNumber);
        httpHeaderss.setUser_Agent(User_Agent);
        httpHeaderss.setDevice(device);
        httpHeaderss.setIMEI(IMEI);
        httpHeaderss.setIMSI(IMSI);
        httpHeaderss.setModel(model);
        httpHeaderss.setScreen(screen);
        if(userInfoService.intoUserInfo(userInfo)&& httpHeadersService.intohttpHeaders(httpHeaderss)){
            response.sendRedirect("addSucess.jsp");
        }

    }
}
