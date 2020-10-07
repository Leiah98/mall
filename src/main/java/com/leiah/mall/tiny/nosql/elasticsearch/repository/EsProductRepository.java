package com.leiah.mall.tiny.nosql.elasticsearch.repository;

import com.leiah.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: Leiah
 * @Description: Product ES manipulate class
 * @Date: 2020/10/6 13:21
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {
    /**
    * @Description: Search and query by product name, subtitle, keywords
    * @Param: [name, subTitle, keywords, page]
    * @Return: org.springframework.data.domain.Page<com.leiah.mall.tiny.nosql.elasticsearch.document.EsProduct> 
    * @Date: 2020/10/6 13:25
    **/
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}
