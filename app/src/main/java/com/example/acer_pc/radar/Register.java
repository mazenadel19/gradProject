package com.example.acer_pc.radar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Acer-PC on 19-Apr-17.
 */

public class Register extends Login {

    public EditText et_userName, et_password, et_cpassword, et_phone, et_email;
    Spinner spinner1,spinner2;
    public String username, password, cpassword, phone, email,district,gender;
    Button nxtbtn;
    TextView myTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myTextView = (TextView) findViewById(R.id.condTermsID);
        myTextView.setText(Html.fromHtml("<p><u>Terms &amp; Conditions</u></p>"));

        //DistrictsSpinner
         spinner1 = (Spinner) findViewById(R.id.spinner1Id);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (Register.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.District));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        //GenderSpinner
        spinner2= (Spinner)findViewById(R.id.spinner2Id);
        ArrayAdapter<String> adapter2= new ArrayAdapter<String>
                (Register.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.gender));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        et_userName = (EditText) findViewById(R.id.registerUsernameId);
        et_password = (EditText) findViewById(R.id.registerPasswordId);
        et_cpassword = (EditText) findViewById(R.id.registerRepeatPasswordId);
        et_phone = (EditText) findViewById(R.id.registerPhoneId);
        et_email = (EditText) findViewById(R.id.registerEmailID);
        nxtbtn = (Button) findViewById(R.id.nextBtnId);


        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextBtnValidate();       //check the inputs in the edit text
            }
        });
    }

    private void nextBtnValidate() {

        if (!validate()) {
            Toast.makeText(this, "Please solve the error(s) and try again", Toast.LENGTH_SHORT).show();
        } else {
                     //Preparing the components by converting them to string;
          nextBtnFun(null);
        }
    }




    public boolean validate() {
        boolean valid = true;
        if (username.isEmpty()) {
            et_userName.setError("Please Enter A Valid Username!");
            valid = false;
        }
        if (password.isEmpty()) {
            et_password.setError("Please Enter A Password!");
            valid = false;
        } else if (password.length() < 5) {
            et_password.setError("Your Password Is Too Weak!");
            valid = false;
        }

        if (cpassword.isEmpty()) {
            et_cpassword.setError("Please Retype Your Password!!");
            valid = false;
        } else if (!cpassword.equals(password)) {
            et_cpassword.setError("Password doesn't match!!");
            valid = false;
        }

        if (phone.isEmpty()) {
            et_phone.setError("Please Enter A Phone Number!");
            valid = false;
        } else if (phone.length() != 11) {
            et_phone.setError("Phone Number Must Be Equal to 11 Digits!");
            valid = false;
        } else if (!phone.startsWith("01")) {
            et_phone.setError("Phone Number Must Starts With  '01' Digits!");
            valid = false;
        }

        if (email.isEmpty()) {
            et_email.setError("Please Enter Your Email Address!");
            valid = false;
        } else if (!(email.contains("@") && email.endsWith(".com"))){
            et_email.setError("Please Enter A Valid Email Address!");
            valid = false;
        }
        return valid;
}




    // on click next button
    public void nextBtnFun(View view) {

        username  = et_userName.getText().toString();
        email     = et_email.getText().toString();
        password  = et_password.getText().toString();
        cpassword = et_cpassword.getText().toString();
        phone     = et_phone.getText().toString();
        district  = spinner1.getSelectedItem().toString();
        gender    =spinner2.getSelectedItem().toString();
        String method="register";
        BackgroundTask backgroundTask =new BackgroundTask(this);
        backgroundTask.execute(method,username,email,password,phone,district,gender);
        finish();


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"You Were Successfully Registered",Toast.LENGTH_SHORT).show();
    }

    public void  goToTermsConditions (View view){

        Intent intent = new Intent(this, RegisterTermsConditions.class);
        startActivity(intent);
    }


}
