package com.dingdong.mall.controller;

import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.ProductBrand;
import com.dingdong.mall.dao.ProductCategory;
import com.dingdong.mall.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin("*")
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(method = RequestMethod.POST,value = "/getAll",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult getAll(@RequestParam("pageNum") Integer pageNum, @RequestParam Integer pageSize){
        List<ProductCategory> productCategoryList = productCategoryService.selectAll(pageNum, pageSize);
        if (productCategoryList==null) return CommonResult.failed();

        Integer total = productCategoryService.countAll();

        Map<String,Object> map= new HashMap<>();
        map.put("total",total);
        map.put("categories",productCategoryList);

        return CommonResult.success(map);

    }

    @RequestMapping(method = RequestMethod.POST,value = "/getAllName",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult getAll(){
        List<ProductCategory> productCategoryList = productCategoryService.selectAll();
        if (productCategoryList==null) return CommonResult.failed();

        Integer total = productCategoryService.countAll();

        Map<String,Object> map= new HashMap<>();
        map.put("total",total);
        map.put("categories",productCategoryList);

        return CommonResult.success(map);

    }

}
