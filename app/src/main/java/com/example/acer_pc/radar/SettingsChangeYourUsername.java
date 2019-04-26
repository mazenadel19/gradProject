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

public class SettingsChangeYourUsername extends AppCompatActivity {

    private Toolbar toolbar;

    public EditText et_oUserName, et_UserName;
    public String oUserName, UserName;
    Button savebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_change_your_username);

        //adding title to the activity
        setTitle("Change User's Username");

        //adding the toolbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        et_oUserName = (EditText) findViewById(R.id.settingsOldUsernameID);
        et_UserName = (EditText) findViewById(R.id.settingsNewUsernameID);
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

        if (oUserName.isEmpty()) {
            et_oUserName.setError("Please Enter A Valid Username!");
            valid = false;
        }
        if (UserName.isEmpty()) {
            et_UserName.setError("Please Enter A Valid Username!");
            valid = false;
        }else if(UserName.equalsIgnoreCase(oUserName)){
            et_UserName.setError("Please Enter A New Username!");
            valid = false;
        }

        return valid;
    }

    private void intialize() {

        oUserName  = et_oUserName.getText().toString().trim();
        UserName = et_UserName.getText().toString().trim();

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
