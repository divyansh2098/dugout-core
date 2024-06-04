package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.Inning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InningsRepository extends JpaRepository<Inning, Long> {
}
