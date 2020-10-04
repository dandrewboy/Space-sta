package com.spacesta.dao;

import com.spacesta.models.User;

public interface UserDao {

  int register(User user);

  User validateUser(User user);
}
