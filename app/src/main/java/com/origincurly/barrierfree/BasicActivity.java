package com.origincurly.barrierfree;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.origincurly.barrierfree.util.NetworkManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static android.speech.tts.TextToSpeech.ERROR;

public class BasicActivity extends AppCompatActivity implements GlobalValue {

    //curly
    //region Activity

    public Context mContext;
    public Activity mActivity;

    public void setActivity(Context context, Activity activity) {
        mContext = context;
        mActivity = activity;
        backKeyPressedTime = 0;

        setStatusBarColor(mActivity, R.color.status_bar_color);

        setToastMessage();

        getUserData();
    }

    public void startActivityClass(Class c) {
        Intent intent = new Intent(mContext, c);
        startActivity(intent);
    }
    public void startActivityClass(Class c, int showId, int hideId) {
        Intent intent = new Intent(mContext, c);
        startActivity(intent);
        overridePendingTransition(showId, hideId);
    }
    public void startActivityResultClass(Class c, int requestCode) {
        Intent intent = new Intent(mContext, c);
        startActivityForResult(intent, requestCode);
    }
    public void startActivityResultClass(Class c, int requestCode, int showId, int hideId) {
        Intent intent = new Intent(mContext, c);
        startActivityForResult(intent, requestCode);
        overridePendingTransition(showId, hideId);
    }
    public void startActivityIntent(Intent intent) {
        startActivity(intent);
    }
    public void startActivityIntent(Intent intent, int showId, int hideId) {
        startActivity(intent);
        overridePendingTransition(showId, hideId);
    }
    public void startActivityIntentForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
    }
    public void startActivityIntentForResult(Intent intent, int requestCode, int showId, int hideId) {
        startActivityForResult(intent, requestCode);
        overridePendingTransition(showId, hideId);
    }
    public void finishActivity() {
        finish();
    }
    public void finishActivity(int showId, int hideId) {
        finish();
        overridePendingTransition(showId, hideId);
    }

    //endregion

    //region CarInfo

    public void setCarDataLogin(String _carId, String _carUUIDCode, String _carRegisterCode) {
        loginState = LOGIN_STATE_SUCCESS;
        carId = _carId;
        carUUIDCode = _carUUIDCode;
        carRegisterCode = _carRegisterCode;

        setDevicePreferences(DEVICE_PREF_KEY_PUSH_STATUS, 1);
        setUserPreferences(USER_PREF_KEY_LOGIN_STATE, loginState);
        setUserPreferences(USER_PREF_KEY_CAR_ID, carId);
        setUserPreferences(USER_PREF_KEY_CAR_UUID, carUUIDCode);
        setUserPreferences(USER_PREF_KEY_CAR_REGISTER_CODE, carRegisterCode);
    }

    public void setCarDataLogout() {
        setDevicePreferences(DEVICE_PREF_KEY_PUSH_STATUS, 0);
        NetworkManager.getInstance(mContext).clearSession();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
        clearUserPreferences();
    }

    public void getCarrData() {
        defaultDate = new Date(0);
        loginState = getUserPreferences(USER_PREF_KEY_LOGIN_STATE, LOGIN_STATE_NULL);
        carId = getUserPreferences(USER_PREF_KEY_CAR_ID, USER_PREF_DEFAULT_CAR_ID);
        carUUIDCode = getUserPreferences(USER_PREF_KEY_CAR_UUID, "");
        carRegisterCode = getUserPreferences(USER_PREF_KEY_CAR_REGISTER_CODE, "");
    }

    //endregion

    //region UserInfo

    public int loginState;
    public String version, userLang, userToken;
