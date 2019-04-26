package com.example.acer_pc.radar;

/**
 * Created by Acer-PC on 22-Jun-17.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class OtherUsersAdapter extends RecyclerView.Adapter<OtherUsersAdapter.MyViewHolder> {

    ArrayList<OtherUserProduct> arrayList= new ArrayList<>();
    Context ctx;

    public OtherUsersAdapter(ArrayList<OtherUserProduct> arrayList, Context ctx) {

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


            ArrayList<OtherUserProduct> arrayList= new ArrayList<OtherUserProduct>();
            Context ctx;


            public MyViewHolder(View view,final Context ctx, final ArrayList<OtherUserProduct> arrayList) {
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
                OtherUserProduct otherUserProduct = this.arrayList.get(position);
                Intent intent = new  Intent(this.ctx,OtherUserOfferDetails.class);
                intent.putExtra("img_id",otherUserProduct.getImage_id());
                intent.putExtra("title",otherUserProduct.getTitle());
                intent.putExtra("state",otherUserProduct.getState());
                intent.putExtra("condition",otherUserProduct.getCondition());
                intent.putExtra("price",otherUserProduct.getPrice());
                intent.putExtra("region",otherUserProduct.getRegion());

                intent.putExtra("transmission",otherUserProduct.getTransmission());
                intent.putExtra("model",otherUserProduct.getModel());
                intent.putExtra("kilometer",otherUserProduct.getKilometer());
                intent.putExtra("year",otherUserProduct.getYear());
                intent.putExtra("description",otherUserProduct.getDescription());

                ctx.startActivity(intent);

            }
        }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_other_users_card_layout,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(v,ctx,arrayList);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        OtherUserProduct otherUserProduct = arrayList.get(i);

        myViewHolder.itemImage.setImageResource(otherUserProduct.getImage_id());
        myViewHolder.itemTitle.setText(otherUserProduct.getTitle());
        myViewHolder.itemState.setText(otherUserProduct.getState());
        myViewHolder.itemCondition.setText(otherUserProduct.getCondition());
        myViewHolder.itemRegion.setText(otherUserProduct.getRegion());
        myViewHolder.itemPrice.setText(otherUserProduct.getPrice());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
