package com.example.acer_pc.radar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginForgotPassword extends AppCompatActivity {

    public EditText et_email;
    public String  email;
    Button restbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_forgot_password);

        //adding title to the activity
        setTitle("Forgot Password?");

        //adding the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            et_email = (EditText) findViewById(R.id.restRegisterEmailID);
            restbtn = (Button) findViewById(R.id.restButtonID);

            restbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    email     = et_email.getText().toString().trim();          //Preparing the components by converting them to string;


                    if (!validate()) {
                                Toast.makeText(getApplicationContext(),"solve the error and try again",Toast.LENGTH_LONG).show();
                    } else {

                    restButtonFun(null);   //CALLING A METHOD WITH A VIEW PARAMETER

                }

                }
            });
        }
    }



    public boolean validate() {
        boolean valid = true;

        if (email.isEmpty()) {
            et_email.setError("Please Enter Your Email Address!");
            valid = false;
        } else if (!(email.contains("@") && email.endsWith(".com"))){
            et_email.setError("Please Enter A Valid Email Address!");
            valid = false;
        }
        return valid;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    public void restButtonFun(View view) {
        Toast.makeText(getApplicationContext(),"Check Your Email Address",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(loginForgotPassword.this, Login.class);
        startActivity(intent);
    }
}
