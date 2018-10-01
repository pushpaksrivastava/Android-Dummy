package com.example.pushpaksrivastava.slideapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Pushpak Srivastava on 09-07-2017.
 */
public class LockReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"received",Toast.LENGTH_LONG).show();
    }
}
