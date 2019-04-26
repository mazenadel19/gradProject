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

public class SettingsChangeYourPassword extends AppCompatActivity {

    private Toolbar toolbar;

    public EditText  et_password, et_cpassword, et_opassword;
    public String opassword, password, cpassword;
    Button savebtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_change_your_password);

        //adding title to the activity
        setTitle("Change User's Password");

        //adding the toolbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        et_opassword = (EditText) findViewById(R.id.settingsOldPasswordID);
        et_password = (EditText) findViewById(R.id.settingsNewPasswordID);
        et_cpassword = (EditText) findViewById(R.id.SettingsRepeatPasswordID);
        savebtn = (Button) findViewById(R.id.saveBtnId);




        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBtnValidate();       //check the inputs in the edit text
            }
        });
    }
    private void saveBtnValidate() {
        intialize();          //Preparing the components by converting them to string;

        if (!validate()) {
            Toast.makeText(this, "Please solve the error(s) and try again", Toast.LENGTH_SHORT).show();
        } else {
            saveBtnFun(savebtn);
        }
    }

    public boolean validate() {
        boolean valid = true;

        if(opassword.isEmpty()){
            et_opassword.setError("Please Enter Your Old Password!");
            valid=false;
        }

        if(password.isEmpty()){
            et_password.setError("Please Enter A New Password!");
            valid=false;
        }else
        if(password.length()<5){
            et_password.setError("Your Password Is Too Weak!");
            valid=false;
        } else if(password.equals(opassword)) {
            et_password.setError("Please Enter A New Password!!");
            valid = false;
        }
        if(cpassword.isEmpty()){
            et_cpassword.setError("Please Retype Your New Password!!");
            valid=false;
        }else if(!cpassword.equals(password)){
            et_cpassword.setError("Password doesn't match!!");
            valid=false;

        }
        return valid;
    }



    private void intialize() {

        password  = et_password.getText().toString().trim();
        cpassword = et_cpassword.getText().toString().trim();
        opassword = et_opassword.getText().toString().trim();
    }

    // on click save button
    public void saveBtnFun(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
        Toast.makeText(this, "Your changes have been saved", Toast.LENGTH_SHORT).show();
    }


        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
