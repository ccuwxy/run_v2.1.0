package cn.ccuwxy.service;

import cn.ccuwxy.model.UserInfo;

public interface UserInfoService {
    public boolean intoUserInfo(UserInfo userInfo);

    public UserInfo findByStuNumber(String stuNumber);
}
