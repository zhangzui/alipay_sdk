package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 券状态查询
 *
 * @author auto create
 * @since 1.0, 2018-01-12 10:57:57
 */
public class AlipayOfflineMarketingVoucherStatusQueryModel extends AlipayObject {

	private static final long serialVersionUID = 6294861187624441564L;

	/**
	 * 外部流水号
	 */
	@ApiField("out_biz_no")
	private String outBizNo;

	/**
	 * 券模板id
	 */
	@ApiField("voucher_id")
	private String voucherId;

	public String getOutBizNo() {
		return this.outBizNo;
	}
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	public String getVoucherId() {
		return this.voucherId;
	}
	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

}
