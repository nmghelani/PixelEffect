package com.example.ghelani.pixeleffect.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ghelani.pixeleffect.Emoji_Activity;
import com.example.ghelani.pixeleffect.R;

import static android.content.ContentValues.TAG;

public class AdapterEmoji extends BaseAdapter{
    private final Emoji_Activity activity;
    private final LayoutInflater inflater;
    private ImageView sticker;
    int[] stickersEmoji= new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a12,R.drawable.a14,R.drawable.a15,R.drawable.a16,R.drawable.a17,R.drawable.a18,R.drawable.a19,R.drawable.a20,R.drawable.a21,R.drawable.a22,R.drawable.a24,R.drawable.a25,R.drawable.a26,R.drawable.a28,R.drawable.a29,R.drawable.a30,R.drawable.a32,R.drawable.a34};

    public AdapterEmoji(Emoji_Activity emoji_activity) {
        Log.e(TAG, "AdapterEmoji: constructor" );
        activity=emoji_activity;
        inflater= LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        Log.e(TAG, "AdapterEmoji: getcount" );
        return stickersEmoji.length;
    }

    @Override
    public Object getItem(int position) {
        Log.e(TAG, "AdapterEmoji: getItem" );
        return position;
    }

    @Override
    public long getItemId(int position) {
        Log.e(TAG, "AdapterEmoji: getItemID" );
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e(TAG, "AdapterEmoji: Getview" );
        convertView=inflater.inflate(R.layout.sticker,parent,false);
        sticker=(ImageView)convertView.findViewById(R.id.sticker);
        sticker.setImageResource(stickersEmoji[position]);
        return convertView;
    }
}
