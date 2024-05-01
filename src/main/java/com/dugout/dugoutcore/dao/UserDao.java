package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.UserDTO;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.models.User;
import com.dugout.dugoutcore.pojo.DugoutError;
import com.dugout.dugoutcore.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDao extends BaseDao<User, UserDTO, UserRepository> {
  private UserRepository userRepository;

  @Autowired
  public UserDao(UserRepository userRepository) {
    super(userRepository, User.class, UserDTO.class);
    this.userRepository = userRepository;
  }

  public UserDTO getUserByPhoneNumber(String phoneNumber) throws DugoutDataFetchingException {
    User user = userRepository.findByPhone(phoneNumber).orElse(null);
    if (ObjectUtils.isEmpty(user)) {
      throw new DugoutDataFetchingException(
          DugoutError.builder()
              .message(String.format("User with phoneNumber: %s not found", phoneNumber))
              .build(),
          HttpStatus.BAD_REQUEST);
    }
    return convertToDto(user);
  }

  public UserDTO getUserByUserName(String userName) throws DugoutDataFetchingException {
    if (userName == null) {
      log.info("Null User Name provided");
      return null;
    }
    User user = userRepository.findByUserName(userName).orElse(null);
    return convertToDto(user);
  }
}
