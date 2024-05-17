package com.dugout.dugoutcore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "user_session")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSession extends BaseModel {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "auth_token")
    String authToken;

    @Column(name = "device_id")
    String deviceId;

    @Column(name = "device_model")
    String deviceModel;

    @Column(name = "device_ip")
    String deviceIp;

    @Column(name = "device_os")
    String deviceOs;

    @Column(name = "device_os_version")
    String deviceOsVersion;

    @Column(name = "user_agent")
    String userAgent;

    @Column(name = "app_version")
    String appVersion;

    @Column(name = "expires_on")
    Date expiresOn;
}
