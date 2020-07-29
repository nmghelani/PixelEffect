package com.example.ghelani.pixeleffect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ghelani.pixeleffect.Adapter.AdapterAnniversary;
import com.example.ghelani.pixeleffect.Adapter.AdapterEmoji;
import com.example.ghelani.pixeleffect.Adapter.AdapterLove;
import com.example.ghelani.pixeleffect.Adapter.AdapterMonster;
import com.example.ghelani.pixeleffect.Adapter.AdapterParty;
import com.example.ghelani.pixeleffect.Adapter.AdapterWedding;
import com.example.ghelani.pixeleffect.Sticker.StickerView;

import java.util.ArrayList;
import static com.example.ghelani.pixeleffect.Edit_Activity.frameLayout;

public class Emoji_Activity extends AppCompatActivity {

    private ImageView backsticker;
    private ImageView emoji;
    private ImageView monster;
    private ImageView anniversary;
    private ImageView wedding;
    private ImageView love;
    private ImageView party;
    private GridView gridview1;
    private GridView gridview2;
    private GridView gridview3;
    private GridView gridview4;
    private GridView gridview5;
    private GridView gridview6;
    private TextView t1;
    
    ArrayList<View> arrayList=new ArrayList<>();
    static StickerView mStickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);
        emoji=(ImageView)findViewById(R.id.emoji);
        monster=(ImageView)findViewById(R.id.monster);
        anniversary=(ImageView)findViewById(R.id.anniversary);
        wedding=(ImageView)findViewById(R.id.wedding);
        love=(ImageView)findViewById(R.id.love);
        party=(ImageView)findViewById(R.id.party);
        gridview1=(GridView)findViewById(R.id.gridview1);
        gridview2=(GridView)findViewById(R.id.gridview2);
        gridview3=(GridView)findViewById(R.id.gridview3);
        gridview4=(GridView)findViewById(R.id.gridview4);
        gridview5=(GridView)findViewById(R.id.gridview5);
        gridview6=(GridView)findViewById(R.id.gridview6);
        final int[] stickersParty=new int[]{R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b6,R.drawable.b7,R.drawable.b8,R.drawable.b9,R.drawable.b10,R.drawable.b12,R.drawable.b14,R.drawable.b15,R.drawable.b16,R.drawable.b17,R.drawable.b18,R.drawable.b19,R.drawable.b20};
        final int[] stickersEmoji= new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a12,R.drawable.a14,R.drawable.a15,R.drawable.a16,R.drawable.a17,R.drawable.a18,R.drawable.a19,R.drawable.a20,R.drawable.a21,R.drawable.a22,R.drawable.a24,R.drawable.a25,R.drawable.a26,R.drawable.a28,R.drawable.a29,R.drawable.a30,R.drawable.a32,R.drawable.a34};
        final int[] stickersAnn=new int[]{R.drawable.l7,R.drawable.l8,R.drawable.l9,R.drawable.l10,R.drawable.l11,R.drawable.l12,R.drawable.l13,R.drawable.l14,R.drawable.l15,R.drawable.l16,R.drawable.l17,R.drawable.l18,R.drawable.l9,R.drawable.l20,R.drawable.l21,R.drawable.l22,R.drawable.l23,R.drawable.l24,R.drawable.l25,R.drawable.l26,R.drawable.l27,R.drawable.l28,R.drawable.l35,R.drawable.l36,R.drawable.l37,R.drawable.l38,R.drawable.l39,R.drawable.l40,R.drawable.l42};
        final int[] stickersLove=new int[]{R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,R.drawable.s11,R.drawable.s12,R.drawable.s13,R.drawable.s14,R.drawable.s15,R.drawable.s16,R.drawable.s17,R.drawable.s18,R.drawable.s19,R.drawable.s20};
        final int[] stickersMon=new int[]{R.drawable.monster_01,R.drawable.monster_02,R.drawable.monster_03,R.drawable.monster_04,R.drawable.monster_05,R.drawable.monster_06,R.drawable.monster_07,R.drawable.monster_08,R.drawable.monster_09,R.drawable.monster_10,R.drawable.monster_11,R.drawable.monster_12,R.drawable.monster_13,R.drawable.monster_14,R.drawable.monster_15,R.drawable.monster_16,R.drawable.monster_17,R.drawable.monster_18,R.drawable.monster_19,R.drawable.monster_20,R.drawable.monster_21,R.drawable.monster_22,R.drawable.monster_23,R.drawable.monster_24,R.drawable.monster_25};
        final int[] stickersWed=new int[]{R.drawable.wedding01,R.drawable.wedding02,R.drawable.wedding03,R.drawable.wedding04,R.drawable.wedding05,R.drawable.wedding06,R.drawable.wedding07,R.drawable.wedding08,R.drawable.wedding09,R.drawable.wedding10,R.drawable.wedding11,R.drawable.wedding12,R.drawable.wedding13,R.drawable.wedding14,R.drawable.wedding15,R.drawable.wedding16,R.drawable.wedding17,R.drawable.wedding18,R.drawable.wedding19,R.drawable.wedding20,R.drawable.wedding21,R.drawable.wedding22};
        final AdapterEmoji adapterEmoji=new AdapterEmoji(Emoji_Activity.this);
        gridview1.setAdapter(adapterEmoji);

        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridview1.setAdapter(adapterEmoji);
                gridview1.setVisibility(View.VISIBLE);
                gridview2.setVisibility(View.GONE);
                gridview3.setVisibility(View.GONE);
                gridview4.setVisibility(View.GONE);
                gridview5.setVisibility(View.GONE);
                gridview6.setVisibility(View.GONE);
            }
        });

        monster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterMonster adapterMonster=new AdapterMonster(Emoji_Activity.this);
                gridview2.setAdapter(adapterMonster);
                gridview1.setVisibility(View.GONE);
                gridview2.setVisibility(View.VISIBLE);
                gridview3.setVisibility(View.GONE);
                gridview4.setVisibility(View.GONE);
                gridview5.setVisibility(View.GONE);
                gridview6.setVisibility(View.GONE);
            }
        });

        anniversary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterAnniversary anniversary=new AdapterAnniversary(Emoji_Activity.this);
                gridview3.setAdapter(anniversary);
                gridview1.setVisibility(View.GONE);
                gridview2.setVisibility(View.GONE);
                gridview3.setVisibility(View.VISIBLE);
                gridview4.setVisibility(View.GONE);
                gridview5.setVisibility(View.GONE);
                gridview6.setVisibility(View.GONE);
            }
        });

        wedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterWedding wedding=new AdapterWedding(Emoji_Activity.this);
                gridview4.setAdapter(wedding);
                gridview1.setVisibility(View.GONE);
                gridview2.setVisibility(View.GONE);
                gridview3.setVisibility(View.GONE);
                gridview4.setVisibility(View.VISIBLE);
                gridview5.setVisibility(View.GONE);
                gridview6.setVisibility(View.GONE);
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterLove love=new AdapterLove(Emoji_Activity.this);
                gridview5.setAdapter(love);
                gridview1.setVisibility(View.GONE);
                gridview2.setVisibility(View.GONE);
                gridview3.setVisibility(View.GONE);
                gridview4.setVisibility(View.GONE);
                gridview5.setVisibility(View.VISIBLE);
                gridview6.setVisibility(View.GONE);
            }
        });

        party.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterParty party=new AdapterParty(Emoji_Activity.this);
                gridview6.setAdapter(party);
                gridview1.setVisibility(View.GONE);
                gridview2.setVisibility(View.GONE);
                gridview3.setVisibility(View.GONE);
                gridview4.setVisibility(View.GONE);
                gridview5.setVisibility(View.GONE);
                gridview6.setVisibility(View.VISIBLE);
            }
        });

        gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AddStickerView(stickersEmoji[position]);
                finish();
            }
        });

        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AddStickerView(stickersMon[position]);
                finish();
            }
        });

        gridview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AddStickerView(stickersAnn[position]);
                finish();
            }
        });

        gridview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AddStickerView(stickersWed[position]);
                finish();
            }
        });

        gridview5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AddStickerView(stickersLove[position]);
                finish();
            }
        });

        gridview6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AddStickerView(stickersParty[position]);
                finish();
            }
        });

        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(mStickerView != null){
                    mStickerView.setInEdit(false);
                }
                return false;
            }
        });
        backsticker=findViewById(R.id.backsticker);
        backsticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void AddStickerView(int i) {
        final StickerView stickerView=new StickerView(Emoji_Activity.this);

        stickerView.setImageResource(i);
        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        frameLayout.addView(stickerView,layoutParams);
        arrayList.add(stickerView);
        setCurrentEdit(stickerView);
        stickerView.setOperationListener(new StickerView.OperationListener() {
            @Override
            public void onDeleteClick() {
                arrayList.remove(stickerView);
                frameLayout.removeView(stickerView);
            }

            @Override
            public void onEdit(StickerView stickerView) {
                mStickerView.setInEdit(false);
                mStickerView=stickerView;
                mStickerView.setInEdit(true);
            }

            @Override
            public void onTop(StickerView stickerView) {

            }
        });
    }

    private void setCurrentEdit(StickerView stickerView) {
        if(mStickerView != null){
            mStickerView.setInEdit(false);
        }
        mStickerView=stickerView;
        stickerView.setInEdit(true);
    }
}
