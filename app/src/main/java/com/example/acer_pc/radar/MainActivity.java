package com.example.acer_pc.radar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Toast toastCat;

    private static final String SELECTED_ITEM_ID = "selected_item_ID";
    private static final String FIRST_TIME = "first_time";

    private Toolbar toolbar;

    private FloatingActionButton mFAB;

    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mSelectedID;        //to remember the activity I'm in
    private boolean mUserSawDrawer = false;


    GridView gv;
    ImageButton search_btn;

    String names[] = {"vehicles", "mobile phones & tablets", "electronics", "tools", "fashion", "jobs",
            "kids", "music", "books"};
    int imges[] = {R.drawable.vehicles, R.drawable.mobilephones, R.drawable.electronic,
            R.drawable.tools, R.drawable.fashion, R.drawable.jobs, R.drawable.kids,
            R.drawable.music, R.drawable.books};

    public static int subcatno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //connecting the java with xml
        setContentView(R.layout.activity_main);

        //adding title to the activity
        setTitle("Categories");


        //adding the toolbar************
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initializing the navigation view (child)**********
        mDrawer = (NavigationView) findViewById(R.id.main_drawerID);

        //this activity will handle the click event**************
        mDrawer.setNavigationItemSelectedListener(this);

        //initializing the drawer layout (parent)**************
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layoutID);

        //ActionBarDrawerToggle is needed to show the hamburger icon************
        //mDrawerToggle keep tracks of who is active on the screen the drawer or the main content
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

        //linking mDrawerLayout & mDrawerToggle***************
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        // show the hamburger icon*******************
        mDrawerToggle.syncState();

        //to make the user see the drawer
        if (!didUserSeeDrawer()) {
            showDrawer();
            markDrawerSeen();
        } else {
            hideDrawer();
        }


        //if it's the first time you open the app & in landscape mode open categories if else open the value stored in savedInstanceState ie. id of the activity
        mSelectedID = savedInstanceState == null ? R.id.nav_categories_id : savedInstanceState.getInt(SELECTED_ITEM_ID);
        //go to that activity
        navigate(mSelectedID);

        //initializing the floating button
        mFAB = (FloatingActionButton) findViewById(R.id.fab);
        mFAB.setOnClickListener(mFabClickListener);


        /* Toast toastCat =Toast.makeText(getApplicationContext(),"Categories",Toast.LENGTH_SHORT);
            toastCat.show();
         */


        //grid_view
        gv = (GridView) findViewById(R.id.grid_view);
        final MainActivityAdapter mainActivityAdapter = new MainActivityAdapter(this, getcategory());
        gv.setAdapter(mainActivityAdapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(getApplicationContext(),values[position],Toast.LENGTH_LONG).show();

                subcatno = position;
                startActivity(new Intent(MainActivity.this, Sub_Category.class));


            }
        });

/*
        mDrawer.setNavigationItemSelectedListener(this);
        View header = mDrawer.getHeaderView(0);
        TextView profilename = (TextView) mDrawer.findViewById(R.id.username);
      // profilename.setText("m a d d");

      //  CircleImageView imgProfile = (CircleImageView) header.findViewById(R.id.profile_image);

        RelativeLayout nheader = (RelativeLayout) mDrawer.findViewById(R.id.header);
        mDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });*/
/*
        mDrawer.setNavigationItemSelectedListener(this);
        View headerLayout = mDrawer.getHeaderView(0);

        CircleImageView profileimage = (CircleImageView)headerLayout.findViewById(R.id.profile_image);

        TextView proName = (TextView) headerLayout.findViewById(R.id.username);
        TextView proMail = (TextView) headerLayout.findViewById(R.id.userMail);


        proName.setText("hahahaha");
        proMail.setText("nananan");
       mDrawer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();

               Intent i = new Intent(MainActivity.this,Profile.class);
               startActivity(i);
           }
           //////////////the part in navigate
       });*/


    }

    private ArrayList<Category> getcategory() {
        ArrayList<Category> cat = new ArrayList<Category>();
        cat.add(new Category(names[0], imges[0]));
        cat.add(new Category(names[1], imges[1]));
        cat.add(new Category(names[2], imges[2]));
        cat.add(new Category(names[3], imges[3]));
        cat.add(new Category(names[4], imges[4]));
        cat.add(new Category(names[5], imges[5]));
        cat.add(new Category(names[6], imges[6]));
        cat.add(new Category(names[7], imges[7]));
        cat.add(new Category(names[8], imges[8]));
        return cat;

    }

    //initializing the floating button
    private View.OnClickListener mFabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this, AddOffer.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Add Offer", Toast.LENGTH_SHORT).show();

        }
    };

    //create the option menu to hold account icon*************
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        return true;

    }

    //go to login when account icon clicked*****************
  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_profileID) {
            Intent intent = new Intent(this, Login.class); //intent(from here,to.....)
            startActivity(intent);

            Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    //to know if user saw the drawer
    private boolean didUserSeeDrawer() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mUserSawDrawer = sharedPreferences.getBoolean(FIRST_TIME, false);
        return mUserSawDrawer;
    }

    //update shared preference when user see the drawer
    private void markDrawerSeen() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mUserSawDrawer = true;
        sharedPreferences.edit().putBoolean(FIRST_TIME, mUserSawDrawer).apply();

    }

    //show the drawer
    private void showDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    //hide the drawer
    private void hideDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }


    //start activity  when item is clicked**************
    private void navigate(int selectedItemId) {
        Intent intent = null;

        if (selectedItemId == R.id.nav_add_offer_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START); // CLOSE THE drawer when starting new activity

            intent = new Intent(this, AddOffer.class);
            startActivity(intent);

            Toast.makeText(this, "Add Offer", Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }

      /*
        /////////////the part in onCreate
        else if(selectedItemId==R.id.profile_image){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this,Profile.class);
            startActivity(intent);

            Toast.makeText(this,"Profile",Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }*/

            /*else if(selectedItemId==R.id.nav_categories_id){
                mDrawerLayout.closeDrawer(GravityCompat.START);
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);

                  Toast.makeText(this,"Navigation",Toast.LENGTH_SHORT).show();
                overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }*/

        else if (selectedItemId == R.id.nav_chat_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Chat.class);
            startActivity(intent);

            Toast.makeText(this, "Chat", Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (selectedItemId == R.id.nav_search_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Search.class);
            startActivity(intent);

            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (selectedItemId == R.id.nav_settings_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Settings.class);
            startActivity(intent);

            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (selectedItemId == R.id.nav_contact_us_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, ContactUs.class);
            startActivity(intent);

            Toast.makeText(this, "Contact us", Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }
        else if (selectedItemId == R.id.nav_log_out_id){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Login.class);
            startActivity(intent);

            Toast.makeText(this, "You have logged out", Toast.LENGTH_SHORT).show();

        }
    }

    //needed to be handled while using ActionBarDrawerToggle
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    //navigate to selected item******************
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        menuItem.setChecked(true); //check the item when the user click it
        mSelectedID = menuItem.getItemId(); // save the id of the clicked item

        navigate(mSelectedID);
        return true;
    }

    //to save the last activity when the screen is rotated
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("SELECTED_ITEM_ID", mSelectedID);
    }

    //when back pressed if the drawer open close it else carry on***************
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {

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