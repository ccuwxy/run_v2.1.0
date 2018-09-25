package cn.ccuwxy.dao;

import cn.ccuwxy.model.HttpHeaders;
import cn.ccuwxy.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class httpHeadersImpl implements httpHeadersDao {
    @Override
    public boolean intohttpHeaders(HttpHeaders httpHeaders) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = String.format("insert into httpHeaders" +
                        "(stuNumber,user_Agent,app,crack,device,IMEI,IMSI,latitude,longitude,model,screen,tokenID,userID,ver,host)" +
                        " values('%s','%s','%s',%d,'%s','%s','%s',%f,%f,'%s','%s','%s',%d,'%s','%s')",
                new Object[]{httpHeaders.getStuNumber(), httpHeaders.getUser_Agent(), httpHeaders.getApp(),
                        httpHeaders.getCrack(), httpHeaders.getDevice(), httpHeaders.getIMEI(), httpHeaders.getIMSI(),
                        httpHeaders.getLatitude(), httpHeaders.getLongitude(), httpHeaders.getModel(), httpHeaders.getScreen(),
                        httpHeaders.getTokenID(), httpHeaders.getUserID(), httpHeaders.getVer(), httpHeaders.getHost()});
        System.out.println(sql);
        return jdbcUtil.insert(sql);
    }

    @Override
    public HttpHeaders findByStuNumber(String stuNumber) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = "select * from httpHeaders where stuNumber='" + stuNumber + "'";
        System.out.println(sql);
        ResultSet resultSet = jdbcUtil.excuteQuery(sql);
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            while (resultSet.next()) {
                httpHeaders.setStuNumber(resultSet.getString("stuNumber"));
                httpHeaders.setUser_Agent(resultSet.getString("user_Agent"));
                httpHeaders.setApp(resultSet.getString("app"));
                httpHeaders.setCrack(resultSet.getInt("crack"));
                httpHeaders.setDevice(resultSet.getString("device"));
                httpHeaders.setIMEI(resultSet.getString("IMEI"));
                httpHeaders.setIMSI(resultSet.getString("IMSI"));
                httpHeaders.setLatitude(resultSet.getFloat("latitude"));
                httpHeaders.setLongitude(resultSet.getFloat("longitude"));
                httpHeaders.setModel(resultSet.getString("model"));
                httpHeaders.setScreen(resultSet.getString("screen"));
                httpHeaders.setTokenID(resultSet.getString("tokenID"));
                httpHeaders.setUserID(resultSet.getInt("userID"));
                httpHeaders.setVer(resultSet.getString("ver"));
                httpHeaders.setHost(resultSet.getString("host"));
                return httpHeaders;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
