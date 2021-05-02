package com.dingdong.mall.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.User;
import com.dingdong.mall.dto.admin.AdminLoginParam;
import com.dingdong.mall.dto.admin.AdminRegisterParam;
import com.dingdong.mall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private AdminService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/register",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult userRegister(@RequestBody AdminRegisterParam param){
        User user = userService.register(param);
        if (user==null) return CommonResult.failed("注册失败");
        return CommonResult.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/login",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult userLogin(@RequestBody AdminLoginParam param){
        String token = userService.login(param);
        if (token==null) return CommonResult.loginFailed();
        JSONObject json = JSONUtil.createObj();
        json.put("tokenHead",tokenHead);
        json.put("token",token);
        return CommonResult.loginSuccess(json);
    }

}
