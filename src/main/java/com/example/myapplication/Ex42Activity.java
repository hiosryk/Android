package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ex42Activity extends AppCompatActivity {
    int clickedCnt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex42);
        Button bt1 = (Button)findViewById(R.id.bt1);
        //final int clickedCnt = 0;
//        bt1.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                clickedCnt++;
//                String text = String.valueOf(clickedCnt); // clieckedCnt+""
//                Context context = Ex42Activity.this;
//                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
//                Button bt2 = (Button)findViewById(R.id.bt2);
//                switch(bt2.getVisibility()){
//                    case View.GONE:
//                        bt2.setVisibility(View.VISIBLE); //나타내기
//                        break;
//                    case View.VISIBLE:
//                        bt2.setVisibility(View.GONE); //영역도 사라짐
//                        break;
//                }
//
//
//            }
//        });

    }
    public void btClick(View view){
        int viewId = view.getId();
        Log.i("Ex42Activity", "지금 클릭한 뷰객체의 id는 "+ viewId);
        if(viewId == R.id.bt1){
            Log.i("Ex42Activity", "지금 클릭한 뷰객체는 id값이 bt1입니다");
        }
        clickedCnt++;
        String text = String.valueOf(clickedCnt); // clieckedCnt+""
        Context context = Ex42Activity.this;
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        Button bt2 = (Button) findViewById(R.id.bt2);
        switch (bt2.getVisibility()) {
            case View.GONE:
                bt2.setVisibility(View.VISIBLE); //나타내기
                break;
            case View.VISIBLE:
                bt2.setVisibility(View.GONE); //영역도 사라짐
                break;
        }
    }
}
