package com.zz.simple.sdk.handle;

import com.zz.simple.sdk.domain.OpenAPIEntity;
import com.zz.simple.sdk.domain.RequestBaseVo;
import com.zz.simple.sdk.domain.ResponseBaseVo;

/**
 * @author zhangzuizui
 * @date 2018/7/11 14:14
 */
public interface RequestHandle {

    OpenAPIEntity execute(RequestBaseVo openAPIEntity);

}
