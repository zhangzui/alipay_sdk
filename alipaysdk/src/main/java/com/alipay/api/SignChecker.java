/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.api;

/**
 * 验签器接口
 *
 * @author liuqun.lq
 * @version $Id: SignChecker.java, v 0.1 2018��07��03�� 11:38 liuqun.lq Exp $
 */
public interface SignChecker {

    boolean check(String sourceContent, String signature, String signType, String charset);
}