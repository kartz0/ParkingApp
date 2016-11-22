package com.example.carlos.parkingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper helper = new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnLoginClick(View view) {

        if (view.getId() == R.id.login_button){
            EditText a = (EditText) findViewById(R.id.email_Main);
            String email = a.getText().toString();

            EditText b = (EditText) findViewById(R.id.PasswordMain);
            String pass = b.getText().toString();

            String password = helper.getPass(email);


            if (pass.equals(password)){

                Intent intent = new Intent(this, Location_Options.class);

                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Incorrect Login Information!", Toast.LENGTH_SHORT).show();

            }
        }
    }
    public void OnSignupClick(View view){
    if(view.getId() == R.id.signup_button1) {
        Intent intent = new Intent(MainActivity.this, signup.class);

        startActivity(intent);

    }
    }

}
