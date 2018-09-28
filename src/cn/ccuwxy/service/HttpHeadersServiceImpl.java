package cn.ccuwxy.service;

import cn.ccuwxy.dao.HttpHeadersDao;
import cn.ccuwxy.dao.HttpHeadersImpl;
import cn.ccuwxy.model.HttpHeaderss;

public class HttpHeadersServiceImpl implements HttpHeadersService {
    private HttpHeadersDao httpHeadersDao = new HttpHeadersImpl();
    @Override
    public boolean intohttpHeaders(HttpHeaderss httpHeaderss) {
        return httpHeadersDao.intohttpHeaders(httpHeaderss);
    }

    @Override
    public HttpHeaderss findByStuNumber(String stuNumber) {
        return httpHeadersDao.findByStuNumber(stuNumber);
    }

    public boolean updatahttpUTID(String stuNum,String tokenID,String userID){
        return httpHeadersDao.updatahttpUTID(stuNum,tokenID,userID);
    }
}
