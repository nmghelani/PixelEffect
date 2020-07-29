package com.example.ghelani.pixeleffect.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ghelani.pixeleffect.Edit_Activity;
import com.example.ghelani.pixeleffect.R;

public class AdapterGlare extends RecyclerView.Adapter<AdapterGlare.viewholder>{

    private final Edit_Activity activity;
    LayoutInflater inflater;
    int[] imgglare=new int[]{R.drawable.flare_01,R.drawable.flare_02,R.drawable.flare_03,R.drawable.flare_04,R.drawable.flare_05,R.drawable.flare_06};

    public AdapterGlare(Edit_Activity edit_activity) {
        activity=edit_activity;
        inflater=LayoutInflater.from(edit_activity);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.image_glare,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position) {

        holder.ImgGlare.setImageResource(imgglare[position]);
        holder.ImgGlare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_Activity.Putglare.setImageResource(imgglare[position]); }
        });
    }

    @Override
    public int getItemCount() {
        return imgglare.length;
    }

    public class viewholder extends RecyclerView.ViewHolder{
        private final ImageView ImgGlare;

        public viewholder(View itemView) {
            super(itemView);
            ImgGlare=(ImageView)itemView.findViewById(R.id.ImgGlare);
        }
    }
}
