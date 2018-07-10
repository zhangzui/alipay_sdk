package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * H5刷脸认证查询
 *
 * @author auto create
 * @since 1.0, 2018-03-05 11:29:09
 */
public class ZolozIdentificationUserWebQueryModel extends AlipayObject {

	private static final long serialVersionUID = 8462971314656117861L;

	/**
	 * 商户请求的唯一标识，须与初始化传入的bizId保持一致
	 */
	@ApiField("biz_id")
	private String bizId;

	/**
	 * 扩展参数
	 */
	@ApiField("extern_param")
	private String externParam;

	/**
	 * 刷脸认证的唯一标识，用于查询认证结果
	 */
	@ApiField("zim_id")
	private String zimId;

	public String getBizId() {
		return this.bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getExternParam() {
		return this.externParam;
	}
	public void setExternParam(String externParam) {
		this.externParam = externParam;
	}

	public String getZimId() {
		return this.zimId;
	}
	public void setZimId(String zimId) {
		this.zimId = zimId;
	}

}
