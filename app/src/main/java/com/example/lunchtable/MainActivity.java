package com.example.lunchtable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView timetextview;
    Button tknow,tcal;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        setDefault();
    }

    private void setDefault() {
        timetextview=(TextView)findViewById(R.id.textresult);
        tknow = (Button) findViewById(R.id.buttonknow);
        tcal = (Button) findViewById(R.id.buttoncal);
        tknow.setOnClickListener(this);
        tcal.setOnClickListener(this);

        pref = getSharedPreferences("helloworld", MODE_PRIVATE);
        editor = pref.edit();

       /* int fcheck=pref.getInt("isfirst",-1);
        if(fcheck==-1) {
            Intent intent=null;
            intent = new Intent(MainActivity.this, PollActivity.class);
            startActivity(intent);
        }
        else */
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonknow:
                timeknow();
                break;
            case R.id.buttoncal:
                timecal();
                break;
        }
    }

    private void timeknow() {
        String strResult = "";
        // 현재 날짜 구하기
        Calendar calendar = Calendar.getInstance();
        // 시간 구하기
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        strResult += Integer.toString(hour) + ":";
        // 분 구하기
        int min = calendar.get(Calendar.MINUTE);
        strResult += Integer.toString(min) + ":";
        // 초 구하기
        int sec = calendar.get(Calendar.SECOND);
        strResult += Integer.toString(sec) + " ";

        timetextview.setText(strResult);
    }

    private void timecal() {
        // 현재 날짜&시간 구하기
        Calendar today = Calendar.getInstance();
        // 시작 날짜&시간
        Calendar startday = Calendar.getInstance();
        startday.set(2016, 6, 14, 0, 0, 0);

        // 시간 차이 값을 초단위로 계산
        long gapSec = (today.getTimeInMillis() - startday.getTimeInMillis()) / 1000;
        // 지나간 Day 값 계산
        long gapDay = gapSec / (60 * 60 * 24);
        // 지나간 Hour 값 계산
        gapSec -= gapDay * (60 * 60 * 24);
        long gapHour = gapSec / (60 * 60);
        // 지나간 Min 값 계산
        gapSec -= gapHour * (60 * 60);
        long gapMin = gapSec / 60;
        // 지나간 Sec 값 계산
        gapSec -= gapMin * 60;

        String strResult = "Pased Time from 2013.01.01 00:00:00\n";
        strResult += (gapDay + "Day " + gapHour + "Hour " + gapMin + "Min " + gapSec + "Sec");
        timetextview.setText(strResult);
    }

}
