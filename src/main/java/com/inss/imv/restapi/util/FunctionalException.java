package com.inss.imv.restapi.util;

import lombok.Getter;

public class FunctionalException extends Exception {
    @Getter
    private ExceptionEnum exceptionEnum;

    @Getter
    private String detail;

    public FunctionalException(String message, ExceptionEnum exceptionEnum) {
        super(message);
        this.exceptionEnum = exceptionEnum;
    }

    public FunctionalException(String message, ExceptionEnum exceptionEnum, String detail) {
        super(message);
        this.exceptionEnum = exceptionEnum;
        this.detail = detail;
    }
}
