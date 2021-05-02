package com.dingdong.mall.controller;

import cn.hutool.core.collection.CollUtil;
import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.UserShoppingOrder;
import com.dingdong.mall.dto.shoppingOrder.AddShoppingOrderParam;
import com.dingdong.mall.service.UserShoppingCartService;
import com.dingdong.mall.service.UserShoppingOrderService;
import com.dingdong.mall.util.JwtTokenUtil;
import com.dingdong.mall.vo.UserShoppingOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin("*")
@RequestMapping("/user/shoppingOrder")
public class UserShoppingOrderController {

    @Autowired
    private UserShoppingOrderService userShoppingOrderService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @RequestMapping(method = RequestMethod.POST,value = "/add",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult add(@RequestBody AddShoppingOrderParam param, HttpServletRequest httpServletRequest){
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
        String username = jwtTokenUtil.getUserNameFromToken(authToken);

        UserShoppingOrder userShoppingOrder = userShoppingOrderService.add(username, param);
        if (userShoppingOrder==null) return CommonResult.failed();

        return CommonResult.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getAll",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult getAll(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize,HttpServletRequest httpServletRequest){
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
        String username = jwtTokenUtil.getUserNameFromToken(authToken);

        List<UserShoppingOrderVo> userShoppingOrderVoList = userShoppingOrderService.selectAll(username, pageNum, pageSize);
        Integer amount = userShoppingOrderService.countAll(username);

        Map<String ,Object> map = new HashMap<>();

        map.put("total",amount);
        map.put("orders",userShoppingOrderVoList);

        return CommonResult.success(map);
    }

}
