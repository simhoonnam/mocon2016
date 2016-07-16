package com.example.lunchtable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.lang.Integer;
import java.util.List;

/**
 * Created by 훈 on 2016-07-16.
 */
public class ServiceTool {

    private static boolean isRunning = false;

    public static boolean isServiceRunning(Context context) {
        final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE);

        for (ActivityManager.RunningServiceInfo runningServiceInfo : services) {
            if (runningServiceInfo.service.getClassName().equals("com.example.dudco.Lock.LockService")) {
                return true;
            }
        }
        return false;
    }

    public static void reloadService(Context context) {
        SharedPreferences pref = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        if (!isServiceRunning(context)) startService(context);
    }


    public static void startService(Context context) {
        if (!isRunning) {
            isRunning = true;
            Intent i = new Intent(context, LockService.class);
            context.startService(i);
        }
    }

    public static void stopService(Context context) {
        if (isRunning) {
            isRunning = false;
            Intent i = new Intent(context, LockService.class);
            context.stopService(i);
        }
    }
}
