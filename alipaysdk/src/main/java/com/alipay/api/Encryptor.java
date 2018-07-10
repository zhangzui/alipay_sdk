/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.api;

/**
 * 加密器接口
 *
 * @author liuqun.lq
 */
public interface Encryptor {


    String encrypt(String sourceContent, String encryptType, String charset);
}