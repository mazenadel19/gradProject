package com.example.acer_pc.radar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Acer-PC on 10-Jun-17.
 */

public class MainActivityAdapter extends BaseAdapter {

    Context c;
    ArrayList<Category> category;

    public MainActivityAdapter(Context c , ArrayList<Category> category)
    {
        this.c=c;
        this.category = category;
    }

    @Override
    public int getCount() {
        return category.size();
    }

    @Override
    public Object getItem(int position) {
        return category.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null)
        {
            convertView =inflater.inflate(R.layout.single_category,parent,false);

        }
        ImageView img = (ImageView) convertView.findViewById(R.id.image_view1);
        TextView tv= (TextView) convertView.findViewById(R.id.textview1);
        img.setImageResource(category.get(position).getImg());
        tv.setText(category.get(position).getName());

        return convertView;
    }
}

