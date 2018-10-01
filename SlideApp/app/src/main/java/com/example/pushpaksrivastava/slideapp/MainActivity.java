package com.example.pushpaksrivastava.slideapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    PagerAdapter adapter;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3;
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        pager=(ViewPager)findViewById(R.id.pager);
        rg=(RadioGroup)findViewById(R.id.rg);
        rb1=(RadioButton)findViewById(R.id.rchat);
        rb2=(RadioButton)findViewById(R.id.rstatus);
        rb3=(RadioButton)findViewById(R.id.rcall);
        rg.setOnCheckedChangeListener(this);
        pager.setOnPageChangeListener(this);
        adapter=new PageAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        Intent intent=new Intent(this,LockReceiver.class);
        sendBroadcast(intent);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            int permission=checkSelfPermission("android.intent.action.PHONE_STATE");
            if(permission== PackageManager.PERMISSION_DENIED)
            {
                String [] permissions= {"android.intent.action.PHONE_STATE"};
                requestPermissions(permissions,1001);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==1001)
        {
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"permission provided",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this,"permission still pends",Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onfab(View v){
        Snackbar.make(v,"Replace",Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //Toast.makeText(this,"click",Toast.LENGTH_LONG).show();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_edit) {
            Toast.makeText(this,"edit",Toast.LENGTH_LONG).show();
        }
        else if(id==R.id.action_exit)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i==R.id.rchat)
        {
            pager.setCurrentItem(0);
        }
        else if(i==R.id.rstatus)
        {
            pager.setCurrentItem(1);
        }
        else if(i==R.id.rcall)
        {
            pager.setCurrentItem(2);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            rb1.setChecked(true);
        }
        else if(position==1){
            rb2.setChecked(true);
        }
        else
        {
            rb3.setChecked(true);
        }
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
