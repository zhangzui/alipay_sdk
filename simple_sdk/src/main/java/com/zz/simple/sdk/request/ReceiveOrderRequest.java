package com.zz.simple.sdk.request;

import com.zz.simple.sdk.domain.RequestBaseVo;

/**
 * @author zhangzuizui
 * @date 2018/7/11 12:10
 */
public class ReceiveOrderRequest extends RequestBaseVo {

    private String OrderId;

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }
}
