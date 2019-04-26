package com.example.acer_pc.radar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileOfferDetails extends AppCompatActivity {

    public ImageView imageView;
    public TextView tx_Title;
    public TextView tx_State;
    public TextView tx_Condition;
    public TextView tx_Region;
    public TextView tx_Price;

    public  TextView tx_TransmissionType;
    public  TextView tx_Model;
    public  TextView tx_Kilometer;
    public  TextView tx_Year;
    public  TextView tx_Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_offer_details);

        imageView = (ImageView) findViewById(R.id.d_product_imageID);
        tx_Title = (TextView) findViewById(R.id.d_dummyTitleID);
        tx_State = (TextView) findViewById(R.id.d_dummyStateID);
        tx_Condition = (TextView) findViewById(R.id.d_dummyConditionID);
        tx_Region = (TextView) findViewById(R.id.d_dummyRegionID);
        tx_Price = (TextView) findViewById(R.id.d_dummyPriceID);

        tx_TransmissionType = (TextView) findViewById(R.id.d_dummyTransmissionTypeID);
        tx_Model = (TextView) findViewById(R.id.d_dummyModelID);
        tx_Kilometer = (TextView) findViewById(R.id.d_dummyKilometersID);
        tx_Year = (TextView) findViewById(R.id.d_dummyYearID);
        tx_Description = (TextView) findViewById(R.id.d_dummyDescribtionID);



        imageView.setImageResource(getIntent().getIntExtra("img_id", 00));
        tx_Title.setText("Title : " + getIntent().getStringExtra("title"));
        tx_State.setText("State : " + getIntent().getStringExtra("state"));
        tx_Condition.setText("Condition : " + getIntent().getStringExtra("condition"));
        tx_Region.setText("Region : " + getIntent().getStringExtra("region"));
        tx_Price.setText("Price : " + getIntent().getStringExtra("price"));

        tx_TransmissionType.setText("Transmission Type : " + getIntent().getStringExtra("transmission"));
        tx_Model.setText("Model : "+getIntent().getStringExtra("model"));
        tx_Kilometer.setText("Kilometers : "+getIntent().getStringExtra("kilometer"));
        tx_Year.setText("Years : "+getIntent().getStringExtra("year"));
        tx_Description.setText("Description : "+getIntent().getStringExtra("description"));
    }

    public void goToUsersProfile(View view){

        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

}
