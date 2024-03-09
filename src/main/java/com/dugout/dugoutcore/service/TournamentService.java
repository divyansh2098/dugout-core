package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dao.TournamentDao;
import com.dugout.dugoutcore.dto.TournamentDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TournamentService {

  @NonNull TournamentDao tournamentDao;

  public TournamentDto createTournament(TournamentDto tournamentDto) {
    return tournamentDao.create(tournamentDto);
  }
}
