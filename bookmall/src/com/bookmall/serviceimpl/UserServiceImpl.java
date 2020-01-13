package com.bookmall.serviceimpl;

import com.bookmall.bean.User;
import com.bookmall.dao.UserDao;
import com.bookmall.daoimpl.UserDaoImpl;
import com.bookmall.service.UserService;

public class UserServiceImpl implements UserService {
    protected UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public void regist(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user);
    }

    @Override
    public boolean existUsername(String username) {
        return userDao.queryUserByUsername(username);
    }
}
