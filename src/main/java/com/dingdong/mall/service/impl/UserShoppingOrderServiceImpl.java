package com.dingdong.mall.service.impl;

import com.dingdong.mall.dao.*;
import com.dingdong.mall.dto.shoppingOrder.AddShoppingOrderParam;
import com.dingdong.mall.mappers.mapperExtension.*;
import com.dingdong.mall.service.UserShoppingOrderService;
import com.dingdong.mall.vo.ProductVo;
import com.dingdong.mall.vo.UserShoppingOrderVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserShoppingOrderServiceImpl implements UserShoppingOrderService {

    @Autowired
    private UserMapperExtension userMapperExtension;
    @Autowired
    private ProductMapperExtension productMapperExtension;
    @Autowired
    private UserAddressListMapperExtension userAddressListMapperExtension;
    @Autowired
    private UserShoppingOrderMapperExtension userShoppingOrderMapperExtension;

    @Override
    public UserShoppingOrder add(String username,AddShoppingOrderParam param) {
        Integer productId = param.getId();
        Integer amount = param.getAmount();
        Integer addressId = param.getAddressId();

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapperExtension.selectByExample(userExample);
        User user = userList.get(0);
        Integer userId = user.getId();

        ProductVo productVo = productMapperExtension.selectById(productId);

        UserAddressList userAddressList = userAddressListMapperExtension.selectByPrimaryKey(addressId);
        if (userAddressList==null) return null;

        UserShoppingOrder userShoppingOrder = new UserShoppingOrder();
        userShoppingOrder.setUserId(userId);
        userShoppingOrder.setAddressId(addressId);
        userShoppingOrder.setName(productVo.getName());
        userShoppingOrder.setSubhead(productVo.getSubhead());
        userShoppingOrder.setBrand(productVo.getBrand());
        userShoppingOrder.setCategory(productVo.getCategory());
        userShoppingOrder.setDescription(productVo.getDescription());
        userShoppingOrder.setPrice(productVo.getPrice());
        userShoppingOrder.setPicture(productVo.getPicture());
        userShoppingOrder.setAmount(amount);

        userShoppingOrderMapperExtension.insert(userShoppingOrder);

        return userShoppingOrder;
    }

    @Override
    public List<UserShoppingOrderVo> selectAll(String username, Integer pageNum, Integer pageSize) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapperExtension.selectByExample(userExample);
        User user = userList.get(0);
        Integer userId = user.getId();

        PageHelper.startPage(pageNum,pageSize);
        List<UserShoppingOrderVo> userShoppingOrderVoList = userShoppingOrderMapperExtension.selectByUserId(userId);

        return userShoppingOrderVoList;
    }

    @Override
    public Integer countAll(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapperExtension.selectByExample(userExample);
        User user = userList.get(0);
        Integer userId = user.getId();

        List<UserShoppingOrderVo> userShoppingOrderVoList = userShoppingOrderMapperExtension.selectByUserId(userId);

        return userShoppingOrderVoList.size();
    }
}
