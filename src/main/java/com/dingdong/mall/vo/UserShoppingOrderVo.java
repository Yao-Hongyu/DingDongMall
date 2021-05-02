package com.dingdong.mall.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserShoppingOrderVo implements Serializable {
    private Integer id;
    private Integer userId;
    private String consignee;
    private String phoneNumber;
    private String address;
    private String detailedAddress;
    private String name;
    private String subhead;
    private String brand;
    private String category;
    private String description;
    private Integer price;
    private String picture;
    private Integer amount;
    private Date updateTime;

}
