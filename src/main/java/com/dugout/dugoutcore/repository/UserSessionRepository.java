package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.UserSession;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
  Optional<UserSession> findByUserId(Long userId);

  UserSession findByAuthTokenAndExpiresOnGreaterThan(String authToken, Date currentDate);
}
