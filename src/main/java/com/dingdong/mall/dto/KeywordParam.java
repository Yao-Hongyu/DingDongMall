package com.dingdong.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "KeywordParam")
public class KeywordParam {
    @ApiModelProperty(value = "关键字")
    private String keyword;

}
