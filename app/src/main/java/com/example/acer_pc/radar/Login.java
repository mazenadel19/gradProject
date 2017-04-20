package com.example.acer_pc.radar;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import static android.R.attr.id;

/**
 * Created by Acer-PC on 19-Apr-17.
 */

public class Login extends Category {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Login");

       Toolbar toolbar= (Toolbar) findViewById(R.id.app_barID);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activty_login);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (id==R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        Toast.makeText(getApplicationContext(),"Categories",Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
