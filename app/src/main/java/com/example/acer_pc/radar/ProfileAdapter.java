package com.example.acer_pc.radar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.facebook.FacebookSdk.getApplicationContext;


public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {


    ArrayList<ProfileProduct> arrayList= new ArrayList<>();
    Context ctx;

    public ProfileAdapter(ArrayList<ProfileProduct> arrayList, Context ctx) {

        this.ctx=ctx;
        this.arrayList = arrayList;

    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public  int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemState;
        public TextView itemCondition;
        public TextView itemRegion;
        public TextView itemPrice;

        ArrayList<ProfileProduct> arrayList= new ArrayList<ProfileProduct>();
        Context ctx;

        public MyViewHolder(View view,final Context ctx, final ArrayList<ProfileProduct> arrayList) {
            super(view);

            view.setOnClickListener(this);

            this.arrayList=arrayList;
            this.ctx=ctx;

            itemImage = (ImageView) view.findViewById(R.id.dummyImageID);
            itemTitle = (TextView) view.findViewById(R.id.dummyTitleID);
            itemState = (TextView) view.findViewById(R.id.dummyStateID);
            itemCondition = (TextView) view.findViewById(R.id.dummyConditionID);
            itemRegion = (TextView) view.findViewById(R.id.dummyRegionID);
            itemPrice = (TextView) view.findViewById(R.id.dummyPriceID);

        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            ProfileProduct profileProduct = this.arrayList.get(position);
            Intent intent = new  Intent(this.ctx,ProfileOfferDetails.class);
            intent.putExtra("img_id",profileProduct.getImage_id());
            intent.putExtra("title",profileProduct.getTitle());
            intent.putExtra("state",profileProduct.getState());
            intent.putExtra("condition",profileProduct.getCondition());
            intent.putExtra("price",profileProduct.getPrice());
            intent.putExtra("region",profileProduct.getRegion());

            intent.putExtra("transmission",profileProduct.getTransmission());
            intent.putExtra("model",profileProduct.getModel());
            intent.putExtra("kilometer",profileProduct.getKilometer());
            intent.putExtra("year",profileProduct.getYear());
            intent.putExtra("description",profileProduct.getDescription());
            ctx.startActivity(intent);

        }
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_profile_card_layout,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(v,ctx,arrayList);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        ProfileProduct profileProduct = arrayList.get(i);

        myViewHolder.itemImage.setImageResource(profileProduct.getImage_id());
        myViewHolder.itemTitle.setText(profileProduct.getTitle());
        myViewHolder.itemState.setText(profileProduct.getState());
        myViewHolder.itemCondition.setText(profileProduct.getCondition());
        myViewHolder.itemRegion.setText(profileProduct.getRegion());
        myViewHolder.itemPrice.setText(profileProduct.getPrice());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}