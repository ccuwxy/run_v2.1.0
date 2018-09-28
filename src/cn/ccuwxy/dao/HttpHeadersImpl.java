package cn.ccuwxy.dao;

import cn.ccuwxy.model.HttpHeaderss;
import cn.ccuwxy.util.JdbcUtil;

import java.sql.*;

public class HttpHeadersImpl implements HttpHeadersDao {
    @Override
    public boolean intohttpHeaders(HttpHeaderss httpHeaderss) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = String.format("insert into httpHeaders " +
               "(stuNumber,user_Agent,app,crack,device,IMEI,IMSI,latitude,longitude,model,screen,tokenID,userID,ver,host) " +
                "values('%s','%s','%s','%d','%s','%s','%s','%.1f','%.1f','%s','%s','%s','%d','%s','%s');", new Object[]{httpHeaderss.getStuNumber(), httpHeaderss.getUser_Agent(), httpHeaderss.getApp(),
                httpHeaderss.getCrack(), httpHeaderss.getDevice(), httpHeaderss.getIMEI(), httpHeaderss.getIMSI(), httpHeaderss.getLatitude(), httpHeaderss.getLongitude(),
                httpHeaderss.getModel(), httpHeaderss.getScreen(), httpHeaderss.getTokenID(), httpHeaderss.getUserID(), httpHeaderss.getVer(), httpHeaderss.getHost()});
        System.out.println(sql);
        return jdbcUtil.insert(sql);
    }

    @Override
    public HttpHeaderss findByStuNumber(String stuNumber) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = "select * from httpHeaders where stuNumber='" + stuNumber + "'";
        System.out.println(sql);
        ResultSet resultSet = jdbcUtil.excuteQuery(sql);
        HttpHeaderss httpHeaderss = new HttpHeaderss();
        try {
            while (resultSet.next()) {
                httpHeaderss.setStuNumber(resultSet.getString("stuNumber"));
                httpHeaderss.setUser_Agent(resultSet.getString("user_Agent"));
                httpHeaderss.setApp(resultSet.getString("app"));
                httpHeaderss.setCrack(resultSet.getInt("crack"));
                httpHeaderss.setDevice(resultSet.getString("device"));
                httpHeaderss.setIMEI(resultSet.getString("IMEI"));
                httpHeaderss.setIMSI(resultSet.getString("IMSI"));
                httpHeaderss.setLatitude(resultSet.getFloat("latitude"));
                httpHeaderss.setLongitude(resultSet.getFloat("longitude"));
                httpHeaderss.setModel(resultSet.getString("model"));
                httpHeaderss.setScreen(resultSet.getString("screen"));
                httpHeaderss.setTokenID(resultSet.getString("tokenID"));
                httpHeaderss.setUserID(resultSet.getInt("userID"));
                httpHeaderss.setVer(resultSet.getString("ver"));
                httpHeaderss.setHost(resultSet.getString("host"));
                return httpHeaderss;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean updatahttpUTID(String stuNum,String tokenID,String userID){
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = String.format("update httpHeaders set tokenID='%s',userID='%s' where stuNumber='%s'",new Object[]{tokenID,userID,stuNum});
        System.out.println(sql);
        return jdbcUtil.insert(sql);
    }
}
