package cn.ccuwxy.service;

import cn.ccuwxy.dao.UserInfoDao;
import cn.ccuwxy.dao.UserInfoImpl;
import cn.ccuwxy.model.UserInfo;

public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao = new UserInfoImpl();

    @Override
    public boolean intoUserInfo(UserInfo userInfo) {
        return userInfoDao.intoUserInfo(userInfo);
    }

    @Override
    public UserInfo findByStuNumber(String stuNumber) {

        return userInfoDao.findByStuNumber(stuNumber);
    }
}
