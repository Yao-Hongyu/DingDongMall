package com.dingdong.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "BrandParam")
public class BrandParam {
    @ApiModelProperty(value = "品牌名")
    private String brand;

}
