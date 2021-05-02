package com.dingdong.mall.service;

import com.dingdong.mall.dao.Product;
import com.dingdong.mall.dto.product.AddProductParam;
import com.dingdong.mall.dto.product.RemoveProductParam;
import com.dingdong.mall.dto.product.UpdateProductParam;
import com.dingdong.mall.vo.ProductVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductConfigService {

    /**
     * 添加商品
     */
    public Product addProduct(AddProductParam param);

    /**
     * 移除商品
     */
    public Product removeProduct(RemoveProductParam param);

    /**
     * 修改商品
     */
    public Product updateProduct(UpdateProductParam param);

}
