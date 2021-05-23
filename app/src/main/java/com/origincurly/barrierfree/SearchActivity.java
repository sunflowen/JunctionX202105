package com.origincurly.barrierfree;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

public class SearchActivity extends BasicActivity {

    private LinearLayout recent_Layout;
    private LinearLayout result_Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setActivity(this, this);

        recent_Layout = findViewById(R.id.recent_Layout);
        result_Layout = findViewById(R.id.result_Layout);

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