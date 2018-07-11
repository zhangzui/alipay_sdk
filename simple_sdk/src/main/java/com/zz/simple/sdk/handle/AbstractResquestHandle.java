package com.zz.simple.sdk.handle;

import com.alibaba.fastjson.JSON;
import com.zz.simple.sdk.common.Constants;
import com.zz.simple.sdk.common.OpenApiRuntimeException;
import com.zz.simple.sdk.domain.OpenAPIEntity;
import com.zz.simple.sdk.domain.RequestBaseVo;
import com.zz.simple.sdk.domain.ResponseBaseVo;
import com.zz.simple.sdk.response.ReceiveOrderResponse;
import com.zz.simple.sdk.utils.EncryptUtils;
import com.zz.simple.sdk.utils.SignUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangzuizui
 * @date 2018/7/11 14:37
 */
public abstract class AbstractResquestHandle implements RequestHandle{

    private String signType       = Constants.SIGN_TYPE_RSA2;
    private String encryptType       = Constants.ENCRYPT_TYPE_AES;

    private String version;
    private String tradeType;
    private String appId;
    private String charset;
    private String merchantNo;

    public AbstractResquestHandle(String version,String tradeType, String appId, String charset,String merchantNo) {
        this.version = version;
        this.tradeType = tradeType;
        this.appId = appId;
        this.charset = charset;
        this.merchantNo = merchantNo;
    }

    @Override
    public OpenAPIEntity execute(RequestBaseVo requestBaseVo) {
        //1.生成http请求参数
        Map req = buildHttpRequestParams(requestBaseVo);
        System.out.println("map:"+JSON.toJSONString(req));

        //2.http请求
        Map res = doPost(req);
        System.out.println("res:"+JSON.toJSONString(res));

        //3.处理返回结果
        ResponseBaseVo responseBaseVo = dealResponse(res);
        System.out.println("responseBaseVo:"+JSON.toJSONString(responseBaseVo));
        return null;
    }

    private ResponseBaseVo dealResponse(Map res) {
        //获取加签数据
        String signature = res.get(Constants.SIGN).toString();

        res.remove(Constants.SIGN);
        String sourceContent = SignUtils.getSignContent(res);
        System.out.println("dealResponse,res:"+res.get("data").toString());

        if(getSignChecker().check(sourceContent,signature,this.signType,this.charset)){
            System.out.println("响应验签成功");
            String data = getDecryptor().decrypt(res.get("data").toString(),this.encryptType,this.charset);
            System.out.println("响应参数："+data);
            return JSON.parseObject(data,ResponseBaseVo.class);
        }else{
            System.out.println("响应验签失败");
            return null;
        }

    }


    public Map buildHttpRequestParams(RequestBaseVo requestBaseVo){
        Map<String,String> parmasMap = new HashMap<String, String>();
        parmasMap.put(Constants.VERSION,this.charset);
        parmasMap.put(Constants.APP_ID,this.appId);
        parmasMap.put(Constants.TIMESTAMP,new Date().toString());
        parmasMap.put(Constants.TRADE_TYPE,this.tradeType);
        parmasMap.put(Constants.MERCHANTNO,this.merchantNo);
        //加密
        String decryptData = encryptData(JSON.toJSONString(requestBaseVo));
        System.out.println("decryptData:"+decryptData);
        parmasMap.put(Constants.DATA,decryptData);

        //加签
        String preSign = SignUtils.getSignContent(parmasMap);
        System.out.println("preSign:"+preSign);
        String sign = signData(preSign);

        System.out.println("sign:"+sign);
        parmasMap.put(Constants.SIGN,sign);
        return parmasMap;
    }

