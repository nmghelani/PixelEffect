package com.example.ghelani.pixeleffect.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ghelani.pixeleffect.Edit_Activity;
import com.example.ghelani.pixeleffect.MainActivity;
import com.example.ghelani.pixeleffect.R;

import static android.content.ContentValues.TAG;

public class Adapter3D extends RecyclerView.Adapter<Adapter3D.viewholder>{


    private Edit_Activity activity;
    LayoutInflater inflater;
    int[] img3D=new int[]{R.drawable.bg_3d_1_black,R.drawable.bg_3d_3_black,R.drawable.bg_3d_4_black,R.drawable.bg_3d_5_black,R.drawable.bg_3d_6_black};

    public Adapter3D(Edit_Activity edit_activity) {

        activity=edit_activity;
        inflater=LayoutInflater.from(edit_activity);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder: " );
        View view=inflater.inflate(R.layout.image3d,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position) {
        Log.e(TAG, "onBindViewHolder: " );
        holder.vector3D.setImageResource(img3D[position]);
        holder.mainimg.setImageBitmap(MainActivity.bitmap);
        holder.mainimg.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.vector3D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_Activity.effectimg.setImageResource(img3D[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: " );
        return img3D.length;
    }

    public class viewholder extends RecyclerView.ViewHolder{

        private final ImageView mainimg;
        private final ImageView vector3D;

        public viewholder(View itemView) {
            super(itemView);
            vector3D=(ImageView)itemView.findViewById(R.id.vector3D);
            mainimg=(ImageView)itemView.findViewById(R.id.mainimg3D);
        }
    }
}
