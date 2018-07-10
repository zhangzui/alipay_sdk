package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 云凤蝶站点所有者的模型
 *
 * @author auto create
 * @since 1.0, 2018-05-17 16:00:54
 */
public class FengdieSitesOwner extends AlipayObject {

	private static final long serialVersionUID = 4363249672613281757L;

	/**
	 * 创建者的昵称
	 */
	@ApiField("nick")
	private String nick;

	/**
	 * 云凤蝶空间成员所关联的第三方用户ID
	 */
	@ApiField("origin_user_id")
	private String originUserId;

	public String getNick() {
		return this.nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getOriginUserId() {
		return this.originUserId;
	}
	public void setOriginUserId(String originUserId) {
		this.originUserId = originUserId;
	}

}