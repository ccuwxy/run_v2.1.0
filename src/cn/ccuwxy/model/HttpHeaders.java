package cn.ccuwxy.model;

public class HttpHeaders {
    private String stuNumber="";
    private String User_Agent = "";//1
    private String app = "com.ccxyct.sunshinemotion";//1
    private int crack = 0;//1
    private String device = "";//1   Android,27,8.0.1
    private String IMEI = "";//1
    private String IMSI = "";//1
    private float latitude = 0.0f;//1
    private float longitude = 0.0f;//1
    private String Model = "";//1   EML-AL00
    private String screen = "";//1  1080x2244   width + "x" + height
    private String tokenID = "";//1
    private int userID = 0;//1
    private String Ver = "2.1.0";//1
    private String host = "www.ccxyct.com:8000";

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getUser_Agent() {
        return User_Agent;
    }

    public void setUser_Agent(String user_Agent) {
        User_Agent = user_Agent;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public int getCrack() {
        return crack;
    }

    public void setCrack(int crack) {
        this.crack = crack;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getIMSI() {
        return IMSI;
    }

    public void setIMSI(String IMSI) {
        this.IMSI = IMSI;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getTokenID() {
        return tokenID;
    }

    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getVer() {
        return Ver;
    }

    public void setVer(String ver) {
        Ver = ver;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
