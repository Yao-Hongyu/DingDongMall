package com.dingdong.mall.mappers.mapperExtension;

import com.dingdong.mall.dao.ProductBrand;
import com.dingdong.mall.mappers.mapper.ProductBrandMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductBrandMapperExtension extends ProductBrandMapper {

    /**
     *查询全部商品品牌
     */

    public List<ProductBrand> selectAll();

}
