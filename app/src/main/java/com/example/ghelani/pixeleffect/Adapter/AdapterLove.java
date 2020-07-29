package com.example.ghelani.pixeleffect.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ghelani.pixeleffect.Emoji_Activity;
import com.example.ghelani.pixeleffect.R;

public class AdapterLove extends BaseAdapter{
    private final Emoji_Activity activity;
    private final LayoutInflater inflater;
    private ImageView sticker;
    int[] stickersLove=new int[]{R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,R.drawable.s11,R.drawable.s12,R.drawable.s13,R.drawable.s14,R.drawable.s15,R.drawable.s16,R.drawable.s17,R.drawable.s18,R.drawable.s19,R.drawable.s20};

    public AdapterLove(Emoji_Activity emoji_activity) {
        activity=emoji_activity;
        inflater= LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return stickersLove.length;
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
        sticker.setImageResource(stickersLove[position]);
        return convertView;
    }
}
