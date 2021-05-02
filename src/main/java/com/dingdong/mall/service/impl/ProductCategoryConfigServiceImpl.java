package com.dingdong.mall.service.impl;

import com.dingdong.mall.dao.Product;
import com.dingdong.mall.dao.ProductCategory;
import com.dingdong.mall.dao.ProductCategoryExample;
import com.dingdong.mall.dto.productCategory.AddProductCategoryParam;
import com.dingdong.mall.dto.productCategory.RemoveProductCategoryParam;
import com.dingdong.mall.dto.productCategory.UpdateProductCategoryParam;
import com.dingdong.mall.mappers.mapper.ProductCategoryMapper;
import com.dingdong.mall.mappers.mapperExtension.ProductCategoryMapperExtension;
import com.dingdong.mall.service.ProductCategoryConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryConfigServiceImpl implements ProductCategoryConfigService {

    @Autowired
    private ProductCategoryMapperExtension productCategoryMapperExtension;

    @Override
    public ProductCategory addProductCategory(AddProductCategoryParam param) {
        String categoryName = param.getCategoryName();
        String categoryPic = param.getCategoryPic();

        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        productCategoryExample.createCriteria().andCategoryNameEqualTo(categoryName);

        List<ProductCategory> productCategories = productCategoryMapperExtension.selectByExampleWithBLOBs(productCategoryExample);

        if (productCategories.size()!=0) return null;

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName(categoryName);
        productCategory.setCategoryPic(categoryPic);

        productCategoryMapperExtension.insert(productCategory);

        return productCategory;
    }

    @Override
    public ProductCategory removeProductCategory(RemoveProductCategoryParam param) {
        Integer categoryId = param.getId();

        ProductCategory productCategory = productCategoryMapperExtension.selectByPrimaryKey(categoryId);
        if (productCategory==null) return null;

        productCategoryMapperExtension.deleteByPrimaryKey(categoryId);

        return productCategory;
    }

    @Override
    public ProductCategory updateProductCategory(UpdateProductCategoryParam param) {
        Integer categoryId = param.getId();
        String categoryName = param.getCategoryName();
        String categoryPic = param.getCategoryPic();

        ProductCategory productCategory = productCategoryMapperExtension.selectByPrimaryKey(categoryId);
        if (productCategory==null) return null;

        productCategory.setCategoryName(categoryName);
        productCategory.setCategoryPic(categoryPic);

        productCategoryMapperExtension.updateByPrimaryKeyWithBLOBs(productCategory);

        return productCategory;
    }
}
