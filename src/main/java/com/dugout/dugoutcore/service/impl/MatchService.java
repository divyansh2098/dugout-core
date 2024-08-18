package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dao.*;
import com.dugout.dugoutcore.dto.*;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.pojo.DugoutError;
import com.dugout.dugoutcore.pojo.enums.InningStatus;
import com.dugout.dugoutcore.pojo.enums.MatchStatus;
import com.dugout.dugoutcore.pojo.enums.TossDecision;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MatchService {
  @NonNull MatchDao matchDao;
  @NonNull TeamDao teamDao;
  @NonNull TournamentDao tournamentDao;
  @NonNull GroundDao groundDao;

  @NonNull UserDao userDao;

  @Transactional
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
    switch (matchRequestDto.getType()) {
      case T20 -> match.setOvers(20);
      case ONE_DAY -> match.setOvers(50);
      case TEST -> match.setOvers(90);
      default -> match.setOvers(matchRequestDto.getOvers());
    }
    return matchDao.create(match);
  }

  @Transactional
  public MatchDto addSquad(AddSquadToMatchRequestDto addSquadToMatchRequestDto)
      throws DugoutDataFetchingException {
    MatchDto matchDto = matchDao.getById(addSquadToMatchRequestDto.getMatchId());
    List<UserDTO> users = userDao.getByIdIn(addSquadToMatchRequestDto.getPlayerIds());
    List<SquadPlayerDto> squadPlayers =
        users.stream()
            .map(
                user ->
                    SquadPlayerDto.builder()
                        .teamId(addSquadToMatchRequestDto.getTeamId())
                        .matchId(addSquadToMatchRequestDto.getMatchId())
                        .player(user)
                        .build())
            .collect(Collectors.toList());
    if (ObjectUtils.isEmpty(matchDto.getSquad1Players())) {
      matchDto.setSquad1Players(squadPlayers);
    } else if (ObjectUtils.isEmpty(matchDto.getSquad2Players())) {
      matchDto.setSquad2Players(squadPlayers);
    } else {
      throw new DugoutDataFetchingException(
          DugoutError.builder()
              .message("Failed to add Squad")
              .debug("Both squads already exist")
              .build(),
          HttpStatus.BAD_REQUEST);
    }
    return matchDao.update(matchDto);
  }

  @Transactional
  public MatchDto recordToss(Long matchId, Long tossWinnerId, TossDecision tossDecision)
      throws DugoutDataFetchingException {
    MatchDto matchDto = matchDao.getById(matchId);
    matchDto.setTossWinnerId(tossWinnerId);
    matchDto.setTossDecision(tossDecision);
    return matchDao.update(matchDto);
  }

  @Transactional
  public MatchDto createMatchInnings(Long matchId, Integer inningNumber, Long teamId)
      throws DugoutDataFetchingException {
    MatchDto matchDto = matchDao.getById(matchId);
    TeamDto teamDto = teamDao.getById(teamId);
    Date currDate = new Date();
    InningDto inningDto =
        InningDto.builder()
            .team(teamDto)
            .matchId(matchDto.getId())
            .inningNumber(inningNumber)
            .startTime(currDate)
            .status(InningStatus.IN_PROGRESS)
            .score(0)
            .extras(0)
            .numBalls(0)
            .wickets(0)
            .build();
    matchDto.getInnings().add(inningDto);
    if (inningNumber == 1) {
      matchDto.setStatus(MatchStatus.IN_PROGRESS);
    }
    return matchDao.update(matchDto);
  }
}
