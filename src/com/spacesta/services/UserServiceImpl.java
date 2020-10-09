package com.spacesta.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.spacesta.dao.UserDao;
import com.spacesta.models.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(User user) {
    return userDao.validateUser(user);
  }

public boolean checkRegister(User user) {
	return userDao.checkRegister(user);
}

}