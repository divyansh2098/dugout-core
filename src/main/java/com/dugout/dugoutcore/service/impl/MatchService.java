package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dao.*;
import com.dugout.dugoutcore.dto.*;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.pojo.DugoutError;
import com.dugout.dugoutcore.pojo.enums.TossDecision;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MatchService {
  @NonNull MatchDao matchDao;
  @NonNull TeamDao teamDao;
  @NonNull TournamentDao tournamentDao;
  @NonNull GroundDao groundDao;

  @NonNull UserDao userDao;

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

  public MatchDto recordToss(Long tossWinnerId, TossDecision tossDecision)
      throws DugoutDataFetchingException {
    MatchDto matchDto = matchDao.getById(tossWinnerId);
    matchDto.setTossWinnerId(tossWinnerId);
    matchDto.setTossDecision(tossDecision);
    return matchDao.update(matchDto);
  }
}
