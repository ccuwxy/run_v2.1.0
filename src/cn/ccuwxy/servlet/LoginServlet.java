package cn.ccuwxy.servlet;

import cn.ccuwxy.model.UserInfo;
import cn.ccuwxy.service.ReadJsonService;
import cn.ccuwxy.service.ReadJsonServiceImpl;
import cn.ccuwxy.service.UserInfoService;
import cn.ccuwxy.service.UserInfoServiceImpl;
import cn.ccuwxy.util.HttpUrl;

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
            String loginUrl=HttpUrl.loginUrl+"?stuNum="+userInfo.getStuID()+
                    "&phoneNum="+userInfo.getPhoneNumber()+"&passWd="+userInfo.getMd5Password()+
                    "&schoolId="+userInfo.getSchoolID()+"&stuId="+userInfo.getStuID()+
                    "&token="+userInfo.getToken();
            ReadJsonService readJsonService = new ReadJsonServiceImpl();
            if(readJsonService.getUTIDByJson(loginUrl)!=null){
                response.sendRedirect("passwordError.jsp");
            }else{

            }
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
