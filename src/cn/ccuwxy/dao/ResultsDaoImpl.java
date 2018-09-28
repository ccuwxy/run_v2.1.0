package cn.ccuwxy.dao;

import cn.ccuwxy.model.Result;
import cn.ccuwxy.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultsDaoImpl implements ResultsDao {
    @Override
    public boolean intoResult(Result result) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = String.format("insert into result(stuNumber,beginTime,endTime,result,isValid,schoolID,xtCode,bz)"+
                        "  values('%s','%s','%s','%s','%d','%d','%s','%s')",
                new Object[]{result.getStuNumber(),result.getBeginTime(),result.getEndTime(),
                        result.getResult(),result.getIsValid(),result.getSchoolID(),result.getXtCode(),result.getBz()});
        System.out.println(sql);
        return jdbcUtil.insert(sql);
    }

    @Override
    public List<Result> findByStuNumber(String stuNumber) {
        List<Result> results= new ArrayList<Result>();
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = "select * from result where stuNumber='"+stuNumber+"'";
        System.out.println(sql);
        ResultSet resultSet = jdbcUtil.excuteQuery(sql);
        Result result = new Result();
        try {
            while(resultSet.next()){
                result.setStuNumber(resultSet.getString("stuNumber"));
                result.setBeginTime(resultSet.getString("beginTime"));
                result.setEndTime(resultSet.getString("endTime"));
                result.setResult(resultSet.getString("result"));
                result.setIsValid(resultSet.getInt("isValid"));
                result.setSchoolID(resultSet.getInt("schoolID"));
                result.setXtCode(resultSet.getString("xtCode"));
                result.setBz(resultSet.getString("bz"));
                results.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
