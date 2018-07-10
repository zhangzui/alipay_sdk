package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * OpenApiRoyaltyDetailInfoPojo
 *
 * @author auto create
 * @since 1.0, 2018-05-11 10:43:52
 */
public class OpenApiRoyaltyDetailInfoPojo extends AlipayObject {

	private static final long serialVersionUID = 4274148627994383727L;

	/**
	 * 分账的金额，单位为元
	 */
	@ApiField("amount")
	private Long amount;

	/**
	 * 分账信息中分账百分比。取值范围为大于0，少于或等于100的整数。
	 */
	@ApiField("amount_percentage")
	private Long amountPercentage;

	/**
	 * 分账描述
	 */
	@ApiField("desc")
	private String desc;

	/**
	 * 分账类型.
普通分账为：transfer;
补差为：replenish;
为空默认为分账transfer;
	 */
	@ApiField("royalty_type")
	private String royaltyType;

	/**
	 * 收入方账户。如果收入方账户类型为userId，本参数为收入方的支付宝账号对应的支付宝唯一用户号，以2088开头的纯16位数字；如果收入方类型为cardSerialNo，本参数为收入方在支付宝绑定的卡编号；如果收入方类型为loginName，本参数为收入方的支付宝登录号；
	 */
	@ApiField("trans_in")
	private String transIn;

	/**
	 * 收入方账户类型。userId表示是支付宝账号对应的支付宝唯一用户号;cardSerialNo表示是卡编号;loginName表示是支付宝登录号；
	 */
	@ApiField("trans_in_type")
	private String transInType;

	/**
	 * 支出方账户。如果支出方账户类型为userId，本参数为支出方的支付宝账号对应的支付宝唯一用户号，以2088开头的纯16位数字；如果支出方类型为loginName，本参数为支出方的支付宝登录号；
	 */
	@ApiField("trans_out")
	private String transOut;

	/**
	 * 支出方账户类型。userId表示是支付宝账号对应的支付宝唯一用户号;loginName表示是支付宝登录号；
	 */
	@ApiField("trans_out_type")
	private String transOutType;

	public Long getAmount() {
		return this.amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getAmountPercentage() {
		return this.amountPercentage;
	}
	public void setAmountPercentage(Long amountPercentage) {
		this.amountPercentage = amountPercentage;
	}

	public String getDesc() {
		return this.desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRoyaltyType() {
		return this.royaltyType;
	}
	public void setRoyaltyType(String royaltyType) {
		this.royaltyType = royaltyType;
	}

	public String getTransIn() {
		return this.transIn;
	}
	public void setTransIn(String transIn) {
		this.transIn = transIn;
	}

	public String getTransInType() {
		return this.transInType;
	}
	public void setTransInType(String transInType) {
		this.transInType = transInType;
	}

	public String getTransOut() {
		return this.transOut;
	}
	public void setTransOut(String transOut) {
		this.transOut = transOut;
	}

	public String getTransOutType() {
		return this.transOutType;
	}
	public void setTransOutType(String transOutType) {
		this.transOutType = transOutType;
	}

}
