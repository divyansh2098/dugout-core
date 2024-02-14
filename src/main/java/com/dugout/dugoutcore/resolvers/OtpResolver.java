package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.dto.SendOtpRequest;
import com.dugout.dugoutcore.dto.SendOtpResponse;
import com.dugout.dugoutcore.dto.VerifyOtpRequest;
import com.dugout.dugoutcore.dto.VerifyOtpResponse;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@DgsComponent
@Slf4j
public class OtpResolver {
  @DgsMutation
  public SendOtpResponse generateOtp(@InputArgument SendOtpRequest request) {
    log.info("Generate Otp Request: {}", request);
    return SendOtpResponse.builder()
        .message("Successfully Generated OTP")
        .phoneNumber(request.getPhoneNumber())
        .isSuccess(true)
        .build();
  }

  public VerifyOtpResponse verifyOtp(@InputArgument VerifyOtpRequest request) {
    if (request.getOtp() != "999999") {
      return VerifyOtpResponse.builder().message("Verification Failed").isSuccess(false).build();
    }
    return VerifyOtpResponse.builder()
        .message("Verification Successful")
        .isSuccess(true)
        .authToken(UUID.randomUUID().toString())
        .build();
  }
}
