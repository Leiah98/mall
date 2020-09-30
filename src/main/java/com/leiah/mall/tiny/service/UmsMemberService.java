package com.leiah.mall.tiny.service;

import com.leiah.mall.tiny.common.api.CommonResult;

/**
 * @Author: Leiah
 * @Description: 会员管理service
 * @Date: 2020/9/12 10:00
 */
public interface UmsMemberService {
    /**
    * @Description: 生成验证码
    * @Param: [telephone]
    * @Return: com.leiah.mall.tiny.common.api.CommonResult 
    * @Date: 2020/9/12 10:03
    **/
    CommonResult generateAuthCode(String telephone);

    /**
    * @Description: 判断验证码和手机号是否匹配
    * @Param: [telephone, authCode]
    * @Return: com.leiah.mall.tiny.common.api.CommonResult 
    * @Date: 2020/9/12 10:03
    **/
    CommonResult verifyAuthCode(String telephone, String authCode);
}
