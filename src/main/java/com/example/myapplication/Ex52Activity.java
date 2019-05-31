package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ex52Activity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex52);
        editText1 = (EditText)findViewById(R.id.et1);
        editText2 = (EditText)findViewById(R.id.et2);
    }
    public void btNumClick(View view){
        Button bt = (Button)view;
        int num = Integer.parseInt(bt.getText().toString());

        EditText targetEt;
        targetEt = editText1;
        if(editText1.isFocused()){
            targetEt = editText1;
        }else if(editText2.isFocused()){
            targetEt = editText2;
        }
        String beforeText = targetEt.getText().toString(); //EditText에 미리 있던 문자열
        if(beforeText.equals("") || beforeText.equals("0")){
            targetEt.setText(""+num);
        }else{
            targetEt.setText(beforeText+num);
        }


    }
    public void btClick(View view) {
        final TextView tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setVisibility(View.INVISIBLE);

        String et1Str = editText1.getText().toString().trim();
        String et2Str = editText2.getText().toString().trim();
        if (et1Str.equals("")) {
            Toast.makeText(this, "값을 입력하세요", Toast.LENGTH_LONG).show();
            editText1.requestFocus();
            return;
        }
        if (et2Str.equals("")) {
            Toast.makeText(this, "값을 입력하세요", Toast.LENGTH_LONG).show();
            editText2.requestFocus();
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
                    editText2.requestFocus();
                    return;
                }else {
                    numResult = num1 / num2;
                }
                break;
        }
        tvResult.setVisibility(View.VISIBLE);
        tvResult.setText("계산 결과:" + numResult);
    }
}
