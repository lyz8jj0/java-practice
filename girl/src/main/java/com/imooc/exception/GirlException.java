package com.imooc.exception;

public class GirlException extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public GirlException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
