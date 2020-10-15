package com.leiah.mall.tiny.service.impl;

import com.leiah.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import com.leiah.mall.tiny.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.leiah.mall.tiny.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Leiah
 * @Description: User browsing history service implementation
 * @Date: 2020/10/15 22:30
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;

    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>();
        for (String id : ids) {
            MemberReadHistory m = new MemberReadHistory();
            m.setId(id);
            deleteList.add(m);
        }
        memberReadHistoryRepository.deleteAll(deleteList);
        return deleteList.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
