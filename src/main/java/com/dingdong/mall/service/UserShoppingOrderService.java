package com.dingdong.mall.service;

import com.dingdong.mall.dao.UserShoppingOrder;
import com.dingdong.mall.dto.shoppingOrder.AddShoppingOrderParam;
import com.dingdong.mall.vo.UserShoppingOrderVo;

import java.util.List;

public interface UserShoppingOrderService {

    /**
     * 立即购买
     */
    public UserShoppingOrder add(String username,AddShoppingOrderParam param);

    /**
     * 获取全部订单
     */
    public List<UserShoppingOrderVo> selectAll(String username, Integer pageNum, Integer pageSize);

    /**
     * 获取全部订单数
     */
    public Integer countAll(String username);

}
