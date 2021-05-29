package com.dingdong.mall.dto.shoppingOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AddShoppingOrderParam")
public class AddShoppingOrderParam {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "数量")
    private Integer amount;
    @ApiModelProperty(value = "地址id")
    private Integer addressId;

}
