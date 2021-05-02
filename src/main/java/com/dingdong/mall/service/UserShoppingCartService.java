package com.dingdong.mall.service;

import com.dingdong.mall.dao.UserShoppingCart;
import com.dingdong.mall.dto.shoppingCart.AddShoppingCartParam;
import com.dingdong.mall.dto.shoppingCart.BuyShoppingCartParam;
import com.dingdong.mall.dto.shoppingCart.RemoveShoppingCartParam;
import com.dingdong.mall.vo.ProductVo;

import java.util.List;

public interface UserShoppingCartService {

    /**
     * 商品添加到购物车
     */
    public UserShoppingCart add(String username,AddShoppingCartParam param);

    /**
     * 商品移除自购物车
     */
    public UserShoppingCart remove(String username,RemoveShoppingCartParam param);

    /**
     * 从购物车购买
     */
    public UserShoppingCart buy(String username,BuyShoppingCartParam param);

    /**
     * 获取购物车所有商品
     */
    public List<ProductVo> selectAll(String username,Integer pageNum,Integer pageSize);

    /**
     * 获取购物车所有商品数
     */
    public Integer countAll(String username);

}
