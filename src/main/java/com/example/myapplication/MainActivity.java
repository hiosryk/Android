package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//public class MainActivity extends Activity { //
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 =  (Button)findViewById(R.id.bt1);
        String btText = bt1.getText().toString();
        //System.out.println("버튼 텍스트:" + btText);
        String tag = "MainActivity";
        String msg = btText;
        //Log.d(tag, msg);
        Log.e(tag, msg);

        Context ctx = this;
        String text = btText;
        Toast.makeText(ctx, text, Toast.LENGTH_LONG).show();
    }
}



