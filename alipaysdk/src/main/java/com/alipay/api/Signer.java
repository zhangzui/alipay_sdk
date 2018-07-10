/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.api;

/**
 *加签器接口
 */
public interface Signer {

    String sign(String sourceContent, String signType, String charset);
}