package com.example.ghelani.pixeleffect;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ghelani.pixeleffect.Adapter.AdapterPattern;
import com.example.ghelani.pixeleffect.Adapter.AdapterStyle;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import de.hdodenhof.circleimageview.CircleImageView;

public class Text_Activity extends AppCompatActivity {

    private LinearLayout LayoutAddText;
    private CircleImageView tickmark;
    public static TextView textTV;
    private EditText textET;
    private LinearLayout mainEditing;
    private LinearLayout LayoutDelete;
    private LinearLayout SeekbarSize;
    private SeekBar seekbar;
    private LinearLayout LayoutSize;
    private TextView SizeDone;
    private RecyclerView GridStyle;
    private LinearLayout LayoutStyle;
    private ImageView PatternImg;
    private LinearLayout RecyclerStyle;
    private RecyclerView GridPattern;
    private LinearLayout RecyclerPattern;
    private LinearLayout LayoutPattern;
    private TextView StyleDone;
    private TextView PatternDone;
    private TextView BlurDone;
    private LinearLayout LayoutBlur;
    private LinearLayout BlurPanel;
    private RadioGroup blurgroup;
    private float defaultsize;
    private int colour;
    private Typeface textstyle;
    private ImageView backtext;
    private Shader textPattern;
    int[] pattern=new int[]{R.mipmap.ic_panel_none,R.mipmap.thumb_pattern_01,R.mipmap.thumb_pattern_02,R.mipmap.thumb_pattern_03,R.mipmap.thumb_pattern_04,R.mipmap.thumb_pattern_05,R.mipmap.thumb_pattern_06,R.mipmap.thumb_pattern_07,R.mipmap.thumb_pattern_08,R.mipmap.thumb_pattern_09,R.mipmap.thumb_pattern_10};
    private float size;
    private LinearLayout LayoutColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        LayoutAddText = (LinearLayout) findViewById(R.id.LayoutAddText);
        tickmark = (CircleImageView) findViewById(R.id.tickmark);
        textTV = (TextView) findViewById(R.id.textTV);
        textET = (EditText) findViewById(R.id.textET);
        mainEditing = (LinearLayout) findViewById(R.id.mainEditing);
        LayoutDelete = (LinearLayout) findViewById(R.id.LayoutDelete);
        SeekbarSize = (LinearLayout) findViewById(R.id.seekbarSize);
        SizeDone = (TextView) findViewById(R.id.SizeDone);
        StyleDone=(TextView)findViewById(R.id.StyleDone);
        PatternDone=(TextView)findViewById(R.id.PatternDone);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        LayoutSize = (LinearLayout) findViewById(R.id.LayoutSize);
        LayoutStyle = (LinearLayout) findViewById(R.id.LayoutStyle);
        GridStyle=(RecyclerView)findViewById(R.id.GridStyle);
        PatternImg=(ImageView)findViewById(R.id.PatternImg);
        RecyclerStyle=(LinearLayout)findViewById(R.id.RecyclerStyle);
        GridPattern=(RecyclerView)findViewById(R.id.GridPattern);
        RecyclerPattern=(LinearLayout)findViewById(R.id.RecyclerPattern);
        LayoutPattern=(LinearLayout)findViewById(R.id.LayoutPattern);
        LayoutBlur=(LinearLayout)findViewById(R.id.LayoutBlur);
        BlurPanel=(LinearLayout)findViewById(R.id.BlurPanel);
        BlurDone=(TextView)findViewById(R.id.BlurDone);
        blurgroup=(RadioGroup)findViewById(R.id.blurgroup);
        backtext=(ImageView)findViewById(R.id.backtext);
        LayoutColour=(LinearLayout)findViewById(R.id.LayoutColour);

        backtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tickmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutAddText.setVisibility(View.GONE);
                textTV.setText(textET.getText().toString());
                textTV.setVisibility(View.VISIBLE);
                mainEditing.setVisibility(View.VISIBLE);
                defaultsize=textTV.getTextSize();
                colour=textTV.getCurrentTextColor();
                textstyle=textTV.getTypeface();
                textPattern=textTV.getPaint().getShader();
                size=textTV.getTextSize();
                textTV.setTextSize(40);
            }
        });

        LayoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textTV.setVisibility(View.GONE);
                LayoutAddText.setVisibility(View.VISIBLE);
                textET.setText("");
                textTV.setTextSize(defaultsize);
                textTV.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
                textTV.getPaint().setMaskFilter(null);
                textTV.setTextColor(colour);
                //Typeface typeface=Typeface.createFromAsset(getAssets(),"avenirl_roman.otf");
                textTV.setTypeface(textstyle);
                textTV.getPaint().setShader(textPattern);
                SeekbarSize.setVisibility(View.GONE);
                BlurPanel.setVisibility(View.GONE);
                RecyclerStyle.setVisibility(View.GONE);
                RecyclerPattern.setVisibility(View.GONE);
                mainEditing.setVisibility(View.GONE);
                textTV.setTextSize(size);
            }
        });

        LayoutSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerStyle.setVisibility(View.GONE);
                RecyclerPattern.setVisibility(View.GONE);
                BlurPanel.setVisibility(View.GONE);
                if (SeekbarSize.getVisibility() == View.GONE) {
                    SeekbarSize.setVisibility(View.VISIBLE);
                } else {
                    SeekbarSize.setVisibility(View.GONE);
                }
                seekbar.setProgress(40);
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("12345", "onProgressChanged: "+progress );

                textTV.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SizeDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeekbarSize.setVisibility(View.GONE);
            }
        });

        LayoutStyle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SeekbarSize.setVisibility(View.GONE);
                RecyclerPattern.setVisibility(View.GONE);
                BlurPanel.setVisibility(View.GONE);
                AdapterStyle style = new AdapterStyle(Text_Activity.this);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Text_Activity.this,3);
                GridStyle.setAdapter(style);
                GridStyle.setLayoutManager(layoutManager);
                if(RecyclerStyle.getVisibility()==View.GONE){
                    RecyclerStyle.setVisibility(View.VISIBLE);
                }
                else{
                    RecyclerStyle.setVisibility(View.GONE);
                }
            }
        });

        StyleDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerStyle.setVisibility(View.GONE);
            }
        });

        LayoutPattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeekbarSize.setVisibility(View.GONE);
                RecyclerStyle.setVisibility(View.GONE);
                BlurPanel.setVisibility(View.GONE);
                AdapterPattern adapterPattern=new AdapterPattern(Text_Activity.this);
                GridPattern.setAdapter(adapterPattern);
                RecyclerView.LayoutManager manager=new GridLayoutManager(Text_Activity.this,3);
                GridPattern.setLayoutManager(manager);
                if(RecyclerPattern.getVisibility()==View.GONE){
                    RecyclerPattern.setVisibility(View.VISIBLE);
                }
                else{
                    RecyclerPattern.setVisibility(View.GONE);
                }
            }
        });

        PatternDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerPattern.setVisibility(View.GONE);
            }
        });

        LayoutBlur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeekbarSize.setVisibility(View.GONE);
                RecyclerStyle.setVisibility(View.GONE);
                RecyclerPattern.setVisibility(View.GONE);
                if(BlurPanel.getVisibility()==View.GONE){
                    BlurPanel.setVisibility(View.VISIBLE);
                }
                else{
                    BlurPanel.setVisibility(View.GONE);
                }
            }
        });

        LayoutColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPickerDialogBuilder
                        .with(Text_Activity.this)
                        .setTitle("Choose color")
                        .initialColor(Color.WHITE)
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(12)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int i) {
                            }
                        })
                        .setPositiveButton("Ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, Integer[] integers) {
                                textTV.setTextColor(i);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .build().show();
            }
        });

        blurgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                float radius=textTV.getTextSize()/10;
                if(checkedId==R.id.noblur){
                    textTV.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
                    textTV.getPaint().setMaskFilter(null);
                }
                else if(checkedId==R.id.innerblur){
                    textTV.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
                    BlurMaskFilter filter=new BlurMaskFilter(radius, BlurMaskFilter.Blur.INNER);
                    textTV.getPaint().setMaskFilter(filter);
                }
                else if(checkedId==R.id.normalblur){
                    textTV.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
                    BlurMaskFilter filter=new BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL);
                    textTV.getPaint().setMaskFilter(filter);
                }
                else if (checkedId==R.id.outerblur){
                    textTV.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
                    BlurMaskFilter filter=new BlurMaskFilter(radius, BlurMaskFilter.Blur.OUTER);
                    textTV.getPaint().setMaskFilter(filter);
                }
                else if (checkedId==R.id.solidblur){
                    textTV.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
                    BlurMaskFilter filter=new BlurMaskFilter(radius, BlurMaskFilter.Blur.SOLID);
                    textTV.getPaint().setMaskFilter(filter);
                }
            }
        });

        BlurDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlurPanel.setVisibility(View.GONE);
            }
        });
    }
    public void setPattern(int i){
        Log.e("12", "setPattern: "+i );
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),pattern[2]);
        Shader shader=new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        textTV.getPaint().setShader(shader);
    }


}