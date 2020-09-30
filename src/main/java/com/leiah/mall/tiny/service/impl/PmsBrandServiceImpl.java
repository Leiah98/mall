package com.leiah.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.leiah.mall.tiny.mbg.mapper.PmsBrandMapper;
import com.leiah.mall.tiny.mbg.model.PmsBrand;
import com.leiah.mall.tiny.mbg.model.PmsBrandExample;
import com.leiah.mall.tiny.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Leiah
 * @Description: 商品品牌服务类实现
 * @Date: 2020/9/5 14:12
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

   @Autowired
   private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return brandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
