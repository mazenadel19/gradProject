package com.example.acer_pc.radar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Acer-PC on 21-Jun-17.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.MyViewHolder>{

    ArrayList<SearchProduct> arrayList= new ArrayList<>();
    Context ctx;

    public SearchResultAdapter(ArrayList<SearchProduct> arrayList, Context ctx){

        this.arrayList=arrayList;
        this.ctx=ctx;
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemState;
        public TextView itemCondition;
        public TextView itemRegion;
        public TextView itemPrice;

        ArrayList<SearchProduct> arrayList= new ArrayList<SearchProduct>();
        Context ctx;


        public MyViewHolder(View view, final Context ctx, final ArrayList<SearchProduct> arrayList) {
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
            SearchProduct searchProduct = this.arrayList.get(position);
            Intent intent = new  Intent(this.ctx,SearchOfferDetails.class);
            intent.putExtra("img_id",searchProduct.getImage_id());
            intent.putExtra("title",searchProduct.getTitle());
            intent.putExtra("state",searchProduct.getState());
            intent.putExtra("condition",searchProduct.getCondition());
            intent.putExtra("price",searchProduct.getPrice());
            intent.putExtra("region",searchProduct.getRegion());

            intent.putExtra("transmission",searchProduct.getTransmission());
            intent.putExtra("model",searchProduct.getModel());
            intent.putExtra("kilometer",searchProduct.getKilometer());
            intent.putExtra("year",searchProduct.getYear());
            intent.putExtra("description",searchProduct.getDescription());


            ctx.startActivity(intent);
        }
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext())
               .inflate(R.layout.activity_search_result_card_layout,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(v,ctx,arrayList);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        SearchProduct searchProduct = arrayList.get(i);

        myViewHolder.itemImage.setImageResource(searchProduct.getImage_id());
        myViewHolder.itemTitle.setText(searchProduct.getTitle());
        myViewHolder.itemState.setText(searchProduct.getState());
        myViewHolder.itemCondition.setText(searchProduct.getCondition());
        myViewHolder.itemRegion.setText(searchProduct.getRegion());
        myViewHolder.itemPrice.setText(searchProduct.getPrice());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void  setFilter(ArrayList<SearchProduct> newList)
    {
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }

}
