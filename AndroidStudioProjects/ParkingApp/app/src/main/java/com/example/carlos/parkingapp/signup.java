package com.example.carlos.parkingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

/**
 * Created by Carlos on 11/17/2016.
 */

public class signup extends AppCompatActivity {
    DBHelper helper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Intent i = getIntent();

    }
    public void onSignUp2(View view){
        if(view.getId() == R.id.signup_button2){

            EditText name = (EditText) findViewById(R.id.TFName);
            EditText email = (EditText) findViewById(R.id.TFEmail);
            EditText pwd1 = (EditText) findViewById(R.id.TFPwd1);
            EditText pwd2 = (EditText) findViewById(R.id.TFPwd2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String pwd1str = pwd1.getText().toString();
            String pwd2str = pwd2.getText().toString();

            if(!pwd1str.equals(pwd2str)){
                Toast.makeText(this, "Passwords Do Not Match!", Toast.LENGTH_SHORT).show();

            }
            else{
            //ADD USER INFO TO DATABASE
                UserList user = new UserList();

                user.setName(namestr);
                user.setEmail(emailstr);
                user.setPwd(pwd1str);

                helper.insertUser(user);

            }

        }

    }

}
