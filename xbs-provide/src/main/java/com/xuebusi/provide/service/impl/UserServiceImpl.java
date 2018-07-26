package com.xuebusi.provide.service.impl;

import com.xuebusi.xbs.user.api.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author: syj
 * @CreateDate: 2018/7/25 16:39
 */
@Service("userServiceImplRpc")
public class UserServiceImpl implements IUserService {

    @Override
    public String testUser() {
        return "=========xbs=========";
    }
}
