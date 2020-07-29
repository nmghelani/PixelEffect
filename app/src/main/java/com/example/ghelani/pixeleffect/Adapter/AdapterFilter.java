package com.example.ghelani.pixeleffect.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ghelani.pixeleffect.Edit_Activity;
import com.example.ghelani.pixeleffect.Effects;
import com.example.ghelani.pixeleffect.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterFilter extends RecyclerView.Adapter<AdapterFilter.viewholder> {

    private final Edit_Activity activity;
    private final OnItemClickListner listner;
    LayoutInflater inflater;
    private Effects effects;

    public AdapterFilter(Edit_Activity edit_activity,OnItemClickListner listner) {
        activity = edit_activity;
        this.listner=listner;
        inflater = LayoutInflater.from(edit_activity);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.image_filter, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder holder, final int position) {

        switch (position) {
            case 0:
                effects.applyEffectNone(holder.sunflower);
                break;
            case 1:
                effects.applyEffect1(holder.sunflower);
                break;
            case 2:
                effects.applyEffect2(holder.sunflower);
                break;
            case 3:
                effects.applyEffect3(holder.sunflower);
                break;
            case 4:
                effects.applyEffect4(holder.sunflower);
                break;
            case 5:
                effects.applyEffect5(holder.sunflower);
                break;
            case 6:
                effects.applyEffect6(holder.sunflower);
                break;
            case 7:
                effects.applyEffect7(holder.sunflower);
                break;
            case 8:
                effects.applyEffect8(holder.sunflower);
                break;
            case 9:
                effects.applyEffect9(holder.sunflower);
                break;
            case 10:
                effects.applyEffect10(holder.sunflower);
                break;
            case 11:
                effects.applyEffect11(holder.sunflower);
                break;
            case 12:
                effects.applyEffect12(holder.sunflower);
                break;
            case 13:
                effects.applyEffect13(holder.sunflower);
                break;
            case 14:
                effects.applyEffect14(holder.sunflower);
                break;
            case 15:
                effects.applyEffect15(holder.sunflower);
                break;
            case 16:
                effects.applyEffect16(holder.sunflower);
                break;
            case 17:
                effects.applyEffect17(holder.sunflower);
                break;
            case 18:
                effects.applyEffect18(holder.sunflower);
                break;
            case 19:
                effects.applyEffect19(holder.sunflower);
                break;
            case 20:
                effects.applyEffect20(holder.sunflower);
                break;
            case 21:
                effects.applyEffect21(holder.sunflower);
                break;
            case 22:
                effects.applyEffect22(holder.sunflower);
                break;
        }
        holder.sunflower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.OnclickListner(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 23;
    }
    public interface OnItemClickListner{
        public void OnclickListner(int position);
    }

    public class viewholder extends RecyclerView.ViewHolder {
        private final CircleImageView sunflower;

        public viewholder(View itemView) {
            super(itemView);
            sunflower = (CircleImageView) itemView.findViewById(R.id.sunflower);
        }
    }
}
