package com.app.talkingcard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class WordActivity extends AppCompatActivity {

    ImageView wordImage;
    MediaPlayer mp;
    int alphabetIndex;
    int wordIndex=0;
    int audioCounter=0;
    int [] audios;
    String [] names;

    TextView tName;
    String baseUrl="assets://word/word_pic_img_%s.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        getSupportActionBar().hide();
        wordImage=(ImageView)findViewById(R.id.image_word);
        tName=(TextView)findViewById(R.id.text_name);
        mp= MediaPlayer.create(this,R.raw.btn);
        Intent intent=getIntent();
        alphabetIndex=intent.getIntExtra("position",0);//0
        wordIndex=alphabetIndex;//0,26,52
                                //1,27,53


        String url="";
        if(wordIndex<10)
            url=String.format(baseUrl,"0"+wordIndex);
        else
            url=String.format(baseUrl,""+wordIndex);
        ImageLoader.getInstance().displayImage(url,wordImage);

        if(alphabetIndex==0) {
            audios = new int[]{R.raw.word_sound000, R.raw.word_sound026, R.raw.word_sound052};
            names =new String[]{"Apple","Ant","Airplane"};
        }
        else if(alphabetIndex==1) {
            audios = new int[]{R.raw.word_sound001, R.raw.word_sound027, R.raw.word_sound053};
            names =new String[]{"Bird","Bycylce","Bear"};
        }
        else if(alphabetIndex==2) {
            audios = new int[]{R.raw.word_sound002, R.raw.word_sound028, R.raw.word_sound054};
            names =new String[]{"Clock","Computer","Cat"};
        }

        tName.setText(names[0]);

    }
    public void onClose(View v)
    {
        mp.reset();
        mp= MediaPlayer.create(this,R.raw.btn);
        mp.start();
        onBackPressed();
    }
    public void onRead(View v)
    {
        mp.reset();
        mp=MediaPlayer.create(this,audios[audioCounter]);
        mp.start();

    }
    public void onNext(View v)
    {
        mp.reset();
        mp= MediaPlayer.create(this,R.raw.btn);
        mp.start();

        wordIndex=wordIndex+26;
        audioCounter++;
        if(wordIndex>77) {
            wordIndex = alphabetIndex;
            audioCounter=0;
        }

        String url="";
        if(wordIndex<10)
            url=String.format(baseUrl,"0"+wordIndex);
        else
            url=String.format(baseUrl,""+wordIndex);
        ImageLoader.getInstance().displayImage(url,wordImage);
        tName.setText(names[audioCounter]);

    }
    public void onPrev(View v)
    {
        mp.reset();
        mp= MediaPlayer.create(this,R.raw.btn);
        mp.start();

        wordIndex=wordIndex-26;
        audioCounter--;

        if(wordIndex<alphabetIndex) {
            wordIndex = alphabetIndex + 26 + 26;
            audioCounter=2;
        }

        String url="";
        if(wordIndex<10)
            url=String.format(baseUrl,"0"+wordIndex);
        else
            url=String.format(baseUrl,""+wordIndex);
        ImageLoader.getInstance().displayImage(url,wordImage);
        tName.setText(names[audioCounter]);
    }
}
