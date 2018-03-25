package com.dinhmaumimh.thuphap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Admin on 3/15/2018.
 */

public class Adapter extends BaseAdapter {
    Context context;
    Cursor cusor;
    SQlite sq;
    ArrayList<Thuphap> thuphaplist;

    public Adapter(Context c , ArrayList<Thuphap> thuphap){
        this.context  = c;
        this.thuphaplist = thuphap;
    }
    @Override
    public int getCount() {
        return thuphaplist.size();
    }

    @Override
    public Object getItem(int position) {
        return thuphaplist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View cell = convertView;
        Typeface tf = Typeface.createFromAsset(context.getAssets(),"Fonts/TMC_Ong_Do.TTF");
        mottieude Mottieude;
        if(cell ==null){
            Mottieude = new mottieude();

            LayoutInflater lf = ((Activity)context).getLayoutInflater();
            cell = lf.inflate(R.layout.list_item,parent,false);
            Mottieude.tieude = (TextView)cell.findViewById(R.id.txttieude);
            Mottieude.tieude.setTypeface(tf);
            cell.setTag(Mottieude);
            Mottieude.tieude.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = new Intent(context.getApplicationContext(),ContentActivity.class);
                    it.putExtra("id",thuphaplist.get(position).getId());
                    ((Activity)context).startActivity(it);
                }
            });
        }else{
            Mottieude = (mottieude)cell.getTag();
        }
        Mottieude.tieude.setText(thuphaplist.get(position).getTieude());

        return cell;
    }



}
class mottieude{
    TextView tieude;
}
