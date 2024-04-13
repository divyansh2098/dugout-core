package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.Wicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WicketRepository extends JpaRepository<Wicket, Long> {
}
