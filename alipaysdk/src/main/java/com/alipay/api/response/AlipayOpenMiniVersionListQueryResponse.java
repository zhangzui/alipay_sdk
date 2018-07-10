package com.alipay.api.response;

import java.util.List;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.open.mini.version.list.query response.
 * 
 * @author auto create
 * @since 1.0, 2018-01-15 14:19:28
 */
public class AlipayOpenMiniVersionListQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3297219953284843372L;

	/** 
	 * 小程序的版本号列表
	 */
	@ApiListField("app_versions")
	@ApiField("string")
	private List<String> appVersions;

	public void setAppVersions(List<String> appVersions) {
		this.appVersions = appVersions;
	}
	public List<String> getAppVersions( ) {
		return this.appVersions;
	}

}
