package com.app.talkingcard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class AlphabetActivity extends AppCompatActivity {

    ImageView alphaImage;
    int index=0;
    String baseUrl="assets://alphabet/letter_letter_img_%s.png";
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        getSupportActionBar().hide();
        AdView adView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        alphaImage=(ImageView)findViewById(R.id.image_alphabet);

        String url="";
        if(index<10)
            url=String.format(baseUrl,"0"+index);
        else
            url=String.format(baseUrl,""+index);
        ImageLoader.getInstance().displayImage(url,alphaImage);
        mp=MediaPlayer.create(this,R.raw.btn);
    }
    public void onWord(View c)
    {
        mp.reset();
        mp=MediaPlayer.create(this,R.raw.btn);
        mp.start();

        Intent intent=new Intent(this,WordActivity.class);
        intent.putExtra("position",index);
        startActivity(intent);


    }
    public void onRead(View v)
    {
        mp.reset();
        if(index==0)
            mp=MediaPlayer.create(this,R.raw.letter_sound00);
        else if(index==2)
            mp=MediaPlayer.create(this,R.raw.letter_sound02);
        else if(index==3)
            mp=MediaPlayer.create(this,R.raw.letter_sound03);
        else if(index==4)
            mp=MediaPlayer.create(this,R.raw.letter_sound04);
        else if(index==5)
            mp=MediaPlayer.create(this,R.raw.letter_sound05);
        else if(index==6)
            mp=MediaPlayer.create(this,R.raw.letter_sound06);
        else if(index==7)
            mp=MediaPlayer.create(this,R.raw.letter_sound07);
        else if(index==8)
            mp=MediaPlayer.create(this,R.raw.letter_sound08);
        else if(index==9)
            mp=MediaPlayer.create(this,R.raw.letter_sound09);
        else if(index==10)
            mp=MediaPlayer.create(this,R.raw.letter_sound10);
        else if(index==11)
            mp=MediaPlayer.create(this,R.raw.letter_sound11);
        else if(index==12)
            mp=MediaPlayer.create(this,R.raw.letter_sound12);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==13)
            mp=MediaPlayer.create(this,R.raw.letter_sound13);
        else if(index==14)
            mp=MediaPlayer.create(this,R.raw.letter_sound14);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        else if(index==1)
            mp=MediaPlayer.create(this,R.raw.letter_sound01);
        mp.start();
    }

    public void onClose(View v)
    {
        mp.reset();
        mp=MediaPlayer.create(this,R.raw.btn);
        mp.start();
        onBackPressed();
    }
    public void onNext(View v)
    {
        mp.reset();
        mp=MediaPlayer.create(this,R.raw.btn);
        mp.start();
        index++;
        if(index==26)
            index=0;
        String url="";
        if(index<10)
            url=String.format(baseUrl,"0"+index);
        else
            url=String.format(baseUrl,""+index);
        ImageLoader.getInstance().displayImage(url,alphaImage);
    }
    public void onPrev(View v)
    {
        mp.reset();
        mp=MediaPlayer.create(this,R.raw.btn);
        mp.start();
        index--;
        if(index==-1)
            index=25;
        String url="";
        if(index<10)
            url=String.format(baseUrl,"0"+index);
        else
            url=String.format(baseUrl,""+index);
        ImageLoader.getInstance().displayImage(url,alphaImage);
    }
}
