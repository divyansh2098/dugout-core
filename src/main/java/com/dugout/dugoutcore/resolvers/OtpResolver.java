package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.dto.SendOtpRequest;
import com.dugout.dugoutcore.dto.SendOtpResponse;
import com.dugout.dugoutcore.dto.VerifyOtpRequest;
import com.dugout.dugoutcore.dto.VerifyOtpResponse;
import com.dugout.dugoutcore.service.impl.UserSessionService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
@Slf4j
public class OtpResolver {
  @Autowired UserSessionService userSessionService;

  @DgsMutation
  public SendOtpResponse generateOtp(@InputArgument SendOtpRequest request) {
    return userSessionService.generateOtp(request);
  }

  @DgsMutation
  public VerifyOtpResponse verifyOtp(@InputArgument VerifyOtpRequest request) {
    return userSessionService.verifyOtp(request);
  }
}
