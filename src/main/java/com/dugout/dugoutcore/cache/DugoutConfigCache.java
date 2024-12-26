package com.dugout.dugoutcore.cache;

import com.dugout.dugoutcore.models.Config;
import com.dugout.dugoutcore.repository.DugoutConfigRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DugoutConfigCache {
  private static final Logger logger = LoggerFactory.getLogger(DugoutConfigCache.class);
  List<Config> config;
  @NonNull DugoutConfigRepository dugoutConfigRepository;

  @PostConstruct
  private void init() {
    logger.info("Loading Initial Cache");
    refreshCache();
  }

  public Config getFormConfig(String configName) {
    if (config == null) {
      logger.error("Config not loaded");
      return null;
    }
    Optional<Config> formConfigOptional =
        config.stream().filter(c -> c.getConfigName().equals(configName)).findFirst();
    if (formConfigOptional.isEmpty()) {
      logger.error("No config found for form {}", configName);
      return null;
    }
    return formConfigOptional.get();
  }

  @Scheduled(cron = "*/30 * * * *")
  private void refreshCache() {
    try {
      logger.info("Refreshing Cache");
      config = dugoutConfigRepository.findAll();
    } catch (Exception e) {
      logger.error("Refresh Cache Failed, will retry in 30 minutes");
    }
  }
}