//en,kr / push token
    public String carId, carUUIDCode, carRegisterCode;
    public Date defaultDate;

    public void setDataLogin(String _carId, String _carUUIDCode, String _carRegisterCode) {
        loginState = LOGIN_STATE_SUCCESS;
        carId = _carId;
        carUUIDCode = _carUUIDCode;
        carRegisterCode = _carRegisterCode;

        setDevicePreferences(DEVICE_PREF_KEY_PUSH_STATUS, 1);

        setUserPreferences(USER_PREF_KEY_LOGIN_STATE, loginState);
        setUserPreferences(USER_PREF_KEY_CAR_ID, carId);
        setUserPreferences(USER_PREF_KEY_CAR_UUID, carUUIDCode);
        setUserPreferences(USER_PREF_KEY_CAR_REGISTER_CODE, carRegisterCode);
    }

    public void setDataLogout() {
        setDevicePreferences(DEVICE_PREF_KEY_PUSH_STATUS, 0);
        NetworkManager.getInstance(mContext).clearSession();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
        clearUserPreferences();
    }

    public void getUserData() {
        defaultDate = new Date(0);
        loginState = getUserPreferences(USER_PREF_KEY_LOGIN_STATE, LOGIN_STATE_NULL);
        carId = getUserPreferences(USER_PREF_KEY_CAR_ID, USER_PREF_DEFAULT_CAR_ID);
        carUUIDCode = getUserPreferences(USER_PREF_KEY_CAR_UUID, USER_PREF_DEFAULT_CAR_UUID);
        carRegisterCode = getUserPreferences(USER_PREF_KEY_CAR_REGISTER_CODE, USER_PREF_DEFAULT_CAR_REGISTER_CODE);
    }

    //endregion
