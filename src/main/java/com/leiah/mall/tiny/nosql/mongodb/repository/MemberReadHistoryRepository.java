package com.leiah.mall.tiny.nosql.mongodb.repository;

import com.leiah.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author: Leiah
 * @Description: User browsing history repository
 * @Date: 2020/10/15 22:06
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {
    /**
    * @Description: Get user browse history with memberId order by create time desc
    * @Param: [memberId]
    * @Return: java.util.List<com.leiah.mall.tiny.nosql.mongodb.document.MemberReadHistory> 
    * @Date: 2020/10/15 22:10
    **/
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
