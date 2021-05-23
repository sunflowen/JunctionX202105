package com.origincurly.barrierfree;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SampleActivity extends BasicActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setActivity(this, this);

//        talkOutput_Txt = findViewById(R.id.talkOutput_Txt);

//        initSTT();
    }
x
    public void BtnClicked(View v) {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitApp();
        }

        return true;
    }

    @Override
    public void clearFocusBundle() {
        super.clearFocusBundle();
//        speechInput_EditTxt.clearFocus();
    }
}