/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.zz.simple.sdk.common;


/**
 * 
 * @author runzhi
 */
public class OpenApiRuntimeException extends Exception {

    private static final long serialVersionUID = -238091758285157331L;

    private String            errCode;
    private String            errMsg;

    public OpenApiRuntimeException() {
        super();
    }

    public OpenApiRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenApiRuntimeException(String message) {
        super(message);
    }

    public OpenApiRuntimeException(Throwable cause) {
        super(cause);
    }

    public OpenApiRuntimeException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}