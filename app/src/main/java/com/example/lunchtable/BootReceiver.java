package com.example.lunchtable;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.lang.Override;

/**
 * Created by 훈 on 2016-07-16.
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            ServiceTool.startService(context);
        }
    }

}