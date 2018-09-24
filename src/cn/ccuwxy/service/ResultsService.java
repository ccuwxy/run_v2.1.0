package cn.ccuwxy.service;

import cn.ccuwxy.model.Result;

import java.util.List;

public interface ResultsService {
    public boolean intoResult(Result result);

    public List<Result> findByStuNumber(String stuNumber);
}
