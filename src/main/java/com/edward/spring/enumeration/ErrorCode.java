package com.edward.spring.enumeration;

import lombok.Getter;

public enum ErrorCode {

    SUCCESS("0", "suc"),
    SYSTEM_ERROR("1001", "System error"),
    INVALID_PARAMETER("1002", "Invalid parameter");





    @Getter private final String code;
    @Getter private final String description;
    ErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
