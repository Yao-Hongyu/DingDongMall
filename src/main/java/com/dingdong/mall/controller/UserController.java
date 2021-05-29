package com.dingdong.mall.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.User;
import com.dingdong.mall.dto.user.UserLoginParam;
import com.dingdong.mall.dto.user.UserRegisterParam;
import com.dingdong.mall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户Controller
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/user")
@Api(tags = "UserController")
public class UserController {

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
    @RequestMapping(method = RequestMethod.POST, value = "/register", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult userRegister(@RequestBody UserRegisterParam param) {
        User user = userService.register(param);
        if (user == null) return CommonResult.failed("注册失败");
        return CommonResult.success();
    }

    @ApiOperation("用户登录")
    @RequestMapping(method = RequestMethod.POST, value = "/login", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult userLogin(@RequestBody UserLoginParam param) {
        String token = userService.login(param);
        if (token == null) return CommonResult.loginFailed();
        JSONObject json = JSONUtil.createObj();
        json.put("tokenHead", tokenHead);
        json.put("token", token);
        return CommonResult.loginSuccess(json);
    }

}
