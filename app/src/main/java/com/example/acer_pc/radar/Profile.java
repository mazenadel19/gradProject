package com.example.acer_pc.radar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.media.Rating;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Profile extends AppCompatActivity {


    private  Button button_submit;
    private RatingBar ratingBar;

    private Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    public ProfileAdapter adapter;
    ArrayList<ProfileProduct> arrayList =new ArrayList<>();





    private  int [] images   ={R.drawable.car1,R.drawable.car2,R.drawable.truck1,R.drawable.truck2,R.drawable.motorcycle1,R.drawable.motorcycle2,
            R.drawable.heavyequipment1,R.drawable.heavyequipment2,R.drawable.vehiclesparts1,R.drawable.vehiclesparts2,R.drawable.watercraft1,R.drawable.watercrafts2};

    private String [] titles ={"Acura MDX","nissan bluebird ","Mantega 460"," Actross mp2"," M109 Suzuki","airbrush 919","Mcv 400","Nissan 1994",
            "Alloy wheels and tires Palace","Back Speakers","Crownline 220 LS 5.0L 320HP","Speed Boat"};
    private String [] state  ={"Buy","Rent","Buy","Rent","Buy","Rent","Buy","Rent","Buy","Rent","Buy","Rent"};
    private String [] condition={"New","Used","Used","New","Used","Used","New","Used","Used","New","Used","Used",};
    private String [] region={"District 1","District 1","District 1","District 1", "District 1","District 1","District 1","District 1", "District 1","District 1","District 1","District 1", };
    private String [] price={"67000","5000","43000","140000","7500","24000","67000","5000","43000","140000","7500","24000"};

    private String [] transmission = {"automatic","manuel","automatic","automatic","automatic","automatic","-","manuel","-","-","manuel","manuel"};
    private String [] model = {"Lancer","Nissan ","Mercedes","Chevrolet","Suzuki","Rocket","sernj","Nissan","Mercedes","-","Chaparral","MerCruiser"};
    private String [] kilometer= {"+200000 ","100000 to 109999","100000 to 109999","1000","+200000","100000 to 109999","100000 to 109999","100000","1000","-","100000 to 109999","100000 to 109999"};
    private String [] year = {"2005","2004 ","2006","2007","2008","2001","2005","2004 ","2006","2007","2008","2009"};
    private String [] description = {"In a very good condition","In an acceptable condition","In a good condition","In a very good condition",
            "In a very good condition","In an acceptable condition","In a good condition","In a very good condition",
            "In a very good condition","In an acceptable condition","In a good condition","In a very good condition",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        recyclerView = (RecyclerView) findViewById(R.id.myProfileRecyclerViewID);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int count=0;

        for(String Title : titles)
        {
            ProfileProduct profileProduct= new ProfileProduct(images[count],titles[count],state[count],condition[count],price[count],region[count],
                                        transmission[count],model[count],kilometer[count],year[count],description[count]);
            count++;
            arrayList.add(profileProduct);

        }
        adapter = new ProfileAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);


    }

}

