package com.dingdong.mall.service.impl;

import com.dingdong.mall.dao.*;
import com.dingdong.mall.dto.shoppingCart.AddShoppingCartParam;
import com.dingdong.mall.dto.shoppingCart.BuyShoppingCartParam;
import com.dingdong.mall.dto.shoppingCart.RemoveShoppingCartParam;
import com.dingdong.mall.dto.shoppingOrder.AddShoppingOrderParam;
import com.dingdong.mall.mappers.mapperExtension.ProductMapperExtension;
import com.dingdong.mall.mappers.mapperExtension.UserMapperExtension;
import com.dingdong.mall.mappers.mapperExtension.UserShoppingCartMapperExtension;
import com.dingdong.mall.service.UserShoppingCartService;
import com.dingdong.mall.service.UserShoppingOrderService;
import com.dingdong.mall.vo.ProductVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserShoppingCartServiceImpl implements UserShoppingCartService {

    @Autowired
    private UserMapperExtension userMapperExtension;
    @Autowired
    private ProductMapperExtension productMapperExtension;
    @Autowired
    private UserShoppingCartMapperExtension userShoppingCartMapperExtension;
    @Autowired
    private UserShoppingOrderService userShoppingOrderService;

    @Override
    public UserShoppingCart add(String username, AddShoppingCartParam param) {
        Integer productId = param.getId();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapperExtension.selectByExample(userExample);
        User user = userList.get(0);
        Integer userId = user.getId();

        Product product = productMapperExtension.selectByPrimaryKey(productId);
        if (product==null) return null;

        UserShoppingCartExample userShoppingCartExample = new UserShoppingCartExample();
        userShoppingCartExample.createCriteria().andProductIdEqualTo(productId).andUserIdEqualTo(userId);
        List<UserShoppingCart> userShoppingCartList = userShoppingCartMapperExtension.selectByExample(userShoppingCartExample);
        UserShoppingCart userShoppingCart = new UserShoppingCart();
        if (userShoppingCartList.size()==1){
            userShoppingCart = userShoppingCartList.get(0);
            Integer amount = userShoppingCart.getAmount();
            userShoppingCart.setAmount(amount+1);
            userShoppingCartMapperExtension.updateByPrimaryKey(userShoppingCart);
        } else {
            userShoppingCart.setUserId(userId);
            userShoppingCart.setProductId(productId);
            userShoppingCart.setAmount(1);
            userShoppingCartMapperExtension.insert(userShoppingCart);
        }

        return userShoppingCart;
    }

    @Override
    public UserShoppingCart remove(String username, RemoveShoppingCartParam param) {
        Integer productId = param.getId();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapperExtension.selectByExample(userExample);
        User user = userList.get(0);
        Integer userId = user.getId();

        Product product = productMapperExtension.selectByPrimaryKey(productId);
        if (product==null) return null;

        UserShoppingCartExample userShoppingCartExample = new UserShoppingCartExample();
        userShoppingCartExample.createCriteria().andProductIdEqualTo(productId).andUserIdEqualTo(userId);
        List<UserShoppingCart> userShoppingCartList = userShoppingCartMapperExtension.selectByExample(userShoppingCartExample);
        if (userShoppingCartList==null) return null;

        UserShoppingCart userShoppingCart = userShoppingCartList.get(0);
        Integer amount = userShoppingCart.getAmount();
        Integer userShoppingCartId = userShoppingCart.getId();
        if (amount==1) {
            userShoppingCartMapperExtension.deleteByPrimaryKey(userShoppingCartId);
        } else {
            userShoppingCart.setAmount(amount-1);
            userShoppingCartMapperExtension.updateByPrimaryKey(userShoppingCart);
        }

        return userShoppingCart;
    }

    @Override
    public UserShoppingCart buy(String username, BuyShoppingCartParam param) {
        Integer cartId = param.getId();
        Integer addressId = param.getAddressId();

        UserShoppingCart userShoppingCart = userShoppingCartMapperExtension.selectByPrimaryKey(cartId);
        userShoppingCartMapperExtension.deleteByPrimaryKey(cartId);
        if (userShoppingCart==null) return null;

        AddShoppingOrderParam addShoppingOrderParam = new AddShoppingOrderParam();
        addShoppingOrderParam.setId(userShoppingCart.getProductId());
        addShoppingOrderParam.setAddressId(addressId);
        addShoppingOrderParam.setAmount(userShoppingCart.getAmount());

        userShoppingOrderService.add(username,addShoppingOrderParam);

        return userShoppingCart;
    }

    @Override
    public List<ProductVo> selectAll(String username, Integer pageNum, Integer pageSize) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapperExtension.selectByExample(userExample);
        User user = userList.get(0);
        Integer userId = user.getId();

        PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> productVoList = userShoppingCartMapperExtension.selectAll(userId);

        return productVoList;
    }

    @Override
    public Integer countAll(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapperExtension.selectByExample(userExample);
        User user = userList.get(0);
        Integer userId = user.getId();

        List<ProductVo> productVoList = userShoppingCartMapperExtension.selectAll(userId);

        return productVoList.size();
    }
}