    private Map decryptData(String data) {
        String merPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhmTuHaROm0CRsOorGT94aONCXFSjtbTizJJ+ehT2+LUH4OeRCJ5NH50ij5PGfJhLjZEsqSBRZtUPqEQUlFni1LziS31ekzO6yCGPCnL2kTsvpk44o1w+g69FlMyXOmHrVFdAOpMGavazuPyipBHXsjIg0kWlukii2HydjUuMCgPSL6jlzPgf2MD4KKRmu+44ZWttQvZA7ih+pzZkMFFpM1Nsb4tAvVYtWJj9h0AfC0eGhWsOWmihAHSZCZq1RSKHKCXYe5DzALVqn5m3fDl/Ax87NWLyiDvcezp++tE4uvFWZDkLe74s1FgyuVOUmjRhN6IPPCzWyzeQIAbWD3/BdQIDAQAB";
        String JDPrivateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDQx88wP9l4Zm73n6tNDRj6eHUMgNlWGoUq0dmvPxKZ+hnqoGUecwWqU6wLQk3DqqfaSAc/c6EdAWs7bz3pzBvZJK6/WBuEB3yZXJiJ4jeFUw0QLTfH2bsnLbl1EXtuguHRh7g6/T8IiztB1LD1IzT5lSwrfAsw5fwV8A7+DeGBpmvAX1R9mLGUv5v3rUo+929A9xctxK4RQVNN7Kx1rOLHzZW2mkyR9Jez+u07eCXTSH1B9nCRrO6NWkLGK2qqHsgiguRPQqv8I8RFrmgC65VN1g682VicLreXQVv65I94RureyWVhjAUx1rUzYQQBOF7XY6qVxHXgvYgu++VRb1FxAgMBAAECggEAQj1yzfMkE2Akiuoc1mh2aVl4gYwL6Janc4t7Dm/rffDs8hULoBqMTJsZdcUGmTL26Hl72zTbhDFkDUphEWGR4FYUH19b84rQjHPlbbHZPbK47U37aav6BhcqxSrTx588+FagLA8XRaWvGlbaAhy2fQ1II0/K2SvOzEMK7q4GwzQwH1/mfIrl4zAhyL6fF+u5AmrpihtflLcJVHIVAZiQKzrlVsDt8ejn00/Mq6iyBfI0qDfwZoDw7odKaIcGRKxtEETCqCGLC7FGLwW7cZT8Pk5qkev3GTcr54TVYma/J8Xov0W+buqJwkEpoa9unFXUNWKHSq0S/nDOHFIKlYNwAQKBgQDwwt3mKJ4Fd8W+zTCiY5WiP3A+EXXbfjYHHaS7AtxM58X1FdepM4FdQfuiYpCp2w6aCCmOVi6h1CsZoE2J0z0oa+YydY7QedV3mvjooOJ76luGBo21n9velUuPcu80+DjjDmMGVgI5KXg93fQLHty1Et0mbbYWWuKX66w78RpJAQKBgQDd/r+xkuDchbNEqSiON5Ahj9o/vebdgZc1cVTqDZRx7VaNN23jHyHWiDZgMLt8VMJR52ocTUeeEv8PJcZzjQnpVF2lkITADPuBADQR4Kt4RbZ7XKV50y+7nF25brrXP+jLCmUYLq01uFSq1gJ7xjIK3lWUpt0Re+8ycABTSP0YcQKBgATDxoJ0kVQIX8h75ReBowd3+++uhseWQtl3M7hjwRpgh+Fm0kLN+yRuVt2K19QUusA/oxrnB7s6KLQ0IPS2UoKHSCH9g5sKnjfkwEJSVMkhBTiszocmp8JK8BjhrGw+8VlFAp6wexDIilGnH9pMfQ+0VN4a07yzhcJ97oWtKtkBAoGBAMzTI6N/1aEia0lKmnS9p2qQA9sUKFLwIsfYjXR2mySSy2z4W5dXPi1m+GTAEfyhZ7mSP0FlvFKJTHR5ciVjWGXExbLhKNraH6PiwChOl2cdS0V/Md65kC0WFRPmqtW3zd6o9KXfS0lpjhUh6KCzObD1exjw7MAZDZYH6QTvLzbBAoGBALUOaemB2BGY3ILkUFAay2tq2lx3Ht4BrL52K1HlIszTrrfU8vcvl1eO+6dzb2hVN/SLzw3Li0dAHKGBs3P249kpqRlmU+W9ppOPl4By297KFMgzAVUXcjEZSyZnUj5uhUhh4Q7ePNqKp7boTBcFcA8MUEhreL+dO3ru7vJ+1HYv";

        Map<String,String> parmasMap = new HashMap<String, String>();
        parmasMap.put(Constants.VERSION,this.charset);
        parmasMap.put(Constants.APP_ID,this.appId);
        parmasMap.put(Constants.TIMESTAMP,new Date().toString());
        parmasMap.put(Constants.TRADE_TYPE,this.tradeType);
        parmasMap.put(Constants.MERCHANTNO,this.merchantNo);
        //加密

        String decryptData = getEncryptor().encrypt(data, encryptType, charset);
        System.out.println("decryptData:"+decryptData);
        parmasMap.put(Constants.DATA,decryptData);

        //加签
        String preSign = SignUtils.getSignContent(parmasMap);
        System.out.println("preSign:"+preSign);
        String sign = null;
        try {
            sign = SignUtils.rsaSign(preSign,JDPrivateKey, charset, signType);
        } catch (OpenApiRuntimeException e) {
            throw new RuntimeException(e);
        }

        System.out.println("sign:"+sign);
        parmasMap.put(Constants.SIGN,sign);
        return parmasMap;
    }

