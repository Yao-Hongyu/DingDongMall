package com.dingdong.mall.dto.shoppingCart;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "BuyShoppingCartParam")
public class BuyShoppingCartParam {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "地址id")
    private Integer addressId;

}
