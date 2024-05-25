package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dao.TeamDao;
import com.dugout.dugoutcore.dao.TeamPlayerDao;
import com.dugout.dugoutcore.dao.UserDao;
import com.dugout.dugoutcore.dto.TeamDto;
import com.dugout.dugoutcore.dto.TeamPlayerDto;
import com.dugout.dugoutcore.dto.UserDTO;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.pojo.DugoutError;
import com.dugout.dugoutcore.pojo.enums.TeamPlayerRole;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamService {

  @NonNull TeamDao teamDao;
  @NonNull UserDao userDao;
  @NonNull TeamPlayerDao teamPlayerDao;

  public TeamDto createTeam(TeamDto teamDto) {
    return teamDao.create(teamDto);
  }

  public TeamDto getTeamById(Long id) {
    return teamDao.getById(id);
  }

  public TeamDto addPlayerToTeam(Long teamId, Long playerId, TeamPlayerRole role)
      throws DugoutDataFetchingException {
    TeamDto teamDto = teamDao.getById(teamId);
    List<UserDTO> teamPlayers =
        teamDto.getPlayers().stream().map(TeamPlayerDto::getPlayer).toList();
    Boolean doesPlayerAlreadyExist =
        teamPlayers.stream().anyMatch(player -> player.getId() == playerId);
    if (doesPlayerAlreadyExist) {
      throw new DugoutDataFetchingException(
          DugoutError.builder().message("Player Already Exists").build(), HttpStatus.BAD_REQUEST);
    }
    UserDTO newPlayer = userDao.getById(playerId);
    TeamPlayerDto teamPlayerDto =
        TeamPlayerDto.builder().player(newPlayer).team(teamDto).teamRole(role).build();
    List<TeamPlayerDto> teamPlayerDtos = teamDto.getPlayers();
    teamPlayerDtos.add(teamPlayerDto);
    teamDto.setPlayers(teamPlayerDtos);
    return teamDao.update(teamDto);
  }
}
