package com.dingdong.mall.dto.userAddressList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AddUserAddressListParam")
public class AddUserAddressListParam {
    @ApiModelProperty(value = "收件人")
    private String consignee;
    @ApiModelProperty(value = "手机号")
    private String phoneNumber;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "详细地址")
    private String detailedAddress;

}
