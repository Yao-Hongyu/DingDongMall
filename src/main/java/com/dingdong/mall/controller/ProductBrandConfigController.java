package com.dingdong.mall.controller;

import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.Product;
import com.dingdong.mall.dao.ProductBrand;
import com.dingdong.mall.dto.product.AddProductParam;
import com.dingdong.mall.dto.product.RemoveProductParam;
import com.dingdong.mall.dto.product.UpdateProductParam;
import com.dingdong.mall.dto.productBrand.AddProductBrandParam;
import com.dingdong.mall.dto.productBrand.RemoveProductBrandParam;
import com.dingdong.mall.dto.productBrand.UpdateProductBrandParam;
import com.dingdong.mall.service.ProductBrandConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/admin/config/productBrand")
public class ProductBrandConfigController {

    @Autowired
    private ProductBrandConfigService productBrandConfigService;


    @RequestMapping(method = RequestMethod.POST,value = "/add",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult addProductBrand(@RequestBody AddProductBrandParam param){
        ProductBrand productBrand = productBrandConfigService.addProductBrand(param);
        if (productBrand==null) return CommonResult.failed();
        return CommonResult.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/remove",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult removeProductBrand(@RequestBody RemoveProductBrandParam param){
        ProductBrand productBrand = productBrandConfigService.removeProductBrand(param);
        if (productBrand==null) return CommonResult.failed();
        return CommonResult.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult updateProductBrand(@RequestBody UpdateProductBrandParam param){
        ProductBrand productBrand = productBrandConfigService.updateProductBrand(param);
        if (productBrand==null) return CommonResult.failed();
        return CommonResult.success();
    }

}