//
//    //region Footer
//
//    public int nowPage;
//    public TextView drive_Txt, history_Txt, setting_Txt;
//    public ImageView drive_Img, history_Img, setting_Img;
//
//    public void initFooterLayout() {
//        drive_Txt = findViewById(R.id.drive_Txt);
//        history_Txt = findViewById(R.id.history_Txt);
//        setting_Txt = findViewById(R.id.setting_Txt);
//        drive_Img = findViewById(R.id.drive_Img);
//        history_Img = findViewById(R.id.history_Img);
//        setting_Img = findViewById(R.id.setting_Img);
//    }
//
//    public void setFooterLayout() {
//        drive_Txt.setTextColor(ContextCompat.getColor(mContext, R.color.footer_off_txt));
//        history_Txt.setTextColor(ContextCompat.getColor(mContext, R.color.footer_off_txt));
//        setting_Txt.setTextColor(ContextCompat.getColor(mContext, R.color.footer_off_txt));
//        drive_Img.setImageResource(R.drawable.ic_car_off);
//        history_Img.setImageResource(R.drawable.ic_history_off);
//        setting_Img.setImageResource(R.drawable.ic_setting_off);
//
//        switch (nowPage) {
//            case DRIVE_PAGE:
//                drive_Txt.setTextColor(ContextCompat.getColor(mContext, R.color.footer_on_txt));
//                drive_Img.setImageResource(R.drawable.ic_car_on);
//                break;
//            case HISTORY_PAGE:
//                history_Txt.setTextColor(ContextCompat.getColor(mContext, R.color.footer_on_txt));
//                history_Img.setImageResource(R.drawable.ic_history_on);
//                break;
//            case SETTING_PAGE:
//                setting_Txt.setTextColor(ContextCompat.getColor(mContext, R.color.footer_on_txt));
//                setting_Img.setImageResource(R.drawable.ic_setting_on);
//                break;
//        }
//    }
//
//    public void DriveClicked(View v) {
//        if (nowPage != DRIVE_PAGE) {
//            startActivityClass(DriveActivity.class, R.anim.animation_fade_in, R.anim.animation_stop_short);
//        }
//    }
//
//
//    public void HistoryClicked(View v) {
//        if (nowPage != HISTORY_PAGE) {
//            startActivityClass(HistoryActivity.class, R.anim.animation_fade_in, R.anim.animation_stop_short);
//        }
//    }
//
//
//    public void SettingClicked(View v) {
//        if (nowPage != SETTING_PAGE) {
//            startActivityClass(SettingActivity.class, R.anim.animation_fade_in, R.anim.animation_stop_short);
//        }
//    }

    //endregion

    //region TTS

    public TextToSpeech tts;
    public final Bundle params = new Bundle();
    public boolean isSpeech = false;
    public boolean isSpeechDuring = false;

    public int speechRepeatCount = 0;
    public int speechRepeatMax = SPEECH_REPEAT_MAX;
    public String speechRepeatContent = "";

    public void initTTS() {
        params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, null);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int state) {
                if (state == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.KOREAN);
                } else {
                    showToastMessage("TTS 객체 초기화 중 에러가 발생했습니다.");
                }

                tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                    @Override
                    public void onStart(String utteranceId) {
                        isSpeech = true;
                        onTTSStart();
                    }

                    @Override
                    public void onDone(String utteranceId) {
                        isSpeech = false;
                        onTTSDone();
                    }

                    @Override
                    public void onError(String utteranceId) {
                    }
                });
            }
        });
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != ERROR) {
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });
    }
    public void onTTSStart() {

    }
    public void onTTSDone() {

    }

    public void startSpeech(final String text) {
        isSpeechDuring = true;
        tts.stop();
        tts.speak(text, TextToSpeech.QUEUE_ADD, params, text);
    }
    public void stopSpeech() {
        isSpeechDuring = false;
        tts.stop();
    }
    public void destroySpeech() {
        if (tts !=null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }


    public void startSpeechRepeat(String text, int repeatMax) {
        speechRepeatCount = 0;
        speechRepeatMax = repeatMax;
        speechRepeatContent = text;
        speechRepeatHandler.sendEmptyMessage(0);
    }

    public void stopSpeechRepeat() {
        speechRepeatHandler.removeMessages(0);
        speechRepeatHandler.removeCallbacks(new Runnable() { // callback
            @Override
            public void run() {
                stopSpeech();
            }
        });
    }

    public Handler speechRepeatHandler = new Handler() {
        public void handleMessage(Message msg) {
            //region handleMessage
            speechRepeatCount++;
            if (speechRepeatCount > speechRepeatMax) {
                return;
            } else {
                startSpeech(speechRepeatContent);
                speechRepeatHandler.sendEmptyMessageDelayed(0, SPEECH_REPEAT_INTERVAL_TIME);
            }
            //endregion
        }
    };

    //endregion

    //region STT

    public Intent sttIntent;
    public SpeechRecognizer sRecognizer;
    public boolean isTalkDuring = false;

    public void initSTT() {
        sttIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        sttIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
        sttIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR");
        sRecognizer = SpeechRecognizer.createSpeechRecognizer(mContext);
        sRecognizer.setRecognitionListener(listener);
    }

    private RecognitionListener listener=new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle bundle) {
            Log.d(TAG, "onReadyForSpeech");
        }

        @Override
        public void onBeginningOfSpeech() {
            Log.d(TAG, "onBeginningOfSpeech");
        }

        @Override
        public void onRmsChanged(float v) {
//            Log.d(TAG, "onRmsChanged");
        }

        @Override
        public void onBufferReceived(byte[] bytes) {
            Log.d(TAG, "onBufferReceived");
        }

        @Override
        public void onEndOfSpeech() {
            Log.d(TAG, "onEndOfSpeech");
        }

        @Override
        public void onError(int i) {
            Log.d(TAG, "onError");
            if (isTalkDuring) {
                startTalk();
            }
        }

        @Override
        public void onResults(Bundle results) {
            String key= "";
            key = SpeechRecognizer.RESULTS_RECOGNITION;
            ArrayList<String> mResult =results.getStringArrayList(key);
            String[] rs = new String[mResult.size()];
            mResult.toArray(rs);
            sstResult(rs[0]);
            sRecognizer.startListening(sttIntent);
        }

        @Override
        public void onPartialResults(Bundle bundle) {
            Log.d(TAG, "onPartialResults");
        }

        @Override
        public void onEvent(int i, Bundle bundle) {
            Log.d(TAG, "onEvent");
        }
    };

    public void startTalk() {
        isTalkDuring = true;
        sRecognizer.startListening(sttIntent);
    }

    public void stopTalk() {
        isTalkDuring = false;
        if (sRecognizer != null) {
            sRecognizer.stopListening();
        }
    }

    public void destroyTalk() {
        if (sRecognizer != null) {
            sRecognizer.destroy();
            sRecognizer.cancel();
            sRecognizer = null;
        }
    }
    
    public void sstResult(String msg) {
        
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroySpeech();
        destroyTalk();
    }


    //endregion

    //region ToastMessage

    public static Toast mToast;

    public void setToastMessage() {
        mToast = Toast.makeText(mContext, "null", Toast.LENGTH_SHORT);
    }
    public void showToastMessage(String msg) {
        mToast.setText(msg);
        mToast.show();
    }
    public void showToastMessage(int id) {
        mToast.setText(id);
        mToast.show();
    }

    //endregion

    //region Preferences

    public int getUserPreferences(String key, int fault) {
        SharedPreferences pref = getSharedPreferences(USER_PREF_NAME, Activity.MODE_PRIVATE);
        return pref.getInt(key, fault);
    }
    public String getUserPreferences(String key, String fault) {
        SharedPreferences pref = getSharedPreferences(USER_PREF_NAME, Activity.MODE_PRIVATE);
        return pref.getString(key, fault);
    }
    public void setUserPreferences(String key, int value) {
        SharedPreferences pref = getSharedPreferences(USER_PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public void setUserPreferences(String key, String value) {
        SharedPreferences pref = getSharedPreferences(USER_PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public void clearUserPreferences() {
        SharedPreferences pref = getSharedPreferences(USER_PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public Boolean getCarPreferences(String key, boolean fault) {
        SharedPreferences pref = getSharedPreferences(CAR_PREF_NAME, Activity.MODE_PRIVATE);
        return pref.getBoolean(key, fault);
    }
    public int getCarPreferences(String key, int fault) {
        SharedPreferences pref = getSharedPreferences(CAR_PREF_NAME, Activity.MODE_PRIVATE);
        return pref.getInt(key, fault);
    }
    public Float getCarPreferences(String key, float fault) {
        SharedPreferences pref = getSharedPreferences(CAR_PREF_NAME, Activity.MODE_PRIVATE);
        return pref.getFloat(key, fault);
    }
    public String getCarPreferences(String key, String fault) {
        SharedPreferences pref = getSharedPreferences(CAR_PREF_NAME, Activity.MODE_PRIVATE);
        return pref.getString(key, fault);
    }
    public void setCarPreferences(String key, boolean value) {
        SharedPreferences pref = getSharedPreferences(CAR_PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public void setCarPreferences(String key, int value) {
        SharedPreferences pref = getSharedPreferences(CAR_PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public void setCarPreferences(String key, float value) {
        SharedPreferences pref = getSharedPreferences(CAR_PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat(key, value);
        editor.apply();
    }
    public void setCarPreferences(String key, String value) {
        SharedPreferences pref = getSharedPreferences(CAR_PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public void clearCarPreferences() {
        SharedPreferences pref = getSharedPreferences(CAR_PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public int getDevicePreferences(String key, int fault) {
        SharedPreferences pref = getSharedPreferences(DEVICE_PREF_NAME, Activity.MODE_PRIVATE);
        return pref.getInt(key, fault);
    }
    public String getDevicePreferences(String key, String fault) {
        SharedPreferences pref = getSharedPreferences(DEVICE_PREF_NAME, Activity.MODE_PRIVATE);
        return pref.getString(key, fault);
    }
    public void setDevicePreferences(String key, int value) {
        SharedPreferences pref = getSharedPreferences(DEVICE_PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public void setDevicePreferences(String key, String value) {
        SharedPreferences pref = getSharedPreferences(DEVICE_PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    //endregion

    //region Theme

    public static void setStatusBarColor(Activity activity, int colorId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, colorId));
        }
    }

    //endregion

    //region Keyboard

    public boolean isKeyboardHide = true;

    @Override // hide keyboard when touch outside
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit."))
        {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom()) { // when touch outside
                if (isKeyboardHide) {
                    hideSoftKeyboard(mActivity);
                    clearFocusBundle();
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }
    public static void hideSoftKeyboard(Activity activity) { // hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
    public void clearFocusBundle() {

    }

    //endregion

    //region AppExit

    public long backKeyPressedTime;

    public void exitApp() {
        long nowTime = System.currentTimeMillis();
        if (nowTime > backKeyPressedTime + BACK_KEY_DELAY_TIME) {
            backKeyPressedTime = nowTime;
            showToastMessage(R.string.msg_app_exit);

        } else if (nowTime <= backKeyPressedTime + BACK_KEY_DELAY_TIME) {
            mToast.cancel();
            ActivityCompat.finishAffinity(mActivity);
        }
    }

    public void killApp() {
        ActivityCompat.finishAffinity(mActivity);
    }

    //endregion

}
