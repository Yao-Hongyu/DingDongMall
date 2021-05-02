package com.dingdong.mall.controller;

import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.Product;
import com.dingdong.mall.dto.product.AddProductParam;
import com.dingdong.mall.dto.product.RemoveProductParam;
import com.dingdong.mall.dto.product.UpdateProductParam;
import com.dingdong.mall.service.ProductConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/admin/config/product")
public class ProductConfigController {

    @Autowired
    private ProductConfigService productConfigService;

    @RequestMapping(method = RequestMethod.POST,value = "/add",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult addProduct(@RequestBody AddProductParam param){
        Product product = productConfigService.addProduct(param);
        if (product==null) return CommonResult.failed();
        return CommonResult.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/remove",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult removeProduct(@RequestBody RemoveProductParam param){
        Product product = productConfigService.removeProduct(param);
        if (product==null) return CommonResult.failed();
        return CommonResult.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult updateProduct(@RequestBody UpdateProductParam param){
        Product product = productConfigService.updateProduct(param);
        if (product==null) return CommonResult.failed();
        return CommonResult.success();
    }

}
