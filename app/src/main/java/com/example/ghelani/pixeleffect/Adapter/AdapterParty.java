package com.example.ghelani.pixeleffect.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ghelani.pixeleffect.Emoji_Activity;
import com.example.ghelani.pixeleffect.R;

public class AdapterParty extends BaseAdapter{
    private final Emoji_Activity activity;
    private final LayoutInflater inflater;
    private ImageView sticker;
    int[] stickersParty=new int[]{R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b6,R.drawable.b7,R.drawable.b8,R.drawable.b9,R.drawable.b10,R.drawable.b12,R.drawable.b14,R.drawable.b15,R.drawable.b16,R.drawable.b17,R.drawable.b18,R.drawable.b19,R.drawable.b20};

    public AdapterParty(Emoji_Activity emoji_activity) {
        activity=emoji_activity;
        inflater= LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return stickersParty.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.sticker,parent,false);
        sticker=(ImageView)convertView.findViewById(R.id.sticker);
        sticker.setImageResource(stickersParty[position]);
        return convertView;
    }
}