    private boolean checkSign(Map map) {
        String merPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhmTuHaROm0CRsOorGT94aONCXFSjtbTizJJ+ehT2+LUH4OeRCJ5NH50ij5PGfJhLjZEsqSBRZtUPqEQUlFni1LziS31ekzO6yCGPCnL2kTsvpk44o1w+g69FlMyXOmHrVFdAOpMGavazuPyipBHXsjIg0kWlukii2HydjUuMCgPSL6jlzPgf2MD4KKRmu+44ZWttQvZA7ih+pzZkMFFpM1Nsb4tAvVYtWJj9h0AfC0eGhWsOWmihAHSZCZq1RSKHKCXYe5DzALVqn5m3fDl/Ax87NWLyiDvcezp++tE4uvFWZDkLe74s1FgyuVOUmjRhN6IPPCzWyzeQIAbWD3/BdQIDAQAB";

        String JDPrivateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDQx88wP9l4Zm73n6tNDRj6eHUMgNlWGoUq0dmvPxKZ+hnqoGUecwWqU6wLQk3DqqfaSAc/c6EdAWs7bz3pzBvZJK6/WBuEB3yZXJiJ4jeFUw0QLTfH2bsnLbl1EXtuguHRh7g6/T8IiztB1LD1IzT5lSwrfAsw5fwV8A7+DeGBpmvAX1R9mLGUv5v3rUo+929A9xctxK4RQVNN7Kx1rOLHzZW2mkyR9Jez+u07eCXTSH1B9nCRrO6NWkLGK2qqHsgiguRPQqv8I8RFrmgC65VN1g682VicLreXQVv65I94RureyWVhjAUx1rUzYQQBOF7XY6qVxHXgvYgu++VRb1FxAgMBAAECggEAQj1yzfMkE2Akiuoc1mh2aVl4gYwL6Janc4t7Dm/rffDs8hULoBqMTJsZdcUGmTL26Hl72zTbhDFkDUphEWGR4FYUH19b84rQjHPlbbHZPbK47U37aav6BhcqxSrTx588+FagLA8XRaWvGlbaAhy2fQ1II0/K2SvOzEMK7q4GwzQwH1/mfIrl4zAhyL6fF+u5AmrpihtflLcJVHIVAZiQKzrlVsDt8ejn00/Mq6iyBfI0qDfwZoDw7odKaIcGRKxtEETCqCGLC7FGLwW7cZT8Pk5qkev3GTcr54TVYma/J8Xov0W+buqJwkEpoa9unFXUNWKHSq0S/nDOHFIKlYNwAQKBgQDwwt3mKJ4Fd8W+zTCiY5WiP3A+EXXbfjYHHaS7AtxM58X1FdepM4FdQfuiYpCp2w6aCCmOVi6h1CsZoE2J0z0oa+YydY7QedV3mvjooOJ76luGBo21n9velUuPcu80+DjjDmMGVgI5KXg93fQLHty1Et0mbbYWWuKX66w78RpJAQKBgQDd/r+xkuDchbNEqSiON5Ahj9o/vebdgZc1cVTqDZRx7VaNN23jHyHWiDZgMLt8VMJR52ocTUeeEv8PJcZzjQnpVF2lkITADPuBADQR4Kt4RbZ7XKV50y+7nF25brrXP+jLCmUYLq01uFSq1gJ7xjIK3lWUpt0Re+8ycABTSP0YcQKBgATDxoJ0kVQIX8h75ReBowd3+++uhseWQtl3M7hjwRpgh+Fm0kLN+yRuVt2K19QUusA/oxrnB7s6KLQ0IPS2UoKHSCH9g5sKnjfkwEJSVMkhBTiszocmp8JK8BjhrGw+8VlFAp6wexDIilGnH9pMfQ+0VN4a07yzhcJ97oWtKtkBAoGBAMzTI6N/1aEia0lKmnS9p2qQA9sUKFLwIsfYjXR2mySSy2z4W5dXPi1m+GTAEfyhZ7mSP0FlvFKJTHR5ciVjWGXExbLhKNraH6PiwChOl2cdS0V/Md65kC0WFRPmqtW3zd6o9KXfS0lpjhUh6KCzObD1exjw7MAZDZYH6QTvLzbBAoGBALUOaemB2BGY3ILkUFAay2tq2lx3Ht4BrL52K1HlIszTrrfU8vcvl1eO+6dzb2hVN/SLzw3Li0dAHKGBs3P249kpqRlmU+W9ppOPl4By297KFMgzAVUXcjEZSyZnUj5uhUhh4Q7ePNqKp7boTBcFcA8MUEhreL+dO3ru7vJ+1HYv";

        //获取加签数据

        String signature = map.get(Constants.SIGN).toString();
        map.remove(Constants.SIGN);
        String sourceContent = SignUtils.getSignContent(map);
        try {
            boolean res = SignUtils.rsaCheck(sourceContent, signature, merPublicKey, charset, signType);
            return res;
        } catch (OpenApiRuntimeException e) {
            e.printStackTrace();
        }
        return false;
    }

