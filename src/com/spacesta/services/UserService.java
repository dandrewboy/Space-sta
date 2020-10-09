package com.spacesta.services;

import com.spacesta.models.User;

public interface UserService {

  int register(User user);

  User validateUser(User user);
  
  boolean  checkRegister(User user);
}
