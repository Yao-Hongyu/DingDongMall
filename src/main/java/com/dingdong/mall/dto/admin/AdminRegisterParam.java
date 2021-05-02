package com.dingdong.mall.dto.admin;

import lombok.Data;

@Data
public class AdminRegisterParam {

    private String username;
    private String password;
    private String secretKey;

}
