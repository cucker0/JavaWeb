package com.bookmall.daoimpl;

import com.bookmall.bean.User;
import com.bookmall.dao.BaseDao4Transaction;
import com.bookmall.dao.UserDao;

public class UserDaoImpl extends BaseDao4Transaction<User> implements UserDao {
    // 构造器
    public UserDaoImpl() {}

    // 方法
    @Override
    public User queryUserByUsernameAndPassword(User user) {
        String sql = "SELECT id, username, `password`, email FROM t_user WHERE username = ? AND `password` = ?;";
        return getBean(sql, user.getUsername(), user.getPassword());
    }

    @Override
    public Integer saveUser(User user) {
        String sql = "INSERT INTO t_user (username, `password`, email) VALUES (?, ?, ?);";
        return insert(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public boolean queryUserByUsername(String username) {
        String sql = "SELECT id, username, `password`, email FROM t_user WHERE username = ?;";
        User user = getBean(sql, username);
        return user != null;
    }
}
