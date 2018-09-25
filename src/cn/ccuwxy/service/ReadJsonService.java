package cn.ccuwxy.service;

import cn.ccuwxy.model.Json;
import cn.ccuwxy.model.Log;

public interface ReadJsonService {
    public Json getUTIDByJson(String strUrl);
    public Log getUserInfo(Json userJson);
}
