package com.example.ghelani.pixeleffect;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ghelani.pixeleffect.Adapter.Adapter3D;
import com.example.ghelani.pixeleffect.Adapter.AdapterEffect;
import com.example.ghelani.pixeleffect.Adapter.AdapterFilter;
import com.example.ghelani.pixeleffect.Adapter.AdapterGlare;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Edit_Activity extends AppCompatActivity implements AdapterFilter.OnItemClickListner{

    private ImageView CroppedImg;
    private ImageView back;
    private LinearLayout icon3D;
    private RecyclerView Recycle3D;
    public static ImageView effectimg;
    private Animation animation_down;
    private Animation animation_up;
    private LinearLayout LayoutEffect;
    private RecyclerView RecycleEffect;
    private RecyclerView RecycleGlare;
    public static ImageView Putglare;
    private LinearLayout LayoutGlare;
    private LinearLayout LayoutFilter;
    private RecyclerView RecycleFilter;
    private Effects effects;
    private LinearLayout LayoutRotate;
    private LinearLayout LayoutFlip;
    private LinearLayout LayoutColor;
    private LinearLayout LayoutText;
    private ImageView Text;
    private LinearLayout LayoutEmoji;
    static FrameLayout frameLayout;
    private ImageView save;
    public Bitmap FinalEditedImg;
    private FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_);

        CroppedImg = (ImageView) findViewById(R.id.CroppedImg);
        effectimg = (ImageView) findViewById(R.id.effectimg);
        back = (ImageView) findViewById(R.id.back);
        icon3D = (LinearLayout) findViewById(R.id.icon3D);
        Recycle3D = (RecyclerView) findViewById(R.id.Recycle3D);
        LayoutEffect = (LinearLayout) findViewById(R.id.LayoutEffect);
        RecycleEffect = (RecyclerView) findViewById(R.id.RecycleEffect);
        LayoutGlare = (LinearLayout) findViewById(R.id.LayoutGlare);
        RecycleGlare = (RecyclerView) findViewById(R.id.RecycleGlare);
        Putglare = (ImageView) findViewById(R.id.Putglare);
        LayoutFilter=(LinearLayout)findViewById(R.id.LayoutFilter);
        RecycleFilter=(RecyclerView)findViewById(R.id.RecycleFilter);
        LayoutRotate=(LinearLayout)findViewById(R.id.LayoutRotate);
        LayoutFlip=(LinearLayout)findViewById(R.id.LayoutFlip);
        LayoutColor=(LinearLayout)findViewById(R.id.LayoutColor);
        LayoutText=(LinearLayout)findViewById(R.id.LayoutText);
        LayoutEmoji=(LinearLayout)findViewById(R.id.LayoutEmoji);
        frameLayout=(FrameLayout)findViewById(R.id.frameLayout);
        save=(ImageView)findViewById(R.id.save);

        MobileAds.initialize(this,getString(R.string.app_id));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Edit_Activity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //setting up main image
        CroppedImg.setImageBitmap(MainActivity.bitmap);
        //CroppedImg.setScaleType(ImageView.ScaleType.FIT_XY);

        AdView adView=(AdView)findViewById(R.id.adView2);
        AdRequest adRequest= new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //adapter for 3D
        Adapter3D adapter3D = new Adapter3D(Edit_Activity.this);
        RecyclerView.LayoutManager layoutManager3D = new LinearLayoutManager(Edit_Activity.this, LinearLayoutManager.HORIZONTAL, false);
        Recycle3D.setLayoutManager(layoutManager3D);
        Recycle3D.setAdapter(adapter3D);

        //Adapter for effect
        AdapterEffect adapterEffect = new AdapterEffect(Edit_Activity.this);
        RecyclerView.LayoutManager layoutManagerEffect = new LinearLayoutManager(Edit_Activity.this, LinearLayoutManager.HORIZONTAL, false);
        RecycleEffect.setLayoutManager(layoutManagerEffect);
        RecycleEffect.setAdapter(adapterEffect);

        //Adapter for glare
        AdapterGlare adapterGlare = new AdapterGlare(Edit_Activity.this);
        RecyclerView.LayoutManager layoutManagerglare = new LinearLayoutManager(Edit_Activity.this, LinearLayoutManager.HORIZONTAL, false);
        RecycleGlare.setLayoutManager(layoutManagerglare);
        RecycleGlare.setAdapter(adapterGlare);

        //Adapter for filter
        AdapterFilter adapterFilter=new AdapterFilter(Edit_Activity.this,this);
        RecyclerView.LayoutManager layoutManagerFilter=new LinearLayoutManager(Edit_Activity.this,LinearLayoutManager.HORIZONTAL,false);
        RecycleFilter.setLayoutManager(layoutManagerFilter);
        RecycleFilter.setAdapter(adapterFilter);

        //3D onclick
        icon3D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation_up = AnimationUtils.loadAnimation(Edit_Activity.this, R.anim.slide_up);
                animation_down = AnimationUtils.loadAnimation(Edit_Activity.this, R.anim.slide_down);
                RecycleEffect.setVisibility(View.GONE);
                RecycleGlare.setVisibility(View.GONE);
                RecycleFilter.setVisibility(View.GONE);
                if (Recycle3D.getVisibility() == View.GONE) {
                    Recycle3D.setVisibility(View.VISIBLE);
                    Recycle3D.setAnimation(animation_up);
                } else {
                    Recycle3D.setVisibility(View.GONE);
                    Recycle3D.setAnimation(animation_down);
                }
            }
        });

        //effect on click
        LayoutEffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation_up = AnimationUtils.loadAnimation(Edit_Activity.this, R.anim.slide_up);
                animation_down = AnimationUtils.loadAnimation(Edit_Activity.this, R.anim.slide_down);
                RecycleGlare.setVisibility(View.GONE);
                Recycle3D.setVisibility(View.GONE);
                RecycleFilter.setVisibility(View.GONE);
                if (RecycleEffect.getVisibility() == View.GONE) {
                    RecycleEffect.setVisibility(View.VISIBLE);
                    RecycleEffect.setAnimation(animation_up);
                } else {
                    RecycleEffect.setVisibility(View.GONE);
                    RecycleEffect.setAnimation(animation_down);
                }
            }
        });

        //glare onclick
        LayoutGlare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation_up = AnimationUtils.loadAnimation(Edit_Activity.this, R.anim.slide_up);
                animation_down = AnimationUtils.loadAnimation(Edit_Activity.this, R.anim.slide_down);
                RecycleEffect.setVisibility(View.GONE);
                Recycle3D.setVisibility(View.GONE);
                RecycleFilter.setVisibility(View.GONE);
                if (RecycleGlare.getVisibility() == View.GONE) {
                    RecycleGlare.setVisibility(View.VISIBLE);
                    RecycleGlare.setAnimation(animation_up);
                } else {
                    RecycleGlare.setVisibility(View.GONE);
                    RecycleGlare.setAnimation(animation_down);
                }
            }
        });

        //filter onclick
        LayoutFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation_up = AnimationUtils.loadAnimation(Edit_Activity.this, R.anim.slide_up);
                animation_down = AnimationUtils.loadAnimation(Edit_Activity.this, R.anim.slide_down);
                RecycleEffect.setVisibility(View.GONE);
                Recycle3D.setVisibility(View.GONE);
                RecycleGlare.setVisibility(View.GONE);
                if(RecycleFilter.getVisibility()==View.GONE){
                    RecycleFilter.setVisibility(View.VISIBLE);
                    RecycleFilter.setAnimation(animation_up);
                }
                else {
                    RecycleFilter.setVisibility(View.GONE);
                    RecycleFilter.setAnimation(animation_down);
                }
            }
        });

        //rotate onclick
        LayoutRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CroppedImg.setRotation(CroppedImg.getRotation()+90);
            }
        });

        //Flip onclick
        LayoutFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CroppedImg.setRotationY(CroppedImg.getRotationY()+180);
            }
        });

        //color onclick
        LayoutColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPick();
            }
        });

        //text click
        LayoutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Edit_Activity.this,Text_Activity.class);
                startActivity(i);
            }
        });

        LayoutEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Edit_Activity.this,Emoji_Activity.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create_save_image();
            }
        });
    }

    public void create_save_image(){
        FinalEditedImg = getMainFrameBitmap(frameLayout);
        saveImage(FinalEditedImg);
        Toast.makeText(this, "Image saved", Toast.LENGTH_SHORT).show();
    }

    private void saveImage(Bitmap finalEditedImg) {
        Bitmap bitmap;
        OutputStream outputStream;

        bitmap = finalEditedImg;
        File filepath = Environment.getExternalStorageDirectory();
        File dir = new File(filepath.getAbsolutePath()+"/PixelEffect");
        dir.mkdir();
        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String FileName = ts + ".jpg";
        File file = new File(dir,FileName);
        file.renameTo(file);
        String _uri = "file://" + filepath.getAbsolutePath() + "/" + "PixelEffect" + "/" + FileName;
        String _uri2 = filepath.getAbsolutePath() + "/" + "PixelEffect" + "/" + FileName;
        _uri = _uri2;
        MediaScannerConnection.scanFile(Edit_Activity.this, new String[]{_uri}, null, new MediaScannerConnection.OnScanCompletedListener() {
            @Override
            public void onScanCompleted(String path, Uri uri) {
                Log.i("ExternalStorage", "Scanned " + path + ":");
                Log.i("ExternalStorage", "-> uri=" + uri);
            }
        });
        try {
            outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap getMainFrameBitmap(View view){
        Emoji_Activity.mStickerView.setInEdit(false);
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),view.getHeight(), Bitmap.Config.ARGB_8888 );
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    private void ColorPick() {
        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose Color")
                .initialColor(Color.WHITE)
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int i) {

                    }
                })
                .setPositiveButton("OK", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, Integer[] integers) {
                        effectimg.setColorFilter(i);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .build().show();
    }

    @Override
    public void OnclickListner(int position) {
        switch (position) {
            case 0:
                effects.applyEffectNone(CroppedImg);
                break;
            case 1:
                effects.applyEffect1(CroppedImg);
                break;
            case 2:
                effects.applyEffect2(CroppedImg);
                break;
            case 3:
                effects.applyEffect3(CroppedImg);
                break;
            case 4:
                effects.applyEffect4(CroppedImg);
                break;
            case 5:
                effects.applyEffect5(CroppedImg);
                break;
            case 6:
                effects.applyEffect6(CroppedImg);
                break;
            case 7:
                effects.applyEffect7(CroppedImg);
                break;
            case 8:
                effects.applyEffect8(CroppedImg);
                break;
            case 9:
                effects.applyEffect9(CroppedImg);
                break;
            case 10:
                effects.applyEffect10(CroppedImg);
                break;
            case 11:
                effects.applyEffect11(CroppedImg);
                break;
            case 12:
                effects.applyEffect12(CroppedImg);
                break;
            case 13:
                effects.applyEffect13(CroppedImg);
                break;
            case 14:
                effects.applyEffect14(CroppedImg);
                break;
            case 15:
                effects.applyEffect15(CroppedImg);
                break;
            case 16:
                effects.applyEffect16(CroppedImg);
                break;
            case 17:
                effects.applyEffect17(CroppedImg);
                break;
            case 18:
                effects.applyEffect18(CroppedImg);
                break;
            case 19:
                effects.applyEffect19(CroppedImg);
                break;
            case 20:
                effects.applyEffect20(CroppedImg);
                break;
            case 21:
                effects.applyEffect21(CroppedImg);
                break;
            case 22:
                effects.applyEffect22(CroppedImg);
                break;
        }
    }
}
