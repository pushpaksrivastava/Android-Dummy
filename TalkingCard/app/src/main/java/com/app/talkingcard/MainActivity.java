package com.app.talkingcard;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    LinearLayout menuInfo;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        menuInfo=(LinearLayout)findViewById(R.id.menu_info);

        AdView adView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        mp=MediaPlayer.create(this,R.raw.btn);

    }
    public void onLogo(View v)
    {
        mp.reset();
        mp=MediaPlayer.create(this,R.raw.logo);
        mp.start();
    }
    public void onAlphabet(View v)
    {
        startActivity(new Intent(this,AlphabetActivity.class));
    }
    public void onInfo(View v)
    {
        mp.reset();
        mp=MediaPlayer.create(this,R.raw.btn);
        mp.start();
        if(menuInfo.isShown())
        {
            menuInfo.setVisibility(View.GONE);
        }
        else
        {
            menuInfo.setVisibility(View.VISIBLE);
        }
    }

    public void onClose(View v)
    {
        onBackPressed();
    }

    @Override
    public void onBackPressed()
    {
        mp.reset();
        mp=MediaPlayer.create(this,R.raw.btn);
        mp.start();
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setMessage("Do you really want to exit?");
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        b.setNegativeButton("No",null);
        b.show();
    }
}
