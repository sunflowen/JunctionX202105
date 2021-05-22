package com.origincurly.barrierfree.util;

public enum ErrorCodeEnum {

    CODE_ERROR_NULL(-9999), // 에러 자체가 없을 때 : 문제가 없는경우

    CODE_NORMAL(1),
    CODE_LOGIN_SUCCESS(1000), // 로그인 성공
    CODE_PW_CHANGE_SUCCESS(1007), // 비밀번호 변경 성공
    CODE_NEED_LOGOUT(1010), // 로그인 상태에서는 이용하실 수 없습니다.
    CODE_NO_SESSION(1011), // 로그인 상태가 아닙니다. 로그인 하셔야합니다. (시간이 지나 세션이 만료됨)
    CODE_NEED_LOGIN(1012), // 로그인 상태가 아닙니다. 다시 로그인 하셔야 합니다.
    CODE_TOKEN_FAIL(1013), // 로그인 시도를 했지만, 토큰이 다를 때 (중복로그인)
    CODE_LOGOUT(1020), // 유저 로그아웃 실행
    CODE_UNKNOWN(-1);

    public final int value;

    ErrorCodeEnum(int v) {
        value = v;
    }

    public static ErrorCodeEnum int2Enum(int value) {
        for (ErrorCodeEnum response : values()) {
            if (response.value == value) {
                return response;
            }
        }
        return CODE_UNKNOWN;
    }

    public static ErrorCodeEnum string2Enum(String value) {
        for (ErrorCodeEnum response : values()) {
            if (response.value == Integer.parseInt(value)) {
                return response;
            }
        }
        return CODE_UNKNOWN;
    }
}