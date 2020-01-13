package com.bookmall.service;

import com.bookmall.bean.User;

/**
 * User业务接口
 */
public interface UserService {
    /**
     * 注册用户
     *
     * @param user
     */
    void regist(User user);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);


    /**
     * 断用户名是否存在
     *
     * @param username
     * @return: 如果用户名存在，返回true
     *          用户名不存在，返回false
     */
    boolean existUsername(String username);
}
