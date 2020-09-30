package com.leiah.mall.tiny.service;

import com.leiah.mall.tiny.mbg.model.UmsAdmin;
import com.leiah.mall.tiny.mbg.model.UmsPermission;

import java.util.List;

/**
 * @Author: Leiah
 * @Description: 后台管理员service
 * @Date: 2020/9/17 20:06
 */
public interface UmsAdminService {
    /**
    * @Description: 根据用户名获取后台管理员
    * @Param: [username]
    * @Return: com.leiah.mall.tiny.mbg.model.UmsAdmin 
    * @Date: 2020/9/17 21:03
    **/
    UmsAdmin getAdminByUsername(String username);

    /**
    * @Description: 注册功能
    * @Param: [umsAdminParam]
    * @Return: com.leiah.mall.tiny.mbg.model.UmsAdmin 
    * @Date: 2020/9/17 21:03
    **/
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
    * @Description: 用户名密码
    * @Param: [username, password]
    * @Return: java.lang.String JWT返回的token
    * @Date: 2020/9/17 21:03
    **/
    String login(String username, String password);

    /**
    * @Description: 获取用户权限列表（角色权限和+-权限）
    * @Param: [adminId]
    * @Return: java.util.List<com.leiah.mall.tiny.mbg.model.UmsPermission>
    * @Date: 2020/9/17 21:04
    **/
    List<UmsPermission> getPermissionList(Long adminId);
}
