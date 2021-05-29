package com.dingdong.mall.dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RemoveProductParam")
public class RemoveProductParam {
    @ApiModelProperty(value = "id")
    private Integer id;

}
