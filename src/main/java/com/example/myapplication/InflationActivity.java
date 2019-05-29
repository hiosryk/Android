package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

public class InflationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inflation);

        final LinearLayout root = (LinearLayout)findViewById(R.id.root);
//        Button btCb = (Button)findViewById(R.id.btCb);
//        btCb.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                //부분XML전개
//                LayoutInflater inflater =
//                        (LayoutInflater)getSystemService(
//                                            Context.LAYOUT_INFLATER_SERVICE);
//                inflater.inflate(R.layout.activity_sub_1, root, true);
//                //전개된 View 제거
//                //root.removeView(findViewById(R.id.sub_1));
//
//                //전개된 View 사라지기
//                //findViewById(R.id.sub_1).setVisibility(View.GONE);
//            }
//        });
//
//        Button btCb2 = (Button)findViewById(R.id.btCb2);
//        btCb2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                root.removeView(findViewById(R.id.sub_1));
//            }
//        });

        Switch swCb = (Switch)findViewById(R.id.swCb);
        swCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){ //ON
                    //부분XML전개
                    LayoutInflater inflater =
                            (LayoutInflater)getSystemService(
                                    Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.activity_sub_1, root, true);

                }else{ //OFF
                    root.removeView(findViewById(R.id.sub_1));
                }
            }
        });
    }
}
