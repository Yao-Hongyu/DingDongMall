package com.dingdong.mall.mappers.mapper;

import com.dingdong.mall.dao.UserShoppingOrder;
import com.dingdong.mall.dao.UserShoppingOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserShoppingOrderMapper {
    long countByExample(UserShoppingOrderExample example);

    int deleteByExample(UserShoppingOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserShoppingOrder record);

    int insertSelective(UserShoppingOrder record);

    List<UserShoppingOrder> selectByExampleWithBLOBs(UserShoppingOrderExample example);

    List<UserShoppingOrder> selectByExample(UserShoppingOrderExample example);

    UserShoppingOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserShoppingOrder record, @Param("example") UserShoppingOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") UserShoppingOrder record, @Param("example") UserShoppingOrderExample example);

    int updateByExample(@Param("record") UserShoppingOrder record, @Param("example") UserShoppingOrderExample example);

    int updateByPrimaryKeySelective(UserShoppingOrder record);

    int updateByPrimaryKeyWithBLOBs(UserShoppingOrder record);

    int updateByPrimaryKey(UserShoppingOrder record);
}