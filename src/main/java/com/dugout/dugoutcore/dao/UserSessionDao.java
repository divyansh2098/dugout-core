package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.UserSessionDTO;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.models.UserSession;
import com.dugout.dugoutcore.pojo.DugoutError;
import com.dugout.dugoutcore.repository.UserSessionRepository;
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
public class UserSessionDao {
  @NonNull UserSessionRepository userSessionRepository;

  private UserSessionDTO convertToDto(UserSession userSession) {
    UserSessionDTO userSessionDTO = new UserSessionDTO();
    BeanUtils.copyProperties(userSession, userSessionDTO);
    return userSessionDTO;
  }

  private UserSession convertToEntity(UserSessionDTO userSessionDTO) {
    UserSession userSession = new UserSession();
    BeanUtils.copyProperties(userSessionDTO, userSession);
    return userSession;
  }

  public UserSessionDTO createUserSession(UserSessionDTO userSessionDTO) {
    UserSession userSession = convertToEntity(userSessionDTO);
    UserSession createdUserSession = userSessionRepository.save(userSession);
    return convertToDto(createdUserSession);
  }

  public UserSessionDTO getUserSessionByAuthToken(String authToken) throws DugoutDataFetchingException {
    UserSession userSession = userSessionRepository.findByAuthToken(authToken).orElse(null);
    if (ObjectUtils.isEmpty(userSession)) {
      throw new DugoutDataFetchingException(
              DugoutError.builder()
                      .message("Invalid session token. Login again!")
                      .build(),
              HttpStatus.UNAUTHORIZED);
    }
    return convertToDto(userSession);
  }
}
