package com.dugout.dugoutcore.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.dugout.dugoutcore.models.Ground;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
class BallRepositoryTest {

  @Autowired GroundRepository groundRepository;

  @Container
  static PostgreSQLContainer<?> database =
      new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
          .withDatabaseName("dugout_core")
          .withPassword("dugout")
          .withUsername("postgres")
          .withExposedPorts(5432);

  @DynamicPropertySource
  static void postgresProperties(DynamicPropertyRegistry propertyRegistry) {
    propertyRegistry.add("spring.datasource.url", database::getJdbcUrl);
  }

  @Test
  void testBallRepo() {
    Optional<Ground> groundOptional = groundRepository.findById(1L);
    assertTrue(groundOptional.isPresent());
  }
}
