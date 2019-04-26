package com.example.acer_pc.radar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Acer-PC on 19-Jun-17.
 */

public class SettingsAdapter extends ArrayAdapter<String> {

    Context c;
    int[] imgs={};
    String[] values ={};
    LayoutInflater inflater;

    public SettingsAdapter(Context context, String[] values, int[] imgs) {
        super(context, R.layout.activity_settings_row, values);
        this.c= context;
        this.imgs = imgs;
        this.values = values;
    }

    public class ViewHolder{
        ImageView img;
        TextView value;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.activity_settings_row,null);
        }
        final ViewHolder holder = new ViewHolder();
        holder.value = (TextView) convertView.findViewById(R.id.textView1);
        holder.img= (ImageView) convertView.findViewById(R.id.imageView1);

        holder.img.setImageResource(imgs[position]);
        holder.value.setText(values[position]);

        return  convertView;
    }
}
