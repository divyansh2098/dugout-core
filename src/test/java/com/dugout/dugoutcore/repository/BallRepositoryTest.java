package com.dugout.dugoutcore.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.dugout.dugoutcore.models.Ball;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class BallRepositoryTest {
  @Autowired BallRepository ballRepository;

  @Test
  void testBallRepo() {
    Optional<Ball> ball = ballRepository.findById(1L);
    assertTrue(ball.isEmpty());
  }
}
