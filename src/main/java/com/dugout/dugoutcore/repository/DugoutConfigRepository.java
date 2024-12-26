package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DugoutConfigRepository extends JpaRepository<Config, Long> {}
