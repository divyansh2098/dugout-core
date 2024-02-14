package com.dugout.dugoutcore.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SendOtpRequest {
  String phoneNumber;
}
