package com.dingdong.mall.controller;

import com.dingdong.mall.api.CommonResult;
import com.dingdong.mall.dao.UserShoppingCart;
import com.dingdong.mall.dto.shoppingCart.AddShoppingCartParam;
import com.dingdong.mall.dto.shoppingCart.BuyShoppingCartParam;
import com.dingdong.mall.dto.shoppingCart.RemoveShoppingCartParam;
import com.dingdong.mall.service.UserShoppingCartService;
import com.dingdong.mall.util.JwtTokenUtil;
import com.dingdong.mall.vo.ProductVo;
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
@RequestMapping("/user/shoppingCart")
public class UserShoppingCartController {

    @Autowired
    private UserShoppingCartService userShoppingCartService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @RequestMapping(method = RequestMethod.POST,value = "/getAll",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult getAll(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize, HttpServletRequest httpServletRequest){
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
        String username = jwtTokenUtil.getUserNameFromToken(authToken);
        List<ProductVo> productVoList = userShoppingCartService.selectAll(username, pageNum, pageSize);
        Integer amount = userShoppingCartService.countAll(username);
        if (productVoList==null) return CommonResult.failed();

        Map<String,Object> map = new HashMap<>();
        map.put("total",amount);
        map.put("carts",productVoList);

        return CommonResult.success(map);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult add(@RequestBody AddShoppingCartParam param, HttpServletRequest httpServletRequest){
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
        String username = jwtTokenUtil.getUserNameFromToken(authToken);
        UserShoppingCart userShoppingCart = userShoppingCartService.add(username, param);
        if (userShoppingCart==null) return CommonResult.failed();
        return CommonResult.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/remove",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult remove(@RequestBody RemoveShoppingCartParam param,HttpServletRequest httpServletRequest){
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
        String username = jwtTokenUtil.getUserNameFromToken(authToken);

        UserShoppingCart userShoppingCart = userShoppingCartService.remove(username, param);
        if (userShoppingCart==null) return CommonResult.failed();

        return CommonResult.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/buy",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult buy(@RequestBody BuyShoppingCartParam param,HttpServletRequest httpServletRequest){
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
        String username = jwtTokenUtil.getUserNameFromToken(authToken);

        UserShoppingCart userShoppingCart = userShoppingCartService.buy(username, param);
        if (userShoppingCart==null) return CommonResult.failed();

        return CommonResult.success();
    }

}
