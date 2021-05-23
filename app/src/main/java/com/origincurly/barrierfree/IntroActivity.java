package com.origincurly.barrierfree;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Locale;


public class IntroActivity extends BasicActivity {


    private LinearLayout denied_Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        setActivity(this, this);

        if (!BuildConfig.DEBUG) {
            //Fabric.with(this, new Crashlytics());
        }

        userLang = Locale.getDefault().getLanguage();
        setDevicePreferences("userLang", userLang);

        denied_Layout = findViewById(R.id.denied_Layout);

        checkPermission();
    }

    public void PermissionClicked(View v) {
        checkPermission();
    }

    public void ExitClicked(View v) {
        killApp();
    }

    //region Version

    private void checkPermission() {
        String[] permissions = {
                Manifest.permission.VIBRATE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.RECORD_AUDIO,
        };
        ArrayList<String> denieds = new ArrayList<>();

        for (int i=0; i<permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(mContext, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                denieds.add(permissions[i]);
            }
        }

        if (denieds.size() > 0) {
            String[] requests = new String[denieds.size()];

            for (int i=0; i<denieds.size(); i++) {
                requests[i] = denieds.get(i);
            }
            ActivityCompat.requestPermissions(mActivity, requests, PERMISSION_REQUEST);

        } else {
            introMapHandler.sendEmptyMessageDelayed(0, INTRO_DELAY_TIME);
        }
    }

    Handler introMapHandler = new Handler() {
        public void handleMessage(Message msg) {
            //region introMapHandler
            startActivityClass(MapActivity.class, R.anim.animation_fade_in, R.anim.animation_stop_short);
            //endregion
        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        boolean isGranted = true;
        for (int i=0; i<grantResults.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                isGranted = false;
            }
        }

        if (isGranted) {
            startActivityClass(MapActivity.class);
        } else {
//            denied_Layout.setVisibility(View.VISIBLE);
//            showToastMessage(R.string.msg_permission_need);
            showConfirmDialog();
        }
    }

    private void showConfirmDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.permission_title)
                .setMessage(R.string.msg_permission_need)
                .setPositiveButton(R.string.permission_re, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        checkPermission();
                    }})
                .setNegativeButton(R.string.app_exit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        killApp();
                    }})
                .show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }

        return true; // give next func
    }

}