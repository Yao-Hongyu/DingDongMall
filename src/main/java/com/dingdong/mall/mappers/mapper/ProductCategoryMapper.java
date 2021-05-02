package com.dingdong.mall.mappers.mapper;

import com.dingdong.mall.dao.ProductCategory;
import com.dingdong.mall.dao.ProductCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCategoryMapper {
    long countByExample(ProductCategoryExample example);

    int deleteByExample(ProductCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    List<ProductCategory> selectByExampleWithBLOBs(ProductCategoryExample example);

    List<ProductCategory> selectByExample(ProductCategoryExample example);

    ProductCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    int updateByExample(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKeyWithBLOBs(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}