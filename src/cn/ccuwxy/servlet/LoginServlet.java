package cn.ccuwxy.servlet;

import cn.ccuwxy.model.Log;
import cn.ccuwxy.model.Result;
import cn.ccuwxy.model.UserInfo;
import cn.ccuwxy.service.ReadJsonService;
import cn.ccuwxy.service.ReadJsonServiceImpl;
import cn.ccuwxy.service.UserInfoService;
import cn.ccuwxy.service.UserInfoServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession httpSession = request.getSession();
        String stuNum = request.getParameter("stuNum");
        System.out.println(stuNum);
        String password = request.getParameter("password");
        System.out.println(password);
        UserInfoService userInfoService = new UserInfoServiceImpl();
        UserInfo userInfo = new UserInfo();
        userInfo = userInfoService.findByStuNumber(stuNum);
        if (userInfo == null) {
            response.sendRedirect("stop.jsp");
        } else {
            userInfo.setPassword(password);
            System.out.println(userInfo.getMd5Password());
            httpSession.setAttribute("userInfo",userInfo);
            String loginPost = "stuNum=" + userInfo.getStuNumber() +
                    "&phoneNum=" + userInfo.getPhoneNumber() + "&passWd=" + userInfo.getMd5Password() +
                    "&schoolId=" + userInfo.getSchoolID() + "&stuId=" + userInfo.getStuID() +
                    "&token=" + userInfo.getToken();
            System.out.println(loginPost);
            ReadJsonService readJsonService = new ReadJsonServiceImpl();
            JSONObject jsonObject = readJsonService.getUTIDByJson(loginPost,userInfo.getStuNumber());
            System.out.println(jsonObject);
            if (jsonObject == null) {
                response.sendRedirect("passwordError.jsp");
            } else {
                Log log = null;
                log = readJsonService.getUserInfo(jsonObject);
                if(log!=null){
                    httpSession.setAttribute("log",log);
                    httpSession.setAttribute("userInfo",userInfo);
                    Result result=readJsonService.getResult(userInfo.getStuNumber());
                    httpSession.setAttribute("result",result);
                    response.sendRedirect("updata.jsp");
                }else{
                    response.sendRedirect("passwordError.jsp");
                }
            }
        }
    }
}
