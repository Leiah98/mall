package com.leiah.mall.tiny.dao;

import com.leiah.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Leiah
 * @Description: ES product manage dao
 * @Date: 2020/10/6 13:35
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
