package com.example.acer_pc.radar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AddOffer extends AppCompatActivity implements View.OnClickListener ,NavigationView.OnNavigationItemSelectedListener,
        AdapterView.OnItemSelectedListener {

    private Toolbar toolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mSelectedID;        //to remember the activity I'm in

    private ImageView imageView;
    private Button UploadBtn;
    private EditText Title,Description,Price;
    private Spinner categories_ads,city,region;
    private final int  IMG_REQUEST=1;
    private Bitmap bitmap;
    private String upload_url="http://10.0.3.2/Renta/upload.php";

    String categories []={"Category : vehicles","mobile phones & tablets","electronics","tools","fashion","jobs",
            "kids" ,"music","books"};

    String cityarray []={"City : Alexandria","Cairo"};

    String regionarray []={"Region : Smouha","el maamoura"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addoffer);

        //adding title to the activity
        setTitle("Add Offer");

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


        imageView= (ImageView) findViewById(R.id.image_btn);
        UploadBtn= (Button) findViewById(R.id.upload_btn);
        Title= (EditText) findViewById(R.id.title_ads);
        Description= (EditText) findViewById(R.id.description);
        Price= (EditText) findViewById(R.id.price);
        categories_ads= (Spinner) findViewById(R.id.category_ads);
        city = (Spinner) findViewById(R.id.city);
        region= (Spinner) findViewById(R.id.region);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,categories);
        categories_ads.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item,cityarray);
        city.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.spinner_item, regionarray);
        region.setAdapter(adapter3);

        imageView.setOnClickListener(this);
        UploadBtn.setOnClickListener(this);


    }


    //create the option menu to hold account icon
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
        return true;

    }

    /* //go to login when account icon clicked
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
 */
    //start activity  when item is clicked
    private void navigate(int selectedItemId) {
        Intent intent = null;

        /*if (selectedItemId == R.id.nav_add_offer_id) {
            mDrawerLayout.closeDrawer(GravityCompat.START); // CLOSE THE drawer when starting new activity

            intent = new Intent(this, AddOffer.class);
            startActivity(intent);

            Toast.makeText(this,"Add Offer",Toast.LENGTH_SHORT).show();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }*/


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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //allow navigation header items to take me to profile activity
    public void goToProfile(View view) {
        Intent intent = new Intent(this, Profile.class); //intent(from here,to.....)
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
    }




    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.image_btn:
                selectimg();
                break;

            case R.id.upload_btn:
                uploadimage();
                break;

        }

    }

    private void selectimg()
    {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==IMG_REQUEST && resultCode==RESULT_OK && data!=null)
        {
            Uri path =data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    private void uploadimage ()
    {
        StringRequest stringRequest =new StringRequest(Request.Method.POST,upload_url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String Response=jsonObject.getString("response");
                    Toast.makeText(AddOffer.this,Response,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(AddOffer.this,MainActivity.class);
                    startActivity(intent);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {

                Map <String,String> params =new HashMap<>();
                params.put("title",Title.getText().toString().trim());
                params.put("description",Description.getText().toString().trim());
                params.put("category",categories_ads.getSelectedItem().toString().trim());
                params.put("city",city.getSelectedItem().toString().trim());
                params.put("region",region.getSelectedItem().toString().trim());
                params.put("price",Price.getText().toString().trim());
                params.put("image",imageToString(bitmap));

                return params;

            }
        };
        MySinglton.getInstance(AddOffer.this).addTIoRequestQue(stringRequest);

    }

    private String imageToString(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgBytes,Base64.DEFAULT);

    }
}
