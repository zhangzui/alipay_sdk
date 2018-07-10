package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 口碑菜品项目组
 *
 * @author auto create
 * @since 1.0, 2018-05-08 15:10:09
 */
public class KbdishGroupInfo extends AlipayObject {

	private static final long serialVersionUID = 3666647623575729295L;

	/**
	 * 操作员
	 */
	@ApiField("create_user")
	private String createUser;

	/**
	 * 套餐组明细
	 */
	@ApiListField("detail_list")
	@ApiField("kbdish_group_detail_info")
	private List<KbdishGroupDetailInfo> detailList;

	/**
	 * 组id
	 */
	@ApiField("group_id")
	private String groupId;

	/**
	 * 组名称
	 */
	@ApiField("group_name")
	private String groupName;

	/**
	 * 预留字段
	 */
	@ApiField("group_rule")
	private String groupRule;

	/**
	 * 版本号 就是一个数据操作的时间戳
	 */
	@ApiField("group_version")
	private String groupVersion;

	/**
	 * 商户id
	 */
	@ApiField("merchant_id")
	private String merchantId;

	/**
	 * open 启动 stop 停用
	 */
	@ApiField("status")
	private String status;

	/**
	 * 份数限制
	 */
	@ApiField("unit_count_limit")
	private String unitCountLimit;

	/**
	 * 修改操作小二
	 */
	@ApiField("update_user")
	private String updateUser;

	public String getCreateUser() {
		return this.createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public List<KbdishGroupDetailInfo> getDetailList() {
		return this.detailList;
	}
	public void setDetailList(List<KbdishGroupDetailInfo> detailList) {
		this.detailList = detailList;
	}

	public String getGroupId() {
		return this.groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupRule() {
		return this.groupRule;
	}
	public void setGroupRule(String groupRule) {
		this.groupRule = groupRule;
	}

	public String getGroupVersion() {
		return this.groupVersion;
	}
	public void setGroupVersion(String groupVersion) {
		this.groupVersion = groupVersion;
	}

	public String getMerchantId() {
		return this.merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getUnitCountLimit() {
		return this.unitCountLimit;
	}
	public void setUnitCountLimit(String unitCountLimit) {
		this.unitCountLimit = unitCountLimit;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
