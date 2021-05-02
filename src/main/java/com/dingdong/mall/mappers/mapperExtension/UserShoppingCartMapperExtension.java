package com.dingdong.mall.mappers.mapperExtension;

import com.dingdong.mall.mappers.mapper.UserShoppingCartMapper;
import com.dingdong.mall.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserShoppingCartMapperExtension extends UserShoppingCartMapper {

    /**
     * 查询购物车全部商品
     */
    public List<ProductVo> selectAll(Integer userId);

}
