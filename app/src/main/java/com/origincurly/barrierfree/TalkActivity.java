package com.origincurly.barrierfree;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TalkActivity extends BasicActivity {


    private TextView tts_ready_Txt;
    private TextView tts_result_Txt;

    private String resultMsg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);
        setActivity(this, this);

        tts_ready_Txt = findViewById(R.id.tts_ready_Txt);
        tts_result_Txt = findViewById(R.id.tts_result_Txt);

        initSTT();
//        initTTS();
        startTalk();
        sst1Handler.sendEmptyMessageDelayed(0, 1500);
    }

    Handler sst1Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
            sst2Handler.sendEmptyMessageDelayed(0, 800);
        }
    };
    Handler sst2Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam Station");
        }
    };
    private void showSTT() {
        tts_result_Txt.setText("");
        tts_ready_Txt.setVisibility(View.GONE);
        tts_result_Txt.setVisibility(View.VISIBLE);
    }

    private void hideSTT() {
        tts_ready_Txt.setVisibility(View.VISIBLE);
        tts_result_Txt.setVisibility(View.GONE);
    }

    public void BackClicked(View v) {
        if (isTalkDuring) {
            stopTalk();
        }
        finishActivity(R.anim.animation_stop_short, R.anim.animation_fade_out);
    }

    public void OKClicked(View v) {
        if (resultMsg.length() > 0) {
            if (isTalkDuring) {
                stopTalk();
            }

            Intent intent = new Intent();
            intent.putExtra("result", resultMsg);
            setResult(RESULT_OK, intent);
            finish();

            finishActivity(R.anim.animation_stop_short, R.anim.animation_fade_out);

        } else {
            showToastMessage(R.string.tts_need);
        }
    }

    public void MicClicked(View v) {
        if (!isTalkDuring) {
            hideSTT();
            startTalk();
        }
    }

    @Override
    public void sstResult(String msg) {
        showSTT();
        tts_result_Txt.setText(msg);
        resultMsg = msg;
        stopTalk();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            BackClicked(null);
        }

        return true;
    }
}