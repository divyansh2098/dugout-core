package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.Innings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InningsRepository extends JpaRepository<Innings, Long> {
}
