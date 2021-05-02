package com.dingdong.mall.service;

import com.dingdong.mall.dao.Product;
import com.dingdong.mall.dao.ProductCategory;
import com.dingdong.mall.dto.productCategory.AddProductCategoryParam;
import com.dingdong.mall.dto.productCategory.RemoveProductCategoryParam;
import com.dingdong.mall.dto.productCategory.UpdateProductCategoryParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductCategoryConfigService {

    /**
     * 添加商品类别
     */
    public ProductCategory addProductCategory(AddProductCategoryParam param);

    /**
     * 移除商品类别
     */
    public ProductCategory removeProductCategory(RemoveProductCategoryParam param);

    /**
     * 修改商品类别
     */
    public ProductCategory updateProductCategory(UpdateProductCategoryParam param);

}
