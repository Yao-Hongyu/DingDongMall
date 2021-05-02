package com.dingdong.mall.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String role;

}
