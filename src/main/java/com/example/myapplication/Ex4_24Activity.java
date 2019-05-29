package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Ex4_24Activity extends AppCompatActivity { //extends Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4_24); //inflation : layout에 해당하는 xml을 찾아
                                                   //xml요소들을 객체화하고
                                                   //화면에 전개한다
        CheckBox cb1 = (CheckBox)findViewById(R.id.cb1);//VM에 관리되는 객체중 id가 cb1인 View타입의 객체를 찾는다
        CheckBox cb2 = (CheckBox)findViewById(R.id.cb2);
        CheckBox cb3 = (CheckBox)findViewById(R.id.cb3);

        final RadioButton rb1 = (RadioButton)findViewById(R.id.rb1);
        final RadioButton rb2 = (RadioButton)findViewById(R.id.rb2);
        RadioGroup rg = (RadioGroup)findViewById(R.id.rg);



        MyCheckedChangeListener myListener = new  MyCheckedChangeListener();

        cb1.setOnCheckedChangeListener(myListener);
        cb2.setOnCheckedChangeListener(myListener);
        cb3.setOnCheckedChangeListener(myListener);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rb1){ //선택된 Radio버튼을 찾는다
                    Log.i("Ex4_24Activity", rb1.getText().toString());
                }else if(i==R.id.rb2){
                    Log.i("Ex4_24Activity", rb2.getText().toString());
                }
            }
        });

    }
    class MyCheckedChangeListener implements CompoundButton.OnCheckedChangeListener{
        //안드로이드스튜디오에서 오버라이딩 : Ctrl+o
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
           Log.i("Ex4_24Activity", "checked속성값이 변경됨" + b +", text는" + compoundButton.getText());
        }
    }
}
