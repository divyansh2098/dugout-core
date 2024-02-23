package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.UserDTO;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.models.User;
import com.dugout.dugoutcore.pojo.DugoutError;
import com.dugout.dugoutcore.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserDao {
  @NonNull UserRepository userRepository;

  private UserDTO convertToDto(User user) {
    UserDTO userDto = new UserDTO();
    BeanUtils.copyProperties(user, userDto);
    return userDto;
  }

  private User convertToEntity(UserDTO userDto) {
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    return user;
  }

  public UserDTO createUser(UserDTO userDTO) {
    User user = convertToEntity(userDTO);
    User createdUser = userRepository.save(user);
    return convertToDto(createdUser);
  }

  public UserDTO getUser(Long id) throws DugoutDataFetchingException {
    User user = userRepository.findById(id).orElse(null);
    if (ObjectUtils.isEmpty(user)) {
      throw new DugoutDataFetchingException(
              DugoutError.builder()
                      .message(String.format("User with id: %s not found", id))
                      .build(),
              HttpStatus.BAD_REQUEST);
    }
    return convertToDto(user);
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

  public UserDTO updateUser(UserDTO userDTO) throws DugoutDataFetchingException {
    User existingUser = userRepository.findById(userDTO.getId()).orElse(null);
    if (ObjectUtils.isEmpty(existingUser)) {
      throw new DugoutDataFetchingException(
          DugoutError.builder()
              .message(String.format("User with id: %s not found", userDTO.getId()))
              .build(),
          HttpStatus.BAD_REQUEST);
    }
    userDTO.setCreatedOn(existingUser.getCreatedOn());
    User createdUser = userRepository.save(convertToEntity(userDTO));
    return convertToDto(createdUser);
  }
}
