/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zz.simple.sdk.handle;

import com.zz.simple.sdk.common.OpenApiRuntimeException;
import com.zz.simple.sdk.utils.SignUtils;

/**
 * 默认加签器
 *
 * @author liuqun.lq
 */
public class DefaultSigner implements Signer {

    private String privateKey;

    public DefaultSigner(String privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public String sign(String sourceContent, String signType, String charset) {
        String sign = null;
        try {
            sign = SignUtils.rsaSign(sourceContent, this.privateKey, charset, signType);
        } catch (OpenApiRuntimeException e) {
            throw new RuntimeException(e);
        }
        return sign;
    }

    /**
     * Getter method for property <tt>privateKey</tt>.
     *
     * @return property value of privateKey
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * Setter method for property <tt>privateKey</tt>.
     *
     * @param privateKey  value to be assigned to property privateKey
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}