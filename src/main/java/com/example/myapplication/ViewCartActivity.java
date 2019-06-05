package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitri.dto.Product;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        final SharedPreferences pref =
                getApplicationContext().getSharedPreferences(
                        "sessionCookie"  //xml파일이름
                        , Context.MODE_PRIVATE);

        final SharedPreferences.Editor edit = pref.edit();

        new Thread() {
            public void run() {
                String urlStr = "http://192.168.14.18/myeljstl/viewcart";
                InputStream is = null;
                ByteArrayOutputStream byteArrayOutputStream = null;

                try {
                    URL url = new URL(urlStr);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");

                    //요청헤더에 쿠키추가
                    String jsession_cookie = pref.getString("JSESSIONID", null);
                    if (jsession_cookie != null) {
                        con.setRequestProperty("Cookie", jsession_cookie);
                    }

                    //응답얻기
                    int responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        List<String> cookies =
                                con.getHeaderFields().get("Set-cookie");

                        //JSESSIONID쿠키없이 요청했을경우
                        // 서버가 응답하는 응답헤더에는 쿠키가 있다

                        //JSESSIONID쿠키가  요청헤더에 추가됐을경우
                        // 서버가 응답하는 응답헤더에는 쿠키가 없다
                        if (cookies != null) {
                            Log.i("ViewCartActivity" , "응답쿠키내용:" + cookies.toString());
                            for (String cookie : cookies) {
                                String cookieNameValue = cookie.split(";\\s*")[0];
                                String cookieName = cookieNameValue.split("=")[0];
                                edit.putString(cookieName, cookieNameValue);
                                edit.apply();
                            }
                        }
                    }

                    //응답내용
                    is = con.getInputStream(); //응답결과 입력스트림
                    byte[] buf = new byte[1024];

                    byteArrayOutputStream = new ByteArrayOutputStream(buf.length);
                    int readLength = -1;
                    while ((readLength = is.read(buf)) != -1) {
                        byteArrayOutputStream.write(buf, 0, readLength);
                        Log.i("ViewCartActivity", "readLength:" + readLength);
                    }

                    byte[] byteData = null;
                    byteData = byteArrayOutputStream.toByteArray();

                    //응답내용문자열
                    String str = new String(byteData, 0, byteData.length);
                    Log.i("ViewCartActivity", "응답문자열"+ str);
                    //JACKSON API : JSONObject와 DTO간의 매핑
                    ObjectMapper mapper = new ObjectMapper();
                    Map<Product, Integer> rc = mapper.readValue(
                            str,
                            new TypeReference<Map<Product, Integer> >() {
                            });
                    Log.i("ViewCartActivity", "응답결과 map");
                    Log.i("ViewCartActivity", "장바구니 상품종류:" + rc.size());
                    Log.i("ViewCartActivity", "-------");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if(is != null) {
                        try {
                            is.close();
                        }catch(Exception e){}
                    }
                }
            }
        }.start();

    }
}
