package com.example.acer_pc.radar;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.acer_pc.radar.MainActivity.subcatno;

public class Sub_Category extends  AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,AdapterView.OnItemClickListener {


    private Toolbar toolbar;

    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mSelectedID;        //to remember the activity I'm in

    String [] vehicles={"Cars","Trucks","Motorcycles&Scooters","Heavy Equipment","Vehicles Parts","Watercrafts"};
    String [] MobilePhones={"MobilePhones","Tablets","Accessories for mobilePhones&tablets"};
    String []myarray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub__category);


        Toast.makeText(this, "Sub-Categories", Toast.LENGTH_SHORT).show();

        //adding title to the activity
        setTitle("Sub-Categories");

        //adding the toolbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initializing the navigation view (child)
        mDrawer=(NavigationView) findViewById(R.id.main_drawerID);

        //this activity will handle the click event
        mDrawer.setNavigationItemSelectedListener(this);

        //initializing the drawer layout (parent)
        mDrawerLayout =(DrawerLayout) findViewById(R.id.drawer_layoutID);

        //ActionBarDrawerToggle is needed to show the hamburger icon
        //mDrawerToggle keep tracks of who is active on the screen the drawer or the main content
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);

        //linking mDrawerLayout & mDrawerToggle
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        // show the hamburger icon
        mDrawerToggle.syncState();

        if (subcatno==0)
        {
            myarray=vehicles;
        }
        else {myarray=MobilePhones;}

        ListView subcategory= (ListView) findViewById(R.id.sub_category_list);
        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myarray);
        subcategory.setAdapter(myadapter);
        subcategory.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (myarray==vehicles && position==0 )
        {
            Toast.makeText(this,"cars",Toast.LENGTH_LONG).show();
        }

        if (myarray==MobilePhones && position==0 )
        {
            Toast.makeText(this,"mobilephones",Toast.LENGTH_LONG).show();
        }


    }

    //create the option menu to hold account icon
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
        return true;

    }

    //go to login when account icon clicked
   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();


        if(id==R.id.action_profileID){
            Intent intent= new Intent(this,Login.class); //intent(from here,to.....)
            startActivity(intent);

            Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_SHORT).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    //start activity  when item is clicked
    private void navigate(int selectedItemId) {
        Intent intent = null;

        if (selectedItemId == R.id.nav_add_offer_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START); // CLOSE THE drawer when starting new activity

            intent = new Intent(this, AddOffer.class);
            startActivity(intent);

            Toast.makeText(this,"Add Offer",Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }


        else if(selectedItemId==R.id.nav_categories_id){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this,MainActivity.class);
            startActivity(intent);

            Toast.makeText(this,"Categories",Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }

        else if (selectedItemId == R.id.nav_chat_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Chat.class);
            startActivity(intent);

            Toast.makeText(this,"Chat",Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }

        else  if (selectedItemId == R.id.nav_search_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Search.class);
            startActivity(intent);

            Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }
        else if (selectedItemId == R.id.nav_settings_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Settings.class);
            startActivity(intent);

            Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }

        else if (selectedItemId == R.id.nav_contact_us_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, ContactUs.class);
            startActivity(intent);

            Toast.makeText(this,"Contact us",Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }
        else if ( selectedItemId == R.id.nav_log_out_id){

            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Login.class);
            startActivity(intent);

            Toast.makeText(this, "You have logged out", Toast.LENGTH_SHORT).show();
        }

    }

    //navigate to selected item
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        menuItem.setChecked(true); //check the item when the user click it
        mSelectedID=menuItem.getItemId(); // save the id of the clicked item

        navigate(mSelectedID);
        return true;
    }


    //when back pressed if the drawer open close it else carry on
    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {

            super.onBackPressed();

        }

    }


    //allow navigation header items to take me to profile activity
    public void goToProfile(View view) {
        Intent intent = new Intent(this, Profile.class); //intent(from here,to.....)
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
    }

}
