package com.dingdong.mall.security;

import com.dingdong.mall.vo.UserVo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;


/**
 * SpringSecurity需要的用户详情
 */
public class AdminUserDetails implements UserDetails {
    private UserVo userVo;
    private Collection<? extends GrantedAuthority> authorities;

    public AdminUserDetails(UserVo userVo) {
        this.userVo=userVo;
        authorities= Collections.singleton(new SimpleGrantedAuthority(userVo.getRole()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return authorities;
    }
    @Override
    public String getPassword() {
        return userVo.getPassword();
    }
    @Override
    public String getUsername() {
        return userVo.getUsername();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
