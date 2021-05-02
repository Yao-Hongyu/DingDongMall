package com.dingdong.mall.mappers.mapperExtension;

import com.dingdong.mall.dao.ProductCategory;
import com.dingdong.mall.mappers.mapper.ProductCategoryMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCategoryMapperExtension extends ProductCategoryMapper {

    /**
     *查询全部商品类别
     */

    public List<ProductCategory> selectAll();

}
