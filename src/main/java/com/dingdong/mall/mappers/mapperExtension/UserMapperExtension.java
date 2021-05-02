package com.dingdong.mall.mappers.mapperExtension;

import com.dingdong.mall.mappers.mapper.UserMapper;
import com.dingdong.mall.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapperExtension extends UserMapper {

    public List<UserVo> findByUsername(String username);

}
