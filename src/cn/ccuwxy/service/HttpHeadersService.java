package cn.ccuwxy.service;

import cn.ccuwxy.model.HttpHeaders;

public interface HttpHeadersService {
    public boolean intohttpHeaders(HttpHeaders httpHeaders);

    public HttpHeaders findByStuNumber(String stuNumber);
}
