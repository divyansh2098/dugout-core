package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dto.UserSessionDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthService {
  UserSessionDTO checkTokenValidity(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
