package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){
        Intent intent = new Intent(this,
                                    LoginResultActivity.class);
        String id = ((EditText)findViewById(R.id.etId)).getText().toString();
        String pass = ((EditText)findViewById(R.id.etPass)).getText().toString();
        intent.putExtra("id", id);
        intent.putExtra("pass", pass);
        startActivity(intent);
    }
}
