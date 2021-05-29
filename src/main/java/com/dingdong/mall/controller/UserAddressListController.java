package com.dingdong.mall.controller;

import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.User;
import com.dingdong.mall.dao.UserAddressList;
import com.dingdong.mall.dto.user.UserRegisterParam;
import com.dingdong.mall.dto.userAddressList.AddUserAddressListParam;
import com.dingdong.mall.dto.userAddressList.RemoveUserAddressListParam;
import com.dingdong.mall.dto.userAddressList.UpdateUserAddressListParam;
import com.dingdong.mall.service.UserAddressListService;
import com.dingdong.mall.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户地址簿Controller
 */
@Controller
@CrossOrigin("*")
@RequestMapping("/user/addressList")
@Api(tags = "UserAddressListController")
public class UserAddressListController {

    @Autowired
    private UserAddressListService userAddressListService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("添加地址")
    @RequestMapping(method = RequestMethod.POST, value = "/add", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult userRegister(@RequestBody AddUserAddressListParam param, HttpServletRequest httpServletRequest) {
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
        String username = jwtTokenUtil.getUserNameFromToken(authToken);

        UserAddressList userAddressList = userAddressListService.add(username, param);
        if (userAddressList == null) return CommonResult.failed();

        return CommonResult.success();
    }

    @ApiOperation("更新地址")
    @RequestMapping(method = RequestMethod.POST, value = "/update", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult userRegister(@RequestBody UpdateUserAddressListParam param, HttpServletRequest httpServletRequest) {
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
        String username = jwtTokenUtil.getUserNameFromToken(authToken);

        UserAddressList userAddressList = userAddressListService.update(username, param);
        if (userAddressList == null) return CommonResult.failed();

        return CommonResult.success();
    }

    @ApiOperation("移除地址")
    @RequestMapping(method = RequestMethod.POST, value = "/remove", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult userRegister(@RequestBody RemoveUserAddressListParam param, HttpServletRequest httpServletRequest) {
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
        String username = jwtTokenUtil.getUserNameFromToken(authToken);

        UserAddressList userAddressList = userAddressListService.remove(username, param);
        if (userAddressList == null) return CommonResult.failed();

        return CommonResult.success();
    }

    @ApiOperation("获取全部地址")
    @RequestMapping(method = RequestMethod.POST, value = "/getAll", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult userRegister(HttpServletRequest httpServletRequest, @RequestParam("pageNum") @ApiParam("页码") Integer pageNum, @RequestParam("pageSize") @ApiParam("每页数量") Integer pageSize) {
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
        String username = jwtTokenUtil.getUserNameFromToken(authToken);

        List<UserAddressList> userAddressLists = userAddressListService.getAll(username, pageNum, pageSize);
        Integer count = userAddressListService.count(username);

        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("addresses", userAddressLists);

        return CommonResult.success(map);
    }

}
