package cn.ccuwxy.service;

import cn.ccuwxy.model.HttpHeaderss;
import cn.ccuwxy.model.Log;
import cn.ccuwxy.model.Result;
import cn.ccuwxy.model.UserInfo;
import cn.ccuwxy.util.HttpUrl;
import cn.ccuwxy.util.MD5Util;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadJsonServiceImpl implements ReadJsonService {

    @Override
    public JSONObject getUTIDByJson(String strUrl, String stuID) {
        URL url = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        HttpHeadersService httpHeadersService = new HttpHeadersServiceImpl();
        HttpHeaderss httpHeaderss = new HttpHeaderss();
        httpHeaderss = httpHeadersService.findByStuNumber(stuID);
        try {
            url = new URL(HttpUrl.loginUrl);
            byte[] data = String.format(strUrl).getBytes("utf-8");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            System.setProperty("http.proxyHost", "localhost");
            System.setProperty("http.proxyPort", "8888");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            httpURLConnection.setRequestProperty("User-Agent", httpHeaderss.getUser_Agent());
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("app", httpHeaderss.getApp());
            httpURLConnection.setRequestProperty("crack", httpHeaderss.getCrack() + "");
            httpURLConnection.setRequestProperty("Device", httpHeaderss.getDevice());
            httpURLConnection.setRequestProperty("IMEI", httpHeaderss.getIMEI());
            httpURLConnection.setRequestProperty("IMSI", httpHeaderss.getIMSI());
            httpURLConnection.setRequestProperty("latitude", httpHeaderss.getLatitude() + "");
            httpURLConnection.setRequestProperty("longitude", httpHeaderss.getLongitude() + "");
            httpURLConnection.setRequestProperty("Model", httpHeaderss.getModel());
            httpURLConnection.setRequestProperty("Screen", httpHeaderss.getScreen());
            httpURLConnection.setRequestProperty("TokenID", "");
            httpURLConnection.setRequestProperty("UserID", "0");
            httpURLConnection.setRequestProperty("Ver", httpHeaderss.getVer());
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(data.length));
//            httpURLConnection.connect();
            String str = null;
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(data);
            os.flush();
            os.close();
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
            String jsonstr = stringBuilder.toString();
            System.out.println(jsonstr);
            httpURLConnection.disconnect();
            JSONObject jsonObject = JSONObject.fromObject(jsonstr);
            if (jsonObject.getInt("Status") == 0) {
                return null;
            }
            if (!(httpHeaderss.getTokenID().equals(String.valueOf(jsonObject.get("TokenID"))) ||
                    String.valueOf(httpHeaderss.getUserID()).equals(String.valueOf(jsonObject.get("UserID"))))) {
                httpHeadersService.updatahttpUTID(stuID, String.valueOf(jsonObject.get("TokenID")), String.valueOf(jsonObject.get("UserID")));
            }
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {

            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public Log getUserInfo(JSONObject jsonObject) {
        JSONObject jsObject = jsonObject.getJSONObject("UserInfo");
        Log log = new Log();
        log.setSchoolName(jsObject.getString("inSchoolName"));
        log.setCollegeName(jsObject.getString("inCollegeName"));
        log.setStudentName(jsObject.getString("studentName"));
        log.setStudentNumber(jsObject.getString("studentNumber"));
        log.setSex(jsObject.getString("sex"));
        return log;
    }

    @Override
    public Result getResult(String stuNum) {
        Result result = new Result();
        URL url = null;
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        HttpHeadersService httpHeadersService = new HttpHeadersServiceImpl();
        HttpHeaderss httpHeaderss = new HttpHeaderss();
        httpHeaderss = httpHeadersService.findByStuNumber(stuNum);
        try {
            url = new URL(HttpUrl.getResultUrl);
            byte[] data = String.format("flag=0").getBytes("utf-8");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setConnectTimeout(20000);
            System.setProperty("http.proxyHost", "localhost");
            System.setProperty("http.proxyPort", "8888");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            httpURLConnection.setRequestProperty("User-Agent", httpHeaderss.getUser_Agent());
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("app", httpHeaderss.getApp());
            httpURLConnection.setRequestProperty("crack", httpHeaderss.getCrack() + "");
            httpURLConnection.setRequestProperty("device", httpHeaderss.getDevice());
            httpURLConnection.setRequestProperty("imei", httpHeaderss.getIMEI());
            httpURLConnection.setRequestProperty("imsi", httpHeaderss.getIMSI());
            httpURLConnection.setRequestProperty("latitude", httpHeaderss.getLatitude() + "");
            httpURLConnection.setRequestProperty("longitude", httpHeaderss.getLongitude() + "");
            httpURLConnection.setRequestProperty("model", httpHeaderss.getModel());
            httpURLConnection.setRequestProperty("screen", httpHeaderss.getScreen());
            httpURLConnection.setRequestProperty("TokenID", httpHeaderss.getTokenID());
            httpURLConnection.setRequestProperty("UserID", httpHeaderss.getUserID() + "");
            httpURLConnection.setRequestProperty("ver", httpHeaderss.getVer());
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(data.length));
            //httpURLConnection.connect();
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(data);
            os.flush();
            os.close();
            BufferedReader bf = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = bf.readLine()) != null) {
                sb.append(line).append(System.getProperty("line.separator"));
            }
            bf.close();
            httpURLConnection.disconnect();

            String str = null;
            String jsonstr = sb.toString();
            System.out.println(sb);
            JSONObject jsonObject = JSONObject.fromObject(jsonstr);
            if (jsonObject.getInt("Status") == 0) {
                return null;
            }
            if (jsonObject.getInt("Status") == -1) {
                result.setResult("0");
            } else {
                result.setResult(String.valueOf(jsonObject.getDouble("result")));
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Result upRunData(UserInfo userInfo, String strResult) {
        ResultsService resultsService = new ResultsServiceImpl();
        Result resul = new Result();
        Float result = Float.parseFloat(strResult);
        HttpHeadersService httpHeadersService = new HttpHeadersServiceImpl();
        HttpHeaderss httpHeaderss = new HttpHeaderss();
        httpHeaderss = httpHeadersService.findByStuNumber(userInfo.getStuNumber());
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now_time = dateFormat.format(now);
        String begin_time = "";
        if (result > 1 && result <= 2) {
            Date begin1_2 = new Date(now.getTime() - 540300L);//9*1000*60
            begin_time = dateFormat.format(begin1_2);
        } else if (result > 2 && result < 3) {
            Date begin2_3 = new Date(now.getTime() - 1020600L);//17*1000*60
            begin_time = dateFormat.format(begin2_3);
        } else if (result >= 3 && result < 4.2) {
            Date begin3_4 = new Date(now.getTime() - 1566500L);//26*1000*60
            begin_time = dateFormat.format(begin3_4);
        } else if (result >= 4.2 && result < 5) {
            Date begin4_5 = new Date(now.getTime() - 2472500L);//41*1000*60
            begin_time = dateFormat.format(begin4_5);
        }
        String strTmp = MD5Util.getXTCode(Long.valueOf(httpHeaderss.getUserID()), begin_time, now_time, strResult);
        try {
            URL url = new URL(HttpUrl.updataUrl);
            System.setProperty("http.proxyHost", "localhost");
            System.setProperty("http.proxyPort", "8888");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            resul.setStuNumber(userInfo.getStuNumber());
            resul.setResult(strResult);
            resul.setBeginTime(begin_time);
            resul.setEndTime(now_time);
            resul.setXtCode(strTmp);
            resul.setIsValid(1);
            resul.setSchoolID(userInfo.getSchoolID());
            resul.setBz("");
            byte[] data = String.format("results=%s&beginTime=%s&endTime=%s&isValid=%d&schoolId=%d&xtCode=%s&bz=%s",
                    new Object[]{strResult, begin_time, now_time, 1, userInfo.getSchoolID(), strTmp, ""}).getBytes("utf-8");
            System.out.println(String.format("results=%s&beginTime=%s&endTime=%s&isValid=%d&schoolId=%d&xtCode=%s&bz=%s",
                    new Object[]{strResult, begin_time, now_time, 1, userInfo.getSchoolID(), strTmp, ""}));
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            urlConnection.setReadTimeout(20000);
            urlConnection.setConnectTimeout(20000);
            urlConnection.setRequestProperty("Accept-Encoding", "gzip");
            urlConnection.setRequestProperty("User-Agent", httpHeaderss.getUser_Agent());
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConnection.setRequestProperty("UserID", httpHeaderss.getUserID() + "");
            urlConnection.setRequestProperty("TokenID", httpHeaderss.getTokenID());
            urlConnection.setRequestProperty("app", httpHeaderss.getApp());
            urlConnection.setRequestProperty("ver", httpHeaderss.getVer());
            urlConnection.setRequestProperty("device", httpHeaderss.getDevice());
            urlConnection.setRequestProperty("model", httpHeaderss.getModel());
            urlConnection.setRequestProperty("screen", httpHeaderss.getScreen());
            urlConnection.setRequestProperty("imei", httpHeaderss.getIMEI());
            urlConnection.setRequestProperty("imsi", httpHeaderss.getIMSI());
            urlConnection.setRequestProperty("crack", "" + httpHeaderss.getCrack());
            urlConnection.setRequestProperty("latitude", httpHeaderss.getLatitude() + "");
            urlConnection.setRequestProperty("longitude", httpHeaderss.getLongitude() + "");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Content-Length", String.valueOf(data.length));
            OutputStream os = urlConnection.getOutputStream();
            os.write(data);
            os.flush();
            os.close();
            StringBuilder sb = new StringBuilder();
            BufferedReader bf = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String line;
            while ((line = bf.readLine()) != null) {
                sb.append(line).append(System.getProperty("line.separator"));
            }
            bf.close();
            urlConnection.disconnect();

            String str = null;
            String jsonstr = sb.toString();
            //System.out.println(sb);
            JSONObject jsonObject = JSONObject.fromObject(jsonstr);
            System.out.println(jsonstr);
            if (jsonObject.getInt("Status") == 1) {
                resultsService.intoResult(resul);
                return resul;
            } else {
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


}
