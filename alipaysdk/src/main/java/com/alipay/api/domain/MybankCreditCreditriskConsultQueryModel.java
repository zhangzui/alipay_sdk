package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 咨询各个场景是否准入
 *
 * @author auto create
 * @since 1.0, 2018-06-05 20:10:26
 */
public class MybankCreditCreditriskConsultQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4641982388369796773L;

	/**
	 * 关联实体，咨询者可以添加一些关联实体比方说一个企业、一个会员账号、一个自然人等来作为咨询材料辅助咨询判断
	 */
	@ApiListField("associate_entitys")
	@ApiField("involved_entity")
	private List<InvolvedEntity> associateEntitys;

	/**
	 * 扩展数据（map转换为json字符串）
	 */
	@ApiField("ext_par")
	private String extPar;

	/**
	 * 银行参与者id，是在网商银行创建会员后生成的id，网商银行会员的唯一标识
	 */
	@ApiField("ip_id")
	private String ipId;

	/**
	 * 银行参与者角色id，是在网商银行创建会员后生成的角色id，网商银行会员角色的唯一标识
	 */
	@ApiField("ip_role_id")
	private String ipRoleId;

	/**
	 * 产品码，授信前准入咨询则为运营产品码，支用准入时可不用传
	 */
	@ApiField("pd_code")
	private String pdCode;

	/**
	 * 场景码，表示本次查询应用于哪个场景。目前已有枚举以及对应场景：
1：授信申请前准入判断，2：支用申请准入，3：产品层可贷额度查询
	 */
	@ApiField("scen")
	private String scen;

	/**
	 * 站点类型。枚举ALIPAY,TAOBAO,B2B_CN,B2B_EN,HAVANA,ALICLOUD_CN,DINGDING,ZM,MYBANK,IPAY等
	 */
	@ApiField("site")
	private String site;

	/**
	 * 站点登录账号
	 */
	@ApiField("site_login_id")
	private String siteLoginId;

	/**
	 * 站点ID。咨询的客户在对应站点拥有的角色的ID。比方说站点是ALIPAY的话站点ID就是ALIPAY的ID。
	 */
	@ApiField("site_user_id")
	private String siteUserId;

	public List<InvolvedEntity> getAssociateEntitys() {
		return this.associateEntitys;
	}
	public void setAssociateEntitys(List<InvolvedEntity> associateEntitys) {
		this.associateEntitys = associateEntitys;
	}

	public String getExtPar() {
		return this.extPar;
	}
	public void setExtPar(String extPar) {
		this.extPar = extPar;
	}

	public String getIpId() {
		return this.ipId;
	}
	public void setIpId(String ipId) {
		this.ipId = ipId;
	}

	public String getIpRoleId() {
		return this.ipRoleId;
	}
	public void setIpRoleId(String ipRoleId) {
		this.ipRoleId = ipRoleId;
	}

	public String getPdCode() {
		return this.pdCode;
	}
	public void setPdCode(String pdCode) {
		this.pdCode = pdCode;
	}

	public String getScen() {
		return this.scen;
	}
	public void setScen(String scen) {
		this.scen = scen;
	}

	public String getSite() {
		return this.site;
	}
	public void setSite(String site) {
		this.site = site;
	}

	public String getSiteLoginId() {
		return this.siteLoginId;
	}
	public void setSiteLoginId(String siteLoginId) {
		this.siteLoginId = siteLoginId;
	}

	public String getSiteUserId() {
		return this.siteUserId;
	}
	public void setSiteUserId(String siteUserId) {
		this.siteUserId = siteUserId;
	}

}
