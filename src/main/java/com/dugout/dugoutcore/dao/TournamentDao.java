package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.TournamentDto;
import com.dugout.dugoutcore.models.Tournament;
import com.dugout.dugoutcore.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentDao extends BaseDao<Tournament, TournamentDto, TournamentRepository> {

  @Autowired
  TournamentDao(TournamentRepository tournamentRepository) {
    super(tournamentRepository, Tournament.class, TournamentDto.class);
  }
}
