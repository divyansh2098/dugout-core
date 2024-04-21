package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.BatsmanView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatsmanViewRepository extends JpaRepository<BatsmanView, Long> {}
