package com.dingdong.mall.controller;

import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.ProductBrand;
import com.dingdong.mall.dao.ProductCategory;
import com.dingdong.mall.dto.productBrand.AddProductBrandParam;
import com.dingdong.mall.dto.productBrand.RemoveProductBrandParam;
import com.dingdong.mall.dto.productBrand.UpdateProductBrandParam;
import com.dingdong.mall.dto.productCategory.AddProductCategoryParam;
import com.dingdong.mall.dto.productCategory.RemoveProductCategoryParam;
import com.dingdong.mall.dto.productCategory.UpdateProductCategoryParam;
import com.dingdong.mall.service.ProductBrandConfigService;
import com.dingdong.mall.service.ProductCategoryConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/admin/config/productCategory")
public class ProductCategoryConfigController {

    @Autowired
    private ProductCategoryConfigService productCategoryConfigService;

    @RequestMapping(method = RequestMethod.POST,value = "/add",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult addProductCategory(@RequestBody AddProductCategoryParam param){
        ProductCategory productCategory = productCategoryConfigService.addProductCategory(param);
        if (productCategory==null) return CommonResult.failed();
        return CommonResult.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/remove",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult removeProductCategory(@RequestBody RemoveProductCategoryParam param){
        ProductCategory productCategory = productCategoryConfigService.removeProductCategory(param);
        if (productCategory==null) return CommonResult.failed();
        return CommonResult.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult updateProductCategory(@RequestBody UpdateProductCategoryParam param){
        ProductCategory productCategory = productCategoryConfigService.updateProductCategory(param);
        if (productCategory==null) return CommonResult.failed();
        return CommonResult.success();
    }
}
