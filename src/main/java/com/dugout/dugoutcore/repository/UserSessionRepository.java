package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
    Optional<UserSession> findByUserId(Long userId);

    Optional<UserSession> findByAuthToken(String authToken);
}
