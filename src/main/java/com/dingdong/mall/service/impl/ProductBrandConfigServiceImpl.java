package com.dingdong.mall.service.impl;

import com.dingdong.mall.dao.Product;
import com.dingdong.mall.dao.ProductBrand;
import com.dingdong.mall.dao.ProductBrandExample;
import com.dingdong.mall.dao.ProductCategory;
import com.dingdong.mall.dto.productBrand.AddProductBrandParam;
import com.dingdong.mall.dto.productBrand.RemoveProductBrandParam;
import com.dingdong.mall.dto.productBrand.UpdateProductBrandParam;
import com.dingdong.mall.mappers.mapper.ProductBrandMapper;
import com.dingdong.mall.mappers.mapperExtension.ProductBrandMapperExtension;
import com.dingdong.mall.service.ProductBrandConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductBrandConfigServiceImpl implements ProductBrandConfigService {

    @Autowired
    private ProductBrandMapperExtension productBrandMapperExtension;

    @Override
    public ProductBrand addProductBrand(AddProductBrandParam param) {
        String brandName = param.getBrandName();
        String brandPic = param.getBrandPic();
        String subhead = param.getSubhead();
        String description = param.getDescription();

        ProductBrandExample productBrandExample = new ProductBrandExample();
        productBrandExample.createCriteria().andBrandNameEqualTo(brandName);
        List<ProductBrand> productBrands = productBrandMapperExtension.selectByExampleWithBLOBs(productBrandExample);
        if (productBrands.size()!=0) return null;

        ProductBrand productBrand = new ProductBrand();
        productBrand.setBrandName(brandName);
        productBrand.setBrandPic(brandPic);
        productBrand.setSubhead(subhead);
        productBrand.setDescription(description);

        productBrandMapperExtension.insert(productBrand);

        return productBrand;
    }

    @Override
    public ProductBrand removeProductBrand(RemoveProductBrandParam param) {
        Integer brandId = param.getId();

        ProductBrand productBrand = productBrandMapperExtension.selectByPrimaryKey(brandId);
        if (productBrand==null) return null;

        productBrandMapperExtension.deleteByPrimaryKey(brandId);

        return productBrand;
    }

    @Override
    public ProductBrand updateProductBrand(UpdateProductBrandParam param) {
        Integer id = param.getId();
        String brandName = param.getBrandName();
        String subhead = param.getSubhead();
        String description = param.getDescription();
        String brandPic = param.getBrandPic();

        ProductBrand productBrand = productBrandMapperExtension.selectByPrimaryKey(id);
        if (productBrand==null) return null;

        productBrand.setBrandName(brandName);
        productBrand.setSubhead(subhead);
        productBrand.setDescription(description);
        productBrand.setBrandPic(brandPic);

        productBrandMapperExtension.updateByPrimaryKeyWithBLOBs(productBrand);

        return productBrand;
    }
}
