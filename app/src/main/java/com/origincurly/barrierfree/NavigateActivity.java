package com.origincurly.barrierfree;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NavigateActivity extends BasicActivity {


    private RelativeLayout b1_Layout;
    private RelativeLayout b2_Layout;
    private RelativeLayout b3_Layout;
    private RelativeLayout b4_Layout;
    private RelativeLayout b5_Layout;

    private RelativeLayout c1_Layout;
    private RelativeLayout c2_Layout;
    private RelativeLayout c3_Layout;
    private RelativeLayout c4_Layout;
    private RelativeLayout c5_Layout;
    private RelativeLayout c6_Layout;
    private RelativeLayout c7_Layout;
    private RelativeLayout c8_Layout;
    private RelativeLayout c9_Layout;
    private RelativeLayout c10_Layout;
    private RelativeLayout c11_Layout;

    private TextView min_Txt;
    private TextView km_Txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);
        setActivity(this, this);

        b1_Layout = findViewById(R.id.b1_Layout);
        b2_Layout = findViewById(R.id.b2_Layout);
        b3_Layout = findViewById(R.id.b3_Layout);
        b4_Layout = findViewById(R.id.b4_Layout);
        b5_Layout = findViewById(R.id.b5_Layout);
        c1_Layout = findViewById(R.id.c1_Layout);
        c2_Layout = findViewById(R.id.c2_Layout);
        c3_Layout = findViewById(R.id.c3_Layout);
        c4_Layout = findViewById(R.id.c4_Layout);
        c5_Layout = findViewById(R.id.c5_Layout);
        c6_Layout = findViewById(R.id.c6_Layout);
        c7_Layout = findViewById(R.id.c7_Layout);
        c8_Layout = findViewById(R.id.c8_Layout);
        c9_Layout = findViewById(R.id.c9_Layout);
        c10_Layout = findViewById(R.id.c10_Layout);
        c11_Layout = findViewById(R.id.c11_Layout);

        min_Txt = findViewById(R.id.min_Txt);
        km_Txt = findViewById(R.id.km_Txt);

        a1Handler.sendEmptyMessageDelayed(0, 0);
    }

    Handler a1Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
            a2Handler.sendEmptyMessageDelayed(0, ANIM_INTERVAL_TIME);
        }
    };

    Handler a2Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
            a3Handler.sendEmptyMessageDelayed(0, ANIM_INTERVAL_TIME);
        }
    };

    Handler a3Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
            a4Handler.sendEmptyMessageDelayed(0, ANIM_INTERVAL_TIME);
        }
    };

    Handler a4Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
            a5Handler.sendEmptyMessageDelayed(0, ANIM_INTERVAL_TIME);
        }
    };

    Handler a5Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
            a6Handler.sendEmptyMessageDelayed(0, ANIM_INTERVAL_TIME);
        }
    };

    Handler a6Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
            a7Handler.sendEmptyMessageDelayed(0, ANIM_INTERVAL_TIME);
        }
    };

    Handler a8Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
            a9Handler.sendEmptyMessageDelayed(0, ANIM_INTERVAL_TIME);
        }
    };

    Handler a9Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
            a10Handler.sendEmptyMessageDelayed(0, ANIM_INTERVAL_TIME);
        }
    };

    Handler a10Handler = new Handler() {
        public void handleMessage(Message msg) {
//            a12Handler("Gangnam");
            a11Handler.sendEmptyMessageDelayed(0, ANIM_INTERVAL_TIME);
        }
    };

    Handler a11Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
        }
    };

    Handler a1Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
            a2Handler.sendEmptyMessageDelayed(0, ANIM_INTERVAL_TIME);
        }
    };

    Handler a1Handler = new Handler() {
        public void handleMessage(Message msg) {
            sstResult("Gangnam");
            a2Handler.sendEmptyMessageDelayed(0, ANIM_INTERVAL_TIME);
        }
    };


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitApp();
        }

        return true;
    }
}