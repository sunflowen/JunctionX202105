package com.origincurly.barrierfree;

public interface GlobalValue {
    String TAG = "BARRIER_FREE";

    //Main info
    int NOW_VERSION_CODE = 1;
    String NOW_VERSION_NAME = "1.0.0";
    String PACKAGE_NAME = "com.origincurly.barrierfree";

    //URL info
    String API_URL = "http://www.origincurly.com/_api";

    //preference
    String USER_PREF_NAME = "UserInfo";

    String USER_PREF_KEY_LOGIN_STATE = "loginState";
    String USER_PREF_KEY_USER_ID = "userId";

    String USER_PREF_DEFAULT_USER_ID = "";

    // device Preference
    String DEVICE_PREF_NAME = "DeviceInfo";

    String DEVICE_PREF_KEY_PUSH_STATUS = "push";

    // enum value
    int LOGIN_STATE_NULL = 0;
    int LOGIN_STATE_SUCCESS = 1;

    //time
    int SPEECH_REPEAT_MAX = 3;
    int SPEECH_REPEAT_INTERVAL_TIME = 5000;
    int ANIM_INTERVAL_TIME = 5000;

    int ANIM_DELAY_TIME = 300;
    int INTRO_DELAY_TIME = 1500;
    int BACK_KEY_DELAY_TIME = 2000;

    //RequestCode
    int PERMISSION_REQUEST = 100;
    int TALK_ACTIVITY = 200;
    int DETAIL_ACTIVITY = 300;

}