package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ex10_2ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10_2_result);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvScore = findViewById(R.id.tvScore);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        float score = intent.getFloatExtra("score", 0);
        tvTitle.setText(title);
        tvScore.setText(String.valueOf(score));
    }
    public void close(View view){
        Intent intent = new Intent(this, Ex10_2Activity.class);
        intent.putExtra("scoreAvg", 4.3F);
        setResult(RESULT_OK, intent);
        finish();
    }
}