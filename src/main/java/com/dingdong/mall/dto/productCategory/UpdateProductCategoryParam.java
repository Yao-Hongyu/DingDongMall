package com.dingdong.mall.dto.productCategory;

import lombok.Data;

@Data
public class UpdateProductCategoryParam {

    private Integer id;
    private String categoryName;
    private String categoryPic;

}
