package com.dingdong.mall.service;

import com.dingdong.mall.dao.User;
import com.dingdong.mall.dto.admin.AdminLoginParam;
import com.dingdong.mall.dto.admin.AdminRegisterParam;
import com.dingdong.mall.vo.UserVo;
import org.springframework.transaction.annotation.Transactional;

public interface AdminService {

    /**
     * 通过用户名获取管理员
     */
    public UserVo getUserByUsername(String username);

    /**
     * 管理员注册后台
     */
    public User register(AdminRegisterParam param);

    /**
     * 管理员登录后台
     */
    public String login(AdminLoginParam param);

}
