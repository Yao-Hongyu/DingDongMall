package com.dingdong.mall.mappers.mapper;

import com.dingdong.mall.dao.UserShoppingCart;
import com.dingdong.mall.dao.UserShoppingCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserShoppingCartMapper {
    long countByExample(UserShoppingCartExample example);

    int deleteByExample(UserShoppingCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserShoppingCart record);

    int insertSelective(UserShoppingCart record);

    List<UserShoppingCart> selectByExample(UserShoppingCartExample example);

    UserShoppingCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserShoppingCart record, @Param("example") UserShoppingCartExample example);

    int updateByExample(@Param("record") UserShoppingCart record, @Param("example") UserShoppingCartExample example);

    int updateByPrimaryKeySelective(UserShoppingCart record);

    int updateByPrimaryKey(UserShoppingCart record);
}