/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zz.simple.sdk.handle;


import com.zz.simple.sdk.common.OpenApiRuntimeException;
import com.zz.simple.sdk.utils.SignUtils;

/**
 *
 * @author liuqun.lq
 */
public class DefaultSignChecker implements SignChecker {

    private String alipayPublicKey;

    public DefaultSignChecker(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    @Override
    public boolean check(String sourceContent, String signature, String signType, String charset) {
        boolean success = false;
        try {
            success = SignUtils.rsaCheck(sourceContent, signature, alipayPublicKey, charset, signType);
        } catch (OpenApiRuntimeException e) {
            throw new RuntimeException(e);
        }
        return success;
    }

    /**
     * Getter method for property <tt>alipayPublicKey</tt>.
     *
     * @return property value of alipayPublicKey
     */
    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    /**
     * Setter method for property <tt>alipayPublicKey</tt>.
     *
     * @param alipayPublicKey  value to be assigned to property alipayPublicKey
     */
    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }
}