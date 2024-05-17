package com.dugout.dugoutcore.controller;

import com.dugout.dugoutcore.dto.SendOtpRequest;
import com.dugout.dugoutcore.dto.SendOtpResponse;
import com.dugout.dugoutcore.dto.VerifyOtpRequest;
import com.dugout.dugoutcore.dto.VerifyOtpResponse;
import com.dugout.dugoutcore.service.impl.UserSessionService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthController {
  @NonNull UserSessionService userSessionService;

  @PostMapping("/generateOtp")
  public SendOtpResponse generateOtp(@RequestBody SendOtpRequest request) {
    return userSessionService.generateOtp(request);
  }

  @PostMapping("/verifyOtp")
  public VerifyOtpResponse verifyOtp(@RequestBody VerifyOtpRequest request) {
    return userSessionService.verifyOtp(request);
  }
}
