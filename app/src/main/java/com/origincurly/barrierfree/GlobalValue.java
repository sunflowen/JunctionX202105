package com.origincurly.barrierfree;

public interface GlobalValue {
    String TAG = "DOORICARLOG";

    //Main info
    int NOW_VERSION_CODE = 1;
    String NOW_VERSION_NAME = "1.0.0";
    String PACKAGE_NAME = "com.dooricar.dooricar";

    //URL info
    String API_URL = "http://www.origincurly.com/_api";

    //preference
    String USER_PREF_NAME = "UserInfo";

    String USER_PREF_KEY_LOGIN_STATE = "loginState";
    String USER_PREF_KEY_CAR_ID = "carId";
    String USER_PREF_KEY_CAR_UUID = "carUUIDCode";
    String USER_PREF_KEY_CAR_REGISTER_CODE = "carRegisterCode";

    String USER_PREF_KEY_DRIVER_1_NAME = "driver1Name";
    String USER_PREF_KEY_DRIVER_2_NAME = "driver2NAme";


    String USER_PREF_DEFAULT_CAR_ID = "";
    String USER_PREF_DEFAULT_CAR_UUID = "";
    String USER_PREF_DEFAULT_CAR_REGISTER_CODE = "";
    String USER_PREF_DEFAULT_DRIVER_1_NAME = "DRIVER1";
    String USER_PREF_DEFAULT_DRIVER_2_NAME = "DRIVER2";


    // car Preference
    String CAR_PREF_NAME = "CarInfo";

    String CAR_PREF_KEY_ENGINE_STATUS = "engineStatus";
    String CAR_PREF_KEY_DRIVE_STATUS = "driveStatus";
    String CAR_PREF_KEY_OIL_LEVEL = "oilLevel";

    String CAR_PREF_KEY_DRIVER_NO = "driverNo";
    String CAR_PREF_KEY_DRIVER_EXPIRE = "driverExpire";

    String CAR_PREF_KEY_HISTORY_ID = "historyId";


    int CAR_PREF_DEFAULT_ENGINE_STATUS = 0;
    int CAR_PREF_DEFAULT_DRIVE_STATUS = 0;
    float CAR_PREF_DEFAULT_OIL_LEVEL = 0.0f;

    int CAR_PREF_DEFAULT_HISTORY_ID = 0;


    // device Preference
    String DEVICE_PREF_NAME = "DeviceInfo";

    String DEVICE_PREF_KEY_PUSH_STATUS = "push";
    String DEVICE_PREF_KEY_UPDATE_PERIOD = "updatePeriod";

    int DEVICE_PREF_DEFAULT_UPDATE_PERIOD = 30000;
    //


    // enum value
    int ENGINE_ON = 1;
    int ENGINE_OFF = 0;

    int DRIVE_ON = 1;
    int DRIVE_OFF = 0;

    int DRIVER_DEFAULT = 0;
    int DRIVER_1 = 1;
    int DRIVER_2 = 2;
    String DRIVER_DEFAULT_NAME = "UNKNOWN";

    int LOGIN_STATE_NULL = 0;
    int LOGIN_STATE_SUCCESS = 1;

    String OIL_DEFAULT_UNIT = "%";


    // set value

    //time
    int SPEECH_REPEAT_MAX = 3;
    int SPEECH_REPEAT_INTERVAL_TIME = 5000;

    int INTRO_DELAY_TIME = 1500;
    int BACK_KEY_DELAY_TIME = 2000;

    int WATCH_INTERVAL_TIME = 1000;
    int INIT_INTERVAL_TIME = 1000;
    //long DRIVER_EXPIRE_TIME = 1800000;
    long DRIVER_EXPIRE_TIME = 5000;

    //page info
    int DRIVE_PAGE = 1;
    int HISTORY_PAGE = 2;
    int SETTING_PAGE = 3;

    //RequestCode
    int GOOGLE_STORE_ACTIVITY = 100;
    int FRAME_ACTIVITY = 200;
    int DETAIL_ACTIVITY = 300;

}