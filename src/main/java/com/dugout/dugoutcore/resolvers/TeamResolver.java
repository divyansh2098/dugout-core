package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.dto.AddPlayerToTeamRequestDto;
import com.dugout.dugoutcore.dto.TeamDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.impl.TeamService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@DgsComponent
@AllArgsConstructor
public class TeamResolver {

  @NonNull TeamService teamService;

  @DgsMutation
  public TeamDto createTeam(@InputArgument("team") TeamDto teamDto) {
    return teamService.createTeam(teamDto);
  }

  @DgsQuery
  public TeamDto getTeamById(@InputArgument Long id) {
    return teamService.getTeamById(id);
  }

  @DgsMutation
  public TeamDto addPlayerToTeam(
      @InputArgument("addPlayerToTeamInput") AddPlayerToTeamRequestDto requestDto)
      throws DugoutDataFetchingException {
    TeamDto teamDto =
        teamService.addPlayerToTeam(
            requestDto.getTeamId(), requestDto.getPlayerId(), requestDto.getTeamPlayerRole());
    return teamDto;
  }
}
