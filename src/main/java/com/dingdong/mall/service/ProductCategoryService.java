package com.dingdong.mall.service;

import com.dingdong.mall.dao.ProductBrand;
import com.dingdong.mall.dao.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    /**
     * 获取商品类别总数
     */
    public Integer countAll();

    /**
     * 分页获取所有商品类别
     */
    public List<ProductCategory> selectAll(Integer pageNum, Integer pageSize);

    /**
     * 获取所有商品类别名
     */
    public List<ProductCategory> selectAll();

}
