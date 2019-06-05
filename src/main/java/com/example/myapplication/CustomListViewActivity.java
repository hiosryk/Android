package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitri.dto.Product;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {
    private ArrayList<Product> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

//        final ArrayList<Product> data = new ArrayList<>();
        final MyListView view = new MyListView(CustomListViewActivity.this);
        //웹서버URL : http://192.168.14.52/myeljstl/productlistjson
        new Thread(){
            public void run(){
                String urlStr = "http://192.168.14.18/myeljstl/productlistjson";
                InputStream is = null;
                ByteArrayOutputStream byteArrayOutputStream = null;

                try {
                    //GET방식으로 요청//
                    URL url = new URL(urlStr); //요청
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();//응답
                    con.setRequestMethod("GET");
                    //-----------------------------

                    is = con.getInputStream(); //응답결과 입력스트림
                    byte[] buf = new byte[1024];

                    byteArrayOutputStream = new ByteArrayOutputStream(buf.length);
                    int readLength = -1;
                    while ((readLength = is.read(buf)) != -1) {
                        byteArrayOutputStream.write(buf, 0, readLength);
                    }

                    byte[] byteData = null;
                    byteData = byteArrayOutputStream.toByteArray();

                    //응답내용문자열
                    String str = new String(byteData, 0, byteData.length);

                    //JACKSON API : JSONObject와 DTO간의 매핑
                    ObjectMapper mapper = new ObjectMapper();

                    //응답내용문자열의 구성이 JSONArray포맷이면
                    //DTO클래스배열타입으로 매핑

                    //List<Product> list = Arrays.asList(
                    //        mapper.readValue(str, Product[].class));

                    data = mapper.readValue(
                            str,
                            new TypeReference<ArrayList<Product>>() {
                            });
                    final MyAdapter adapter = new MyAdapter(CustomListViewActivity.this, data);

                    //Only the original thread that created a view hierarchy can touch its views
                    runOnUiThread(new Runnable(){
                        public void run(){
                            view.setAdapter(adapter);
                        }
                    });

                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    if(is != null) {
                        try {
                            is.close();
                        }catch(Exception e){}
                    }
                }
            }//run()
        }.start();


        LinearLayout layout = findViewById(R.id.list);

        //MyAdapter adapter = new MyAdapter(CustomListViewActivity.this, data);
        //view.setAdapter(adapter);
        layout.addView(view);

        view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int index, long l) {
                Intent intent = new Intent(
                        CustomListViewActivity.this,
                        ProductInfoActivity.class);

                //putExtra()대상 - 직렬화가능한객체, 기본형데이터
                intent.putExtra("productInfo", data.get(index));
                startActivity(intent);
                return false;
            }
        });
    }
}
