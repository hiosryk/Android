package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kitri.dto.Product;

public class ProductInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        TextView tvProdu_no = (TextView)findViewById(R.id.tvProd_no);
        TextView tvProdu_name = (TextView)findViewById(R.id.tvProd_name);
        TextView tvProdu_price = (TextView)findViewById(R.id.tvProd_price);

        Intent intent = getIntent();
        Product product = (Product)(intent.getExtras().get("productInfo"));

        tvProdu_no.setText(tvProdu_no.getText() + product.getProd_no());
        tvProdu_name.setText(tvProdu_name.getText()+product.getProd_name());
        tvProdu_price.setText(tvProdu_price.getText()+String.valueOf(product.getProd_price()));
    }
}
