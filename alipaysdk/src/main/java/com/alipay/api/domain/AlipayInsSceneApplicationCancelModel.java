package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 投保订单出单撤销
 *
 * @author auto create
 * @since 1.0, 2018-03-08 18:09:21
 */
public class AlipayInsSceneApplicationCancelModel extends AlipayObject {

	private static final long serialVersionUID = 6778881493429233581L;

	/**
	 * 投保订单号
	 */
	@ApiField("application_no")
	private String applicationNo;

	public String getApplicationNo() {
		return this.applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

}
