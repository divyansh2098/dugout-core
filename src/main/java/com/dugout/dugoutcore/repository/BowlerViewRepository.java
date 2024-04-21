package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.BowlerView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlerViewRepository extends JpaRepository<BowlerView, Long> {}
