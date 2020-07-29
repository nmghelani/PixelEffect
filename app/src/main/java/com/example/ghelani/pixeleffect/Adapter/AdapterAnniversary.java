package com.example.ghelani.pixeleffect.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ghelani.pixeleffect.Emoji_Activity;
import com.example.ghelani.pixeleffect.R;

public class AdapterAnniversary extends BaseAdapter{
    private final Emoji_Activity activity;
    private final LayoutInflater inflater;
    private ImageView sticker;
    int[] stickersAnn=new int[]{R.drawable.l7,R.drawable.l8,R.drawable.l9,R.drawable.l10,R.drawable.l11,R.drawable.l12,R.drawable.l13,R.drawable.l14,R.drawable.l15,R.drawable.l16,R.drawable.l17,R.drawable.l18,R.drawable.l9,R.drawable.l20,R.drawable.l21,R.drawable.l22,R.drawable.l23,R.drawable.l24,R.drawable.l25,R.drawable.l26,R.drawable.l27,R.drawable.l28,R.drawable.l35,R.drawable.l36,R.drawable.l37,R.drawable.l38,R.drawable.l39,R.drawable.l40,R.drawable.l42};

    public AdapterAnniversary(Emoji_Activity emoji_activity) {
        activity=emoji_activity;
        inflater= LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return stickersAnn.length;
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
        sticker.setImageResource(stickersAnn[position]);
        return convertView;
    }
}