    //生成签名证书
    private String signData(String data) {
        String decryptData = getSigner().sign(data,signType,charset);
        return decryptData;
    }

    private String encryptData(String data) {
        String decryptData = getEncryptor().encrypt(data,encryptType,charset);
        return decryptData;
    }

    private void buildOpenAPIEntity(String jsonData) {
        OpenAPIEntity openAPIEntity = new OpenAPIEntity();
        openAPIEntity.setVersion("1.0.0");
        openAPIEntity.setAppId("000001");
        openAPIEntity.setCharset("UTF-8");
        openAPIEntity.setMerchantNo("000001");
        openAPIEntity.setData("xxx");
        openAPIEntity.setTimestamp(new Date().toString());
        openAPIEntity.setTradeType("01");

    }

    /**
     * 服务端模拟
     * @param map
     * @return
     */
    public Map doPost(Map map){
        //解密响应密文
        if(checkSign(map)) {
            System.out.println("验签成功");
            ReceiveOrderResponse receiveOrderResponse = new ReceiveOrderResponse();
            receiveOrderResponse.setResultCode("success");
            Map res = decryptData(JSON.toJSONString(receiveOrderResponse));
            return res;
        }else {
            System.out.println("验签失败");
            return null;
        }
    }


    public abstract Signer getSigner();

    public abstract SignChecker getSignChecker();

    public abstract Encryptor getEncryptor();

    public abstract Decryptor getDecryptor();

}
