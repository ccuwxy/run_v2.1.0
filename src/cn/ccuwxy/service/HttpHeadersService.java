package cn.ccuwxy.service;

import cn.ccuwxy.model.HttpHeaderss;

public interface HttpHeadersService {
    public boolean intohttpHeaders(HttpHeaderss httpHeaderss);

    public HttpHeaderss findByStuNumber(String stuNumber);

    public boolean updatahttpUTID(String stuNum,String tokenID,String userID);
}
