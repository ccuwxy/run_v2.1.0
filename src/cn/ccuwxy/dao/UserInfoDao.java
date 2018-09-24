package cn.ccuwxy.dao;

import cn.ccuwxy.model.UserInfo;

public interface UserInfoDao {
    public boolean intoUserInfo(UserInfo userInfo);

    public UserInfo findByStuNumber(String stuNumber);
}
