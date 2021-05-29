package com.dingdong.mall.controller;

import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.Product;
import com.dingdong.mall.dto.product.AddProductParam;
import com.dingdong.mall.dto.product.RemoveProductParam;
import com.dingdong.mall.dto.product.UpdateProductParam;
import com.dingdong.mall.service.ProductConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 商品配置Controller
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/admin/config/product")
@Api(tags = "ProductConfigController")
public class ProductConfigController {

    @Autowired
    private ProductConfigService productConfigService;

    @ApiOperation("添加商品")
    @RequestMapping(method = RequestMethod.POST, value = "/add", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult addProduct(@RequestBody AddProductParam param) {
        Product product = productConfigService.addProduct(param);
        if (product == null) return CommonResult.failed();
        return CommonResult.success();
    }

    @ApiOperation("移除商品")
    @RequestMapping(method = RequestMethod.POST, value = "/remove", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult removeProduct(@RequestBody RemoveProductParam param) {
        Product product = productConfigService.removeProduct(param);
        if (product == null) return CommonResult.failed();
        return CommonResult.success();
    }

    @ApiOperation("更新商品")
    @RequestMapping(method = RequestMethod.POST, value = "/update", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult updateProduct(@RequestBody UpdateProductParam param) {
        Product product = productConfigService.updateProduct(param);
        if (product == null) return CommonResult.failed();
        return CommonResult.success();
    }

}
