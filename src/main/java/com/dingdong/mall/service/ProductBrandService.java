package com.dingdong.mall.service;

import com.dingdong.mall.dao.ProductBrand;

import java.util.List;

public interface ProductBrandService {

    /**
     * 获取商品品牌总数
     */
    public Integer countAll();

    /**
     * 分页获取所有商品品牌
     */
    public List<ProductBrand> selectAll(Integer pageNum, Integer pageSize);

    /**
     * 获取所有商品品牌名
     */
    public List<ProductBrand> selectAll();

}
