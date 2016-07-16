package com.example.lunchtable;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;import java.lang.Override;


/**
 * Created by 훈 on 2016-07-16.
 */
public class ScreenReceiver  extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()) {
            case Intent.ACTION_SCREEN_ON:
            case Intent.ACTION_SCREEN_OFF:
                LockManager.getInstance().sendAction(intent.getAction());
                break;
        }
    }
}