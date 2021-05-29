package com.dingdong.mall.dto.productBrand;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RemoveProductBrandParam")
public class RemoveProductBrandParam {
    @ApiModelProperty(value = "id")
    private Integer id;

}
