package com.dingdong.mall.dto.product;

import lombok.Data;

@Data
public class AddProductParam {

    private String name;
    private String subhead;
    private String brand;
    private String category;
    private String description;
    private Integer price;
    private String picture;

}
