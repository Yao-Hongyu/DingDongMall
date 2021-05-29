package com.dingdong.mall.dto.productCategory;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "UpdateProductCategoryParam")
public class UpdateProductCategoryParam {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "类别名")
    private String categoryName;
    @ApiModelProperty(value = "类别图片")
    private String categoryPic;

}
