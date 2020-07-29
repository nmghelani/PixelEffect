package com.example.ghelani.pixeleffect.Adapter;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ghelani.pixeleffect.R;
import com.example.ghelani.pixeleffect.Text_Activity;

public class AdapterStyle extends RecyclerView.Adapter<AdapterStyle.viewholder> {
    private Text_Activity activity;
    LayoutInflater inflater;

    public AdapterStyle(Text_Activity text_activity) {
        activity = text_activity;
        inflater = LayoutInflater.from(text_activity);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_textstyle, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder holder, final int position) {
        holder.textStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        Typeface typeface0 = Typeface.createFromAsset(activity.getAssets(), "font1.ttf");
                        activity.textTV.setTypeface(typeface0);
                        break;
                    case 1:
                        Typeface typeface1 = Typeface.createFromAsset(activity.getAssets(), "font2.ttf");
                        activity.textTV.setTypeface(typeface1);
                        break;
                    case 2:
                        Typeface typeface2 = Typeface.createFromAsset(activity.getAssets(), "font3.ttf");
                        activity.textTV.setTypeface(typeface2);
                        break;
                    case 3:
                        Typeface typeface3 = Typeface.createFromAsset(activity.getAssets(), "font4.TTF");
                        activity.textTV.setTypeface(typeface3);
                        break;
                    case 4:
                        Typeface typeface4 = Typeface.createFromAsset(activity.getAssets(), "font5.ttf");
                        activity.textTV.setTypeface(typeface4);
                        break;
                    case 5:
                        Typeface typeface5 = Typeface.createFromAsset(activity.getAssets(), "font6.TTF");
                        activity.textTV.setTypeface(typeface5);
                        break;
                    case 6:
                        Typeface typeface6 = Typeface.createFromAsset(activity.getAssets(), "font7.ttf");
                        activity.textTV.setTypeface(typeface6);
                        break;
                    case 7:
                        Typeface typeface7 = Typeface.createFromAsset(activity.getAssets(), "font8.ttf");
                        activity.textTV.setTypeface(typeface7);
                        break;
                    case 8:
                        Typeface typeface8 = Typeface.createFromAsset(activity.getAssets(), "font9.ttf");
                        activity.textTV.setTypeface(typeface8);
                        break;
                    case 9:
                        Typeface typeface9 = Typeface.createFromAsset(activity.getAssets(), "font10.TTF");
                        activity.textTV.setTypeface(typeface9);
                        break;
                    case 10:
                        Typeface typeface10 = Typeface.createFromAsset(activity.getAssets(), "font11.ttf");
                        activity.textTV.setTypeface(typeface10);
                        break;
                    case 11:
                        Typeface typeface11 = Typeface.createFromAsset(activity.getAssets(), "font12.ttf");
                        activity.textTV.setTypeface(typeface11);
                        break;
                    case 12:
                        Typeface typeface14 = Typeface.createFromAsset(activity.getAssets(), "font14.TTF");
                        activity.textTV.setTypeface(typeface14);
                        break;
                    case 13:
                        Typeface typeface15 = Typeface.createFromAsset(activity.getAssets(), "font16.TTF");
                        activity.textTV.setTypeface(typeface15);
                        break;
                    case 14:
                        Typeface typeface16 = Typeface.createFromAsset(activity.getAssets(), "font17.ttf");
                        activity.textTV.setTypeface(typeface16);
                        break;
                    case 15:
                        Typeface typeface17 = Typeface.createFromAsset(activity.getAssets(), "font18.ttf");
                        activity.textTV.setTypeface(typeface17);
                        break;
                    case 16:
                        Typeface typeface18 = Typeface.createFromAsset(activity.getAssets(), "font19.ttf");
                        activity.textTV.setTypeface(typeface18);
                        break;
                    case 17:
                        Typeface typeface19 = Typeface.createFromAsset(activity.getAssets(), "font20.ttf");
                        activity.textTV.setTypeface(typeface19);
                        break;
                    case 18:
                        Typeface typeface20 = Typeface.createFromAsset(activity.getAssets(), "font21.ttf");
                        activity.textTV.setTypeface(typeface20);
                        break;
                }
            }
        });
        switch (position) {
            case 0:
                Typeface typeface0 = Typeface.createFromAsset(activity.getAssets(), "font1.ttf");
                holder.textStyle.setTypeface(typeface0);
                break;
            case 1:
                Typeface typeface1 = Typeface.createFromAsset(activity.getAssets(), "font2.ttf");
                holder.textStyle.setTypeface(typeface1);
                break;
            case 2:
                Typeface typeface2 = Typeface.createFromAsset(activity.getAssets(), "font3.ttf");
                holder.textStyle.setTypeface(typeface2);
                break;
            case 3:
                Typeface typeface3 = Typeface.createFromAsset(activity.getAssets(), "font4.TTF");
                holder.textStyle.setTypeface(typeface3);
                break;
            case 4:
                Typeface typeface4 = Typeface.createFromAsset(activity.getAssets(), "font5.ttf");
                holder.textStyle.setTypeface(typeface4);
                break;
            case 5:
                Typeface typeface5 = Typeface.createFromAsset(activity.getAssets(), "font6.TTF");
                holder.textStyle.setTypeface(typeface5);
                break;
            case 6:
                Typeface typeface6 = Typeface.createFromAsset(activity.getAssets(), "font7.ttf");
                holder.textStyle.setTypeface(typeface6);
                break;
            case 7:
                Typeface typeface7 = Typeface.createFromAsset(activity.getAssets(), "font8.ttf");
                holder.textStyle.setTypeface(typeface7);
                break;
            case 8:
                Typeface typeface8 = Typeface.createFromAsset(activity.getAssets(), "font9.ttf");
                holder.textStyle.setTypeface(typeface8);
                break;
            case 9:
                Typeface typeface9 = Typeface.createFromAsset(activity.getAssets(), "font10.TTF");
                holder.textStyle.setTypeface(typeface9);
                break;
            case 10:
                Typeface typeface10 = Typeface.createFromAsset(activity.getAssets(), "font11.ttf");
                holder.textStyle.setTypeface(typeface10);
                break;
            case 11:
                Typeface typeface11 = Typeface.createFromAsset(activity.getAssets(), "font12.ttf");
                holder.textStyle.setTypeface(typeface11);
                break;
            case 12:
                Typeface typeface14 = Typeface.createFromAsset(activity.getAssets(), "font14.TTF");
                holder.textStyle.setTypeface(typeface14);
                break;
            case 13:
                Typeface typeface15 = Typeface.createFromAsset(activity.getAssets(), "font16.TTF");
                holder.textStyle.setTypeface(typeface15);
                break;
            case 14:
                Typeface typeface16 = Typeface.createFromAsset(activity.getAssets(), "font17.ttf");
                holder.textStyle.setTypeface(typeface16);
                break;
            case 15:
                Typeface typeface17 = Typeface.createFromAsset(activity.getAssets(), "font18.ttf");
                holder.textStyle.setTypeface(typeface17);
                break;
            case 16:
                Typeface typeface18 = Typeface.createFromAsset(activity.getAssets(), "font19.ttf");
                holder.textStyle.setTypeface(typeface18);
                break;
            case 17:
                Typeface typeface19 = Typeface.createFromAsset(activity.getAssets(), "font20.ttf");
                holder.textStyle.setTypeface(typeface19);
                break;
            case 18:
                Typeface typeface20 = Typeface.createFromAsset(activity.getAssets(), "font21.ttf");
                holder.textStyle.setTypeface(typeface20);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 19;
    }

    public class viewholder extends RecyclerView.ViewHolder {
        private final TextView textStyle;

        public viewholder(View itemView) {
            super(itemView);
            textStyle = (TextView) itemView.findViewById(R.id.textStyle);
        }
    }
}
