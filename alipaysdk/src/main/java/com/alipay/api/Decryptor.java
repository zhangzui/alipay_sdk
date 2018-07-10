/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.api;

/**
 * 解密器接口
 *
 * @author liuqun.lq
 * @version $Id: Decryptor.java, v 0.1 2018��07��03�� 11:44 liuqun.lq Exp $
 */
public interface Decryptor {

    String decrypt(String encryptContent, String encryptType, String charset);
}