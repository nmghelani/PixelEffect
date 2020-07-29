package com.example.ghelani.pixeleffect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.theartofdev.edmodo.cropper.CropImageView;


public class ImgEdit_Activity extends AppCompatActivity {

    private CropImageView CropImage;
    private ImageView tick;
    private ImageView delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_edit);

        CropImage=(CropImageView)findViewById(R.id.CropImage);
        CropImage.setImageBitmap(MainActivity.bitmap);
        tick=(ImageView)findViewById(R.id.tick);
        delete=(ImageView)findViewById(R.id.delete);

        CropImage.setAspectRatio(4,3);
        CropImage.setFixedAspectRatio(true);
//        CropImage.setMinCropResultSize(CropImage.getWidth(),CropImage.getHeight());
//        CropImage.setMaxCropResultSize(CropImage.getWidth(),CropImage.getHeight());

        tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.bitmap=CropImage.getCroppedImage();
                Intent i=new Intent(ImgEdit_Activity.this,Edit_Activity.class);
                startActivity(i);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}