package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 业务参数的KeyValue键值对
 *
 * @author auto create
 * @since 1.0, 2018-01-31 22:13:25
 */
public class BizParamKeyValue extends AlipayObject {

	private static final long serialVersionUID = 5739779759428768451L;

	/**
	 * 参数名key
	 */
	@ApiField("key")
	private String key;

	/**
	 * 参数值value
	 */
	@ApiField("value")
	private String value;

	public String getKey() {
		return this.key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
