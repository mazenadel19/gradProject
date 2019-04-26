package com.example.acer_pc.radar;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchOfferDetails extends AppCompatActivity {

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

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_offer_details);

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

    public void goToChat(View view) {
        Intent intent = new Intent(this, Chat.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "Chat", Toast.LENGTH_SHORT).show();

    }

    public void Alert (View view){
        AlertDialog.Builder builder = new  AlertDialog.Builder(SearchOfferDetails.this);
        builder.setMessage("How much are you willing to pay for this product?");

        input=new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SearchOfferDetails.this, "Your offer was sent", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.setTitle("We'll Make The Offer For You!!\n");
        alert.show();
    }

    public void goToOtherUsersProfile(View view){

        Intent intent = new Intent(this, OtherUsersProfile.class); //intent(from here,to.....)
        startActivity(intent);
    }

    public void reportFun(View view) {
            AlertDialog.Builder builder = new  AlertDialog.Builder(SearchOfferDetails.this);
            builder.setMessage("Please explain why do you think this product is harmful?");

            input=new EditText(this);
            builder.setView(input);

            builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(SearchOfferDetails.this, "Thank you", Toast.LENGTH_SHORT).show();
                }
            })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("Report!!\n");
            alert.show();

    }
}