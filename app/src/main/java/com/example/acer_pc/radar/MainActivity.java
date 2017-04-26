package com.example.acer_pc.radar;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {


        //Toast toastCat;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTitle("Categories");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar= (Toolbar) findViewById(R.id.app_barID);
        setSupportActionBar(toolbar);    //tell android studio to use my new toolbar

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationDrawerFragment drawerFragment =(NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawerID);

        drawerFragment.setUp(R.id.fragment_navigation_drawerID,(DrawerLayout) findViewById(R.id.drawer_layoutID),toolbar);

        /* Toast toastCat =Toast.makeText(getApplicationContext(),"Categories",Toast.LENGTH_SHORT);
            toastCat.show();
        */
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();


        if(id==R.id.action_profileID){
            Intent intent= new Intent(this,Login.class); //intent(from here,to.....)
            startActivity(intent);

            Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_SHORT).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}