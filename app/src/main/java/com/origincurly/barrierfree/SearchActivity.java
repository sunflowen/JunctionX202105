package com.origincurly.barrierfree;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchActivity extends BasicActivity {

    private EditText where_EditTxt;

    private LinearLayout recent_Layout;
    private LinearLayout result_Layout;

    private boolean isShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setActivity(this, this);

        where_EditTxt = findViewById(R.id.where_EditTxt);
        recent_Layout = findViewById(R.id.recent_Layout);
        result_Layout = findViewById(R.id.result_Layout);

        where_EditTxt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch(actionId) {
                    case EditorInfo.IME_ACTION_SEARCH:
                        showResult();
                        break;
                }
                return true;
            }
        });

    }

    private void showRecent() {
        isShow = false;
        result_Layout.animate()
                .alpha(0.0f)
                .setDuration(300);
        showRecentHandler.sendEmptyMessageDelayed(0, ANIM_DELAY_TIME);
    }

    Handler showRecentHandler = new Handler() {
        public void handleMessage(Message msg) {
            result_Layout.setVisibility(View.GONE);
            recent_Layout.setVisibility(View.VISIBLE);
            recent_Layout.animate()
                .alpha(1.0f)
                .setDuration(300);
        }
    };
    private void showResult() {
        hideSoftKeyboard(mActivity);
        isShow = true;
        recent_Layout.animate()
                .alpha(0.0f)
                .setDuration(300);
        showResultHandler.sendEmptyMessageDelayed(0, ANIM_DELAY_TIME);
    }

    Handler showResultHandler = new Handler() {
        public void handleMessage(Message msg) {
            recent_Layout.setVisibility(View.GONE);
            result_Layout.setVisibility(View.VISIBLE);
            result_Layout.animate()
                    .alpha(1.0f)
                    .setDuration(300);
        }
    };

    public void MicClicked(View v) {
        startActivityResultClass(TalkActivity.class, TALK_ACTIVITY, R.anim.animation_fade_in, R.anim.animation_stop_short);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode==TALK_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                String msg = intent.getStringExtra("result");
                where_EditTxt.setText(msg);
            } else {
                where_EditTxt.setText("");
            }
        }
    }
    public void BackClicked(View v) {
        if (isShow) {
            showRecent();
        } else {
            finishActivity(R.anim.animation_stop_short, R.anim.animation_bottom_close);
        }
    }

    public void HomeClicked(View v) {
        where_EditTxt.setText("Mapo-gu Office Station Line 6");
        showResult();
    }

    public void HospitalClicked(View v) {
        where_EditTxt.setText("Mapo-gu Office Station Line 6");
        showResult();
    }

    public void CompanyClicked(View v) {
        where_EditTxt.setText("Mapo-gu Office Station Line 6");
        showResult();
    }

    public void GangseoClicked(View v) {
        where_EditTxt.setText("Mapo-gu Office Station Line 6");
        showResult();
    }

    public void GoClicked(View v) {
        startActivityClass(NavigateActivity.class, R.anim.animation_fade_in, R.anim.animation_stop_short);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            BackClicked(null);
        }

        return true;
    }

    @Override
    public void clearFocusBundle() {
        super.clearFocusBundle();
        where_EditTxt.clearFocus();
    }
}