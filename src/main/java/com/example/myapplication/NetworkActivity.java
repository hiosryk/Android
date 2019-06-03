package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitri.dto.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class NetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        new Thread() {
            public void run() {
                String urlStr = "http://192.168.14.52/androidweb/index.jsp";
                InputStream is = null;
                ByteArrayOutputStream byteArrayOutputStream = null;

                try {
                    //GET방식으로 요청
//                    urlStr += "?opt=add";
//                    URL url = new URL(urlStr); //요청
//                    HttpURLConnection con = (HttpURLConnection) url.openConnection();//응답
//                    con.setRequestMethod("GET");
                    //-----------------------------

                    //POST방식으로 요청
                    URL url = new URL(urlStr);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();//응답
                    con.setRequestMethod("POST");//
                    con.setDoOutput(true); //요청 전달데이터를 message body에 쓰기허용
                    DataOutputStream dos =
                            new DataOutputStream(con.getOutputStream());
                    dos.writeBytes("opt=add");//message body에 쓰기
                    //-----------------------------------------------------


                    is = con.getInputStream(); //응답결과 입력스트림
                    byte[] buf = new byte[1024];

                    byteArrayOutputStream = new ByteArrayOutputStream(buf.length);
                    int readLength = -1;
                    while ((readLength = is.read(buf)) != -1) {
//                        String str = new String(buf, 0, readLength);
//                        JSONObject jsonObj = new JSONObject();

                        byteArrayOutputStream.write(buf, 0, readLength);
                    }

                    byte[] byteData = null;
                    byteData = byteArrayOutputStream.toByteArray();
                    String str = new String(byteData, 0, byteData.length);

//                    JSONObject jsonObj = new JSONObject(str);
//                    int status = jsonObj.getInt("status");
//                    String msg = jsonObj.getString("msg");
//                    Log.i("NetworkActivity", "서버가 보내준 [status]:" + status);
//                    Log.i("NetworkActivity", "서버가 보내준 [msg]:" + msg);
//                    Log.i("NetworkActivity",
//                            "서버가 보내준 [method]:" + jsonObj.getString("method"));
//                    Log.i("NetworkActivity",
//                            "서버가 보내준 [opt]:" + jsonObj.getString("opt"));

//                    JSONArray jsonArr = new JSONArray(str);
//                    Log.i("NetworkActivity",
//                            "서버가 보내준 상품종류:" + jsonArr.length());
//                    for(int i=0; i<jsonArr.length(); i++){
//                        JSONObject jsonObj = (JSONObject)jsonArr.get(i);
//                        Log.i("NetworkActivity",
//                                i+"-상품번호:"+ jsonObj.getString("prod_no")
//                                      + ", 상품명:"+ jsonObj.getString("prod_name")
//                                      + ", 가격:"+ jsonObj.getInt("prod_price"));
//                    }


                    ObjectMapper mapper = new ObjectMapper();

                    List<Product> list = Arrays.asList(
                            mapper.readValue(str, Product[].class));



                            Log.i("NetworkActivity",
                            "서버가 보내준 상품종류:" + list.size());
                    for(int i=0; i<list.size(); i++){
                        Product p = list.get(i);
                        Log.i("NetworkActivity",
                                i+"-상품번호:"+ p.getProd_no()
                                      + ", 상품명:"+ p.getProd_name()
                                      + ", 가격:"+ p.getProd_price());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
//                } catch (JSONException e) {
//                    e.printStackTrace();
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                        }
                    }
                }
            }
        }.start();

    }
}
