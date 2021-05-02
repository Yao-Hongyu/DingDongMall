package com.dingdong.mall.service;

import com.dingdong.mall.dao.User;
import com.dingdong.mall.dto.user.UserLoginParam;
import com.dingdong.mall.dto.user.UserRegisterParam;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    /**
     * 用户注册
     */
    public User register(UserRegisterParam param);

    /**
     * 用户登录
     */
    public String login(UserLoginParam param);

}
