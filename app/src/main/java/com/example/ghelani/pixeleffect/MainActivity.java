package com.example.ghelani.pixeleffect;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private static final int THUMBNAIL_SIZE = 10;
    private CircleImageView start;
    private int GALLERY = 1;
    public static Bitmap bitmap;
    private ImageView img;
    private ImageView goneimg;
    private LinearLayout Layoutstart;
    private LinearLayout Layoutmore;
    private ImageView popup;
    private TextView user;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, getString(R.string.app_id));

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7238219494817625/6799315407");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        start = (CircleImageView) findViewById(R.id.start);
        goneimg = (ImageView) findViewById(R.id.goneimg);
        Layoutstart = (LinearLayout) findViewById(R.id.Layoutstart);
        Layoutmore = (LinearLayout) findViewById(R.id.Layoutmore);
        popup = (ImageView) findViewById(R.id.popup);
        user = (TextView) findViewById(R.id.user);

        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(MainActivity.this, popup);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    public LinearLayout Instagram;
                    public LinearLayout Facebook;
                    public LinearLayout whatsapp;

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();
                        switch (id){
                            case R.id.rate:
                                Intent intent_rate = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=" + getPackageName()));
                                startActivity(intent_rate);
                                break;
                            case R.id.feedback:
                                Intent intent_mail = new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:"+"nevilghelani99612@gmail.com"));
                                intent_mail.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
                                intent_mail.putExtra(Intent.EXTRA_TEXT,"Enter your feedback: ");
                                startActivity(intent_mail);
                                break;
                            case R.id.call:
                                Intent intent_call = new Intent(Intent.ACTION_DIAL);
                                intent_call.setData(Uri.parse("tel:7202998827"));
                                startActivity(intent_call);
                                break;
                            case R.id.share:
                                Intent intent_share = new Intent(Intent.ACTION_SEND);
                                intent_share.setType("text/plain");
                                intent_share.putExtra(Intent.EXTRA_SUBJECT,"Enter your subject here");
                                intent_share.putExtra(Intent.EXTRA_TEXT,"Enter your content here");
                                startActivity(Intent.createChooser(intent_share,""));
                                break;
                        }

                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        user.setText("Welcome "+sharedPreferences.getString("username",null));

        Layoutstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.e("TAG", "The interstitial wasn't loaded yet.");
                }

                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select picture"),GALLERY);
            }
        });



    }

    public Bitmap getThumbnail(Uri uri) throws FileNotFoundException, IOException {
        InputStream input = this.getContentResolver().openInputStream(uri);

        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        onlyBoundsOptions.inDither=true;//optional
        onlyBoundsOptions.inPreferredConfig=Bitmap.Config.ARGB_8888;//optional
        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();
        if ((onlyBoundsOptions.outWidth == -1) || (onlyBoundsOptions.outHeight == -1))
            return null;

        int originalSize = (onlyBoundsOptions.outHeight > onlyBoundsOptions.outWidth) ? onlyBoundsOptions.outHeight : onlyBoundsOptions.outWidth;

        double ratio = (originalSize > THUMBNAIL_SIZE) ? (originalSize / THUMBNAIL_SIZE) : 1.0;

        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = getPowerOfTwoForSampleRatio(ratio);
        bitmapOptions.inDither=true;//optional
        bitmapOptions.inPreferredConfig=Bitmap.Config.ARGB_8888;//optional
        input = this.getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        input.close();
        return bitmap;
    }

    private static int getPowerOfTwoForSampleRatio(double ratio){
        int k = Integer.highestOneBit((int)Math.floor(ratio));
        if(k==0) return 1;
        else return k;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY && resultCode==RESULT_OK){
            Uri uri=data.getData();
            try {
                bitmap= MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
            } catch (IOException e){
                e.printStackTrace();
            }
            goneimg.setImageBitmap(bitmap);
            Intent i=new Intent(MainActivity.this,ImgEdit_Activity.class);
            startActivity(i);
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert dialouge");
        builder.setMessage("Are you really want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

}
