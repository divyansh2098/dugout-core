package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dto.UserSessionDTO;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.dugout.dugoutcore.ApplicationConstants.AUTH_TOKEN_HEADER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  @NonNull UserSessionService userSessionService;

  @Override
  public UserSessionDTO checkTokenValidity(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String authToken = request.getHeader(AUTH_TOKEN_HEADER);
    try {
      return userSessionService.authenticateRequest(authToken);
    } catch (DugoutDataFetchingException e) {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getError().getMessage());
      return null;
    }
  }
}
