package com.dingdong.mall.service.impl;

import com.dingdong.mall.dao.*;
import com.dingdong.mall.dto.admin.AdminLoginParam;
import com.dingdong.mall.dto.admin.AdminRegisterParam;
import com.dingdong.mall.mappers.mapperExtension.RoleMapperExtension;
import com.dingdong.mall.mappers.mapperExtension.UserMapperExtension;
import com.dingdong.mall.mappers.mapperExtension.UserRoleMapperExtension;
import com.dingdong.mall.service.AdminService;
import com.dingdong.mall.util.JwtTokenUtil;
import com.dingdong.mall.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);
    @Autowired
    private UserMapperExtension userMapperExtension;
    @Autowired
    private RoleMapperExtension roleMapperExtension;
    @Autowired
    private UserRoleMapperExtension userRoleMapperExtension;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserVo getUserByUsername(String username) {
        List<UserVo> userVos = userMapperExtension.findByUsername(username);
        if (userVos.size()!=1) return null;
        UserVo userVo = userVos.get(0);

        return userVo;
    }

    @Override
    public User register(AdminRegisterParam param) {
        String username = param.getUsername();
        String password = param.getPassword();
        String secretKey = param.getSecretKey();
        if (!secretKey.equals("ddmall@key")) return null;

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapperExtension.selectByExample(userExample);
        if (users.size()!=0) return null;

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userMapperExtension.insert(user);
        users = userMapperExtension.selectByExample(userExample);
        if (users.size()!=1) return null;
        user = users.get(0);
        Integer userId = user.getId();

        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleEqualTo("ROLE_ADMIN");
        List<Role> roles = roleMapperExtension.selectByExample(roleExample);
        if (roles.size()!=1) return null;
        Role role = roles.get(0);
        Integer roleId = role.getId();

        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(userId);
        List<UserRole> userRoles = userRoleMapperExtension.selectByExample(userRoleExample);
        if (userRoles.size()!=0) return null;

        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setUserRole(roleId);
        userRoleMapperExtension.insert(userRole);

        return user;
    }

    @Override
    public String login(AdminLoginParam param) {
        String token = null;

        String username = param.getUsername();
        String password = param.getPassword();

        List<UserVo> userVoList = userMapperExtension.findByUsername(username);
        if (userVoList.size()!=1) return null;
        UserVo userVo = userVoList.get(0);
        String role = userVo.getRole();
        if (!role.equals("ROLE_ADMIN")) return null;

        try{
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e){
            LOGGER.warn("登录异常:{}",e.getMessage());
        }
        return token;
    }
}
