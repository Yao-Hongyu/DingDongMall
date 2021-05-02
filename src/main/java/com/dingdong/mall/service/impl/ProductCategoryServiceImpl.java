package com.dingdong.mall.service.impl;

import com.dingdong.mall.dao.ProductCategory;
import com.dingdong.mall.mappers.mapperExtension.ProductCategoryMapperExtension;
import com.dingdong.mall.service.ProductCategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapperExtension productCategoryMapperExtension;

    @Override
    @Cacheable(cacheNames = "categoryAmount")
    public Integer countAll() {
        List<ProductCategory> productCategoryList = productCategoryMapperExtension.selectAll();
        int size = productCategoryList.size();

        return size;
    }

    @Override
    @Cacheable(cacheNames = "categoryByPage")
    public List<ProductCategory> selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductCategory> productCategoryList = productCategoryMapperExtension.selectAll();

        return productCategoryList;
    }

    @Override
    @Cacheable(cacheNames = "categoryName")
    public List<ProductCategory> selectAll() {
        List<ProductCategory> productCategoryList = productCategoryMapperExtension.selectAll();
        for (ProductCategory productCategory:productCategoryList){
            productCategory.setId(null);
            productCategory.setCategoryPic(null);

        }

        return productCategoryList;
    }
}
