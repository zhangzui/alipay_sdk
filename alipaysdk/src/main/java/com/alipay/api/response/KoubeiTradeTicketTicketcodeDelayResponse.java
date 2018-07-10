package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: koubei.trade.ticket.ticketcode.delay response.
 * 
 * @author auto create
 * @since 1.0, 2018-05-21 11:33:24
 */
public class KoubeiTradeTicketTicketcodeDelayResponse extends AlipayResponse {

	private static final long serialVersionUID = 8852972351587593754L;

	/** 
	 * 该字段用于描述本次返回中的业务属性，现有：BIZ_ALREADY_SUCCESS（幂等业务码）。
	 */
	@ApiField("biz_code")
	private String bizCode;

	/** 
	 * 请求id，唯一标识一次请求
	 */
	@ApiField("request_id")
	private String requestId;

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	public String getBizCode( ) {
		return this.bizCode;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRequestId( ) {
		return this.requestId;
	}

}
