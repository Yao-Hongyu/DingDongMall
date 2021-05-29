package com.dingdong.mall.dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "UpdateProductParam")
public class UpdateProductParam {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "标题")
    private String subhead;
    @ApiModelProperty(value = "品牌")
    private String brand;
    @ApiModelProperty(value = "类别")
    private String category;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "价格")
    private Integer price;
    @ApiModelProperty(value = "图片")
    private String picture;

}
