package com.dingdong.mall.dto.shoppingCart;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AddShoppingCartParam")
public class AddShoppingCartParam {
    @ApiModelProperty(value = "id")
    private Integer id;

}
