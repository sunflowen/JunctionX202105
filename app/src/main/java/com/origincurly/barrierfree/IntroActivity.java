package com.origincurly.barrierfree;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Locale;


public class IntroActivity extends BasicActivity {

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

        checkPermission();
    }

    //region Version

    //endregion

    private void checkPermission() {
        boolean isAllGranted;
        String[] permissions = {
                Manifest.permission.VIBRATE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.RECORD_AUDIO,
        };
        ArrayList<String> requests = new ArrayList<>();

        for (int i=0; i<permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(mContext, permissions[i]) != PackageManager.PERMISSION_GRANTED){
                requests.add(permissions[i]);
            }
        }

        if (requests.size() > 0) {

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

        if(requestCode==200 && grantResults.length>0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){

            }
            if(grantResults[1] == PackageManager.PERMISSION_GRANTED){

            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }

        return true; // give next func
    }

}