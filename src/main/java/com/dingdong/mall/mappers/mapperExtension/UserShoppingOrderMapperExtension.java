package com.dingdong.mall.mappers.mapperExtension;

import com.dingdong.mall.mappers.mapper.UserShoppingOrderMapper;
import com.dingdong.mall.vo.UserShoppingOrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserShoppingOrderMapperExtension extends UserShoppingOrderMapper {

    /**
     * 根据用户查找订单
     */
    public List<UserShoppingOrderVo> selectByUserId(Integer userId);

}
