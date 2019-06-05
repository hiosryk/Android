package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //public class MainActivity extends Activity {

    @Override
    protected void onNewIntent(Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button bt1 =  (Button)findViewById(R.id.bt1);
//        String btText = bt1.getText().toString();
//        //System.out.println("버튼 텍스트:" + btText);
//        String tag = "MainActivity";
//        String msg = btText;
//        //Log.d(tag, msg);
//        Log.e(tag, msg);
//
//        Context ctx = this;
//        String text = btText;
//        Toast.makeText(ctx, text, Toast.LENGTH_LONG).show();
        activityMap.put(R.id.bt_ex42,  Ex42Activity.class);
        activityMap.put(R.id.bt_ex43,  Ex43Activity.class);
        activityMap.put(R.id.bt_ex51,  Ex51Activity.class);
        activityMap.put(R.id.bt_ex52,  Ex52Activity.class);
        activityMap.put(R.id.bt_ex4_24,  Ex4_24Activity.class);
        activityMap.put(R.id.bt_inflation,  InflationActivity.class);
        activityMap.put(R.id.bt_newActivity,  NewActivity.class);
        activityMap.put(R.id.bt_ex_10_2, Ex10_2Activity.class);
        activityMap.put(R.id.bt_ex_10_20, Ex10_20Activity.class);
        activityMap.put(R.id.bt_ex_10_3, Ex10_3Activity.class);
        activityMap.put(R.id.bt_login, LoginActivity.class);
        activityMap.put(R.id.bt_callComponent, CallComponentActivity.class);
        activityMap.put(R.id.bt_ex11_2, Ex11_2Activity.class);
        activityMap.put(R.id.bt_customListView, CustomListViewActivity.class);
        activityMap.put(R.id.bt_seekbar, SeekBarActivity.class);
        activityMap.put(R.id.bt_network, NetworkActivity.class);
        activityMap.put(R.id.bt_exchage_rate, ExchangeRateActivity.class);
        activityMap.put(R.id.bt_viewcart, ViewCartActivity.class);

    }
    private Map<Integer, Class> activityMap = new HashMap<>();

    public void btClick(View view) {
        Class clazz = activityMap.get(view.getId());
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
//        switch (view.getId()) {
//            case R.id.bt_ex42:
//                Intent intent = new Intent(this, Ex42Activity.class);
//                startActivity(intent); //새화면 띄우기
//                break;
//        }
    }
}



