package com.dingdong.mall.controller;

import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.ProductBrand;
import com.dingdong.mall.dto.BrandParam;
import com.dingdong.mall.dto.CategoryParam;
import com.dingdong.mall.dto.KeywordParam;
import com.dingdong.mall.service.ProductService;
import com.dingdong.mall.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST,value = "/getAll",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult getAll(@RequestParam("pageNum") Integer pageNum, @RequestParam Integer pageSize){
        List<ProductVo> productVoList = productService.selectAll(pageNum, pageSize);
        if (productVoList==null) return CommonResult.failed();

        Integer total = productService.countAll();

        Map<String,Object> map= new HashMap<>();
        map.put("total",total);
        map.put("products",productVoList);

        return CommonResult.success(map);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getByCategory",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult getByCategory(@RequestBody CategoryParam param, @RequestParam("pageNum") Integer pageNum, @RequestParam Integer pageSize){
        String category = param.getCategory();
        List<ProductVo> productVoList = productService.selectByCategory(category, pageNum, pageSize);
        if (productVoList==null) return CommonResult.failed();

        Integer total =productService.countByCategory(category);

        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("products",productVoList);

        return CommonResult.success(map);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getByBrand",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult getByBrand(@RequestBody BrandParam param, @RequestParam("pageNum") Integer pageNum, @RequestParam Integer pageSize){
        String brand = param.getBrand();
        List<ProductVo> productVoList = productService.selectByBrand(brand, pageNum, pageSize);
        if (productVoList==null) return CommonResult.failed();

        Integer total = productService.countByBrand(brand);

        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("products",productVoList);

        return CommonResult.success(map);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getByKeyword",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult getByKeyword(@RequestBody KeywordParam param, @RequestParam("pageNum") Integer pageNum, @RequestParam Integer pageSize){
        String keyword = param.getKeyword();

        List<ProductVo> productVoList = productService.selectByKeyword(keyword, pageNum, pageSize);
        Integer total = productService.countByKeyword(keyword);

        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("products",productVoList);

        return CommonResult.success(map);
    }

}
