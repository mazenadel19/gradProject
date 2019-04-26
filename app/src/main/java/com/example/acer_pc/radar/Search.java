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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Search extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mSelectedID;        //to remember the activity I'm in

    Button searchbtn;

    private Spinner districts_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //CategorySpinner
        Spinner category = (Spinner) findViewById(R.id.categorySpinnerID);
        ArrayAdapter<String> category_adapter = new ArrayAdapter<String>
                (Search.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.category));
        category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(category_adapter);

        //Sub-CategorySpinner
        Spinner subcategory = (Spinner) findViewById(R.id.subcategorySpinnerID);
        ArrayAdapter<String> subcategory_adapter = new ArrayAdapter<String>
                (Search.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.subcategory));
        subcategory_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subcategory.setAdapter(subcategory_adapter);

        //DistrictsSpinner
        districts_spinner = (Spinner) findViewById(R.id.districtSpinnerID);
        ArrayAdapter<String> districts_adapter = new ArrayAdapter<String>
                (Search.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.District));
        districts_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districts_spinner.setAdapter(districts_adapter);





        //adding title to the activity
        setTitle("Search");

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

    }

    public void disableDistrict(View view){
        boolean checked =((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioButton:
                districts_spinner.setEnabled(false);
                districts_spinner.setClickable(false);

        }

    }

    public void enableDistrict(View view){
        boolean checked =((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioButton2:
                districts_spinner.setEnabled(true);
                districts_spinner.setClickable(true);
        }

    }


    //create the option menu to hold account icon
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
        return true;

    }

    //go to login when account icon clicked
  /*  @Override
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
*/
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


        if(selectedItemId==R.id.nav_categories_id){
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
        /*else  if (selectedItemId == R.id.nav_search_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Search.class);
            startActivity(intent);

            Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }*/
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


    // on click next button
    public void searchBtnFun(View view) {
        Intent intent = new Intent(this, SearchResult.class);
        startActivity(intent);

    }



}