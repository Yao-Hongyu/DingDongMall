package com.dingdong.mall.service.impl;

import com.dingdong.mall.dao.*;
import com.dingdong.mall.dto.product.AddProductParam;
import com.dingdong.mall.dto.product.RemoveProductParam;
import com.dingdong.mall.dto.product.UpdateProductParam;
import com.dingdong.mall.mappers.mapper.ProductMapper;
import com.dingdong.mall.mappers.mapperExtension.ProductBrandMapperExtension;
import com.dingdong.mall.mappers.mapperExtension.ProductCategoryMapperExtension;
import com.dingdong.mall.mappers.mapperExtension.ProductMapperExtension;
import com.dingdong.mall.service.ProductConfigService;
import com.dingdong.mall.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductConfigServiceImpl implements ProductConfigService {

    @Autowired
    private ProductMapperExtension productMapperExtension;
    @Autowired
    private ProductBrandMapperExtension productBrandMapperExtension;
    @Autowired
    private ProductCategoryMapperExtension productCategoryMapperExtension;

    @Override
    public Product addProduct(AddProductParam param) {
        String name = param.getName();
        String subhead = param.getSubhead();
        String brand = param.getBrand();
        String category = param.getCategory();
        String description = param.getDescription();
        Integer price = param.getPrice();
        String picture = param.getPicture();

        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andNameEqualTo(name);
        List<Product> productList = productMapperExtension.selectByExampleWithBLOBs(productExample);
        if (productList.size() != 0) return null;

        ProductBrandExample productBrandExample = new ProductBrandExample();
        productBrandExample.createCriteria().andBrandNameEqualTo(brand);
        List<ProductBrand> productBrands = productBrandMapperExtension.selectByExampleWithBLOBs(productBrandExample);
        if (productBrands.size()!=1) return null;
        ProductBrand productBrand = productBrands.get(0);
        Integer brandId = productBrand.getId();

        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        productCategoryExample.createCriteria().andCategoryNameEqualTo(category);
        List<ProductCategory> productCategories = productCategoryMapperExtension.selectByExampleWithBLOBs(productCategoryExample);
        if (productCategories.size()!=1) return null;
        ProductCategory productCategory = productCategories.get(0);
        Integer categoryId = productCategory.getId();

        Product product = new Product();
        product.setName(name);
        product.setSubhead(subhead);
        product.setBrandId(brandId);
        product.setCategoryId(categoryId);
        product.setDescription(description);
        product.setPrice(price);
        product.setPicture(picture);

        productMapperExtension.insert(product);

        return product;
    }

    @Override
    public Product removeProduct(RemoveProductParam param) {
        Integer id = param.getId();

        Product product = productMapperExtension.selectByPrimaryKey(id);
        if (product==null) return null;
        
        productMapperExtension.deleteByPrimaryKey(id);

        return product;
    }

    @Override
    public Product updateProduct(UpdateProductParam param) {
        Integer id = param.getId();
        String name = param.getName();
        String subhead = param.getSubhead();
        String brand = param.getBrand();
        String category = param.getCategory();
        String description = param.getDescription();
        Integer price = param.getPrice();
        String picture = param.getPicture();

        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andIdEqualTo(id);
        Product product = productMapperExtension.selectByPrimaryKey(id);
        if (product==null) return null;

        ProductBrandExample productBrandExample = new ProductBrandExample();
        productBrandExample.createCriteria().andBrandNameEqualTo(brand);
        List<ProductBrand> brandList = productBrandMapperExtension.selectByExampleWithBLOBs(productBrandExample);
        if (brandList.size()!=1) return null;
        Integer brandId = brandList.get(0).getId();

        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        productCategoryExample.createCriteria().andCategoryNameEqualTo(category);
        List<ProductCategory> productCategoryList = productCategoryMapperExtension.selectByExampleWithBLOBs(productCategoryExample);
        if (productCategoryList.size()!=1) return null;
        Integer categoryId = productCategoryList.get(0).getId();

        product.setName(name);
        product.setSubhead(subhead);
        product.setBrandId(brandId);
        product.setCategoryId(categoryId);
        product.setDescription(description);
        product.setPrice(price);
        product.setPicture(picture);

        productMapperExtension.updateByPrimaryKeyWithBLOBs(product);

        return product;
    }
}
