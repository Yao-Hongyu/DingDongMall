package com.dingdong.mall.service.impl;

import com.dingdong.mall.dao.User;
import com.dingdong.mall.dao.UserAddressList;
import com.dingdong.mall.dao.UserAddressListExample;
import com.dingdong.mall.dao.UserExample;
import com.dingdong.mall.dto.userAddressList.AddUserAddressListParam;
import com.dingdong.mall.dto.userAddressList.RemoveUserAddressListParam;
import com.dingdong.mall.dto.userAddressList.UpdateUserAddressListParam;
import com.dingdong.mall.mappers.mapperExtension.UserAddressListMapperExtension;
import com.dingdong.mall.mappers.mapperExtension.UserMapperExtension;
import com.dingdong.mall.service.UserAddressListService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressListServiceImpl implements UserAddressListService {

    @Autowired
    private UserMapperExtension userMapperExtension;
    @Autowired
    private UserAddressListMapperExtension userAddressListMapperExtension;

    @Override
    public UserAddressList add(String username, AddUserAddressListParam param) {
        String consignee = param.getConsignee();
        String phoneNumber = param.getPhoneNumber();
        String address = param.getAddress();
        String detailedAddress = param.getDetailedAddress();

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapperExtension.selectByExample(userExample);
        if (userList.size()!=1) return null;

        User user = userList.get(0);
        Integer userId = user.getId();

        UserAddressListExample userAddressListExample = new UserAddressListExample();
        UserAddressList userAddressList = new UserAddressList();
        userAddressListExample.createCriteria().andUserIdEqualTo(userId).andConsigneeEqualTo(consignee).andPhonenumberEqualTo(
                phoneNumber).andAddressEqualTo(address).andDetailedAddressEqualTo(detailedAddress);
        List<UserAddressList> userAddressLists = userAddressListMapperExtension.selectByExample(userAddressListExample);
        if (userAddressLists.size()==1){
            userAddressList = userAddressLists.get(0);
            userAddressList.setIson(true);
            userAddressListMapperExtension.updateByPrimaryKey(userAddressList);
        } else {
            userAddressList.setUserId(userId);
            userAddressList.setConsignee(consignee);
            userAddressList.setPhonenumber(phoneNumber);
            userAddressList.setAddress(address);
            userAddressList.setDetailedAddress(detailedAddress);
            userAddressList.setIson(true);
            userAddressListMapperExtension.insert(userAddressList);
        }


        return userAddressList;
    }

    @Override
    public UserAddressList update(String username, UpdateUserAddressListParam param) {
        Integer id = param.getId();
        String consignee = param.getConsignee();
        String phoneNumber = param.getPhoneNumber();
        String address = param.getAddress();
        String detailedAddress = param.getDetailedAddress();

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapperExtension.selectByExample(userExample);
        if (userList.size()!=1) return null;
        User user = userList.get(0);
        Integer userId = user.getId();

        UserAddressList userAddressList = userAddressListMapperExtension.selectByPrimaryKey(id);
        if (userAddressList==null) return null;

        userAddressList.setId(id);
        userAddressList.setUserId(userId);
        userAddressList.setConsignee(consignee);
        userAddressList.setPhonenumber(phoneNumber);
        userAddressList.setAddress(address);
        userAddressList.setDetailedAddress(detailedAddress);
        userAddressList.setIson(true);

        userAddressListMapperExtension.updateByPrimaryKey(userAddressList);

        return userAddressList;
    }

    @Override
    public UserAddressList remove(String username, RemoveUserAddressListParam param) {
        Integer id = param.getId();
        UserAddressList userAddressList = userAddressListMapperExtension.selectByPrimaryKey(id);
        if (userAddressList==null) return null;

        userAddressList.setIson(false);
        userAddressListMapperExtension.updateByPrimaryKey(userAddressList);

        return userAddressList;
    }

    @Override
    public List<UserAddressList> getAll(String username,Integer pageNum,Integer pageSize) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapperExtension.selectByExample(userExample);
        if (userList.size()!=1) return null;

        User user = userList.get(0);
        Integer userId = user.getId();

        UserAddressListExample userAddressListExample = new UserAddressListExample();
        userAddressListExample.createCriteria().andUserIdEqualTo(userId).andIsonEqualTo(true);
        PageHelper.startPage(pageNum,pageSize);
        List<UserAddressList> userAddressLists = userAddressListMapperExtension.selectByExample(userAddressListExample);

        return userAddressLists;
    }

    @Override
    public Integer count(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapperExtension.selectByExample(userExample);
        if (userList.size()!=1) return null;

        User user = userList.get(0);
        Integer userId = user.getId();

        UserAddressListExample userAddressListExample = new UserAddressListExample();
        userAddressListExample.createCriteria().andUserIdEqualTo(userId).andIsonEqualTo(true);
        List<UserAddressList> userAddressLists = userAddressListMapperExtension.selectByExample(userAddressListExample);

        return userAddressLists.size();
    }
}
