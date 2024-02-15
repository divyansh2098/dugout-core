package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dao.UserDao;
import com.dugout.dugoutcore.dto.UserDTO;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService {

  @Autowired
  UserDao userDao;

  public UserDTO getUser(Long id) throws DugoutDataFetchingException {
    return userDao.getUser(id);
  }

  @Transactional
  public UserDTO createUser(UserDTO userDto) {
    return userDao.createUser(userDto);
  }

  @Transactional
  @SneakyThrows
  public UserDTO updateUser(UserDTO userDto) {
    return userDao.updateUser(userDto);
  }
}
