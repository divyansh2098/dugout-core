package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.dto.SendOtpRequest;
import com.dugout.dugoutcore.dto.SendOtpResponse;
import com.dugout.dugoutcore.dto.VerifyOtpRequest;
import com.dugout.dugoutcore.dto.VerifyOtpResponse;
import com.dugout.dugoutcore.service.UserSessionService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@DgsComponent
@Slf4j
public class OtpResolver {
  @Autowired
  UserSessionService userSessionService;

  @DgsMutation
  public SendOtpResponse generateOtp(@InputArgument SendOtpRequest request) {
    return userSessionService.generateOtp(request);
  }

  @DgsQuery
  public VerifyOtpResponse verifyOtp(@InputArgument VerifyOtpRequest request) {
    return userSessionService.verifyOtp(request);
  }
}
