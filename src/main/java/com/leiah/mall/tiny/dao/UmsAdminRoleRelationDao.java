package com.leiah.mall.tiny.dao;

import com.leiah.mall.tiny.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Leiah
 * @Description: 后台用户与角色管理自定义dao
 * @Date: 2020/10/1 8:45
 */
public interface UmsAdminRoleRelationDao {
    /**
    * @Description: 获取用户所有权限（包括+-权限）
    * @Param: [adminId]
    * @Return: java.util.List<com.leiah.mall.tiny.mbg.model.UmsPermission>
    * @Date: 2020/10/1 8:48
    **/
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
