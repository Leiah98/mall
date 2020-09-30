package com.leiah.mall.tiny.service;

import com.leiah.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * @Author: Leiah
 * @Description: 商品品牌服务接口
 * @Date: 2020/9/5 14:08
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand pmsBrand);

    int updateBrand(Long id, PmsBrand pmsBrand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
