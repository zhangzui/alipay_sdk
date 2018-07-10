package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 直付通二级商户修改
 *
 * @author auto create
 * @since 1.0, 2018-05-18 16:52:53
 */
public class AntMerchantExpandIndirectZftModifyModel extends AlipayObject {

	private static final long serialVersionUID = 3817333485476185979L;

	/**
	 * 商户别名
	 */
	@ApiField("alias_name")
	private String aliasName;

	/**
	 * 商户支付宝账号（如果有）
	 */
	@ApiField("alipay_logon_id")
	private String alipayLogonId;

	/**
	 * 商户结算卡信息。本业务当前只允许传入一张结算卡
	 */
	@ApiListField("biz_cards")
	@ApiField("settle_card_info")
	private List<SettleCardInfo> bizCards;

	/**
	 * 经营地址。地址对象中省、市、区、地址必填，其余选填
	 */
	@ApiField("business_address")
	private AddressInfo businessAddress;

	/**
	 * 商户联系人信息。在本业务中，ContactInfo对象中名称，类型、手机号必填，其他选填
	 */
	@ApiListField("contact_infos")
	@ApiField("contact_info")
	private List<ContactInfo> contactInfos;

	/**
	 * 商户编号，由机构定义，需要保证在机构下唯一。与smid二选一必填
	 */
	@ApiField("external_id")
	private String externalId;

	/**
	 * 开票资料信息
	 */
	@ApiField("invoice_info")
	private MerchantInvoiceInfo invoiceInfo;

	/**
	 * 法人身份证反面url，其值为使用ant.merchant.expand.indirect.image.upload上传图片得到的一串oss key。本业务接口中，如果是特殊行业必填
	 */
	@ApiField("legal_cert_back_image")
	private String legalCertBackImage;

	/**
	 * 法人身份证正面url，其值为使用ant.merchant.expand.indirect.image.upload上传图片得到的一串oss key。本业务接口中，如果是特殊行业必填
	 */
	@ApiField("legal_cert_front_image")
	private String legalCertFrontImage;

	/**
	 * 法人身份证号
	 */
	@ApiField("legal_cert_no")
	private String legalCertNo;

	/**
	 * 法人名称
	 */
	@ApiField("legal_name")
	private String legalName;

	/**
	 * 营业执照授权函。其值为使用ant.merchant.expand.indirect.image.upload上传图片得到的一串oss key。当商户名与结算卡户名不一致时必填
	 */
	@ApiField("license_auth_letter_image")
	private String licenseAuthLetterImage;

	/**
	 * 商户类别码mcc，参见附件描述中的“类目code”  https://mif-pub.alipayobjects.com/AlipayMCC.xlsx
	 */
	@ApiField("mcc")
	private String mcc;

	/**
	 * 商家类型：01：企业；02：事业单位
	 */
	@ApiField("merchant_type")
	private String merchantType;

	/**
	 * 进件的二级商户名称
	 */
	@ApiField("name")
	private String name;

	/**
	 * 门头照，其值为使用ant.merchant.expand.indirect.image.upload上传图片得到的一串oss key。如果使用当面付服务则必填
	 */
	@ApiListField("out_door_images")
	@ApiField("string")
	private List<String> outDoorImages;

	/**
	 * 商户行业资质，当商户是特殊行业时必填
	 */
	@ApiListField("qualifications")
	@ApiField("industry_qualification_info")
	private List<IndustryQualificationInfo> qualifications;

	/**
	 * 商户使用服务，可选值有：当面付、app支付、wap支付、电脑支付
	 */
	@ApiListField("service")
	@ApiField("string")
	private List<String> service;

	/**
	 * 客服电话
	 */
	@ApiField("service_phone")
	private String servicePhone;

	/**
	 * 二级商户与服务商的签约时间
	 */
	@ApiField("sign_time_with_isv")
	private String signTimeWithIsv;

	/**
	 * 商户站点信息，包括网站、app、小程序。
商户使用服务包含电脑支付或wap支付时，必须填充一个类型为01(网站)的SiteInfo对象；
当包含app支付时，必须至少填充类型为02(APP)或06(支付宝小程序)中一种类型的SiteInfo对象
	 */
	@ApiListField("sites")
	@ApiField("site_info")
	private List<SiteInfo> sites;

	/**
	 * 二级商户id。与external_id二选一必填
	 */
	@ApiField("smid")
	private String smid;

	public String getAliasName() {
		return this.aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getAlipayLogonId() {
		return this.alipayLogonId;
	}
	public void setAlipayLogonId(String alipayLogonId) {
		this.alipayLogonId = alipayLogonId;
	}

	public List<SettleCardInfo> getBizCards() {
		return this.bizCards;
	}
	public void setBizCards(List<SettleCardInfo> bizCards) {
		this.bizCards = bizCards;
	}

	public AddressInfo getBusinessAddress() {
		return this.businessAddress;
	}
	public void setBusinessAddress(AddressInfo businessAddress) {
		this.businessAddress = businessAddress;
	}

	public List<ContactInfo> getContactInfos() {
		return this.contactInfos;
	}
	public void setContactInfos(List<ContactInfo> contactInfos) {
		this.contactInfos = contactInfos;
	}

	public String getExternalId() {
		return this.externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public MerchantInvoiceInfo getInvoiceInfo() {
		return this.invoiceInfo;
	}
	public void setInvoiceInfo(MerchantInvoiceInfo invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}

	public String getLegalCertBackImage() {
		return this.legalCertBackImage;
	}
	public void setLegalCertBackImage(String legalCertBackImage) {
		this.legalCertBackImage = legalCertBackImage;
	}

	public String getLegalCertFrontImage() {
		return this.legalCertFrontImage;
	}
	public void setLegalCertFrontImage(String legalCertFrontImage) {
		this.legalCertFrontImage = legalCertFrontImage;
	}

	public String getLegalCertNo() {
		return this.legalCertNo;
	}
	public void setLegalCertNo(String legalCertNo) {
		this.legalCertNo = legalCertNo;
	}

	public String getLegalName() {
		return this.legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLicenseAuthLetterImage() {
		return this.licenseAuthLetterImage;
	}
	public void setLicenseAuthLetterImage(String licenseAuthLetterImage) {
		this.licenseAuthLetterImage = licenseAuthLetterImage;
	}

	public String getMcc() {
		return this.mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getMerchantType() {
		return this.merchantType;
	}
	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<String> getOutDoorImages() {
		return this.outDoorImages;
	}
	public void setOutDoorImages(List<String> outDoorImages) {
		this.outDoorImages = outDoorImages;
	}

	public List<IndustryQualificationInfo> getQualifications() {
		return this.qualifications;
	}
	public void setQualifications(List<IndustryQualificationInfo> qualifications) {
		this.qualifications = qualifications;
	}

	public List<String> getService() {
		return this.service;
	}
	public void setService(List<String> service) {
		this.service = service;
	}

	public String getServicePhone() {
		return this.servicePhone;
	}
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	public String getSignTimeWithIsv() {
		return this.signTimeWithIsv;
	}
	public void setSignTimeWithIsv(String signTimeWithIsv) {
		this.signTimeWithIsv = signTimeWithIsv;
	}

	public List<SiteInfo> getSites() {
		return this.sites;
	}
	public void setSites(List<SiteInfo> sites) {
		this.sites = sites;
	}

	public String getSmid() {
		return this.smid;
	}
	public void setSmid(String smid) {
		this.smid = smid;
	}

}
