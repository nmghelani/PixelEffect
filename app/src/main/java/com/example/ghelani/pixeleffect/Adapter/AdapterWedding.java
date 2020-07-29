package com.example.ghelani.pixeleffect.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ghelani.pixeleffect.Emoji_Activity;
import com.example.ghelani.pixeleffect.R;

public class AdapterWedding extends BaseAdapter{
    private final Emoji_Activity activity;
    private final LayoutInflater inflater;
    private ImageView sticker;
    int[] stickersWed=new int[]{R.drawable.wedding01,R.drawable.wedding02,R.drawable.wedding03,R.drawable.wedding04,R.drawable.wedding05,R.drawable.wedding06,R.drawable.wedding07,R.drawable.wedding08,R.drawable.wedding09,R.drawable.wedding10,R.drawable.wedding11,R.drawable.wedding12,R.drawable.wedding13,R.drawable.wedding14,R.drawable.wedding15,R.drawable.wedding16,R.drawable.wedding17,R.drawable.wedding18,R.drawable.wedding19,R.drawable.wedding20,R.drawable.wedding21,R.drawable.wedding22};

    public AdapterWedding(Emoji_Activity emoji_activity) {
        activity=emoji_activity;
        inflater= LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return stickersWed.length;
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
        sticker.setImageResource(stickersWed[position]);
        return convertView;
    }
}
