/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zz.simple.sdk.handle;

import com.zz.simple.sdk.common.OpenApiRuntimeException;
import com.zz.simple.sdk.utils.EncryptUtils;


public class DefaultDecryptor implements Decryptor {

    private String encryptKey;

    public DefaultDecryptor(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    @Override
    public String decrypt(String encryptContent, String encryptType, String charset) {
        String decryptContent = null;
        try {
            decryptContent = EncryptUtils.decryptContent(encryptContent, encryptType,
                    encryptKey, charset);
        } catch (OpenApiRuntimeException e) {
            throw new RuntimeException(e);
        }
        return decryptContent;
    }

    /**
     * Getter method for property <tt>encryptKey</tt>.
     *
     * @return property value of encryptKey
     */
    public String getEncryptKey() {
        return encryptKey;
    }

    /**
     * Setter method for property <tt>encryptKey</tt>.
     *
     * @param encryptKey  value to be assigned to property encryptKey
     */
    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }
}