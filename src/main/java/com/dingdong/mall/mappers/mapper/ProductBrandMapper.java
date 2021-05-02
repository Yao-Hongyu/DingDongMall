package com.dingdong.mall.mappers.mapper;

import com.dingdong.mall.dao.ProductBrand;
import com.dingdong.mall.dao.ProductBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductBrandMapper {
    long countByExample(ProductBrandExample example);

    int deleteByExample(ProductBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductBrand record);

    int insertSelective(ProductBrand record);

    List<ProductBrand> selectByExampleWithBLOBs(ProductBrandExample example);

    List<ProductBrand> selectByExample(ProductBrandExample example);

    ProductBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductBrand record, @Param("example") ProductBrandExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductBrand record, @Param("example") ProductBrandExample example);

    int updateByExample(@Param("record") ProductBrand record, @Param("example") ProductBrandExample example);

    int updateByPrimaryKeySelective(ProductBrand record);

    int updateByPrimaryKeyWithBLOBs(ProductBrand record);

    int updateByPrimaryKey(ProductBrand record);
}