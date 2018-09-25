package cn.ccuwxy.service;

import cn.ccuwxy.model.Json;
import cn.ccuwxy.model.Log;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReadJsonServiceImpl implements ReadJsonService {

    @Override
    public Json getUTIDByJson(String strUrl) {
        Json json = new Json();
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();

        try {
            url = new URL(strUrl);
            String str=null;
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
            while ((str = bufferedReader.readLine())!=null){
                stringBuffer.append(str);
            }
            String jsonstr = stringBuffer.toString();
            JSONObject jsonObject = JSONObject.fromObject(jsonstr);
            json.setJson(jsonObject);
            if(jsonObject.getInt("Status")==0){
                return null;
            }
            json.setUserID(String.valueOf(jsonObject.get("UserID")));
            json.setTokenID(String.valueOf(jsonObject.get("TokenID")));

            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if(bufferedReader!=null){
                    bufferedReader.close();;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public Log getUserInfo(Json userJson) {
        JSONObject jsonObject = JSONObject.fromObject(userJson);
        Log log = new Log();
        log.setSchoolName(jsonObject.getString("inSchoolName"));
        log.setCollegeName(jsonObject.getString("inCollegeName"));
        log.setStudentName(jsonObject.getString("studentName"));
        log.setStudentNumber(jsonObject.getString("studentNumber"));
        log.setSex(jsonObject.getString("sex"));
        return null;
    }

}
