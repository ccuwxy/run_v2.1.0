package cn.ccuwxy.dao;

import cn.ccuwxy.model.UserInfo;
import cn.ccuwxy.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoImpl implements UserInfoDao {
    @Override
    public boolean intoUserInfo(UserInfo userInfo) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = String.format("insert into userInfo" +
                        "(stuNumber,password,phoneNumber,schoolID,stuID,token,result,qualified)" +
                        "  values('%s','%s','%s',%d,%d,'%s',%f,%f)",
                new Object[]{userInfo.getStuNumber(), userInfo.getMd5Password(), userInfo.getPhoneNumber(),
                        userInfo.getSchoolID(), userInfo.getStuID(), userInfo.getToken(),
                        userInfo.getResult(), userInfo.getQualified()});
        System.out.println(sql);
        return jdbcUtil.insert(sql);
    }

    @Override
    public UserInfo findByStuNumber(String stuNumber) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = "select * from userInfo where stuNumber='"+stuNumber+"'";
        System.out.println(sql);
        ResultSet resultSet = jdbcUtil.excuteQuery(sql);
        UserInfo userInfo = new UserInfo();
        try {
            while(resultSet.next()){
                userInfo.setStuNumber(resultSet.getString("stuNumber"));
                userInfo.setPassword(resultSet.getString("password"));
                userInfo.setPhoneNumber(resultSet.getString("phoneNumber"));
                userInfo.setSchoolID(resultSet.getInt("schoolID"));
                userInfo.setStuID(resultSet.getInt("stuID"));
                userInfo.setToken(resultSet.getString("token"));
                userInfo.setResult(resultSet.getFloat("result"));
                userInfo.setQualified(resultSet.getFloat("qualified"));
                return userInfo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
