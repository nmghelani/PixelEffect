package com.example.ghelani.pixeleffect.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ghelani.pixeleffect.Edit_Activity;
import com.example.ghelani.pixeleffect.MainActivity;
import com.example.ghelani.pixeleffect.R;

public class AdapterEffect extends RecyclerView.Adapter<AdapterEffect.viewholder>{


    private final Edit_Activity activity;
    LayoutInflater inflater;
    int[] imgEffect=new int[]{R.drawable.pixel_01,R.drawable.pixel_02,R.drawable.pixel_03,R.drawable.pixel_04,R.drawable.pixel_05,R.drawable.pixel_06,R.drawable.pixel_2,R.drawable.pixel_3,R.drawable.pixel_4,R.drawable.pixel_6,R.drawable.pixel_7,R.drawable.pixel_8,R.drawable.pixel_9,R.drawable.pixel_13,R.drawable.pixel_14,R.drawable.pixel_15,R.drawable.pixel_16,R.drawable.pixel_17,R.drawable.pixel_18,R.drawable.pixel_19,R.drawable.pixel_20,R.drawable.pixel_21,R.drawable.pixel_22,R.drawable.pixel_23,R.drawable.pixel_24,R.drawable.pixel_25,R.drawable.pixel_26,R.drawable.pixel_27,R.drawable.pixel_28,R.drawable.pixel_31,R.drawable.pixel_32,R.drawable.pixel_33,R.drawable.pixel_34,R.drawable.splash_01,R.drawable.splash_02,R.drawable.splash_03,R.drawable.splash_04,R.drawable.splash_05,R.drawable.pixel_mask_1,R.drawable.pixel_mask_2};

    public AdapterEffect(Edit_Activity edit_activity) {
        activity=edit_activity;
        inflater=LayoutInflater.from(edit_activity);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.image_effect,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position) {

        holder.MainImgEffect.setImageBitmap(MainActivity.bitmap);
        holder.MainImgEffect.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.ImgEffect.setImageResource(imgEffect[position]);

        holder.ImgEffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_Activity.effectimg.setImageResource(imgEffect[position]);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imgEffect.length;
    }

    public class viewholder extends RecyclerView.ViewHolder{
        private final ImageView MainImgEffect;
        private final ImageView ImgEffect;

        public viewholder(View itemView) {
            super(itemView);
                ImgEffect=(ImageView)itemView.findViewById(R.id.ImgEffect);
                MainImgEffect=(ImageView)itemView.findViewById(R.id.MainImgEffect);
        }
    }
}
