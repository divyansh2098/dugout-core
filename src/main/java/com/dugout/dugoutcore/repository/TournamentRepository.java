package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {}
