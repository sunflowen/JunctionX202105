package com.origincurly.barrierfree;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.constraintlayout.widget.Placeholder;

public class MapActivity extends BasicActivity {


    private TextView talkOutput_Txt;
    private EditText speechInput_EditTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActivity(this, this);

        talkOutput_Txt = findViewById(R.id.talkOutput_Txt);
        speechInput_EditTxt = findViewById(R.id.speechInput_EditTxt);

        initSTT();
        initTTS();
    }

    public void TalkClicked(View v) {
        if (isTalkDuring) {
            stopTalk();

        } else {
            startTalk();
            talkOutput_Txt.setText("");
        }
    }

    public void SpeechClicked(View v) {
        if (isSpeechDuring) {
            stopSpeechRepeat();

        } else {
            String msg = speechInput_EditTxt.getText().toString();
            if (msg.length() > 0) {
                startSpeechRepeat(msg, 3);
            } else {
                startSpeechRepeat("메세지를 입력해주세요.", 1);
            }
        }
    }

    @Override
    public void sstResult(String msg) {
        talkOutput_Txt.setText(talkOutput_Txt.getText()+"\r\n"+msg);
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
        speechInput_EditTxt.clearFocus();
    }
}