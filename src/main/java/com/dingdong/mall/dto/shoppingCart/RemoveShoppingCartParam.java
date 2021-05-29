package com.dingdong.mall.dto.shoppingCart;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RemoveShoppingCartParam")
public class RemoveShoppingCartParam {
    @ApiModelProperty(value = "id")
    private Integer id;

}
