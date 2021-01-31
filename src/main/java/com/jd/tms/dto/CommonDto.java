package com.jd.tms.dto;

import lombok.Data;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 15:02
 */
@Data
public class CommonDto<T> {

    private Integer code;

    private T data;

    private String message;

    public CommonDto() {}

    public CommonDto(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <T> CommonDto<T> constructWithWarnMessage(String message) {
        return new CommonDto<>(COMMON_WARN, null, message);
    }

    public static <T> CommonDto<T> constructWithNormalMessage(String message, T data) {
        return new CommonDto<>(COMMON_NORMAL, data, message);
    }

    public static <T> CommonDto<T> constructWithExpMessage(String message) {
        return new CommonDto<>(COMMON_EXCEPTION, null, message);
    }

    public static final Integer COMMON_WARN = 20;
    public static final Integer COMMON_NORMAL = 10;
    public static final Integer COMMON_EXCEPTION = 30;
}
