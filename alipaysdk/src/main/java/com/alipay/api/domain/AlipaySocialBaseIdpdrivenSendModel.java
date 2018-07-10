package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 数据驱动-外部触发事件
 *
 * @author auto create
 * @since 1.0, 2018-04-16 15:26:04
 */
public class AlipaySocialBaseIdpdrivenSendModel extends AlipayObject {

	private static final long serialVersionUID = 3897567864476723286L;

	/**
	 * 参数名：asset_id
是否唯一：不唯一
应用场景：用于对应IDP中相关的资产id
如何获取：由开发小二配置后分配
	 */
	@ApiField("asset_id")
	private String assetId;

	/**
	 * 参数名：data
是否唯一：不唯一
应用场景：用于数据触发的参数信息，具体参数内容与开发小二约定
如何获取：商户的触发事件业务信息，通过文档约定字段
	 */
	@ApiField("data")
	private String data;

	/**
	 * 参数名：data_time
是否唯一：不唯一
应用场景：用于判断用户触发事件真实时间
如何获取：外部商户系统中用户触发事件的系统时间
	 */
	@ApiField("data_time")
	private Long dataTime;

	public String getAssetId() {
		return this.assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getData() {
		return this.data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public Long getDataTime() {
		return this.dataTime;
	}
	public void setDataTime(Long dataTime) {
		this.dataTime = dataTime;
	}

}
