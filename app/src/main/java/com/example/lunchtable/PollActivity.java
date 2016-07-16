package com.example.lunchtable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 훈 on 2016-07-14.
 */
public class PollActivity extends AppCompatActivity implements View.OnClickListener {
    Button backtomain;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        setDefault();
    }

    private void setDefault() {
        backtomain = (Button) findViewById(R.id.backtmain);
        backtomain.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backtmain:
                finish();
        }
    }
}
