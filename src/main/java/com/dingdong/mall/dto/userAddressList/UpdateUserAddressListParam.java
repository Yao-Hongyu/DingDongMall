package com.dingdong.mall.dto.userAddressList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "UpdateUserAddressListParam")
public class UpdateUserAddressListParam {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "收件人")
    private String consignee;
    @ApiModelProperty(value = "手机号")
    private String phoneNumber;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "详细地址")
    private String detailedAddress;

}
