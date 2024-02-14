package com.dugout.dugoutcore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SendOtpResponse {
  String phoneNumber;
  String message;
  Boolean isSuccess;
}
