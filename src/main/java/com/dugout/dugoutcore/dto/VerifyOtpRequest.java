package com.dugout.dugoutcore.dto;

import lombok.Data;

@Data
public class VerifyOtpRequest {
  String otp;
  String phoneNumber;
  String deviceId;
  String deviceModel;
  String deviceIp;
  String deviceOs;
  String deviceOsVersion;
  String userAgent;
  String appVersion;
}
