package com.example.pushpaksrivastava.slideapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pushpaksrivastava.slideapp.fragment.FragCalls;
import com.example.pushpaksrivastava.slideapp.fragment.FragChat;
import com.example.pushpaksrivastava.slideapp.fragment.FragStatus;

/**
 * Created by Pushpak Srivastava on 08-07-2017.
 */
public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
             {
                return new FragChat();
             }
        else if (position == 1)
        {
                return new FragStatus();
        }
            else
        {
            return new FragCalls();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
        {
         return "CHAT";
        }
        else if(position==1)
        {
            return "STATUS";
        }
        else
        {
            return "CALLS";
        }
    }
}
