package com.dingdong.mall.service;

import com.dingdong.mall.vo.ProductVo;

import java.util.List;

public interface ProductService {

    /**
     * 获取商品总数
     */
    public Integer countAll();

    /**
     * 分类别获取商品总数
     */
    public Integer countByCategory(String category);

    /**
     * 分品牌获取商品总数
     */
    public Integer countByBrand(String brand);

    /**
     * 分页获取所有商品
     */
    public List<ProductVo> selectAll(Integer pageNum, Integer pageSize);

    /**
     * 分页分类别获取所有商品
     */
    public List<ProductVo> selectByCategory(String category,Integer pageNum,Integer pageSize);

    /**
     * 分页分品牌获取所有商品
     */
    public List<ProductVo> selectByBrand(String brand,Integer pageNum,Integer pageSize);

    /**
     * 分页根据关键字获取商品
     */
    public List<ProductVo> selectByKeyword(String keyword,Integer pageNum,Integer pageSize);

    /**
     * 根据关键字获取商品总数
     */
    public Integer countByKeyword(String keyword);

}
