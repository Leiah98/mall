package com.leiah.mall.tiny.service;

import com.leiah.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: Leiah
 * @Description: Product search service
 * @Date: 2020/10/6 13:26
 */
public interface EsProductService {
    /**
    * @Description: import all products to ES from database
    * @Param: []
    * @Return: int 
    * @Date: 2020/10/6 13:30
    **/
    int importAll();
    
    /**
    * @Description: create product according to id
    * @Param: [id]
    * @Return: com.leiah.mall.tiny.nosql.elasticsearch.document.EsProduct 
    * @Date: 2020/10/6 13:30
    **/
    EsProduct create(Long id);
    
    /**
    * @Description: delete product by id
    * @Param: [id]
    * @Return: void 
    * @Date: 2020/10/6 13:30
    **/
    void delete(Long id);
    
    /**
    * @Description: delete product by id in batches
    * @Param: [ids]
    * @Return: void 
    * @Date: 2020/10/6 13:31
    **/
    void delete(List<Long> ids);
    
    /**
    * @Description: search by keyword
    * @Param: [name, pageNum, pageSize]
    * @Return: org.springframework.data.domain.Page<com.leiah.mall.tiny.nosql.elasticsearch.document.EsProduct> 
    * @Date: 2020/10/6 13:32
    **/
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);
}
