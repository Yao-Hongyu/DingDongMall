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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 商品品牌配置Controller
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/admin/config/productBrand")
@Api(tags = "ProductBrandConfigController")
public class ProductBrandConfigController {

    @Autowired
    private ProductBrandConfigService productBrandConfigService;

    @ApiOperation("添加商品品牌")
    @RequestMapping(method = RequestMethod.POST, value = "/add", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult addProductBrand(@RequestBody AddProductBrandParam param) {
        ProductBrand productBrand = productBrandConfigService.addProductBrand(param);
        if (productBrand == null) return CommonResult.failed();
        return CommonResult.success();
    }

    @ApiOperation("移除商品品牌")
    @RequestMapping(method = RequestMethod.POST, value = "/remove", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult removeProductBrand(@RequestBody RemoveProductBrandParam param) {
        ProductBrand productBrand = productBrandConfigService.removeProductBrand(param);
        if (productBrand == null) return CommonResult.failed();
        return CommonResult.success();
    }

    @ApiOperation("更新商品品牌")
    @RequestMapping(method = RequestMethod.POST, value = "/update", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult updateProductBrand(@RequestBody UpdateProductBrandParam param) {
        ProductBrand productBrand = productBrandConfigService.updateProductBrand(param);
        if (productBrand == null) return CommonResult.failed();
        return CommonResult.success();
    }

}
