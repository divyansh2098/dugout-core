package com.dugout.dugoutcore.filter;

import static com.dugout.dugoutcore.ApplicationConstants.GRAPHQL_ENDPOINT;
import static com.dugout.dugoutcore.ApplicationConstants.USER_SESSION_ATTRIBUTE;

import com.dugout.dugoutcore.dto.UserSessionDTO;
import com.dugout.dugoutcore.service.AuthService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DugoutAuthFilter implements Filter {
  @NonNull AuthService authService;

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    // No auth check on verify otp and request otp as we don't expect token here
    if (!GRAPHQL_ENDPOINT.equals(request.getRequestURI())) {
      filterChain.doFilter(request, response);
      return;
    }
    // All graphql endpoints should have a valid auth token
    UserSessionDTO userSessionDTO = authService.checkTokenValidity(request, response);
    if (ObjectUtils.isEmpty(userSessionDTO)) {
      return;
    }
    request.setAttribute(USER_SESSION_ATTRIBUTE, userSessionDTO);
    filterChain.doFilter(request, response);
  }
}
