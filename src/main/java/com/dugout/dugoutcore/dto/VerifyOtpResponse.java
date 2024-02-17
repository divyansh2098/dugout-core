package com.dugout.dugoutcore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class VerifyOtpResponse {
  Boolean isSuccess;
  String message;
  String authToken;
  UserDTO user;
  Boolean isNewUser;
}
