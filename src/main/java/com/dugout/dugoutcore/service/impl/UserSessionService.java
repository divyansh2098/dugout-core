package com.dugout.dugoutcore.service.impl;

import static com.dugout.dugoutcore.ApplicationConstants.TOKEN_EXPIRY_DAYS;

import com.dugout.dugoutcore.dao.UserSessionDao;
import com.dugout.dugoutcore.dto.*;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import java.util.Calendar;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
@AllArgsConstructor
public class UserSessionService {
  final UserSessionDao userSessionDao;
  final UserService userService;

  public UserSessionDTO authenticateRequest(String authToken) throws DugoutDataFetchingException {
    return userSessionDao.getUserSessionByAuthToken(authToken);
  }

  public SendOtpResponse generateOtp(SendOtpRequest request) {
    log.info("Generate Otp Request: {}", request);
    return SendOtpResponse.builder()
        .message("Successfully Generated OTP")
        .phoneNumber(request.getPhoneNumber())
        .isSuccess(true)
        .build();
  }

  public VerifyOtpResponse verifyOtp(VerifyOtpRequest request) {
    if (!request.getOtp().equals("9999")) {
      return VerifyOtpResponse.builder().message("Verification Failed").isSuccess(false).build();
    }
    log.info("User Verified!! with phone number: {}", request.getPhoneNumber());
    boolean isNewUser = false;
    UserDTO userDTO = userService.getUserByPhone(request.getPhoneNumber());
    if (ObjectUtils.isEmpty(userDTO)) {
      log.info("No user found with phone number {}. Creating new one", request.getPhoneNumber());
      isNewUser = true;
      userDTO = new UserDTO();
      userDTO.setPhone(request.getPhoneNumber());
      userDTO = userService.createUser(userDTO);
    }
    Calendar tokenExpiryDate = Calendar.getInstance();
    tokenExpiryDate.add(Calendar.DATE, TOKEN_EXPIRY_DAYS);
    UserSessionDTO userSessionDTO =
        UserSessionDTO.builder()
            .userId(userDTO.getId())
            .authToken(UUID.randomUUID().toString())
            .deviceId(request.getDeviceId())
            .deviceIp(request.getDeviceIp())
            .deviceModel(request.getDeviceModel())
            .deviceOs(request.getDeviceOs())
            .deviceOsVersion(request.getDeviceOsVersion())
            .userAgent(request.getUserAgent())
            .appVersion(request.getAppVersion())
            .expiresOn(tokenExpiryDate.getTime())
            .build();
    UserSessionDTO createdUserSession = createUserSession(userSessionDTO);
    return VerifyOtpResponse.builder()
        .message("Verification Successful")
        .isSuccess(true)
        .authToken(createdUserSession.getAuthToken())
        .user(userDTO)
        .isNewUser(isNewUser)
        .build();
  }

  public UserSessionDTO createUserSession(UserSessionDTO userSessionDTO) {
    return userSessionDao.createUserSession(userSessionDTO);
  }
}
