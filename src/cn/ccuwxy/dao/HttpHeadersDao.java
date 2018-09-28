package cn.ccuwxy.dao;

import cn.ccuwxy.model.HttpHeaderss;

public interface HttpHeadersDao {
    public boolean intohttpHeaders(HttpHeaderss httpHeaderss);

    public HttpHeaderss findByStuNumber(String stuNumber);

    public boolean updatahttpUTID(String stuNum,String tokenID,String userID);
}
