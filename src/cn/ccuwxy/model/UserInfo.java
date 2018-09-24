package cn.ccuwxy.model;

import org.apache.commons.codec.digest.DigestUtils;

public class UserInfo {
    private String stuNumber = "";//studentnum
    private String password = "";
    private String phoneNumber = "123";
    private int schoolID = 60;
    private int stuID = 1;
    private String token="";
    private float result = 0.0f;
    private float qualified = 0.0f;

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getPassword() {
        return password;
    }
    public String getMd5Password() {
        return DigestUtils.md5Hex(password);
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public float getQualified() {
        return qualified;
    }

    public void setQualified(float qualified) {
        this.qualified = qualified;
    }
}
