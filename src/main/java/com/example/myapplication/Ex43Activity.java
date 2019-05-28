package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ex43Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex43);
//        final EditText et1 = (EditText) findViewById(R.id.et1);
//        final EditText et2 = (EditText) findViewById(R.id.et2);
//        Button btPlus = (Button) findViewById(R.id.btPlus);
//        Button btMinus = (Button) findViewById(R.id.btMinus);
//        Button btMul = (Button) findViewById(R.id.btMul);
//        Button btDiv = (Button) findViewById(R.id.btDiv);
//        Button btMod = (Button) findViewById(R.id.btMod);
//        final TextView tvResult = (TextView) findViewById(R.id.tvResult);
//        btPlus.setOnClickListener(new View.OnClickListener() {
//                                      @Override
//                                      public void onClick(View view) {
//                                          String et1Str = et1.getText().toString().trim();
//                                          String et2Str = et2.getText().toString().trim();
//                                          if (et1Str.equals("")) {
//                                              Toast.makeText(Ex43Activity.this, "값을 입력하세요", Toast.LENGTH_LONG).show();
//                                              et1.requestFocus();
//                                              tvResult.setVisibility(View.INVISIBLE);
//                                          } else if (et2Str.equals("")) {
//                                              Toast.makeText(Ex43Activity.this, "값을 입력하세요", Toast.LENGTH_LONG).show();
//                                              et2.requestFocus();
//                                              tvResult.setVisibility(View.INVISIBLE);
//                                          } else {
//                                              float num1 = Float.parseFloat(et1Str);
//                                              float num2 = Float.parseFloat(et2Str);
//                                              tvResult.setVisibility(View.VISIBLE);
//                                              tvResult.setText("계산 결과:" + (num1 + num2));
//                                          }
//                                      }
//                                  }
//        );
//        btMinus.setOnClickListener(new View.OnClickListener() {
//                                       @Override
//                                       public void onClick(View view) {
//                                           String et1Str = et1.getText().toString().trim();
//                                           String et2Str = et2.getText().toString().trim();
//                                           if (et1Str.equals("")) {
//                                               Toast.makeText(Ex43Activity.this, "값을 입력하세요", Toast.LENGTH_LONG).show();
//                                               et1.requestFocus();
//                                               tvResult.setVisibility(View.INVISIBLE);
//                                           } else if (et2Str.equals("")) {
//                                               Toast.makeText(Ex43Activity.this, "값을 입력하세요", Toast.LENGTH_LONG).show();
//                                               et2.requestFocus();
//                                               tvResult.setVisibility(View.INVISIBLE);
//                                           } else {
//                                               float num1 = Float.parseFloat(et1Str);
//                                               float num2 = Float.parseFloat(et2Str);
//                                               tvResult.setVisibility(View.VISIBLE);
//                                               tvResult.setText("계산 결과:" + (num1 - num2));
//                                           }
//                                       }
//                                   }
//        );
//        btMul.setOnClickListener(new View.OnClickListener() {
//                                     @Override
//                                     public void onClick(View view) {
//                                         String et1Str = et1.getText().toString().trim();
//                                         String et2Str = et2.getText().toString().trim();
//                                         if (et1Str.equals("")) {
//                                             Toast.makeText(Ex43Activity.this, "값을 입력하세요", Toast.LENGTH_LONG).show();
//                                             et1.requestFocus();
//                                             tvResult.setVisibility(View.INVISIBLE);
//                                         } else if (et2Str.equals("")) {
//                                             Toast.makeText(Ex43Activity.this, "값을 입력하세요", Toast.LENGTH_LONG).show();
//                                             et2.requestFocus();
//                                             tvResult.setVisibility(View.INVISIBLE);
//                                         } else {
//                                             float num1 = Float.parseFloat(et1Str);
//                                             float num2 = Float.parseFloat(et2Str);
//                                             tvResult.setVisibility(View.VISIBLE);
//                                             tvResult.setText("계산 결과:" + (num1 * num2));
//                                         }
//                                     }
//                                 }
//        );
//        btDiv.setOnClickListener(new View.OnClickListener() {
//                                     @Override
//                                     public void onClick(View view) {
//                                         String et1Str = et1.getText().toString().trim();
//                                         String et2Str = et2.getText().toString().trim();
//                                         if (et1Str.equals("")) {
//                                             Toast.makeText(Ex43Activity.this, "값을 입력하세요", Toast.LENGTH_LONG).show();
//                                             et1.requestFocus();
//                                             tvResult.setVisibility(View.INVISIBLE);
//                                         } else if (et2Str.equals("")) {
//                                             Toast.makeText(Ex43Activity.this, "값을 입력하세요", Toast.LENGTH_LONG).show();
//                                             et2.requestFocus();
//                                             tvResult.setVisibility(View.INVISIBLE);
//                                         } else if (et2Str.equals("0")) {
//                                             Toast.makeText(Ex43Activity.this, "0이 아닌 값을 입력하세요", Toast.LENGTH_LONG).show();
//                                             et2.requestFocus();
//                                             tvResult.setVisibility(View.INVISIBLE);
//                                         } else {
//                                             tvResult.setVisibility(View.VISIBLE);
//                                             float num1 = Float.parseFloat(et1Str);
//                                             float num2 = Float.parseFloat(et2Str);
//                                             tvResult.setText("계산 결과:" + (num1 / num2));
//                                         }
//                                     }
//                                 }
//        );
//        btMod.setOnClickListener(new View.OnClickListener() {
//                                     @Override
//                                     public void onClick(View view) {
//                                         String et1Str = et1.getText().toString().trim();
//                                         String et2Str = et2.getText().toString().trim();
//                                         if (et1Str.equals("")) {
//                                             Toast.makeText(Ex43Activity.this, "값을 입력하세요", Toast.LENGTH_LONG).show();
//                                             et1.requestFocus();
//                                             tvResult.setVisibility(View.INVISIBLE);
//                                         } else if (et2Str.equals("")) {
//                                             Toast.makeText(Ex43Activity.this, "값을 입력하세요", Toast.LENGTH_LONG).show();
//                                             et2.requestFocus();
//                                             tvResult.setVisibility(View.INVISIBLE);
//                                         } else if (et2Str.equals("0")) {
//                                             Toast.makeText(Ex43Activity.this, "0이 아닌 값을 입력하세요", Toast.LENGTH_LONG).show();
//                                             et2.requestFocus();
//                                             tvResult.setVisibility(View.INVISIBLE);
//                                         } else {
//                                             tvResult.setVisibility(View.VISIBLE);
//                                             int num1 = Integer.parseInt(et1Str);
//                                             int num2 = Integer.parseInt(et2Str);
//                                             tvResult.setText("계산 결과:" + (num1 % num2));
//                                         }
//                                     }
//                                 }
//        );
    }

    public void btClick(View view) {

        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final TextView tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setVisibility(View.INVISIBLE);

        String et1Str = et1.getText().toString().trim();
        String et2Str = et2.getText().toString().trim();
        if (et1Str.equals("")) {
            Toast.makeText(this, "값을 입력하세요", Toast.LENGTH_LONG).show();
            et1.requestFocus();
            return;
        }
        if (et2Str.equals("")) {
            Toast.makeText(this, "값을 입력하세요", Toast.LENGTH_LONG).show();
            et2.requestFocus();
            return;
        }
        float num1 = Float.parseFloat(et1Str);
        float num2 = Float.parseFloat(et2Str);
        float numResult = -1;
        switch (view.getId()) {
            case R.id.btPlus:
                numResult = num1 + num2;
                break;
            case R.id.btMinus:
                numResult = num1 - num2;
                break;
            case R.id.btMul:
                numResult = num1 * num2;
                break;
            case R.id.btDiv:
                if (num2 == 0.0F) {
                    Toast.makeText(this, "0이 아닌 값을 입력하세요", Toast.LENGTH_LONG).show();
                    et2.requestFocus();
                    return;
                }else {
                    numResult = num1 / num2;
                }
                break;
            case R.id.btMod:
                if (num2 == 0.0F) {
                    Toast.makeText(this, "0이 아닌 값을 입력하세요", Toast.LENGTH_LONG).show();
                    et2.requestFocus();
                    return;
                }else {
                    numResult = num1 % num2;
                }
                break;
        }
        tvResult.setVisibility(View.VISIBLE);
        tvResult.setText("계산 결과:" + numResult);
    }
}