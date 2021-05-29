package com.dingdong.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CategoryParam")
public class CategoryParam {
    @ApiModelProperty(value = "类别名")
    private String category;

}
