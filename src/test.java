public class test {
    public static void main(String[] args){
//        UserInfo userInfo = new UserInfo();
//        userInfo.setStuNumber("041640707");
//        userInfo.setPassword("123456");
//        UserInfoDao userInfoDao = new UserInfoImpl();
//        System.out.println(userInfoDao.intoUserInfo(userInfo));
//        HttpHeaderss httpHeaderss = new HttpHeaderss();
//        HttpHeadersDao httpHeadersDao = new HttpHeadersImpl();
//        httpHeaderss.setStuNumber("041640707");
//        httpHeaderss.setUser_Agent("Dalvik/2.1.0(Linux; U; Anfroid 8.1.0; EML-AL00 BUILD/HUAWEIEML-AL00");
//        httpHeaderss.setDevice("Android,27,8.1.0");
//        httpHeaderss.setIMEI("867130034543840");
//        httpHeaderss.setIMSI("460029044184353");
//        httpHeaderss.setModel("EML-AL00");
//        httpHeaderss.setScreen("1080x2244");
//        System.out.println(httpHeadersDao.intohttpHeaders(httpHeaderss));
//        String js = "{\"Status\":1,\"Date\":\"2018-09-28\",\"UserInfo\":{\"id\":4618,\"inClassID\":236,\"inClassName\":\"电算16407\",\"inCollegeID\":31,\"inCollegeName\":\"计算机科学技术学院\",\"inSchoolID\":60,\"inSchoolName\":\"长春大学\",\"inSchoolNumber\":\"61102\",\"isTeacher\":0,\"nickName\":\"张笑妍\",\"phoneNumber\":\"123\",\"sex\":\"F\",\"studentName\":\"张笑妍\",\"studentNumber\":\"041640707\",\"userRoleID\":1},\"TokenID\":\"01d67dceabd3f2ac6c69e6154f9d8212\",\"UserExpirationTime\":1539403617612,\"UserID\":4618}\n";
//        JSONObject jsonObject = JSONObject.fromObject(js);
//        System.out.println(jsonObject);
        Float re = 1.85f;
        String strResult = String.format("%.3f", new Object[]{re});
        System.out.println(strResult);
    }
}
