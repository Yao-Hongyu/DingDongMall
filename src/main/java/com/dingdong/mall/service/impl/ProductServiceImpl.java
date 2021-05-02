package com.dingdong.mall.service.impl;

import com.dingdong.mall.mappers.mapperExtension.ProductMapperExtension;
import com.dingdong.mall.service.ProductService;
import com.dingdong.mall.vo.ProductVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapperExtension productMapperExtension;

    @Override
    @Cacheable(cacheNames = "productAmount")
    public Integer countAll() {
        List<ProductVo> productVoList = productMapperExtension.selectAll();
        int size = productVoList.size();

        return size;
    }

    @Override
    @Cacheable(cacheNames = "productByCategoryAmount")
    public Integer countByCategory(String category) {
        List<ProductVo> productVoList = productMapperExtension.selectByCategory(category);
        int size = productVoList.size();

        return size;
    }

    @Override
    @Cacheable(cacheNames = "productByBrandAmount")
    public Integer countByBrand(String brand) {
        List<ProductVo> productVos = productMapperExtension.selectByBrand(brand);
        int size = productVos.size();

        return size;
    }

    @Override
    @Cacheable(cacheNames = "productByPage")
    public List<ProductVo> selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> productVoList = productMapperExtension.selectAll();

        return productVoList;
    }

    @Override
    @Cacheable(cacheNames = "productByCategory")
    public List<ProductVo> selectByCategory(String category, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> productVoList = productMapperExtension.selectByCategory(category);

        return productVoList;
    }

    @Override
    @Cacheable(cacheNames = "productByBrand")
    public List<ProductVo> selectByBrand(String brand, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> productVoList = productMapperExtension.selectByBrand(brand);

        return productVoList;
    }

    @Override
    public List<ProductVo> selectByKeyword(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> productVoList = productMapperExtension.selectByKeyword(keyword);

        return productVoList;
    }

    @Override
    public Integer countByKeyword(String keyword) {
        List<ProductVo> productVoList = productMapperExtension.selectByKeyword(keyword);

        return productVoList.size();
    }
}
