package com.dugout.dugoutcore.cache;

import com.dugout.dugoutcore.models.Config;
import com.dugout.dugoutcore.repository.DugoutConfigRepository;
import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DugoutConfigCache {
  private static final Logger logger = LoggerFactory.getLogger(DugoutConfigCache.class);
  Map<String, Object> config;
  @NonNull DugoutConfigRepository dugoutConfigRepository;

  @PostConstruct
  private void init() {
    refreshCache();
  }

  public Object getFormConfig(String formName) {
    if (config == null) {
      logger.error("Config not loaded");
    }
    return config.get(formName);
  }

  @Scheduled(cron = "*/30 * * * *")
  private void refreshCache() {
    try {
      logger.info("Refreshing Cache");
      List<Config> configList = dugoutConfigRepository.findAll();
      config = configList.get(0).getCache();
    } catch (Exception e) {
      logger.error("Refresh Cache Failed, will retry in 30 minutes");
    }
  }
}
