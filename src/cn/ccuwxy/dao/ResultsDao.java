package cn.ccuwxy.dao;

import cn.ccuwxy.model.Result;

import java.util.List;

public interface ResultsDao {
    public boolean intoResult(Result result);

    public List<Result> findByStuNumber(String stuNumber);
}
