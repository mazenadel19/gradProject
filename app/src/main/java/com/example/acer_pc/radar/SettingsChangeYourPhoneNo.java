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

public class SettingsChangeYourPhoneNo extends AppCompatActivity {

    private Toolbar toolbar;

    public EditText et_ophone,et_phone;
    public String ophone,phone;
    Button savebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_change_your_phone_no);

        //adding title to the activity
        setTitle("Change User's Phone Number");

        //adding the toolbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        et_ophone = (EditText) findViewById(R.id.settingsOldPhoneId);
        et_phone = (EditText) findViewById(R.id.settingsNewPhoneId);
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

        if (ophone.isEmpty()) {
            et_ophone.setError("Please Enter A Phone Number!");
            valid = false;
        } else if (ophone.length() != 11) {
            et_ophone.setError("Phone Number Must Be Equal to 11 Digits!");
            valid = false;
        } else if (!ophone.startsWith("01")) {
            et_ophone.setError("Phone Number Must Starts With  '01' Digits!");
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
        else if(phone.equals(ophone)){
            et_phone.setError("Please Enter A New Phone Number!");
            valid = false;
        }
        return valid;
    }

    private void intialize() {

        ophone  = et_ophone.getText().toString().trim();
        phone = et_phone.getText().toString().trim();

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
