package cn.ccuwxy.dao;

import cn.ccuwxy.model.HttpHeaders;

public interface httpHeadersDao {
    public boolean intohttpHeaders(HttpHeaders httpHeaders);

    public HttpHeaders findByStuNumber(String stuNumber);
}
