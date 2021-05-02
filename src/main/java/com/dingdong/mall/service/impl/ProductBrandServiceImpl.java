package com.dingdong.mall.service.impl;

import com.dingdong.mall.dao.ProductBrand;
import com.dingdong.mall.mappers.mapperExtension.ProductBrandMapperExtension;
import com.dingdong.mall.service.ProductBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBrandServiceImpl implements ProductBrandService {

    @Autowired
    private ProductBrandMapperExtension productBrandMapperExtension;

    @Override
    @Cacheable(cacheNames = "brandAmount")
    public Integer countAll() {
        List<ProductBrand> brandList = productBrandMapperExtension.selectAll();
        int size = brandList.size();

        return size;
    }

    @Override
    @Cacheable(cacheNames = "brandByPage")
    public List<ProductBrand> selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductBrand> productBrandList = productBrandMapperExtension.selectAll();

        return productBrandList;
    }

    @Override
    @Cacheable(cacheNames = "brandName")
    public List<ProductBrand> selectAll() {
        List<ProductBrand> productBrandList = productBrandMapperExtension.selectAll();
        for (ProductBrand productBrand:productBrandList){
            productBrand.setId(null);
            productBrand.setSubhead(null);
            productBrand.setDescription(null);
            productBrand.setBrandPic(null);

        }

        return productBrandList;
    }

}
