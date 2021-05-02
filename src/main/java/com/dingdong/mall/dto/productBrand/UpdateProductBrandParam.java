package com.dingdong.mall.dto.productBrand;

import lombok.Data;

@Data
public class UpdateProductBrandParam {

    private Integer id;
    private String brandName;
    private String subhead;
    private String description;
    private String brandPic;

}
