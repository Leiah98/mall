package com.leiah.mall.tiny.service;

import com.leiah.mall.tiny.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * @Author: Leiah
 * @Description: User browsing history service
 * @Date: 2020/10/15 22:11
 */
public interface MemberReadHistoryService {
    /**
    * @Description: Create user browse history
    * @Param: [memberReadHistory]
    * @Return: int
    * @Date: 2020/10/15 22:13
    **/
    int create(MemberReadHistory memberReadHistory);

    /**
    * @Description: Batch delete user browse history
    * @Param: [ids]
    * @Return: int
    * @Date: 2020/10/15 22:13
    **/
    int delete(List<String> ids);

    /**
    * @Description: Get user browse history
    * @Param: [memberId]
    * @Return: java.util.List<com.leiah.mall.tiny.nosql.mongodb.document.MemberReadHistory>
    * @Date: 2020/10/15 22:14
    **/
    List<MemberReadHistory> list(Long memberId);
}
