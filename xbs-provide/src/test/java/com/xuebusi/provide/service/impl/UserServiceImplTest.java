package com.xuebusi.provide.service.impl;

import com.xuebusi.test.BaseTest;
import com.xuebusi.xbs.user.api.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: syj
 * @CreateDate: 2018/7/25 17:46
 */
public class UserServiceImplTest extends BaseTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testUser() {
        String result = userService.testUser();
        System.out.println("返回结果:" + result);
    }
}