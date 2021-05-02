package com.dingdong.mall.mappers.mapperExtension;

import com.dingdong.mall.mappers.mapper.ProductMapper;
import com.dingdong.mall.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapperExtension extends ProductMapper {

    /**
     * 查询全部商品
     */
    public List<ProductVo> selectAll();

    /**
     * 分类查询商品
     */
    public List<ProductVo> selectByCategory(String category);

    /**
     * 分品牌查询商品
     */
    public List<ProductVo> selectByBrand(String brand);

    /**
     * 根据关键词查询商品
     */
    public List<ProductVo> selectByKeyword(String keyword);

    /**
     * 根据Id查询商品
     */
    public ProductVo selectById(Integer id);

}
