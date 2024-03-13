package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dao.GroundDao;
import com.dugout.dugoutcore.dao.MatchDao;
import com.dugout.dugoutcore.dao.TeamDao;
import com.dugout.dugoutcore.dao.TournamentDao;
import com.dugout.dugoutcore.dto.*;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MatchService {
  @NonNull MatchDao matchDao;
  @NonNull TeamDao teamDao;
  @NonNull TournamentDao tournamentDao;
  @NonNull GroundDao groundDao;

  public MatchDto createMatch(MatchRequestDto matchRequestDto) {
    MatchDto match = new MatchDto();
    BeanUtils.copyProperties(matchRequestDto, match);
    TournamentDto tournamentDto = tournamentDao.getById(matchRequestDto.getTournamentId());
    GroundDto groundDto = groundDao.getById(matchRequestDto.getGroundId());
    TeamDto team1 = teamDao.getById(matchRequestDto.getTeam1Id());
    TeamDto team2 = teamDao.getById(matchRequestDto.getTeam2Id());
    match.setGround(groundDto);
    match.setTeam1(team1);
    match.setTeam2(team2);
    match.setTournament(tournamentDto);
    return matchDao.create(match);
  }
}
