package com.example.ghelani.pixeleffect.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ghelani.pixeleffect.Emoji_Activity;
import com.example.ghelani.pixeleffect.R;

public class AdapterMonster extends BaseAdapter{
    private final Emoji_Activity activity;
    private final LayoutInflater inflater;
    private ImageView sticker;
    int[] stickersMon=new int[]{R.drawable.monster_01,R.drawable.monster_02,R.drawable.monster_03,R.drawable.monster_04,R.drawable.monster_05,R.drawable.monster_06,R.drawable.monster_07,R.drawable.monster_08,R.drawable.monster_09,R.drawable.monster_10,R.drawable.monster_11,R.drawable.monster_12,R.drawable.monster_13,R.drawable.monster_14,R.drawable.monster_15,R.drawable.monster_16,R.drawable.monster_17,R.drawable.monster_18,R.drawable.monster_19,R.drawable.monster_20,R.drawable.monster_21,R.drawable.monster_22,R.drawable.monster_23,R.drawable.monster_24,R.drawable.monster_25};

    public AdapterMonster(Emoji_Activity emoji_activity) {
        activity=emoji_activity;
        inflater= LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return stickersMon.length;
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
        sticker.setImageResource(stickersMon[position]);
        return convertView;
    }
}
