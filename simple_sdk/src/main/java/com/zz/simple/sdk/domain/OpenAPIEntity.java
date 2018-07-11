package com.zz.simple.sdk.domain;

/**
 * @author zhangzuizui
 */
public class OpenAPIEntity {

    /**
     * 版本号
     */
    public String version;

    /**
     * appId
     */
    public String appId;

    /**
     * timestamp
     * 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
     */
    public String timestamp;

    /**
     * 字符集GBK/UTF-8等
     */
    public String charset;

    /**
     * 交易类型
     */
    public String tradeType;

    /**
     * 业务数据
     */
    public String data;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 所有数据签名
     */
    public String sign;

    public OpenAPIEntity(String version, String appId, String timestamp, String charset, String tradeType, String data, String merchantNo, String sign) {
        this.version = version;
        this.appId = appId;
        this.timestamp = timestamp;
        this.charset = charset;
        this.tradeType = tradeType;
        this.data = data;
        this.merchantNo = merchantNo;
        this.sign = sign;
    }

    public OpenAPIEntity() {

    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "BizEntity{" +
                "version='" + version + '\'' +
                ", appId='" + appId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", charset='" + charset + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", data='" + data + '\'' +
                ", merchantNo='" + merchantNo + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
