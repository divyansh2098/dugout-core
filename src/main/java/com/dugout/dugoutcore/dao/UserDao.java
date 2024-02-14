package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.UserDTO;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.models.User;
import com.dugout.dugoutcore.pojo.DugoutError;
import com.dugout.dugoutcore.repository.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserDao {
  @NonNull UserRepository userRepository;

  private UserDTO convertToDto(User user) {
    log.info("convertToDto::User " + user.toString());
    UserDTO userDto = new UserDTO();
    BeanUtils.copyProperties(user, userDto);
    log.info("convertToDto::UserDTO " + userDto.toString());
    return userDto;
  }

  private User convertToEntity(UserDTO userDto) {
    log.info("convertToEntity::UserDTO " + userDto.toString());
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    log.info("convertToEntity::User: {}", user);
    return user;
  }

  public UserDTO createUser(UserDTO userDTO) {
    User user = convertToEntity(userDTO);
    User createdUser = userRepository.save(user);
    return convertToDto(createdUser);
  }

  public UserDTO getUser(Long id) {
    User user = userRepository.findById(id).orElse(null);
    if (ObjectUtils.isEmpty(user)) {
      return null;
    }
    return convertToDto(user);
  }

  public UserDTO updateUser(UserDTO userDTO) throws DugoutDataFetchingException {
    Optional<User> user = userRepository.findById(userDTO.getId());
    if (user.isEmpty()) {
      throw new DugoutDataFetchingException(
          DugoutError.builder()
              .message(String.format("User with id: %s not found", userDTO.getId()))
              .build());
    }
    User existingUser = user.get();
    userDTO.setCreatedOn(existingUser.getCreatedOn());
    User createdUser = userRepository.save(convertToEntity(userDTO));
    return convertToDto(createdUser);
  }
}
