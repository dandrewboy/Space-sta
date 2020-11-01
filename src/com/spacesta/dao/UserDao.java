package com.spacesta.dao;

import java.util.List;

import com.spacesta.models.User;

public interface UserDao {

  int register(User user);

  User validateUser(User user);
  
  boolean checkRegister(User user);
  
  List<User> getUsers();
}
