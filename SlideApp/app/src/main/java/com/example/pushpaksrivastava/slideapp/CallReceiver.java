package com.example.pushpaksrivastava.slideapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by Pushpak Srivastava on 11-07-2017.
 */
public class CallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String state=intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        String number=intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
        Toast.makeText(context,"State: "+state+"/n Number: "+number ,Toast.LENGTH_LONG).show();
    }
}
