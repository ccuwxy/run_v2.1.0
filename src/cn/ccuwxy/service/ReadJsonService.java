package cn.ccuwxy.service;

import cn.ccuwxy.model.Log;
import cn.ccuwxy.model.Result;
import cn.ccuwxy.model.UserInfo;
import net.sf.json.JSONObject;

public interface ReadJsonService {
    public JSONObject getUTIDByJson(String strUrl, String stuID);
    public Log getUserInfo(JSONObject jsonObject);
    public Result getResult(String stuID);
    public Result upRunData(UserInfo userInfo, String strResult);
}
