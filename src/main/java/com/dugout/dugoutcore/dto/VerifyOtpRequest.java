package com.dugout.dugoutcore.dto;

import lombok.Data;

@Data
public class VerifyOtpRequest {
  String otp;
  String phoneNumber;
}
