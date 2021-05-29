package com.dingdong.mall.dto.productCategory;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RemoveProductCategoryParam")
public class RemoveProductCategoryParam {
    @ApiModelProperty(value = "id")
    private Integer id;

}
