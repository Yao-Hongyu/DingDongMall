package com.dingdong.mall.controller;

import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.ProductBrand;
import com.dingdong.mall.service.ProductBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品品牌Controller
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/productBrand")
@Api(tags = "ProductBrandController")
public class ProductBrandController {

    @Autowired
    private ProductBrandService productBrandService;

    @ApiOperation("获取全部品牌")
    @RequestMapping(method = RequestMethod.POST, value = "/getAll", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult getAll(@RequestParam("pageNum") @ApiParam("页码") Integer pageNum, @RequestParam @ApiParam("每页数量") Integer pageSize) {
        List<ProductBrand> productBrandList = productBrandService.selectAll(pageNum, pageSize);
        if (productBrandList == null) return CommonResult.failed();

        Integer total = productBrandService.countAll();

        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("brands", productBrandList);

        return CommonResult.success(map);
    }

    @ApiOperation("获取全部品牌名")
    @RequestMapping(method = RequestMethod.POST, value = "/getAllName", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult getAll() {
        List<ProductBrand> productBrandList = productBrandService.selectAll();
        if (productBrandList == null) return CommonResult.failed();

        Integer total = productBrandService.countAll();

        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("brands", productBrandList);

        return CommonResult.success(map);
    }

}
