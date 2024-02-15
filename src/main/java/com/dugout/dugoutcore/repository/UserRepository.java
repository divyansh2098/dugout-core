package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByPhone(String phone);
}