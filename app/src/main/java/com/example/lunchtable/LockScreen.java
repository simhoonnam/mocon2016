package com.example.lunchtable;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by 훈 on 2016-07-16.
 */
public class LockScreen {

    Button button;
    EditText editText;
    String ok = "112";

    public int getXML() {
        return R.layout.activity_lock;
    }

    protected void onCreate(final View view) {
        button = (Button) view.findViewById(R.id.click);
        editText = (EditText) view.findViewById(R.id.whaaa);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String num = editText.getText().toString();
                if(num.equals(ok)) {
                    LockManager.getInstance().resetView();
                }else{
                    Toast.makeText(v.getContext(), "틀렸어요!" , Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void onLock(View view) {
//        num++;
//        textView.setText("잠금해제가 " + num + "번 되었습니다.");
    }
}
