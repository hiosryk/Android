package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

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
    private List<Product> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        final LinearLayout layout = findViewById(R.id.list);
        final  MyListView view = new MyListView(CustomListViewActivity.this);
        final MyAdapter adapter =
                new MyAdapter(CustomListViewActivity.this);

        view.setAdapter(adapter);
        adapter.setItems(data);
        layout.addView(view);

         /* Product p = new Product();
        p.setProd_no("001"); p.setProd_name("Americano"); p.setProd_price(2500);
        data.add(p);

        p = new Product();
        p.setProd_no("002"); p.setProd_name("Ice Americano"); p.setProd_price(2500);
        data.add(p);

        p = new Product();
        p.setProd_no("003"); p.setProd_name("Latte"); p.setProd_price(3000);
        data.add(p);

        p = new Product();
        p.setProd_no("004"); p.setProd_name("Cake"); p.setProd_price(4000);
        data.add(p);*/

        new Thread() {
            public void run() {
                String urlStr = "http://192.168.14.18/myeljstl/productlistjson";
                InputStream is = null;
                ByteArrayOutputStream byteArrayOutputStream = null;

                try {
                    //GET방식으로 요청
//                    urlStr += "?opt=add";
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
                    String str = new String(byteData, 0, byteData.length);
                    ObjectMapper mapper = new ObjectMapper();
                    data = Arrays.asList(
                            mapper.readValue(str, Product[].class));
                    Log.i("CustomListViewActivity", "총상품수:" + data.size());
                    //final MyAdapter adapter = new MyAdapter(CustomListViewActivity.this, data);
                    adapter.setItems(data);
                    runOnUiThread(new Runnable(){
                        public void run(){
                            //view.setAdapter(adapter);
                        }
                    });

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
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
