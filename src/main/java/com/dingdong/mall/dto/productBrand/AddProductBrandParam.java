package com.dingdong.mall.dto.productBrand;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AddProductBrandParam")
public class AddProductBrandParam {
    @ApiModelProperty(value = "品牌名")
    private String brandName;
    @ApiModelProperty(value = "副标题")
    private String subhead;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "品牌图片")
    private String brandPic;

}
