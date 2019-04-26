package com.example.acer_pc.radar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class SettingsChangeYourPersonalInformation extends AppCompatActivity {

    private Toolbar toolbar;

    private ImageView uploadPic;
    int  IMAGE_GALLERY_REQUEST=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_change_your_personal_information);

        //adding title to the activity
        setTitle("Change User's Personal Information");

        //adding the toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //GenderSpinner
        Spinner spinner2= (Spinner)findViewById(R.id.spinner2Id);
        ArrayAdapter<String> adapter2= new ArrayAdapter<String>
                (SettingsChangeYourPersonalInformation.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.gender));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        //get a reference to the image view that holds the image that the user will see
        uploadPic = (ImageView) findViewById(R.id.ppID);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    //on click Upload button
    public void uploadProfilePic(View v) {
        //requesting the photo
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

        //where to find it?
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath = pictureDirectory.getPath();

        //URI Representation
        Uri data = Uri.parse(pictureDirectoryPath);

        //set the data and the type (get all image types)
        photoPickerIntent.setDataAndType(data, "image/*");

        //use this to get the image from the gallery
        startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {

            //if we are here, everything processed successfully
            if (requestCode == IMAGE_GALLERY_REQUEST) {

                //if we are hearing back from image gallery

                //the address of the image on the SD Card
                Uri imageUri = data.getData();

                //declare a stream to read the image from the SD Card
                InputStream inputStream;

                //we are getting an input stream, based on the uri of the image
                try {
                    inputStream = getContentResolver().openInputStream(imageUri);

                    //get a bitmap from the stream
                    Bitmap image = BitmapFactory.decodeStream(inputStream);

                    uploadPic.setImageBitmap(image);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                    //show message to user indicating that image is not available
                    Toast.makeText(this, "Unable to open Gallery", Toast.LENGTH_SHORT).show();
                }


            }
        }
    }


    // on click save button
    public void saveBtnFun(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
        Toast.makeText(this, "Your changes have been saved", Toast.LENGTH_SHORT).show();
    }

}