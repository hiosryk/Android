package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.kitri.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        LinearLayout layout = (LinearLayout)findViewById(R.id.list);
        ArrayList<Product> data = new ArrayList<>();
        Product p = new Product();
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
        data.add(p);

        MyAdapter adapter = new MyAdapter(this, data);
        MyListView view = new MyListView(this);
        view.setAdapter(adapter);

        layout.addView(view);
    }
}
