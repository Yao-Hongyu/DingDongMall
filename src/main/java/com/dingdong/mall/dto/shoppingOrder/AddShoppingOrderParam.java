package com.dingdong.mall.dto.shoppingOrder;

import lombok.Data;

@Data
public class AddShoppingOrderParam {
    private Integer id;
    private Integer amount;
    private Integer addressId;

}
