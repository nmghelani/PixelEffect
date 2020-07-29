package com.example.ghelani.pixeleffect.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ghelani.pixeleffect.R;
import com.example.ghelani.pixeleffect.Text_Activity;

import static com.example.ghelani.pixeleffect.Text_Activity.textTV;

public class AdapterPattern extends RecyclerView.Adapter<AdapterPattern.viewholder>{
    private final Text_Activity activity;
    LayoutInflater inflater;
    int[] pattern=new int[]{R.mipmap.ic_panel_none,R.mipmap.thumb_pattern_01,R.mipmap.thumb_pattern_02,R.mipmap.thumb_pattern_03,R.mipmap.thumb_pattern_04,R.mipmap.thumb_pattern_05,R.mipmap.thumb_pattern_06,R.mipmap.thumb_pattern_07,R.mipmap.thumb_pattern_08,R.mipmap.thumb_pattern_09,R.mipmap.thumb_pattern_10};

    public AdapterPattern(Text_Activity text_activity) {
        activity=text_activity;
        inflater=LayoutInflater.from(activity);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.pattern,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position) {
        holder.patternthumb.setImageResource(pattern[position]);
        holder.patternthumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                activity.setPattern(position);
                if(position==0){
                    Bitmap b1 = BitmapFactory.decodeResource(activity.getResources(),R.drawable.blank);
                    Shader s1= new BitmapShader(b1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    textTV.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
                    activity.textTV.getPaint().setShader(s1);
                }else {
                    Bitmap b1 = BitmapFactory.decodeResource(activity.getResources(), pattern[position]);
                    Shader s1 = new BitmapShader(b1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    activity.textTV.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                    activity.textTV.getPaint().setShader(s1);
                }
            }
        });
        /*holder.patternthumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Bitmap bitmap0= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.ic_panel_none);
                        Shader shader0= new BitmapShader(bitmap0, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        activity.textTV.getPaint().setShader(shader0);
                    case 1:
                        Bitmap bitmap1= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.thumb_pattern_01);
                        Shader shader1= new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        activity.textTV.getPaint().setShader(shader1);
                    case 2:
                        Bitmap bitmap2= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.thumb_pattern_02);
                        Shader shader2= new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        activity.textTV.getPaint().setShader(shader2);
                    case 3:
                        Bitmap bitmap3= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.thumb_pattern_03);
                        Shader shader3= new BitmapShader(bitmap3, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        activity.textTV.getPaint().setShader(shader3);
                    case 4:
                        Bitmap bitmap4= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.thumb_pattern_04);
                        Shader shader4= new BitmapShader(bitmap4, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        activity.textTV.getPaint().setShader(shader4);
                    case 5:
                        Bitmap bitmap5= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.thumb_pattern_05);
                        Shader shader5= new BitmapShader(bitmap5, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        activity.textTV.getPaint().setShader(shader5);
                    case 6:
                        Bitmap bitmap6= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.thumb_pattern_06);
                        Shader shader6= new BitmapShader(bitmap6, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        activity.textTV.getPaint().setShader(shader6);
                    case 7:
                        Bitmap bitmap7= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.thumb_pattern_07);
                        Shader shader7= new BitmapShader(bitmap7, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        activity.textTV.getPaint().setShader(shader7);
                    case 8:
                        Bitmap bitmap8= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.thumb_pattern_08);
                        Shader shader8= new BitmapShader(bitmap8, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        activity.textTV.getPaint().setShader(shader8);
                    case 9:
                        Bitmap bitmap9= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.thumb_pattern_09);
                        Shader shader9= new BitmapShader(bitmap9, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        activity.textTV.getPaint().setShader(shader9);
                    case 10:
                        Bitmap bitmap10= BitmapFactory.decodeResource(activity.getResources(),R.mipmap.thumb_pattern_10);
                        Shader shader10= new BitmapShader(bitmap10, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        activity.textTV.getPaint().setShader(shader10);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return pattern.length;
    }

    public class viewholder extends RecyclerView.ViewHolder{

        private final ImageView patternthumb;

        public viewholder(View itemView) {
            super(itemView);
            patternthumb=(ImageView)itemView.findViewById(R.id.patternthumb);

        }
    }
}
