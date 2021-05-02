package com.dingdong.mall.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductVo implements Serializable {
    private Integer id;
    private String name;
    private String subhead;
    private String brand;
    private String category;
    private String description;
    private Integer price;
    private String picture;

}
