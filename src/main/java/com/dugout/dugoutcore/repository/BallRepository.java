package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.Ball;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BallRepository extends JpaRepository<Ball, Long> {
}
