package com.mm.service;

import com.mm.entity.Admin;

/**
 * @author 茂茂
 * @create 2022-02-11 16:41
 */
public interface AdminService {
    /**
     * 登录验证
     *
     * @param userName 传入的用户名
     * @param passWord 传入的密码
     * @return 一个Admin对象,Admin!=null则通过登录验证.
     */
    Admin login(String userName, String passWord);
}
