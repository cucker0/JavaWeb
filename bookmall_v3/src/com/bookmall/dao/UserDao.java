package com.bookmall.dao;

import com.bookmall.bean.User;

public interface UserDao {

    /**
     * 根据用户名、密码 查找用户
     *
     * @param user: 根据用户名、密码生成的User对象
     * @return: 查找到的User对象
     *          null: 用户不存在
     */
    User queryUserByUsernameAndPassword(User user);


    /**
     * 保存用户信息
     *
     * @param user: 要保存的User对象
     * @return: 返回新插入用户的id
     */
    Integer saveUser(User user);

    /**
     * 检查用户名是否存在
     *
     * @param username: 用户名
     * @return: 检查结果
     *      true: 用户存在
     *      false: 用户不存在
     */
    boolean queryUserByUsername(String username);
}
