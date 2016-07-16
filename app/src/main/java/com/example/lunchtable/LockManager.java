package com.example.lunchtable;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import java.util.Random;
/**
 * Created by 훈 on 2016-07-16.
 */
public class LockManager {
    private static LockManager instance = null;

    Random random = new Random();
    int a;


    public static LockManager getInstance() {
        if (instance == null) instance = new LockManager();
        return instance;
    }

    private LockManager() {
    }

    private boolean isShowing = false;

    private WindowManager windowManager;
    private View view;

    WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            PixelFormat.TRANSLUCENT
    );

    LockScreen lockScreen = new LockScreen();

    public void sendAction(String action) {
        switch (action) {
            case "CONNECTING":
                addView();
                break;
            case "DISCONNECTED":
                addView();
                break;
        }

    }

    public void init(Context context) {
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        view = LayoutInflater.from(context).inflate(lockScreen.getXML(), null);
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        lockScreen.onCreate(view);
    }

    public void addView() {
        if(view != null) {
            if (!isShowing) {
                lockScreen.onLock(view);
                windowManager.addView(view, params);
                isShowing = true;
            }
        }
        else throw new Error("need to init");
    }

    public void removeView() {
        if(view != null) {
            if (isShowing) {
                windowManager.removeView(view);
                isShowing = false;
            }
        }
        else throw new Error("need to init");
    }

    public void resetView() {
        Context context = view.getContext();
        if (isShowing) {
            windowManager.removeView(view);
            isShowing = false;
        }
        view = LayoutInflater.from(context).inflate(lockScreen.getXML(), null);
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        lockScreen.onCreate(view);
    }
}
