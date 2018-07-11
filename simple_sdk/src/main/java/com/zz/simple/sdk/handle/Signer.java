/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zz.simple.sdk.handle;

/**
 *加签器接口
 */
public interface Signer {

    String sign(String sourceContent, String signType, String charset);
}