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

public class SettingsChangeYourEmail extends AppCompatActivity {

    private Toolbar toolbar;

    public EditText et_oemail,et_email;
    public String oemail,email;
    Button savebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_change_your_email);

        //adding title to the activity
        setTitle("Change User's Email");

        //adding the toolbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        et_oemail = (EditText) findViewById(R.id.settingsOldEmailID);
        et_email = (EditText) findViewById(R.id.settingsNewEmailID);
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

        if (email.isEmpty()) {
            et_email.setError("Please Enter Your New Email Address!");
            valid = false;
        } else if (!(email.contains("@") && email.endsWith(".com"))){
            et_email.setError("Please Enter A Valid Email Address!");
            valid = false;
        }

        if (oemail.isEmpty()) {
            et_oemail.setError("Please Enter Your Old Email Address!");
            valid = false;
        } else if (!(oemail.contains("@") && oemail.endsWith(".com"))){
            et_oemail.setError("Please Enter A Valid Email Address!");
            valid = false;
        }
        else if(email.equalsIgnoreCase(oemail)){
           et_email.setError("Please Enter A New Email Address!");
            valid=false;
        }
        return valid;
    }

    private void intialize() {

        oemail  = et_oemail.getText().toString().trim();
        email = et_email.getText().toString().trim();

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
