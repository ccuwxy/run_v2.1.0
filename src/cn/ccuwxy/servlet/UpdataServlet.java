package cn.ccuwxy.servlet;

import cn.ccuwxy.model.UserInfo;
import cn.ccuwxy.service.ReadJsonService;
import cn.ccuwxy.service.ReadJsonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession httpSession = request.getSession();
        String result = request.getParameter("result");
        Float f_result = Float.parseFloat(result)+0.0132f;
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        String strResult = String.format("%.3f", new Object[]{f_result});
        ReadJsonService readJsonService= new ReadJsonServiceImpl();
        if(readJsonService.upRunData(userInfo,strResult)==null){
            response.sendRedirect("runError.jsp");
        }else{
            httpSession.setAttribute("result",readJsonService.getResult(userInfo.getStuNumber()));
            response.sendRedirect("success.jsp");
        }

    }

}
