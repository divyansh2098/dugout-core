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

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  @NonNull UserSessionService userSessionService;

  @Override
  public UserSessionDTO checkTokenValidity(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String authToken = request.getHeader("auth_token");
    try {
      return userSessionService.authenticateRequest(authToken);
    } catch (DugoutDataFetchingException e) {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getError().getMessage());
      return null;
    }
  }
}
