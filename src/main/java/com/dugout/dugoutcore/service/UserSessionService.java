package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dao.UserSessionDao;
import com.dugout.dugoutcore.dto.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class UserSessionService {
    final UserSessionDao userSessionDao;
    final UserService userService;

    public SendOtpResponse generateOtp(SendOtpRequest request) {
        log.info("Generate Otp Request: {}", request);
        return SendOtpResponse.builder()
                .message("Successfully Generated OTP")
                .phoneNumber(request.getPhoneNumber())
                .isSuccess(true)
                .build();
    }

    public VerifyOtpResponse verifyOtp(VerifyOtpRequest request) {
        if (!request.getOtp().equals("999999")) {
            return VerifyOtpResponse.builder().message("Verification Failed").isSuccess(false).build();
        }
        log.info("User Verified!! with phone number: {}", request.getPhoneNumber());
        boolean isNewUser = false;
        UserDTO userDTO = userService.getUserByPhone(request.getPhoneNumber());
        if (ObjectUtils.isEmpty(userDTO)){
            log.info("No user found with phone number {}. Creating new one", request.getPhoneNumber());
            isNewUser = true;
            userDTO = new UserDTO();
            userDTO.setPhone(request.getPhoneNumber());
            userDTO = userService.createUser(userDTO);
        }
        UserSessionDTO userSessionDTO = UserSessionDTO.builder()
                .userId(userDTO.getId())
                .authToken(UUID.randomUUID().toString())
                .deviceId(request.getDeviceId())
                .deviceIp(request.getDeviceIp())
                .deviceModel(request.getDeviceModel())
                .deviceOs(request.getDeviceOs())
                .deviceOsVersion(request.getDeviceOsVersion())
                .userAgent(request.getUserAgent())
                .appVersion(request.getAppVersion())
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
