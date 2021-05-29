package com.dingdong.mall.dto.userAddressList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RemoveUserAddressListParam")
public class RemoveUserAddressListParam {
    @ApiModelProperty(value = "id")
    private Integer id;

}
