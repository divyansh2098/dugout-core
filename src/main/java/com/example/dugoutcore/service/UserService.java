package com.example.dugoutcore.service;

import com.example.dugoutcore.dto.UserDTO;
import com.example.dugoutcore.model.User;
import com.example.dugoutcore.repository.UserRepository;
import com.example.dugoutcore.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    private UserDTO convertToDto(User user) {
        log.info("convertToDto::User " + user.toString());
        if (user == null)
            return null;
        UserDTO userDto = new UserDTO();
        BeanUtils.copyProperties(user, userDto);
        log.info("convertToDto::UserDTO " + userDto.toString());
        return userDto;
    }

    private User convertToEntity(UserDTO userDto) {
        log.info("convertToEntity::UserDTO " + userDto.toString());
        if (userDto == null)
            return null;
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        log.info("convertToEntity::User " + user.toString());
        return user;
    }

    public UserDTO getUer(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return convertToDto(optionalUser.orElse(null));
    }

    public UserDTO createUser(UserDTO userDto) {
        User user = userRepository.save(convertToEntity(userDto));
        return convertToDto(user);
    }

    @Transactional
    public UserDTO updateUser(UserDTO userDto) {
        Optional<User> existingUserOptional = userRepository.findById(userDto.getId());
        if (existingUserOptional.isEmpty()) {
            throw new Error("Cannot find user with id "+userDto.getId());
        }
        User existingUser = existingUserOptional.get();
        userDto.setCreatedOn(existingUser.getCreatedOn());
        User user = userRepository.save(convertToEntity(userDto));
        return convertToDto(user);
    }
}
