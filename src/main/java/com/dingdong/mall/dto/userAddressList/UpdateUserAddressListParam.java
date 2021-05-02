package com.dingdong.mall.dto.userAddressList;

import lombok.Data;

@Data
public class UpdateUserAddressListParam {
    private Integer id;
    private String consignee;
    private String phoneNumber;
    private String address;
    private String detailedAddress;

}
