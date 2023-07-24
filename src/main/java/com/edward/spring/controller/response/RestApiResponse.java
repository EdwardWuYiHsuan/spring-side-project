package com.edward.spring.controller.response;

import com.edward.spring.enumeration.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
public class RestApiResponse<T> {

    private final String code;
    private final String desc;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String extra;

    public RestApiResponse(ErrorCode errorCode, T data) {
        this.code = errorCode.getCode();
        this.desc = errorCode.getDescription();
        this.data = data;
    }

    public RestApiResponse(ErrorCode errorCode, String extra) {
        this.code = errorCode.getCode();
        this.desc = errorCode.getDescription();
        this.extra = extra;
    }

    public static <T> RestApiResponse<T> success(T data) {
        return new RestApiResponse<>(ErrorCode.SUCCESS, data);
    }

    public static <T> RestApiResponse<T> create(ErrorCode errorCode, T data) {
        return new RestApiResponse<>(errorCode, data);
    }

    public static <T> RestApiResponse<T> create(ErrorCode errorCode, String extra) {
        return new RestApiResponse<>(errorCode, extra);
    }
}
