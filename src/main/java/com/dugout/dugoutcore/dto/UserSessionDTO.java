package com.dugout.dugoutcore.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSessionDTO extends BaseDto {
  Long userId;
  String authToken;
  String deviceId;
  String deviceModel;
  String deviceIp;
  String deviceOs;
  String deviceOsVersion;
  String userAgent;
  String appVersion;

  Date expiresOn;
}
