package com.dingdong.mall.mappers.mapper;

import com.dingdong.mall.dao.UserAddressList;
import com.dingdong.mall.dao.UserAddressListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAddressListMapper {
    long countByExample(UserAddressListExample example);

    int deleteByExample(UserAddressListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAddressList record);

    int insertSelective(UserAddressList record);

    List<UserAddressList> selectByExample(UserAddressListExample example);

    UserAddressList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAddressList record, @Param("example") UserAddressListExample example);

    int updateByExample(@Param("record") UserAddressList record, @Param("example") UserAddressListExample example);

    int updateByPrimaryKeySelective(UserAddressList record);

    int updateByPrimaryKey(UserAddressList record);
}