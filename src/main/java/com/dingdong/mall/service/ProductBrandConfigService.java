package com.dingdong.mall.service;

import com.dingdong.mall.dao.Product;
import com.dingdong.mall.dao.ProductBrand;
import com.dingdong.mall.dto.productBrand.AddProductBrandParam;
import com.dingdong.mall.dto.productBrand.RemoveProductBrandParam;
import com.dingdong.mall.dto.productBrand.UpdateProductBrandParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductBrandConfigService {

    /**
     * 添加商品品牌
     */
    public ProductBrand addProductBrand(AddProductBrandParam param);

    /**
     * 移除商品品牌
     */
    public ProductBrand removeProductBrand(RemoveProductBrandParam param);

    /**
     * 修改商品品牌
     */
    public ProductBrand updateProductBrand(UpdateProductBrandParam param);

}
