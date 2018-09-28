package cn.ccuwxy.service;

import cn.ccuwxy.dao.ResultsDao;
import cn.ccuwxy.dao.ResultsDaoImpl;
import cn.ccuwxy.model.Result;

import java.util.List;

public class ResultsServiceImpl implements ResultsService {
    private ResultsDao resultsDao = new ResultsDaoImpl();
    @Override
    public boolean intoResult(Result result) {
        return resultsDao.intoResult(result);
    }

    @Override
    public List<Result> findByStuNumber(String stuNumber) {
        return resultsDao.findByStuNumber(stuNumber);
    }
}
