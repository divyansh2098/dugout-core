package com.dugout.dugoutcore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSessionDTO {
    Long userId;
    String authToken;
    String deviceId;
    String deviceModel;
    String deviceIp;
    String deviceOs;
    String deviceOsVersion;
    String userAgent;
    String appVersion;
}
