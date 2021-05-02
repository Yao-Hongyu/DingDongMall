package com.dingdong.mall.service;

import com.dingdong.mall.dao.UserAddressList;
import com.dingdong.mall.dto.userAddressList.AddUserAddressListParam;
import com.dingdong.mall.dto.userAddressList.RemoveUserAddressListParam;
import com.dingdong.mall.dto.userAddressList.UpdateUserAddressListParam;

import java.util.List;

public interface UserAddressListService {

    /**
     * 添加常用地址
     */
    public UserAddressList add(String username, AddUserAddressListParam param);

    /**
     * 更新常用地址
     */
    public UserAddressList update(String username, UpdateUserAddressListParam param);

    /**
     * 删除常用地址
     */
    public UserAddressList remove(String username, RemoveUserAddressListParam param);

    /**
     * 获取常用地址
     */
    public List<UserAddressList> getAll(String username,Integer pageNum,Integer pageSize);

    /**
     * 获取常用地址数
     */
    public Integer count(String username);

}
